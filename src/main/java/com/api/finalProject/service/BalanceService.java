package com.api.finalProject.service;

import com.api.finalProject.entity.ClientAccountEntity;
import com.api.finalProject.entity.ClientTransaction;
import com.api.finalProject.model.ClientModel;
import com.api.finalProject.repo.ClientAccountRepo;
import com.api.finalProject.repo.ClientTransactionRepo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class BalanceService {

    private final ClientAccountRepo clientAccountRepo;
    private final ClientTransactionRepo clientTransactionRepo;

    public BalanceService(ClientAccountRepo clientAccountRepo, ClientTransactionRepo clientTransactionRepo) {
        this.clientAccountRepo = clientAccountRepo;
        this.clientTransactionRepo = clientTransactionRepo;
    }

    public ClientModel getBalance(Long idDonor) {
        ClientAccountEntity clientAccountEntity = clientAccountRepo.findById(idDonor).get();
        return ClientModel.toModel(clientAccountEntity);
    }

    public ClientModel putMoney(Long idDonor, BigDecimal amount) {
        ClientAccountEntity clientAccountEntity = clientAccountRepo.findById(idDonor)
                .orElseThrow(() -> new IllegalArgumentException("user is not found"));
        BigDecimal updatedBalance = clientAccountEntity.getBalance().add(amount);
        clientAccountEntity.setBalance(updatedBalance);

        ClientTransaction clientTransaction = new ClientTransaction();
        clientTransaction.setTransactionAmount(amount);
        clientTransaction.setTransactionDate(new Date());
        clientTransaction.setTransactionType("replenishment");
        clientTransaction.setClient(clientAccountEntity);
        clientTransactionRepo.save(clientTransaction);
        return ClientModel.toModel(clientAccountRepo.save(clientAccountEntity));
    }

    public ClientModel takeMoney(Long idDonor, BigDecimal amount) {
        ClientAccountEntity clientAccountEntity = clientAccountRepo.findById(idDonor)
                .orElseThrow(() -> new IllegalArgumentException("user is not found"));
        BigDecimal updatedBalance = clientAccountEntity.getBalance().subtract(amount);
        clientAccountEntity.setBalance(updatedBalance);

        ClientTransaction clientTransaction = new ClientTransaction();
        clientTransaction.setTransactionAmount(amount);
        clientTransaction.setTransactionDate(new Date());
        clientTransaction.setTransactionType("withdrawal");
        clientTransaction.setClient(clientAccountEntity);
        clientTransactionRepo.save(clientTransaction);
        return ClientModel.toModel(clientAccountRepo.save(clientAccountEntity));
    }




}