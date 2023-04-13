package com.project.d11.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserMatchTeamDetails {
    @JsonProperty("team_name")
    String teamName;

    @JsonProperty("team1_name")
    String team1Name;

    @JsonProperty("team2_name")
    String team2Name;

    @JsonProperty("team1_player_count")
    String team1PlayerCount;

    @JsonProperty("team2_player_count")
    String team2PlayerCount;

    @JsonProperty("wicket_keeper_count")
    String wicketKeeperCount;

    @JsonProperty("batter_count")
    String batterCount;

    @JsonProperty("all_rounder_count")
    String allRounderCount;

    @JsonProperty("bowler_count")
    String bowlerCount;

    @JsonProperty("captain")
    String captain;

    @JsonProperty("vice_captain")
    String viceCaptain;
}
