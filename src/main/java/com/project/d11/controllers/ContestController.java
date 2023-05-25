package com.project.d11.controllers;


import com.project.d11.models.BaseResponse;
import com.project.d11.models.request.CreateContestRequest;
import com.project.d11.models.request.CreateMatchRequest;
import com.project.d11.models.request.JoinContestRequest;
import com.project.d11.models.response.MyContestResponse;
import com.project.d11.services.ContestService;
import com.project.d11.services.MatchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping(value = "/v1/contest")
public class ContestController {

    private final ContestService contestService;

    @Autowired
    public ContestController(ContestService contestService) {
        this.contestService = contestService;
    }


    @PostMapping("/create")
    public BaseResponse createContest(@Valid @RequestBody CreateContestRequest createContestRequest){
        return contestService.createContest(createContestRequest);
    }

    @GetMapping("/list")
    public BaseResponse getContest(@RequestParam String matchId){
        return contestService.getContest(UUID.fromString(matchId));
    }

    @GetMapping("/breakup")
    public BaseResponse getContestBreakup(@RequestParam String contestId){
        return contestService.getContestBreakUp(UUID.fromString(contestId));
    }


    @PostMapping("/join-contest")
    public BaseResponse joinContest(@RequestBody JoinContestRequest joinContestRequest){
        return contestService.joinContest(joinContestRequest);
    }

    @GetMapping("my-contest")
    public MyContestResponse getMyContest(@RequestParam String userId, @RequestParam String matchId){
        return contestService.getMyContest(UUID.fromString(userId), UUID.fromString(matchId));
    }
}
