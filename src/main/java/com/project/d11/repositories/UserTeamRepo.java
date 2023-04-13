package com.project.d11.repositories;

import com.project.d11.jpa.D11Repo;
import com.project.d11.jpa.entities.TeamEntity;
import com.project.d11.jpa.entities.UserTeamEntity;

import java.util.List;
import java.util.UUID;

public interface UserTeamRepo extends D11Repo<UserTeamEntity, Long> {
    UserTeamEntity findByUuid(UUID teamId);

    List<UserTeamEntity> findByUserIdAndMatchId(UUID userId, UUID matchId);

}
