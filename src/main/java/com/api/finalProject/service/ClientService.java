package com.api.finalProject.service;

import com.api.finalProject.entity.ClientAccountEntity;
import com.api.finalProject.repo.ClientAccountRepo;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientAccountRepo clientAccountRepo;

    public ClientService(ClientAccountRepo clientAccountRepo) {
        this.clientAccountRepo = clientAccountRepo;
    }

    public void addClient(ClientAccountEntity clientAccountEntity) {
        this.clientAccountRepo.save(clientAccountEntity);

    }

    public void deleteClient(Long id) {
        clientAccountRepo.deleteById(id);
    }

}