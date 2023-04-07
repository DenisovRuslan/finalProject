package com.api.finalProject.controller;

import com.api.finalProject.entity.ClientAccountEntity;
import com.api.finalProject.service.ClientService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public void addClient(@RequestBody ClientAccountEntity clientAccountEntity) {
        this.clientService.addClient(clientAccountEntity);
    }

    @DeleteMapping("{id}")
    public void deleteClient(@PathVariable Long id) {
        this.clientService.deleteClient(id);
    }

}