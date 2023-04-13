package com.project.d11.repositories;

import com.project.d11.jpa.D11Repo;
import com.project.d11.jpa.entities.ContestEntity;
import com.project.d11.jpa.entities.PlayerEntity;

import java.util.List;
import java.util.UUID;

public interface PlayerRepo extends D11Repo<PlayerEntity, Long> {
    PlayerEntity findByUuid(UUID playerId);

    List<PlayerEntity> findByUuidIn(List<UUID> uuids);

    List<PlayerEntity> findByTeamId(UUID teamId);

    List<PlayerEntity> findByRoleAndTeamIdAndIsPlaying(String role, UUID teamId,boolean isPlaying);
}
