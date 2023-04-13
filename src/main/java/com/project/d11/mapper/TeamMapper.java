package com.project.d11.mapper;


import com.project.d11.jpa.entities.TeamEntity;
import com.project.d11.models.request.OnboardTeamRequest;
import com.project.d11.models.response.OnboardTeamResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamMapper {
TeamEntity map(OnboardTeamRequest onboardTeamRequest);
OnboardTeamResponse map(TeamEntity teamEntity);
}
