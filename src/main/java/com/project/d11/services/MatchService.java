package com.project.d11.services;

import com.project.d11.models.BaseResponse;
import com.project.d11.models.request.CreateMatchRequest;

import java.util.UUID;

public interface MatchService {
    BaseResponse createMatch(CreateMatchRequest createMatchRequest);

    BaseResponse getList();

    BaseResponse setLive(UUID matchId);

    BaseResponse setCompleted(UUID matchId);

    BaseResponse getLineUps(UUID team1Id, UUID team2Id);
}
