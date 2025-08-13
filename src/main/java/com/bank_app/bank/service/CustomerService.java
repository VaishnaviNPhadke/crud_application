//CustomerService.java
package com.bank_app.bank.service;

import com.bank_app.bank.exception.CustomException;
import com.bank_app.bank.model.Customer;
import com.bank_app.bank.model.TransactionResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private final List<Customer> customers = new ArrayList<>();
    private int idCounter = 1;

    public Customer addCustomer(Customer customer) {
        customer.setCustomerId(idCounter++);
        customers.add(customer);
        return customer;
    }

    private Customer findCustomer(int id) {
        return customers.stream()
                .filter(c -> c.getCustomerId() == id)
                .findFirst()
                .orElseThrow(() -> new CustomException("Customer with id " + id + " not found."));
    }

    public TransactionResponse depositMoney(int customerId, double amount) {
        if (amount <= 0) throw new CustomException("Deposit amount must be positive.");
        Customer customer = findCustomer(customerId);
        double prev = customer.getBalance();
        customer.setBalance(prev + amount);

        return new TransactionResponse(customer.getCustomerId(), customer.getCustomerName(), prev, customer.getBalance());
    }

    public TransactionResponse withdrawMoney(int customerId, double amount) {
        if (amount <= 0) throw new CustomException("Withdrawal amount must be positive.");
        Customer customer = findCustomer(customerId);
        double prev = customer.getBalance();
        if (prev < amount) throw new CustomException("Insufficient balance.");
        customer.setBalance(prev - amount);

        return new TransactionResponse(customer.getCustomerId(), customer.getCustomerName(), prev, customer.getBalance());
    }

    public TransactionResponse transferMoney(int fromId, int toId, double amount) {
        if (amount <= 0) throw new CustomException("Transfer amount must be positive.");
        Customer sender = findCustomer(fromId);
        Customer receiver = findCustomer(toId);
        if (sender.getBalance() < amount) throw new CustomException("Insufficient balance for transfer.");

        double senderPrev = sender.getBalance();
        double receiverPrev = receiver.getBalance();

        sender.setBalance(senderPrev - amount);
        receiver.setBalance(receiverPrev + amount);

        TransactionResponse response = new TransactionResponse(sender.getCustomerId(), sender.getCustomerName(), senderPrev, sender.getBalance());
        response.setTransferMoneyTo(receiver.getCustomerName());
        response.setTransferMoneyDate(LocalDateTime.now());
        response.setReceivedMoneyFrom(sender.getCustomerName());
        response.setReceivedMoneyDate(LocalDateTime.now());
        return response;
    }

    public boolean authenticate(String username, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'authenticate'");
    }
}
