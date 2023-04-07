package com.api.finalProject.model;

import com.api.finalProject.entity.TransferBalance;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ClientTransactionModel {

    private BigDecimal amount;

    public static ClientTransactionModel toModel(TransferBalance transferBalance) {
        ClientTransactionModel model = new ClientTransactionModel();
        model.setAmount(transferBalance.getAmountTransfer());
        return model;

    }
}