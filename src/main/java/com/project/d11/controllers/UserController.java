package com.project.d11.controllers;


import com.project.d11.models.BaseResponse;
import com.project.d11.models.request.CreateUserTeamRequest;
import com.project.d11.models.request.OnboardUserRequest;
import com.project.d11.models.response.CreateUserTeamResponse;
import com.project.d11.models.response.UserMatchTeamResponse;
import com.project.d11.models.response.UserWalletResponse;
import com.project.d11.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping(value = "/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/onboard")
    public BaseResponse onboardUser(@Valid @RequestBody OnboardUserRequest onboardUserRequest){
        return userService.onboardUser(onboardUserRequest);
    }

    @PostMapping("/create-team")
    public CreateUserTeamResponse createTeam(@Valid @RequestBody CreateUserTeamRequest createUserTeamRequest){
        return userService.createTeam(createUserTeamRequest);
    }

    @GetMapping("/get-teams")
    public UserMatchTeamResponse getTeam(@RequestParam String userId, @RequestParam String matchId){
        return userService.getTeam(UUID.fromString(userId), UUID.fromString(matchId));
    }

    @GetMapping("/get-wallet-data")
    public UserWalletResponse getUserWalletData(@RequestParam String userId){
        return userService.getWalletData(UUID.fromString(userId)) ;
    }
}
