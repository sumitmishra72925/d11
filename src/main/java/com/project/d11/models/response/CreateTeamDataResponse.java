package com.project.d11.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.d11.models.dto.AllRounderModel;
import com.project.d11.models.dto.BatsManModel;
import com.project.d11.models.dto.BowlerModel;
import com.project.d11.models.dto.WicketKeeperModel;
import lombok.Data;

import java.util.List;

@Data
public class CreateTeamDataResponse {
    @JsonProperty("wicket_keepers")
    List<WicketKeeperModel> wicketKeeperList;

    @JsonProperty("bat_mens")
    public List<BatsManModel> batsManList;

    @JsonProperty("all_rounders")
    List<AllRounderModel> allRounderList;

    @JsonProperty("bowlers")
    List<BowlerModel> bowlers;
}
