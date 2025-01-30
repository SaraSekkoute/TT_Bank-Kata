package org.example;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account implements AccountService{

    //to store multiple transaction deposits / withdrawals.
    List<Transaction> transactions = new ArrayList<>();

    @Override
    public void deposit(int amount) {
        transactions.add(new Transaction(amount, "deposit"));
    }


    public void deposit(int amount,LocalDate date) {
        transactions.add(new Transaction(amount, "deposit",date));
    }

    @Override
    public void withdraw(int amount) {
        amount=-amount;
        transactions.add(new Transaction(amount, "withdraw"));
    }

    public void withdraw(int amount, LocalDate date) {
        amount=-amount;
        transactions.add(new Transaction(amount, "withdraw",date));
    }

    public void printStatement() {
            StringBuilder statement = new StringBuilder();
        statement.append("Date       || Amount || Balance\n");
            int balance = 0;
            for (Transaction transaction : transactions) {
                balance += transaction.getAmount();
                DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String formattedDate = transaction.getDate().format(outputFormatter);
                statement.append(formattedDate).append(" || ").append(transaction.getAmount()).append(" || ").append(balance).append("\n");
            }


        System.out.print(statement.toString());
    }


}
