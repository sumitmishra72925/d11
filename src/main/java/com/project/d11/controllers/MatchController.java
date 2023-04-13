package com.project.d11.controllers;


import com.project.d11.models.BaseResponse;
import com.project.d11.models.request.CreateMatchRequest;
import com.project.d11.services.MatchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping(value = "/v1/match")
public class MatchController {

    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping("/create")
    public BaseResponse createMatch(@Valid @RequestBody CreateMatchRequest createMatchRequest){
        return matchService.createMatch(createMatchRequest);
    }

    @GetMapping("/list")
    public BaseResponse getList(){
        return matchService.getList();
    }

    @PostMapping("/set-live")
    public BaseResponse setLive(@RequestParam UUID matchId){
        return matchService.setLive(matchId);
    }

    @PostMapping("/set-completed")
    public BaseResponse setCompleted(@RequestParam UUID matchId){
        return matchService.setLive(matchId);
    }

    @GetMapping("get-lineups")
    public BaseResponse getLineUps(@RequestParam String team1Id, @RequestParam String team2Id){
        return matchService.getLineUps(UUID.fromString(team1Id), UUID.fromString(team2Id));
    }

    @PostMapping("create-team")
    public BaseResponse createTeam(){
        return null;
    }


}
