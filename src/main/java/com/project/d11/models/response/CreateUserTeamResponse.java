package com.project.d11.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CreateUserTeamResponse {
    @JsonProperty("team_id")
    UUID teamId;

    @JsonProperty("message")
    String message;
}
