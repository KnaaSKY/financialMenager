package financialManager.transaction;

import java.util.Scanner;

public class Expense extends Transaction {
    private final String type = "Expense";

    public Expense(String name, double amount) {
        super(name, amount);
    }

    public Expense(String name, double amount, int day, int month, int year) {
        super(name, amount, day, month, year);
    }

    public Expense(String name, double amount, int hour, int minute) {
        super(name, amount, hour, minute);
    }

    public Expense(String name, double amount, int day, int month, int year, int hour, int minute) {
        super(name, amount, day, month, year, hour, minute);
    }

    @Override
    public String toString() {
        return "Expense, " + getAmount() + ", " + getDescription() + ", " + getDate() + ", " + getTime();
    }

}
