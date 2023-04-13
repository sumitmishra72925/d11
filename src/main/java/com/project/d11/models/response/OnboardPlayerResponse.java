package com.project.d11.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class OnboardPlayerResponse {
    @JsonProperty("full_name")
    String playerFullName;

    @JsonProperty("short_name")
    String playerShortName;

    @JsonProperty("role")
    String role;

    @JsonProperty("team_name")
    String teamName;

    @JsonProperty("player_id")
    UUID uuid;

    @JsonProperty("team_id")
    UUID teamId;

    @JsonProperty("is_playing")
    Boolean isPlaying;

}
