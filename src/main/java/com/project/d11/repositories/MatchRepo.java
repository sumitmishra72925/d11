package com.project.d11.repositories;

import com.project.d11.jpa.D11Repo;
import com.project.d11.jpa.entities.MatchEntity;

import java.util.List;
import java.util.UUID;

public interface MatchRepo extends D11Repo<MatchEntity, Long> {
    MatchEntity findByUuid(UUID matchId);
    List<MatchEntity> findAllByOrderByStartTimeAsc();

}
