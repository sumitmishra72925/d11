package com.project.d11.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class CreateUserTeamRequest {
    @JsonProperty("user_id")
    UUID userId;

    @JsonProperty("match_id")
    UUID matchId;

    @JsonProperty("player1")
    UUID player1;

    @JsonProperty("player2")
    UUID player2;

    @JsonProperty("player3")
    UUID player3;

    @JsonProperty("player4")
    UUID player4;

    @JsonProperty("player5")
    UUID player5;

    @JsonProperty("player6")
    UUID player6;

    @JsonProperty("player7")
    UUID player7;

    @JsonProperty("player8")
    UUID player8;

    @JsonProperty("player9")
    UUID player9;

    @JsonProperty("captain")
    UUID captain;

    @JsonProperty("vice_captain")
    UUID viceCaptain;

    @JsonProperty("team_name")
    String teamName;


}
