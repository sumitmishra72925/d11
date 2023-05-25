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
@Table(name = "contest_team")
@Data
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class ContestTeamEntity extends D11BaseEntity {
    @Column(name = "joined_contest_id")
    UUID joinedContestId;

    @Column(name = "team_id")
    UUID teamId;
}
