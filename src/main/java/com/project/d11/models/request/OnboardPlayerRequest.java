package com.project.d11.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class OnboardPlayerRequest {

    @JsonProperty("team_id")
    UUID teamId;

    @JsonProperty("full_name")
    String playerFullName;

    @JsonProperty("short_name")
    String playerShortName;

    @JsonProperty("role")
    String role;

    @JsonProperty("is_playing")
    Boolean isPlaying;

}
