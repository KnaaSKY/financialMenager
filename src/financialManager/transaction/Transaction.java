package financialManager.transaction;

import java.time.LocalDate;
import java.time.LocalTime;


public abstract class Transaction implements Transcations{
    private double amount;
    private String description;
    private LocalDate date;
    private LocalTime time;


    public Transaction(String description, double amount) {
        if(amount > 0) {
            this.description = description;
            this.amount = amount;
            this.date = LocalDate.now();
            this.time = LocalTime.of(LocalTime.now().getHour(), LocalTime.now().getMinute());
        }
        else System.out.println("Incorrect data!");
    }

    public Transaction(String description, double amount, int day, int month, int year) {
        if(amount > 0 && day > 0 && day <= 31 && month > 0 && month <= 12 && year > 2000 && year <= 3000) {
            this.description = description;
            this.amount = amount;
            this.date = LocalDate.of(year, month, day);
            this.time = LocalTime.of(LocalTime.now().getHour(), LocalTime.now().getMinute());
        }
        else {
            System.out.println("Incorrect data!");
        }
    }

    public Transaction(String description, double amount, int hour, int minute) {
        if(amount > 0 && hour >= 0 && hour <= 24 && minute >= 0 && minute < 60) {
            if(hour == 24) hour = 0;
            this.description = description;
            this.amount = amount;
            this.date = LocalDate.now();
            this.time = LocalTime.of(hour, minute);
        }
        else {
            System.out.println("Incorrect data!");
        }
    }

    public Transaction(String description, double amount, int day, int month, int year, int hour, int minute) {
        if(amount > 0 && day > 0 && day <= 31 && month > 0 && month <= 12 && year > 2000 && year <= 3000 && hour >= 0 && hour <= 24 && minute >= 0 && minute < 60) {
            if(hour == 24) hour = 0;
            this.description = description;
            this.amount = amount;
            this.date = LocalDate.of(year, month, day);
            this.time = LocalTime.of(hour, minute);
        }
        else {
            System.out.println("Incorrect data!");
        }
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public LocalTime getTime() {
        return time;
    }

    public LocalDate getDate() {
        return date;
    }
}

