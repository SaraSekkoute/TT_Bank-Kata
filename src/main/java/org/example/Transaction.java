package org.example;

import java.time.LocalDate;

public class Transaction {

    private int amount;
    private String type;
    private LocalDate date;

    public Transaction(int amount, String type, LocalDate date) {
        this.amount = amount;
        this.type = type;
        this.date = date;
    }

    public Transaction(int amount, String type) {
        this.amount = amount;
        this.type = type;
    }

    // Getters and Setters
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
