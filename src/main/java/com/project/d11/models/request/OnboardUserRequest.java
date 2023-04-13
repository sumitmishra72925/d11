package com.project.d11.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class OnboardUserRequest {

    @JsonProperty(value = "user_name")
    String userName;

    @JsonProperty(value = "email")
    String email;

    @JsonProperty("auth_token")
    String authToken;

}
