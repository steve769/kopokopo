package co.devskills.springbootboilerplate.service;

import co.devskills.springbootboilerplate.dto.TransactionRequest;
import co.devskills.springbootboilerplate.entity.Transaction;
import co.devskills.springbootboilerplate.repository.TransactionRepository;
import co.devskills.springbootboilerplate.utils.APIResponse;
import co.devskills.springbootboilerplate.utils.ValidationFieldResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class TransactionServiceImpl implements TransactionService{
    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public ResponseEntity<Map<String, Object>> createTransaction(TransactionRequest transactionRequest, BindingResult bindingResult) {
        try{
            //Check for Validation Errors
            if(bindingResult.hasErrors()){
                return ValidationFieldResponse.validationCheckingFailed(bindingResult);
            }

            //Map from DTO
            Transaction transaction = new Transaction();
            transaction.setAccountId(transactionRequest.getAccountId());
            transaction.setAmount(transactionRequest.getAmount());
            transaction.setCreatedAt(LocalDateTime.now());

            //save transaction
            transactionRepository.save(transaction);

            return APIResponse.genericResponse("success", "user created successfully", HttpStatus.CREATED);

        }catch(Exception ex){
            return APIResponse.genericResponse("failure", ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Map<String, Object>> fetchAllTransactions() {
        try{
            //fetch From Database
            Map<String, Object> transactions = new HashMap<>();
            List<Transaction> allTransactions = transactionRepository.findAll();
            transactions.put("transactions", allTransactions);


            return APIResponse.genericResponse("success", transactions, HttpStatus.OK);
        }catch(Exception ex){
            return APIResponse.genericResponse("failure", ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Map<String, Object>> fetchTransactionById(String transactionId) {
        try{
            //fetch From Database
            Map<String, Object> transactions = new HashMap<>();
            Transaction optionalTransaction = transactionRepository.findByTransactionId(UUID.fromString(transactionId)).orElse(null);

            if(optionalTransaction != null){
                transactions.put("transaction", optionalTransaction);
            }
            return APIResponse.genericResponse("success", transactions, HttpStatus.OK);
        }catch(Exception ex){
            return APIResponse.genericResponse("failure", ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
