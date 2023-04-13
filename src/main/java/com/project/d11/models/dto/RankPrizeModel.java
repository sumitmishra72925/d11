package com.project.d11.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RankPrizeModel {
    @JsonProperty("rank")
    String rank;

    @JsonProperty("prize")
    String prize;
}
