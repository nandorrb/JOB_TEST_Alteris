package com.example.demo.controllers;

import com.example.demo.dtos.TransactionDTO;
import com.example.demo.entities.Transaction;
import com.example.demo.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/transactions")
public class TransactionController {


    @Autowired
    private TransactionRepository transactionRepository;

    // Create a new transaction
    @PostMapping
    public ResponseEntity<TransactionDTO> createTransaction(@RequestBody TransactionDTO transactionDTO) {
        // Convert TransactionDTO to Transaction entity
        Transaction transaction = new Transaction();
        transaction.timestamp = transactionDTO.timestamp;
        transaction.type = transactionDTO.type;
        transaction.actor = transactionDTO.actor;

        // Save the transaction in the repository
        transaction = transactionRepository.save(transaction);

        // Convert the saved Transaction entity back to TransactionDTO
        TransactionDTO savedTransactionDTO = convertToDTO(transaction);

        return new ResponseEntity<>(savedTransactionDTO, HttpStatus.CREATED);
    }

    // Read a transaction by ID
    @GetMapping("/{id}")
    public ResponseEntity<TransactionDTO> getTransactionById(@PathVariable Long id) {
        // Retrieve the transaction from the repository
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);

        if (optionalTransaction.isPresent()) {
            Transaction transaction = optionalTransaction.get();
            TransactionDTO transactionDTO = convertToDTO(transaction);
            return new ResponseEntity<>(transactionDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get all transactions
    @GetMapping("/")
    public ResponseEntity<List<TransactionDTO>> getAllTransactions() {
        // Retrieve all transactions from the repository
        List<Transaction> transactions = transactionRepository.findAll();

        // Convert the list of Transaction entities to a list of TransactionDTOs
        List<TransactionDTO> transactionDTOs = transactions.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(transactionDTOs, HttpStatus.OK);
    }

    // Update a transaction by ID
    @PutMapping("/{id}")
    public ResponseEntity<TransactionDTO> updateTransaction(@PathVariable Long id, @RequestBody TransactionDTO transactionDTO) {
        // Check if the transaction with the given ID exists
        if (!transactionRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Convert TransactionDTO to Transaction entity
        Transaction transaction = new Transaction();
        transaction.id = id;
        transaction.timestamp = transactionDTO.timestamp;
        transaction.type = transactionDTO.type;
        transaction.actor = transactionDTO.actor;

        // Save the updated transaction in the repository
        transaction = transactionRepository.save(transaction);

        // Convert the updated Transaction entity back to TransactionDTO
        TransactionDTO updatedTransactionDTO = convertToDTO(transaction);

        return new ResponseEntity<>(updatedTransactionDTO, HttpStatus.OK);
    }

    // Delete a transaction by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        // Check if the transaction with the given ID exists
        if (!transactionRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Delete the transaction from the repository
        transactionRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Utility method to convert Transaction entity to TransactionDTO
    private TransactionDTO convertToDTO(Transaction transaction) {
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.id = transaction.id;
        transactionDTO.timestamp = transaction.timestamp;
        transactionDTO.type = transaction.type;
        transactionDTO.actor = transaction.actor;

        // You can also convert TransactionData entities to TransactionDataDTO here if needed

        return transactionDTO;
    }


}
