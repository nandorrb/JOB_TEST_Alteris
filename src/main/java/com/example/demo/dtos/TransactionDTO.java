package com.example.demo.dtos;

import lombok.Getter;
import lombok.Setter;

import java.security.Timestamp;
import java.util.List;

@Getter
@Setter
public class TransactionDTO {
    public Long id;
    public Timestamp timestamp;
    public String type;
    public String actor;
    public List<TransactionDataDTO> transactionData;


}
