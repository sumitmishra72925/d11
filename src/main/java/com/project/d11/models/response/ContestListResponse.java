package com.project.d11.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class ContestListResponse {
    @JsonProperty(value = "contest_list")
    List<CreateContestResponse> contestList;
}
