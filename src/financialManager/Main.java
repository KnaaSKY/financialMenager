package financialManager;

import financialManager.transaction.Expense;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean shouldContinue = true;
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();


        System.out.print("Enter account balance: ");
        int balance = scanner.nextInt();
        Account account = new Account(balance);

        while (shouldContinue) {
            menu.displayMenu();
            int userChoice = scanner.nextInt();
            switch (userChoice) {
                case 1 -> account.displayBalance();
                case 2 -> account.displayHistory();
                case 3 -> account.addIncome();
                case 4 -> account.addExpense();
                case 5 -> account.displayRaport();
                case 7 -> {
                    scanner.nextLine();
                    System.out.println("Are you sure? (Y/N)");
                    String exit = scanner.nextLine();
                    if (exit.equals("Y") || exit.equals("y")) {
                        shouldContinue = false;
                        System.out.println("Closing the program");
                    } else if (exit.equals("N") || exit.equals("n")) {
                        continue;
                    }

                }
            }
        }
    }
}

