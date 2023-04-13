package com.project.d11.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.d11.models.dto.RankPrizeModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class ContestBreakUpResponse {
    @JsonProperty("break_up_map")
    List<RankPrizeModel> breakupMap;
}
