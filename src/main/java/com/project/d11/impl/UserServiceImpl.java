package com.project.d11.impl;

import com.project.d11.jpa.entities.*;
import com.project.d11.mapper.UserMapper;
import com.project.d11.mapper.UserTeamMapper;
import com.project.d11.mapper.WalletMapper;
import com.project.d11.models.BaseResponse;
import com.project.d11.models.request.CreateUserTeamRequest;
import com.project.d11.models.request.OnboardUserRequest;
import com.project.d11.models.response.*;
import com.project.d11.repositories.*;
import com.project.d11.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {


    private final UserRepo userRepo;
    private final UserMapper userMapper;
    private final UserTeamRepo teamRepo;
    private final UserTeamMapper userTeamMapper;
    private final WalletRepo walletRepo;
    private final WalletMapper walletMapper;



    @Autowired
    public UserServiceImpl(UserRepo userRepo, UserMapper userMapper, UserTeamRepo teamRepo, UserTeamMapper userTeamMapper, WalletRepo walletRepo, WalletMapper walletMapper) {
        this.userRepo = userRepo;
        this.userMapper= userMapper;
        this.teamRepo = teamRepo;
        this.userTeamMapper = userTeamMapper;
        this.walletRepo = walletRepo;
        this.walletMapper = walletMapper;
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
            UserTeamEntity userTeamEntity = teamRepo.saveAndFlush(userTeamMapper.map(createUserTeamRequest));
             return new CreateUserTeamResponse(userTeamEntity.getUuid(), "Team Created Successfully!");
        }else {
             return new CreateUserTeamResponse(null, "Duplicate team found");
        }
    }

    @Override
    public UserMatchTeamResponse getTeam(UUID userId, UUID matchId) {
        UserMatchTeamResponse userMatchTeamResponse = new UserMatchTeamResponse();
        List<UserTeamEntity> userTeamList = teamRepo.findByUserIdAndMatchId(userId, matchId);
        if(userTeamList != null && userTeamList.size() != 0){
            int team1Count, wkCount, team2Count, batCount, allRounderCount, bowlerCount;
            String team1Name = null, team2Name = null, userTeamName = null,captain = null, viceCaptain = null;
        }

      return userMatchTeamResponse;
    }

    @Override
    public UserWalletResponse getWalletData(UUID userid) {
        return walletMapper.map(walletRepo.findByUserId(userid));
    }

    private boolean isTeamExists(CreateUserTeamRequest createUserTeamRequest) {
        List<UserTeamEntity> teamList = teamRepo.findByUserIdAndMatchId(createUserTeamRequest.getUserId(), createUserTeamRequest.getMatchId());
        if(teamList.size() == 0){
            return false;
        }else {
            //TODO: find an efficient solution
            for(UserTeamEntity single : teamList){
                if(single.getPlayer1().equals(createUserTeamRequest.getPlayer1())
                        && single.getPlayer2().equals(createUserTeamRequest.getPlayer2())
                        && single.getPlayer3().equals(createUserTeamRequest.getPlayer3())
                        && single.getPlayer4().equals(createUserTeamRequest.getPlayer4())
                        && single.getPlayer5().equals(createUserTeamRequest.getPlayer5())
                        && single.getPlayer6().equals(createUserTeamRequest.getPlayer6())
                        && single.getPlayer7().equals(createUserTeamRequest.getPlayer7())
                        && single.getPlayer8().equals(createUserTeamRequest.getPlayer8())
                        && single.getPlayer9().equals(createUserTeamRequest.getPlayer9())
                        && single.getCaptain().equals(createUserTeamRequest.getCaptain())
                        && single.getViceCaptain().equals(createUserTeamRequest.getViceCaptain())){
                    return true;
                }
            }
        }
        return false;
    }

}
