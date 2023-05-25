package com.project.d11.repositories;

import com.project.d11.jpa.D11Repo;
import com.project.d11.jpa.entities.ContestTeamEntity;
import com.project.d11.jpa.entities.JoinContestEntity;

import java.util.List;
import java.util.UUID;

public interface ContestTeamRepo extends D11Repo<ContestTeamEntity, Long> {
    ContestTeamEntity findByUuid(UUID uuid);

    List<ContestTeamEntity> findByJoinedContestId(UUID joinedContestId);

}
