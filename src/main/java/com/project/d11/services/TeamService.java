package com.project.d11.services;

import com.project.d11.models.BaseResponse;
import com.project.d11.models.request.OnboardTeamRequest;
import com.project.d11.models.response.OnboardTeamResponse;

import java.util.UUID;

public interface TeamService {
    BaseResponse onboardTeam(OnboardTeamRequest onboardTeamRequest);

    BaseResponse getTeamList();

    OnboardTeamResponse getTeamDetails(UUID teamId);
}
