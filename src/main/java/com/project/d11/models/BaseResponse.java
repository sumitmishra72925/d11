package com.project.d11.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Getter
@Setter
@AllArgsConstructor
public class BaseResponse {

    @JsonProperty(value = "data")
    Object Data;

    @JsonProperty(value = "status")
    String status;

}
