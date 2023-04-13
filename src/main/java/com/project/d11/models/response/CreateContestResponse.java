package com.project.d11.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
@Getter
@Setter
public class CreateContestResponse {

    @JsonProperty("contest_id")
    UUID uuid;

    @JsonProperty(value = "match_id")
    UUID matchId;

    @JsonProperty(value = "prize_pool")
    String prizePool;

    @JsonProperty(value = "entry_fee")
    String entryFee;

    @JsonProperty(value = "total_spot")
    String totalSpot;

    @JsonProperty(value = "remaining_spot")
    String remainingSpot;

    @JsonProperty(value = "is_full")
    Boolean isFull;

    @JsonProperty(value = "first_prize")
    String firstPrize;

}
