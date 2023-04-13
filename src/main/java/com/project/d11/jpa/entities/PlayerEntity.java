package com.project.d11.jpa.entities;


import com.project.d11.jpa.D11BaseEntity;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "players")
@Data
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class PlayerEntity extends D11BaseEntity {

    @Column(name = "team_id")
    UUID teamId;

    @Column(name = "full_name")
    String playerFullName;

    @Column(name = "short_name")
    String playerShortName;

    @Column(name = "role")
    String role;

    @Column(name = "is_playing")
    Boolean isPlaying;
}
