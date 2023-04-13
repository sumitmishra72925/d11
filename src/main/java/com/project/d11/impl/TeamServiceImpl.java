package com.project.d11.impl;

import com.project.d11.mapper.TeamMapper;
import com.project.d11.models.BaseResponse;
import com.project.d11.models.request.OnboardTeamRequest;
import com.project.d11.models.response.OnboardTeamResponse;
import com.project.d11.models.response.AllTeamResponse;
import com.project.d11.repositories.TeamRepo;
import com.project.d11.services.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TeamServiceImpl implements TeamService {

    private final TeamRepo teamRepo;
    private final TeamMapper teamMapper;

    public TeamServiceImpl(TeamRepo teamRepo, TeamMapper teamMapper) {
        this.teamRepo = teamRepo;
        this.teamMapper = teamMapper;
    }

    @Override
    public BaseResponse onboardTeam(OnboardTeamRequest onboardTeamRequest) {
        return new BaseResponse(teamRepo.saveAndFlush(teamMapper.map(onboardTeamRequest)),"SUCCESS");
    }

    @Override
    public BaseResponse getTeamList() {
        AllTeamResponse allTeamResponse = new AllTeamResponse();
        allTeamResponse.setTeamResponseList(teamRepo.findAll().stream().map(teamMapper::map).collect(Collectors.toList()));
        return new BaseResponse(allTeamResponse,"SUCCESS");
    }

    @Override
    public OnboardTeamResponse getTeamDetails(UUID teamId) {
        return teamMapper.map(teamRepo.findByUuid(teamId));
    }
}
