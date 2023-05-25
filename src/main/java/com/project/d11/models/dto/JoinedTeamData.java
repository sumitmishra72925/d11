package com.project.d11.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
@Getter
@Setter
public class JoinedTeamData {

    @JsonProperty("team_id")
    UUID teamId;

    @JsonProperty("team_name")
    String teamName;

    @JsonProperty("total_points")
    Double totalPoints;
}
