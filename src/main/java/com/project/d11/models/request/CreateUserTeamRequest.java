package com.project.d11.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class CreateUserTeamRequest {
    @JsonProperty("user_id")
    UUID userId;

    @JsonProperty("match_id")
    UUID matchId;

    @JsonProperty("team_name")
    String teamName;

    @JsonProperty("player_list")
    List<UserTeamPlayerRequest> playerList;
}
