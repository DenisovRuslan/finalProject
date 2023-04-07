package com.api.finalProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "transactions")
public class ClientTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transactionAmount")
    private BigDecimal transactionAmount;

    @Column(name = "transactionDate")
    private Date transactionDate;

    @Column(name = "transactionType")
    private String transactionType;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private ClientAccountEntity client;

}