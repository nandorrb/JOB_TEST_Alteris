package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.security.Timestamp;
import java.util.List;

@Entity
@Getter
@Setter
@Table( name = "TRANSACTION")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    public Long id;
    @Column(name = "TIMESTAMP")
    public Timestamp timestamp;
    @Column(name = "TYPE")
    public String type;
    @Column(name = "ACTOR")
    public String actor;
    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL)
    private List<TransactionData> transactionDataList; // Use a list for one-to-many mapping



}