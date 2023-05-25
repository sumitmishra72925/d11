package com.project.d11.repositories;

import com.project.d11.jpa.D11Repo;
import com.project.d11.jpa.entities.ContestEntity;
import com.project.d11.jpa.entities.JoinContestEntity;

import java.util.List;
import java.util.UUID;

public interface JoinContestRepo extends D11Repo<JoinContestEntity, Long> {
    JoinContestEntity findByUuid(UUID uuid);

    List<JoinContestEntity> findByUserIdAndMatchId(UUID userId, UUID matchId);

}
