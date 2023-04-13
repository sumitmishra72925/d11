package com.project.d11.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class AllRounderModel {
    @JsonProperty("all_rounder")
    String allRounder;

    @JsonProperty("team_name")
    String teamName;

    @JsonProperty("player_id")
    UUID playerId;

    @JsonProperty("team_id")
    UUID teamid;
}
