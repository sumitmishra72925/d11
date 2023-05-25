package com.project.d11.jpa.entities;


import com.project.d11.jpa.D11BaseEntity;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "user_team_player")
@Data
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class UserTeamPlayerEntity extends D11BaseEntity {

    @Column(name = "user_team_id")
    UUID userTeamId;

    @Column(name = "player_id")
    UUID playerId;

    @Column(name = "is_captain")
    Boolean isCaptain = false;

    @Column(name = "is_vice_captain")
    Boolean isViceCaptain = false;

    @Column(name = "points_scored")
    Double pointsScored = 0.0;
}
