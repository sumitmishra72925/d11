package com.project.d11.impl;

import com.project.d11.constants.ContestConstants;
import com.project.d11.jpa.entities.ContestEntity;
import com.project.d11.mapper.ContestMapper;
import com.project.d11.models.BaseResponse;
import com.project.d11.models.request.CreateContestRequest;
import com.project.d11.models.response.ContestBreakUpResponse;
import com.project.d11.models.response.ContestListResponse;
import com.project.d11.repositories.ContestRepo;
import com.project.d11.services.ContestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ContestServiceImpl implements ContestService {


    private final ContestRepo contestRepo;
    private final ContestMapper contestMapper;

    @Autowired
    public ContestServiceImpl(ContestRepo contestRepo, ContestMapper contestMapper) {
        this.contestRepo = contestRepo;
        this.contestMapper= contestMapper;
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
}
