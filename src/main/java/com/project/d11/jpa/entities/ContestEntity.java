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
@Table(name = "contest")
@Data
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class ContestEntity extends D11BaseEntity {
    @Column(name = "matchId")
    UUID matchId;

    @Column(name = "prize_pool")
    String prizePool;

    @Column(name = "entry_fee")
    String entryFee;

    @Column(name = "total_spot")
    String totalSpot;

    @Column(name = "remaining_spot")
    String remainingSpot;

    @Column(name = "is_full")
    Boolean isFull;

    @Column(name = "first_prize")
    String firstPrize;
}
