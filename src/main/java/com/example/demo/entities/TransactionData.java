package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table( name = "TRANSACTION_DATA")
public class TransactionData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "KEY")
    private String key;
    @Column(name = "VALUE")
    private String value;

    @ManyToOne
    @JoinColumn(name = "TRANSACTION") // Name of the column in the database
    private Transaction transaction; // Reference to the parent Transaction entity


}