package com.project.d11.repositories;

import com.project.d11.jpa.D11Repo;
import com.project.d11.jpa.entities.UserEntity;
import com.project.d11.jpa.entities.WalletEntity;

import java.util.UUID;

public interface WalletRepo extends D11Repo<WalletEntity, Long> {
    WalletEntity findByUserId(UUID userId);
}
