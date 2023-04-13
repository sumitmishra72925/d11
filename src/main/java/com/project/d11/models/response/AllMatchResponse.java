package com.project.d11.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.d11.models.dto.MatchDetailsModel;
import lombok.Data;

import java.util.List;

@Data
public class AllMatchResponse {
    @JsonProperty("match_list")
    List<MatchDetailsModel> matchList;
}
