package financialManager.transaction;

import java.util.Scanner;

public class Income extends Transaction {
    private final String type= "Income";

    public Income(String name, double amount) {
        super(name, amount);
    }

    public Income(String name, double amount, int day, int month, int year) {
        super(name, amount, day, month, year);
    }

    public Income(String name, double amount, int hour, int minute) {
        super(name, amount, hour, minute);
    }

    public Income(String name, double amount, int day, int month, int year, int hour, int minute) {
        super(name, amount, day, month, year, hour, minute);
    }


    @Override
    public String toString() {
        return "Income, " + getAmount() + ", " + getDescription() + ", " + getDate() + ", " + getTime();
    }
}
