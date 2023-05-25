package com.project.d11.impl;

import com.project.d11.constants.ContestConstants;
import com.project.d11.jpa.entities.ContestEntity;
import com.project.d11.jpa.entities.ContestTeamEntity;
import com.project.d11.jpa.entities.JoinContestEntity;
import com.project.d11.jpa.entities.UserTeamEntity;
import com.project.d11.mapper.ContestMapper;
import com.project.d11.models.BaseResponse;
import com.project.d11.models.dto.JoinedTeamData;
import com.project.d11.models.dto.TeamDataVO;
import com.project.d11.models.request.CreateContestRequest;
import com.project.d11.models.request.JoinContestRequest;
import com.project.d11.models.response.ContestBreakUpResponse;
import com.project.d11.models.response.ContestListResponse;
import com.project.d11.models.response.CreateContestResponse;
import com.project.d11.models.response.MyContestResponse;
import com.project.d11.repositories.ContestRepo;
import com.project.d11.repositories.ContestTeamRepo;
import com.project.d11.repositories.JoinContestRepo;
import com.project.d11.repositories.UserTeamRepo;
import com.project.d11.services.ContestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ContestServiceImpl implements ContestService {


    private final ContestRepo contestRepo;
    private final ContestMapper contestMapper;
    private final JoinContestRepo joinContestRepo;
    private final ContestTeamRepo contestTeamRepo;
    private final UserTeamRepo userTeamRepo;

    @Autowired
    public ContestServiceImpl(ContestRepo contestRepo, ContestMapper contestMapper,
                              JoinContestRepo joinContestRepo, ContestTeamRepo contestTeamRepo, UserTeamRepo userTeamRepo) {
        this.contestRepo = contestRepo;
        this.contestMapper= contestMapper;
        this.joinContestRepo = joinContestRepo;
        this.contestTeamRepo = contestTeamRepo;
        this.userTeamRepo = userTeamRepo;
    }


    @Override
    public BaseResponse createContest(CreateContestRequest createContestRequest) {
        ContestEntity contestEntity = contestMapper.map(createContestRequest);
        return new BaseResponse(contestRepo.saveAndFlush(contestEntity),"SUCCESS");
    }

    @Override
    public BaseResponse getContest(UUID matchId) {
        ContestListResponse contestListResponse = new ContestListResponse();
        contestListResponse.setContestList(contestRepo.findByMatchId(matchId).stream().filter(single->!single.getIsFull()).map(contestMapper::map).collect(Collectors.toList()));
        return new BaseResponse(contestListResponse, "SUCCESS");
    }

    @Override
    public BaseResponse getContestBreakUp(UUID contestId) {
        ContestEntity contestEntity = contestRepo.findByUuid(contestId);
        ContestBreakUpResponse contestBreakUpResponse = new ContestBreakUpResponse();
        if ("49".equals(contestEntity.getEntryFee())) {
            contestBreakUpResponse.setBreakupMap(ContestConstants.getContest49());
        } else {
            contestBreakUpResponse.setBreakupMap(ContestConstants.getContest29());
        }
        return new BaseResponse(contestBreakUpResponse, "SUCCESS");

    }

    @Override
    public BaseResponse joinContest(JoinContestRequest joinContestRequest) {
        JoinContestEntity joinContestEntity = new JoinContestEntity();
        joinContestEntity.setContestId(UUID.fromString(joinContestRequest.getContestId()));
        joinContestEntity.setUserId(UUID.fromString(joinContestRequest.getUserId()));
        joinContestEntity.setMatchId(UUID.fromString(joinContestRequest.getMatchId()));
        JoinContestEntity savedEntity = joinContestRepo.saveAndFlush(joinContestEntity);
        for(TeamDataVO teamId : joinContestRequest.getTeamIds()){
            ContestTeamEntity contestTeamEntity = new ContestTeamEntity();
            contestTeamEntity.setJoinedContestId(savedEntity.getUuid());
            contestTeamEntity.setTeamId(UUID.fromString(teamId.getTeamId()));
            contestTeamRepo.saveAndFlush(contestTeamEntity);
        }
     return new BaseResponse("Contest Joined Successfully!","SUCCESS");
    }

    @Override
    public MyContestResponse getMyContest(UUID userId, UUID matchId) {
        MyContestResponse myContestResponse = new MyContestResponse();
        List<CreateContestResponse> responses = new ArrayList<>();
        List<JoinedTeamData> teamData = new ArrayList<>();
        List<JoinContestEntity> joinedContestList = joinContestRepo.findByUserIdAndMatchId(userId, matchId);
        for(JoinContestEntity entity : joinedContestList){
            CreateContestResponse createContestResponse = new CreateContestResponse();
            createContestResponse.setMatchId(entity.getMatchId());
            createContestResponse.setUuid(entity.getUuid());
            ContestEntity contestEntity = contestRepo.findByUuid(entity.getContestId());
            createContestResponse.setEntryFee(contestEntity.getEntryFee());
            createContestResponse.setFirstPrize(contestEntity.getFirstPrize());
            createContestResponse.setPrizePool(contestEntity.getPrizePool());
            createContestResponse.setIsFull(contestEntity.getIsFull());
            createContestResponse.setTotalSpot(contestEntity.getTotalSpot());
            createContestResponse.setRemainingSpot(contestEntity.getRemainingSpot());
            List<ContestTeamEntity> teamList = contestTeamRepo.findByJoinedContestId(entity.getUuid());
            for(ContestTeamEntity teamEntity : teamList){
                JoinedTeamData joinedTeamData = new JoinedTeamData();
                UserTeamEntity userTeamEntity = userTeamRepo.findByUuid(teamEntity.getTeamId());
                joinedTeamData.setTeamId(userTeamEntity.getUuid());
                joinedTeamData.setTeamName(userTeamEntity.getTeamName());
                joinedTeamData.setTotalPoints(userTeamEntity.getTotalPoints());
                teamData.add(joinedTeamData);
            }
            createContestResponse.setTeamList(teamData);
            responses.add(createContestResponse);
        }
        myContestResponse.setContestResponseList(responses);
        return myContestResponse;
    }
}
