package com.project.d11.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWalletResponse {
    @JsonProperty("winning_amount")
    String winningAmount;

    @JsonProperty("amount_added")
    String amountAdded;

    @JsonProperty("total_amount")
    String totalAmount;

}
