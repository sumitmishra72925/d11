package com.project.d11.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class UserTeamPlayerRequest {

    @JsonProperty("player_id")
    UUID playerId;

    @JsonProperty("is_captain")
    Boolean isCaptain;

    @JsonProperty("is_vice_captain")
    Boolean isViceCaptain;
}
