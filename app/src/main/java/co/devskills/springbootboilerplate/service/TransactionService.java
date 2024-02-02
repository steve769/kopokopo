package co.devskills.springbootboilerplate.service;

import co.devskills.springbootboilerplate.dto.TransactionRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Map;

@Service
public interface TransactionService {
    ResponseEntity<Map<String, Object>> createTransaction(TransactionRequest transactionRequest, BindingResult bindingResult);

    ResponseEntity<Map<String, Object>> fetchAllTransactions();

    ResponseEntity<Map<String, Object>> fetchTransactionById(String transactionId);
}
