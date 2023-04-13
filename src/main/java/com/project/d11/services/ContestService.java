package com.project.d11.services;

import com.project.d11.models.BaseResponse;
import com.project.d11.models.request.CreateContestRequest;

import java.util.UUID;

public interface ContestService {
    BaseResponse createContest(CreateContestRequest createContestRequest);

    BaseResponse getContest(UUID matchId);

    BaseResponse getContestBreakUp(UUID contestId);
}
