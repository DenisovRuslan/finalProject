package com.api.finalProject.model;

import com.api.finalProject.entity.ClientAccountEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ClientModel {

    private BigDecimal balance;

    public static ClientModel toModel(ClientAccountEntity clientAccountEntity) {
        ClientModel model = new ClientModel();
        model.setBalance(clientAccountEntity.getBalance());
        return model;
    }
}