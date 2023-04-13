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

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "teams")
@Data
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class TeamEntity extends D11BaseEntity {

    @Column(name = "team_name")
    String teamName;

    @Column(name = "address")
    String address;

    @Column(name = "team_logo")
    String teamLogo;

    @Column(name = "short_name")
    String teamShortName;

}
