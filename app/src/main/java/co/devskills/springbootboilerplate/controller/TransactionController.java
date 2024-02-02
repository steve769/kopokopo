package co.devskills.springbootboilerplate.controller;

import co.devskills.springbootboilerplate.dto.TransactionRequest;
import co.devskills.springbootboilerplate.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/")
    public ResponseEntity<Map<String, Object>> createTransaction(@Valid @RequestBody TransactionRequest transactionRequest, BindingResult bindingResult){
        return transactionService.createTransaction(transactionRequest, bindingResult);
    }

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> fetchAllTransactions(){
        return transactionService.fetchAllTransactions();
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<Map<String, Object>> fetchAllTransactions(@PathVariable String transactionId){
        return transactionService.fetchTransactionById(transactionId);
    }


}
