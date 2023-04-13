package com.project.d11.jpa.entities;


import com.project.d11.jpa.D11BaseEntity;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "user_team")
@Data
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class UserTeamEntity extends D11BaseEntity {

    @Column(name = "user_id")
    UUID userId;

    @Column(name = "match_id")
    UUID matchId;

    @Column(name = "player1")
    UUID player1;

    @Column(name = "player2")
    UUID player2;

    @Column(name = "player3")
    UUID player3;

    @Column(name = "player4")
    UUID player4;

    @Column(name = "player5")
    UUID player5;

    @Column(name = "player6")
    UUID player6;

    @Column(name = "player7")
    UUID player7;

    @Column(name = "player8")
    UUID player8;

    @Column(name = "player9")
    UUID player9;

    @Column(name = "captain")
    UUID captain;

    @Column(name = "vice_captain")
    UUID viceCaptain;

    @Column(name = "team_name")
    String teamName;

}
