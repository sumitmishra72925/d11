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

    @Column(name = "team_name")
    String teamName;

    @Column(name = "total_points")
    Double totalPoints = 0.0;

}
