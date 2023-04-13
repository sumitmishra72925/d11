package com.project.d11.repositories;

import com.project.d11.jpa.entities.ContestEntity;
import com.project.d11.jpa.D11Repo;

import java.util.List;
import java.util.UUID;

public interface ContestRepo extends D11Repo<ContestEntity, Long> {
    ContestEntity findByUuid(UUID contestId);

    List<ContestEntity> findByMatchId(UUID matchId);

}
