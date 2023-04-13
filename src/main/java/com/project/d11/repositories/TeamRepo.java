package com.project.d11.repositories;

import com.project.d11.jpa.D11Repo;
import com.project.d11.jpa.entities.MatchEntity;
import com.project.d11.jpa.entities.TeamEntity;

import java.util.List;
import java.util.UUID;

public interface TeamRepo extends D11Repo<TeamEntity, Long> {
    TeamEntity findByUuid(UUID teamId);

    List<TeamEntity> findAll();
}
