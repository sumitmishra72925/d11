package com.project.d11.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TeamDataVO {
    @JsonProperty("team_id")
    String teamId;
}
