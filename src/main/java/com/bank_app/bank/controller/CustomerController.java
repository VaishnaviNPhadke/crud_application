// File: CustomerController.java
package com.bank_app.bank.controller;
import com.bank_app.bank.model.Customer;
import com.bank_app.bank.model.TransactionResponse;
import com.bank_app.bank.security.jwtUtil;
import com.bank_app.bank.service.CustomerService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final jwtUtil jwtUtil;

    @Autowired
    public CustomerController(CustomerService customerService, jwtUtil jwtUtil) {
        this.customerService = customerService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        //return ResponseEntity.ok(customerService.addCustomer(customer));
        return ResponseEntity.ok(customerService.addCustomer(customer));
    }

    @PutMapping("/{customerId}/deposit")
    public ResponseEntity<TransactionResponse> deposit(@PathVariable int customerId, @RequestParam double amount) {
        return ResponseEntity.ok(customerService.depositMoney(customerId, amount));
    }

    @PutMapping("/{customerId}/withdraw")
    public ResponseEntity<TransactionResponse> withdraw(@PathVariable int customerId, @RequestParam double amount) {
        return ResponseEntity.ok(customerService.withdrawMoney(customerId, amount));
    }

    @PutMapping("/transfer")
    public ResponseEntity<TransactionResponse> transfer(@RequestParam int fromId, @RequestParam int toId, @RequestParam double amount) {
        return ResponseEntity.ok(customerService.transferMoney(fromId, toId, amount));
    }
}
