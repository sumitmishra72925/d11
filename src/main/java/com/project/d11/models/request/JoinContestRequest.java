package com.project.d11.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.d11.models.dto.TeamDataVO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class JoinContestRequest {
    @JsonProperty("contest_id")
    String contestId;

    @JsonProperty("user_id")
    String userId;

    @JsonProperty("match_id")
    String matchId;

    @JsonProperty("team_ids")
    List<TeamDataVO> teamIds;
}
