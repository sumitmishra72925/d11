package com.project.d11.repositories;

import com.project.d11.jpa.D11Repo;
import com.project.d11.jpa.entities.TeamEntity;
import com.project.d11.jpa.entities.UserTeamPlayerEntity;

import java.util.List;
import java.util.UUID;

public interface UserTeamPlayerRepo extends D11Repo<UserTeamPlayerEntity, Long> {
    UserTeamPlayerEntity findByUuid(UUID teamId);

    List<UserTeamPlayerEntity> findByUserTeamId(UUID userTeamId);
}
