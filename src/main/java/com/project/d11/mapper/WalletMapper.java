package com.project.d11.mapper;


import com.project.d11.jpa.entities.ContestEntity;
import com.project.d11.jpa.entities.WalletEntity;
import com.project.d11.models.request.CreateContestRequest;
import com.project.d11.models.response.CreateContestResponse;
import com.project.d11.models.response.UserWalletResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WalletMapper {
UserWalletResponse map(WalletEntity walletEntity);
}
