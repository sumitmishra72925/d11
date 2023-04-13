package com.project.d11.models.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.d11.jpa.D11BaseEntity;
import lombok.Data;

import java.util.UUID;

@Data
public class OnboardTeamResponse extends D11BaseEntity {

    @JsonProperty("team_name")
    String teamName;

    @JsonProperty("address")
    String address;

    @JsonProperty("team_logo")
    String teamLogo;

    @JsonProperty("short_name")
    String teamShortName;

    @JsonProperty("team_id")
    UUID uuid;

}
