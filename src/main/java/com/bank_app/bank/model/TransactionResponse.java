//TransactionResponse.java
package com.bank_app.bank.model;

import java.time.LocalDateTime;

public class TransactionResponse {
    private int customerId;
    private String customerName;
    private double previousBalance;
    private double currentBalance;
    private String receivedMoneyFrom;
    private LocalDateTime receivedMoneyDate;
    private String transferMoneyTo;
    private LocalDateTime transferMoneyDate;

    public TransactionResponse(int customerId, String customerName, double previousBalance, double currentBalance) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.previousBalance = previousBalance;
        this.currentBalance = currentBalance;
    }

    // Getters and Setters...
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public double getPreviousBalance() { return previousBalance; }
    public void setPreviousBalance(double previousBalance) { this.previousBalance = previousBalance; }

    public double getCurrentBalance() { return currentBalance; }
    public void setCurrentBalance(double currentBalance) { this.currentBalance = currentBalance; }

    public String getReceivedMoneyFrom() { return receivedMoneyFrom; }
    public void setReceivedMoneyFrom(String receivedMoneyFrom) { this.receivedMoneyFrom = receivedMoneyFrom; }

    public LocalDateTime getReceivedMoneyDate() { return receivedMoneyDate; }
    public void setReceivedMoneyDate(LocalDateTime receivedMoneyDate) { this.receivedMoneyDate = receivedMoneyDate; }

    public String getTransferMoneyTo() { return transferMoneyTo; }
    public void setTransferMoneyTo(String transferMoneyTo) { this.transferMoneyTo = transferMoneyTo; }

    public LocalDateTime getTransferMoneyDate() { return transferMoneyDate; }
    public void setTransferMoneyDate(LocalDateTime transferMoneyDate) { this.transferMoneyDate = transferMoneyDate; }
}
