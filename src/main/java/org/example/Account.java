package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Account implements AccountService {

    // to store multiple transaction deposits / withdrawals
    private List<Transaction> transactions = new ArrayList<>();
    private int balance;

    // Original deposit method (from AccountService interface)
    @Override
    public void deposit(int amount) {
        transactions.add(new Transaction(amount, "deposit"));
    }

    // Overloaded deposit method (accepts both amount and date)
    public void deposit(int amount, LocalDate date) {
        transactions.add(new Transaction(amount, "deposit", date));
    }

    // Original withdraw method (from AccountService interface)
    @Override
    public void withdraw(int amount) {
        transactions.add(new Transaction(-amount, "withdraw"));
    }

    // Overloaded withdraw method (accepts both amount and date)
    public void withdraw(int amount, LocalDate date) {
        transactions.add(new Transaction(-amount, "withdraw", date));
    }

    public void printStatement() {

        // to construct the statement string
        StringBuilder statement = new StringBuilder();

        // The table header
        statement.append("Date       || Amount || Balance\n");

        List<String> statementLines = new ArrayList<>();
        int balance = 0;
        for (Transaction transaction : transactions) {
            balance += transaction.getAmount();

            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = transaction.getDate().format(outputFormatter);

            statementLines.add(formattedDate + " || " + transaction.getAmount() + "   || " + balance);
        }

        // sort the table by date in descending order
        statementLines.sort((line1, line2) -> line2.compareTo(line1));

        // build the StringBuilder after sorting
        for (String line : statementLines) {
            statement.append(line).append("\n");
        }

        System.out.print(statement.toString());
    }

    // Getters and Setters
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}
