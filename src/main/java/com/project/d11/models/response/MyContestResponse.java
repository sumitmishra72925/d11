package com.project.d11.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.d11.models.dto.JoinedTeamData;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class MyContestResponse {
    @JsonProperty("contest_list")
    List<CreateContestResponse> contestResponseList;
}
