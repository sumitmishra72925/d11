package com.project.d11.models.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class CreateMatchRequest {

    @JsonProperty(value = "match_name")
    String matchName;

    @JsonProperty(value = "team1_id")
    UUID team1Id;

    @JsonProperty(value = "team2_id")
    UUID team2Id;

    @JsonProperty(value = "prize_pool")
    String prizePool;

    @JsonProperty(value = "start_time", required = true)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:MM", iso = DateTimeFormat.ISO.DATE_TIME)
    LocalDateTime startTime;
}
