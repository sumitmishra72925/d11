package com.project.d11.impl;

import com.project.d11.jpa.entities.*;
import com.project.d11.mapper.UserMapper;
import com.project.d11.mapper.UserTeamMapper;
import com.project.d11.mapper.UserTeamPlayerMapper;
import com.project.d11.mapper.WalletMapper;
import com.project.d11.models.BaseResponse;
import com.project.d11.models.request.CreateUserTeamRequest;
import com.project.d11.models.request.OnboardUserRequest;
import com.project.d11.models.request.UserTeamPlayerRequest;
import com.project.d11.models.response.*;
import com.project.d11.repositories.*;
import com.project.d11.services.UserService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {


    private final UserRepo userRepo;
    private final UserMapper userMapper;
    private final UserTeamRepo userTeamRepo;
    private final UserTeamMapper userTeamMapper;
    private final WalletRepo walletRepo;
    private final WalletMapper walletMapper;
    private final UserTeamPlayerRepo teamPlayerRepo;
    private final UserTeamPlayerMapper userTeamPlayerMapper;
    private final TeamRepo teamRepo;
    private final PlayerRepo playerRepo;
    private final MatchRepo matchRepo;



    @Autowired
    public UserServiceImpl(UserRepo userRepo, UserMapper userMapper, UserTeamRepo userTeamRepo, UserTeamMapper userTeamMapper,
                           WalletRepo walletRepo, WalletMapper walletMapper, UserTeamPlayerRepo teamPlayerRepo,
                           UserTeamPlayerMapper userTeamPlayerMapper, TeamRepo teamRepo, PlayerRepo playerRepo, MatchRepo matchRepo) {
        this.userRepo = userRepo;
        this.userMapper= userMapper;
        this.userTeamRepo = userTeamRepo;
        this.userTeamMapper = userTeamMapper;
        this.walletRepo = walletRepo;
        this.walletMapper = walletMapper;
        this.teamPlayerRepo = teamPlayerRepo;
        this.userTeamPlayerMapper = userTeamPlayerMapper;
        this.teamRepo = teamRepo;
        this.playerRepo = playerRepo;
        this.matchRepo = matchRepo;
    }


    @Override
    public BaseResponse onboardUser(OnboardUserRequest onboardUserRequest) {
        UserEntity userEntity = userRepo.findByEmail(onboardUserRequest.getEmail());
        if(userEntity != null){
            userEntity.setAuthToken(onboardUserRequest.getAuthToken());
            UserEntity updatedUser = userRepo.saveAndFlush(userEntity);
            return new BaseResponse(userMapper.map(updatedUser),"SUCCESS");
        }
        userEntity = userRepo.saveAndFlush(userMapper.map(onboardUserRequest));
        WalletEntity walletEntity = new WalletEntity();
        walletEntity.setUserId(userEntity.getUuid());
        walletEntity.setAmountAdded("0");
        walletEntity.setTotalAmount("0");
        walletEntity.setWinningAmount("0");
        walletRepo.saveAndFlush(walletEntity);
        return new BaseResponse(userMapper.map(userEntity),"SUCCESS");
    }

    @Override
    public CreateUserTeamResponse createTeam(CreateUserTeamRequest createUserTeamRequest) {
        if(!isTeamExists(createUserTeamRequest)){
             UserTeamEntity userTeamEntity = userTeamRepo.saveAndFlush(userTeamMapper.map(createUserTeamRequest));
             UUID matchTeamId = userTeamEntity.getUuid();
             for(UserTeamPlayerRequest request : createUserTeamRequest.getPlayerList()){
                 UserTeamPlayerEntity userTeamPlayerEntity = userTeamPlayerMapper.map(request);
                 userTeamPlayerEntity.setUserTeamId(matchTeamId);
                 teamPlayerRepo.saveAndFlush(userTeamPlayerEntity);
             }
             return new CreateUserTeamResponse(userTeamEntity.getUuid(), "Team Created Successfully!");
        }else {
             return new CreateUserTeamResponse(null, "Duplicate team found");
        }
    }

    @Override
    public UserMatchTeamResponse getTeam(UUID userId, UUID matchId) {
        UserMatchTeamResponse userMatchTeamResponse = new UserMatchTeamResponse();
        List<UserMatchTeamDetails> teamDetailsList = new ArrayList<>();
        List<UserTeamEntity> userTeamList = userTeamRepo.findByUserIdAndMatchId(userId, matchId);
        if(userTeamList != null && !userTeamList.isEmpty()){
            UserMatchTeamDetails userMatchTeamDetails;
            for(UserTeamEntity entity : userTeamList){

                int team1Count = 0;
                int wkCount = 0;
                int team2Count = 0;
                int batCount = 0;
                int allRounderCount = 0;
                int bowlerCount = 0;
                String team1Name;
                String team2Name;
                String userTeamName;
                String captain = null;
                String viceCaptain = null;
                Double totalPoint;

                team1Name = teamRepo.findByUuid(matchRepo.findByUuid(matchId).getTeam1Id()).getTeamShortName();
                team2Name = teamRepo.findByUuid(matchRepo.findByUuid(matchId).getTeam2Id()).getTeamShortName();
                List<UserTeamPlayerEntity> playerEntityList = teamPlayerRepo.findByUserTeamId(entity.getUuid());
                for(UserTeamPlayerEntity player : playerEntityList){
                   PlayerEntity playerEntity = playerRepo.findByUuid(player.getPlayerId());
                   switch (playerEntity.getRole()){
                       case "WK":
                           wkCount++;
                           break;
                       case "BAT":
                           batCount++;
                           break;
                       case "AR":
                           allRounderCount++;
                           break;
                       default:
                           bowlerCount++;
                           break;
                   }
                   if(teamRepo.findByUuid(playerEntity.getTeamId()).getTeamShortName().equals(team1Name)){
                       team1Count++;
                   }else {
                       team2Count++;
                   }

                   if(Boolean.TRUE.equals(player.getIsCaptain())){
                       captain = playerRepo.findByUuid(player.getPlayerId()).getPlayerShortName();
                   }

                   if(Boolean.TRUE.equals(player.getIsViceCaptain())){
                       viceCaptain = playerRepo.findByUuid(player.getPlayerId()).getPlayerShortName();
                   }
                }
                userTeamName = entity.getTeamName();
                totalPoint = entity.getTotalPoints();
                userMatchTeamDetails = new UserMatchTeamDetails();
                userMatchTeamDetails.setTeam1Name(team1Name);
                userMatchTeamDetails.setTeam2Name(team2Name);
                userMatchTeamDetails.setAllRounderCount(String.valueOf(allRounderCount));
                userMatchTeamDetails.setBatterCount(String.valueOf(batCount));
                userMatchTeamDetails.setWicketKeeperCount(String.valueOf(wkCount));
                userMatchTeamDetails.setBowlerCount(String.valueOf(bowlerCount));
                userMatchTeamDetails.setTeam1PlayerCount(String.valueOf(team1Count));
                userMatchTeamDetails.setTeam2PlayerCount(String.valueOf(team2Count));
                userMatchTeamDetails.setTeamName(userTeamName);
                userMatchTeamDetails.setTotalPoint(String.valueOf(totalPoint));
                userMatchTeamDetails.setCaptain(captain);
                userMatchTeamDetails.setViceCaptain(viceCaptain);
                teamDetailsList.add(userMatchTeamDetails);
            }
        }
        userMatchTeamResponse.setTeamDetailsList(teamDetailsList);
        return userMatchTeamResponse;
    }



    @Override
    public UserWalletResponse getWalletData(UUID userid) {
        return walletMapper.map(walletRepo.findByUserId(userid));
    }

    private boolean isTeamExists(CreateUserTeamRequest createUserTeamRequest) {
        List<UserTeamEntity> teamList = userTeamRepo.findByUserIdAndMatchId(createUserTeamRequest.getUserId(), createUserTeamRequest.getMatchId());
        if(teamList.isEmpty()){
            return false;
        }else {
            for(UserTeamEntity teamEntity : teamList){
               List<UserTeamPlayerEntity> playerEntityList = teamPlayerRepo.findByUserTeamId(teamEntity.getUuid());
               Set<UUID> entitySet = teamPlayerRepo.findByUserTeamId(teamEntity.getUuid()).stream().map(UserTeamPlayerEntity::getPlayerId).collect(Collectors.toSet());
               Set<UUID> requestSet = createUserTeamRequest.getPlayerList().stream().map(UserTeamPlayerRequest::getPlayerId).collect(Collectors.toSet());
               if(entitySet.equals(requestSet)){
                   val oC = playerEntityList.stream().filter(UserTeamPlayerEntity::getIsCaptain).findAny().get().getPlayerId();
                   val oVc = playerEntityList.stream().filter(UserTeamPlayerEntity::getIsViceCaptain).findAny().get().getPlayerId();
                   val nC = createUserTeamRequest.getPlayerList().stream().filter(UserTeamPlayerRequest::getIsCaptain).findAny().get().getPlayerId();
                   val nVc = createUserTeamRequest.getPlayerList().stream().filter(UserTeamPlayerRequest::getIsViceCaptain).findAny().get().getPlayerId();
                   if(oC.equals(nC) && oVc.equals(nVc)){
                       return true;
                   }
               }else {
                   return false;
               }
            }
        }
        return false;
    }

}
