package com.project.d11.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class TeamDetailsModel {
    @JsonProperty("team_name")
    String teamName;

    /*@JsonProperty("address")
    String address;*/

    @JsonProperty("team_logo")
    String teamLogo;

    @JsonProperty("short_name")
    String teamShortName;

    @JsonProperty("team_id")
    UUID uuid;
}
