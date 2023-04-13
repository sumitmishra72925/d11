package com.project.d11.models.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.d11.jpa.D11BaseEntity;
import lombok.Data;

import javax.persistence.Column;

@Data
public class OnboardTeamRequest extends D11BaseEntity {

    @JsonProperty("team_name")
    String teamName;

    @JsonProperty("address")
    String address;

    @JsonProperty("team_logo")
    String teamLogo;

    @JsonProperty("short_name")
    String teamShortName;

}
