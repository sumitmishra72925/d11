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
@Table(name = "match")
@Data
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class MatchEntity extends D11BaseEntity {

    @Column(name = "match_name")
    String matchName;

    @Column(name = "team1_id")
    UUID team1Id;

    @Column(name = "team2_id")
    UUID team2Id;

    @Column(name = "prize_pool")
    String prizePool;

    @Column(name = "start_time")
    LocalDateTime startTime;

    @Column(name = "is_live")
    Boolean isLive;

    @Column(name = "is_completed")
    Boolean isCompleted;

}
