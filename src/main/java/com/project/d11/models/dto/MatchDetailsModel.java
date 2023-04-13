package com.project.d11.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class MatchDetailsModel {
    @JsonProperty(value = "match_name")
    String matchName;

    @JsonProperty("team1")
    TeamDetailsModel team1;

    @JsonProperty("team2")
    TeamDetailsModel team2;

    @JsonProperty(value = "prize_pool")
    String prizePool;

    @JsonProperty(value = "start_time", required = true)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:MM", iso = DateTimeFormat.ISO.DATE_TIME)
    LocalDateTime startTime;

    @JsonProperty("uuid")
    UUID uuid;
}
