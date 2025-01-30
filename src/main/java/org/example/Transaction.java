package org.example;

import java.time.LocalDate;

public class Transaction {

        private  int amount;
        private  String type;
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

        public int getAmount() {
            return amount;
        }

        public LocalDate getDate() {
            return date;
        }

}
