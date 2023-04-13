package com.project.d11.services;

import com.project.d11.jpa.entities.PlayerEntity;
import com.project.d11.models.BaseResponse;
import com.project.d11.models.request.CreateContestRequest;
import com.project.d11.models.request.OnboardPlayerRequest;
import com.project.d11.models.response.OnboardPlayerResponse;

import java.util.List;
import java.util.UUID;

public interface PlayerService {
    BaseResponse onboardPlayer(OnboardPlayerRequest onboardPlayerRequest);

    BaseResponse getPlayer(UUID playerId);

    BaseResponse getPlayerByTeam(UUID teamId);

    List<PlayerEntity> getPlayersByRoleAndTeamIdAndIsPlaying(String role, UUID teamId);
}
