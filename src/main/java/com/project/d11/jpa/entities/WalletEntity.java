package com.project.d11.jpa.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.d11.jpa.D11BaseEntity;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "wallet")
@Data
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class WalletEntity extends D11BaseEntity {
    @JsonProperty("user_id")
    UUID userId;

    @JsonProperty("winning_amount")
    String winningAmount;

    @JsonProperty("amount_added")
    String amountAdded;

    @JsonProperty("total_amount")
    String totalAmount;
}
