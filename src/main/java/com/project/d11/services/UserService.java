package com.project.d11.services;

import com.project.d11.models.BaseResponse;
import com.project.d11.models.request.CreateUserTeamRequest;
import com.project.d11.models.request.OnboardUserRequest;
import com.project.d11.models.response.CreateUserTeamResponse;
import com.project.d11.models.response.UserMatchTeamResponse;
import com.project.d11.models.response.UserWalletResponse;

import java.util.UUID;

public interface UserService {
    BaseResponse onboardUser(OnboardUserRequest onboardUserRequest);

    CreateUserTeamResponse createTeam(CreateUserTeamRequest createUserTeamRequest);

    UserMatchTeamResponse getTeam(UUID userId, UUID matchId);

    UserWalletResponse getWalletData(UUID userid);
}
