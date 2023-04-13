package com.project.d11.controllers;


import com.project.d11.models.BaseResponse;
import com.project.d11.models.request.CreateContestRequest;
import com.project.d11.models.request.OnboardTeamRequest;
import com.project.d11.services.ContestService;
import com.project.d11.services.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping(value = "/v1/team")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }


    @PostMapping("/onboard")
    public BaseResponse onboardTeam(@Valid @RequestBody OnboardTeamRequest onboardTeamRequest){
        return teamService.onboardTeam(onboardTeamRequest);
    }

    @GetMapping("/list")
    public BaseResponse getTeamList(){
        return teamService.getTeamList();
    }






}
