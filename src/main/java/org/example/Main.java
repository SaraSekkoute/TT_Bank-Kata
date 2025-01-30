package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Account account = new Account();
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate date1 = LocalDate.parse("10-01-2012", inputFormatter);
        LocalDate date2 = LocalDate.parse("13-01-2012", inputFormatter);
        LocalDate date3 = LocalDate.parse("14-01-2012", inputFormatter);

        account.deposit(1000, date1);
        account.deposit(2000, date2);
        account.withdraw(500, date3);
        
        account.printStatement();
    }
}
