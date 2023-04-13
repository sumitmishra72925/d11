package com.project.d11.mapper;


import com.project.d11.jpa.entities.MatchEntity;
import com.project.d11.jpa.entities.UserTeamEntity;
import com.project.d11.models.request.CreateMatchRequest;
import com.project.d11.models.request.CreateUserTeamRequest;
import com.project.d11.models.response.CreateMatchResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserTeamMapper {
UserTeamEntity map(CreateUserTeamRequest createUserTeamRequest);
}
