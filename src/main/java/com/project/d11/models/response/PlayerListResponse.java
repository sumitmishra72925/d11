package com.project.d11.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PlayerListResponse {

    @JsonProperty("player_list")
    List<OnboardPlayerResponse> playerList;
}
