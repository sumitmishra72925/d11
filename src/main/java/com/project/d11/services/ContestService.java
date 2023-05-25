package com.project.d11.services;

import com.project.d11.models.BaseResponse;
import com.project.d11.models.request.CreateContestRequest;
import com.project.d11.models.request.JoinContestRequest;
import com.project.d11.models.response.MyContestResponse;

import java.util.UUID;

public interface ContestService {
    BaseResponse createContest(CreateContestRequest createContestRequest);

    BaseResponse getContest(UUID matchId);

    BaseResponse getContestBreakUp(UUID contestId);

    BaseResponse joinContest(JoinContestRequest joinContestRequest);

    MyContestResponse getMyContest(UUID userId, UUID matchId);
}
