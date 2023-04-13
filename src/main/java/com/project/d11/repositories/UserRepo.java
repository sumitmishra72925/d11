package com.project.d11.repositories;

import com.project.d11.jpa.D11Repo;
import com.project.d11.jpa.entities.ContestEntity;
import com.project.d11.jpa.entities.UserEntity;

import java.util.List;
import java.util.UUID;

public interface UserRepo extends D11Repo<UserEntity, Long> {
    UserEntity findByUuid(UUID userId);

    UserEntity findByEmail(String email);
}
