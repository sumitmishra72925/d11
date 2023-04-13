package com.project.d11.mapper;


import com.project.d11.jpa.entities.PlayerEntity;
import com.project.d11.models.request.OnboardPlayerRequest;
import com.project.d11.models.response.OnboardPlayerResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerMapper {
PlayerEntity map(OnboardPlayerRequest onboardPlayerRequest);

OnboardPlayerResponse map(PlayerEntity playerEntity);
}
