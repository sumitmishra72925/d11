package com.project.d11.impl;

import com.project.d11.jpa.entities.MatchEntity;
import com.project.d11.jpa.entities.PlayerEntity;
import com.project.d11.jpa.entities.TeamEntity;
import com.project.d11.mapper.MatchMapper;
import com.project.d11.models.BaseResponse;
import com.project.d11.models.dto.*;
import com.project.d11.models.request.CreateMatchRequest;
import com.project.d11.models.response.AllMatchResponse;
import com.project.d11.models.response.CreateTeamDataResponse;
import com.project.d11.repositories.MatchRepo;
import com.project.d11.repositories.TeamRepo;
import com.project.d11.services.MatchService;
import com.project.d11.services.PlayerService;
import com.project.d11.services.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class MatchServiceImpl implements MatchService {


    private final MatchRepo matchRepo;
    private final MatchMapper matchMapper;
    private final TeamRepo teamRepo;
    private final TeamService teamService;
    private final PlayerService playerService;

    @Autowired
    public MatchServiceImpl(MatchRepo matchRepo, MatchMapper matchMapper, TeamRepo teamRepo, TeamService teamService, PlayerService playerService) {
        this.matchRepo = matchRepo;
        this.matchMapper = matchMapper;
        this.teamRepo = teamRepo;
        this.teamService = teamService;
        this.playerService = playerService;
    }

    @Override
    public BaseResponse createMatch(CreateMatchRequest createMatchRequest) {
        MatchEntity matchEntity = matchMapper.map(createMatchRequest);
        return new BaseResponse(matchRepo.saveAndFlush(matchEntity),"SUCCESS");
    }

    @Override
    public BaseResponse getList() {
        AllMatchResponse allMatchResponse = new AllMatchResponse();
        List<MatchDetailsModel> matchList = new ArrayList<>();
        List<MatchEntity> matchEntityList=  matchRepo.findAllByOrderByStartTimeAsc();
        for (MatchEntity matchEntity : matchEntityList) {
            MatchDetailsModel matchDetailsModel = new MatchDetailsModel();
            matchDetailsModel.setMatchName(matchEntity.getMatchName());
            matchDetailsModel.setPrizePool(matchEntity.getPrizePool());
            matchDetailsModel.setStartTime(matchEntity.getStartTime());
            matchDetailsModel.setUuid(matchEntity.getUuid());

            TeamDetailsModel team1Details = new TeamDetailsModel();
            TeamEntity team1Entity = teamRepo.findByUuid(matchEntity.getTeam1Id());
            team1Details.setTeamLogo(team1Entity.getTeamLogo());
            team1Details.setUuid(team1Entity.getUuid());
            //team1Details.setAddress(team1Entity.getAddress());
            team1Details.setTeamShortName(team1Entity.getTeamShortName());
            team1Details.setTeamName(team1Entity.getTeamName());

            TeamDetailsModel team2Details = new TeamDetailsModel();
            TeamEntity team2Entity = teamRepo.findByUuid(matchEntity.getTeam2Id());
            team2Details.setTeamLogo(team2Entity.getTeamLogo());
            team2Details.setUuid(team2Entity.getUuid());
            //team2Details.setAddress(team2Entity.getAddress());
            team2Details.setTeamShortName(team2Entity.getTeamShortName());
            team2Details.setTeamName(team2Entity.getTeamName());

            matchDetailsModel.setTeam1(team1Details);
            matchDetailsModel.setTeam2(team2Details);

            matchList.add(matchDetailsModel);
        }
        allMatchResponse.setMatchList(matchList);
        return new BaseResponse(allMatchResponse, "SUCCESS");
    }

    @Override
    public BaseResponse setLive(UUID matchId) {
        ;MatchEntity matchEntity = matchRepo.findByUuid(matchId);
        matchEntity.setIsLive(true);
        matchRepo.saveAndFlush(matchEntity);
        return new BaseResponse(matchEntity,"SUCCESS");
    }

    @Override
    public BaseResponse setCompleted(UUID matchId) {
        MatchEntity matchEntity = matchRepo.findByUuid(matchId);
        matchEntity.setIsCompleted(true);
        matchRepo.saveAndFlush(matchEntity);
        return new BaseResponse(matchEntity,"SUCCESS");
    }

    @Override
    public BaseResponse getLineUps(UUID team1Id, UUID team2Id) {
        String team1Name = teamService.getTeamDetails(team1Id).getTeamShortName();
        String team2Name = teamService.getTeamDetails(team2Id).getTeamShortName();

        CreateTeamDataResponse teamListResponse = new CreateTeamDataResponse();


        List<WicketKeeperModel> wicketKeepers= new ArrayList<>();
        List<PlayerEntity> team1WicketKeepers = playerService.getPlayersByRoleAndTeamIdAndIsPlaying("WK",team1Id);
        List<PlayerEntity> team2WicketKeepers = playerService.getPlayersByRoleAndTeamIdAndIsPlaying("WK",team2Id);
        for(PlayerEntity entity : team1WicketKeepers){wicketKeepers.add(new WicketKeeperModel(entity.getPlayerShortName(),team1Name,entity.getUuid(), entity.getTeamId()));}
        for(PlayerEntity entity : team2WicketKeepers){wicketKeepers.add(new WicketKeeperModel(entity.getPlayerShortName(),team2Name,entity.getUuid(), entity.getTeamId()));}
        teamListResponse.setWicketKeeperList(wicketKeepers);

        List<BatsManModel> batMens = new ArrayList<>();
        List<PlayerEntity> team1BatMens = playerService.getPlayersByRoleAndTeamIdAndIsPlaying("BAT",team1Id);
        List<PlayerEntity> team2BatMens = playerService.getPlayersByRoleAndTeamIdAndIsPlaying("BAT",team2Id);
        for(PlayerEntity entity : team1BatMens){batMens.add(new BatsManModel(entity.getPlayerShortName(),team1Name,entity.getUuid(), entity.getTeamId()));}
        for(PlayerEntity entity : team2BatMens){batMens.add(new BatsManModel(entity.getPlayerShortName(),team2Name,entity.getUuid(), entity.getTeamId()));}
        teamListResponse.setBatsManList(batMens);

        List<AllRounderModel> allRounders = new ArrayList<>();
        List<PlayerEntity> team1AllRounders = playerService.getPlayersByRoleAndTeamIdAndIsPlaying("AR",team1Id);
        List<PlayerEntity> team2AllRounders = playerService.getPlayersByRoleAndTeamIdAndIsPlaying("AR",team2Id);
        for(PlayerEntity entity : team1AllRounders){allRounders.add(new AllRounderModel(entity.getPlayerShortName(),team1Name,entity.getUuid(), entity.getTeamId()));}
        for(PlayerEntity entity : team2AllRounders){allRounders.add(new AllRounderModel(entity.getPlayerShortName(),team2Name,entity.getUuid(), entity.getTeamId()));}
        teamListResponse.setAllRounderList(allRounders);

        List<BowlerModel> bowlers = new ArrayList<>();
        List<PlayerEntity> team1Bowlers = playerService.getPlayersByRoleAndTeamIdAndIsPlaying("BOWL",team1Id);
        List<PlayerEntity> team2Bowlers = playerService.getPlayersByRoleAndTeamIdAndIsPlaying("BOWL",team2Id);
        for(PlayerEntity entity : team1Bowlers){bowlers.add(new BowlerModel(entity.getPlayerShortName(),team1Name,entity.getUuid(), entity.getTeamId()));}
        for(PlayerEntity entity : team2Bowlers){bowlers.add(new BowlerModel(entity.getPlayerShortName(),team2Name,entity.getUuid(), entity.getTeamId()));}
        teamListResponse.setBowlers(bowlers);
        return new BaseResponse(teamListResponse, "SUCCESS");
    }
}
