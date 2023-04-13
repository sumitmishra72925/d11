package com.project.d11.controllers;


import com.project.d11.models.BaseResponse;
import com.project.d11.models.request.OnboardPlayerRequest;
import com.project.d11.services.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping(value = "/v1/player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }


    @PostMapping("/onboard")
    public BaseResponse createPlayer(@Valid @RequestBody OnboardPlayerRequest onboardPlayerRequest){
        return playerService.onboardPlayer(onboardPlayerRequest);
    }

    @GetMapping("/details")
    public BaseResponse getContest(@RequestParam String playerId){
        return playerService.getPlayer(UUID.fromString(playerId));
    }

    @GetMapping("player-list-by-team")
    public BaseResponse getPlayerListByTeam(@RequestParam String teamId){
        return playerService.getPlayerByTeam(UUID.fromString(teamId));

    }

}
