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
@Table(name = "join_contest")
@Data
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class JoinContestEntity extends D11BaseEntity {
    @Column(name = "match_id")
    UUID matchId;

    @Column(name = "user_id")
    UUID userId;

    @Column(name = "contest_id")
    UUID contestId;
}
