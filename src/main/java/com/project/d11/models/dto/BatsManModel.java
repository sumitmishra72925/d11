package com.project.d11.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class BatsManModel {
    @JsonProperty("batsman")
    String batsMan;

    @JsonProperty("team_name")
    String teamName;

    @JsonProperty("player_id")
    UUID playerId;

    @JsonProperty("team_id")
    UUID teamid;


}
