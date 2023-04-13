package com.project.d11.models.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class CreateContestRequest {

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
