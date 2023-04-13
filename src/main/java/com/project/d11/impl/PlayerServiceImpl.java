package com.project.d11.impl;

import com.project.d11.jpa.entities.PlayerEntity;
import com.project.d11.mapper.PlayerMapper;
import com.project.d11.models.BaseResponse;
import com.project.d11.models.request.OnboardPlayerRequest;
import com.project.d11.models.response.PlayerListResponse;
import com.project.d11.repositories.PlayerRepo;
import com.project.d11.services.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PlayerServiceImpl implements PlayerService {


    private final PlayerRepo playerRepo;
    private final PlayerMapper playerMapper;

    @Autowired
    public PlayerServiceImpl(PlayerRepo playerRepo, PlayerMapper playerMapper) {
        this.playerRepo = playerRepo;
        this.playerMapper= playerMapper;
    }


    @Override
    public BaseResponse onboardPlayer(OnboardPlayerRequest onboardPlayerRequest) {
        return new BaseResponse(playerRepo.saveAndFlush(playerMapper.map(onboardPlayerRequest)),"SUCCESS");
    }

    @Override
    public BaseResponse getPlayer(UUID playerId) {
        return new BaseResponse(playerMapper.map(playerRepo.findByUuid(playerId)),"SUCCESS");
    }

    @Override
    public BaseResponse getPlayerByTeam(UUID teamId) {
        PlayerListResponse playerListResponse = new PlayerListResponse();
        playerListResponse.setPlayerList(playerRepo.findByTeamId(teamId).stream().map(playerMapper::map).collect(Collectors.toList()));
        return new BaseResponse(playerListResponse,"SUCCESS");
    }

    @Override
    public List<PlayerEntity> getPlayersByRoleAndTeamIdAndIsPlaying(String role, UUID teamId) {
        return playerRepo.findByRoleAndTeamIdAndIsPlaying(role,teamId,true);
    }
}
