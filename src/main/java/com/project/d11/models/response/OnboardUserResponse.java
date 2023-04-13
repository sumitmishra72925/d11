package com.project.d11.models.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class OnboardUserResponse {
    @JsonProperty(value = "user_name")
    String userName;

    @JsonProperty(value = "email")
    String email;

    @JsonProperty("auth_token")
    String authToken;

    @JsonProperty("user_id")
    UUID uuid;
}
