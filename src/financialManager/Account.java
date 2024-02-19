package financialManager;

import financialManager.transaction.Expense;
import financialManager.transaction.Income;
import financialManager.transaction.SortByDateTime;
import financialManager.transaction.Transaction;

import java.time.LocalDate;
import java.util.*;

public class Account {
    private double balance;
    private List<Transaction> history = new ArrayList<>();
    Menu menu = new Menu();

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void displayHistory() {
        System.out.println("Transaction History:");
        ListIterator<Transaction> iterator = history.listIterator(history.size());

        while (iterator.hasPrevious()) {
            Transaction tran = iterator.previous();
            System.out.println(tran);
        }
    }

    private void sortHistoryByDateTime() {
        Collections.sort(history, new SortByDateTime());
    }

    public void displayBalance() {
        System.out.println("Balance: " + balance);
    }

    private void updateBalance(Transaction trans) {
        if (trans instanceof Income) {
            balance += ((Income) trans).getAmount();
            this.addTransaction(trans);
        } else {
            balance -= ((Expense) trans).getAmount();
            this.addTransaction(trans);
        }
        sortHistoryByDateTime();
    }

    private void addTransaction(Transaction transaction) {
        history.add(transaction);
    }

    public void displayRaport() {
        Scanner scanner = new Scanner(System.in);
        menu.displayRaportMenu();
        int userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1 -> System.out.println("Balance from today: " + calculateBalance(0));
            case 2 -> System.out.println("Balance from last week: " + calculateBalance(7));
            case 3 -> System.out.println("Balance from last month: " + calculateBalance(31));
            case 4 -> System.out.println("Balance from last 3 months: " + calculateBalance(92));
            case 5 -> System.out.println("Balance from last 6 months: " + calculateBalance(183));
            case 6 -> System.out.println("Balance from last year: " + calculateBalance(365));
            case 7 -> {
                System.out.println("Enter the number of days back:");
                int daysBack = scanner.nextInt();
                System.out.println("Balance from last " + daysBack + " days: " + calculateBalance(daysBack));
            }
            case 8 -> {}
        }
    }

    private double calculateBalance(int daysBack) {
        double totalBalance = 0.0;
        LocalDate startDate = LocalDate.now().minusDays(daysBack);

        for (Transaction transaction : history) {
            if (transaction.getDate().isAfter(startDate) || transaction.getDate().isEqual(startDate)) {
                if (transaction instanceof Income) {
                    totalBalance += transaction.getAmount();
                } else if (transaction instanceof Expense) {
                    totalBalance -= transaction.getAmount();
                }
            }
        }
        return totalBalance;
    }

    public void addIncome() {
        System.out.println("Enter the income amount: ");
        Scanner scanner = new Scanner(System.in);
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter a name of income: ");
        String name = scanner.nextLine();
        System.out.println("Current date? Y/N");
        String choiceDate = scanner.nextLine();
        if (choiceDate.equals("Y") || choiceDate.equals("y")) {
            System.out.println("Current time? Y/N");
            String choiceTime = scanner.nextLine();
            if (choiceTime.equals("Y") || choiceTime.equals("y")) {
                Income income = new Income(name, amount);
                this.updateBalance(income);
            } else if (choiceTime.equals("N") || choiceTime.equals("n")) {
                System.out.println("Enter hour: ");
                int hour = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter minute: ");
                int minute = Integer.parseInt(scanner.nextLine());
                Income income = new Income(name, amount, hour, minute);
                this.updateBalance(income);
            } else {
                System.out.println("Incorrect data!");
            }
        } else if (choiceDate.equals("N") || choiceDate.equals("n")) {
            System.out.println("Enter day: ");
            int day = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter month: ");
            int month = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter year: ");
            int year = Integer.parseInt(scanner.nextLine());

            System.out.println("Current time? Y/N");
            String choiceTime = scanner.nextLine();
            if (choiceTime.equals("Y") || choiceTime.equals("y")) {
                Income income = new Income(name, amount, day, month, year);
                this.updateBalance(income);
            } else if (choiceTime.equals("N") || choiceTime.equals("n")) {
                System.out.println("Enter hour: ");
                int hour = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter minute: ");
                int minute = Integer.parseInt(scanner.nextLine());
                Income income = new Income(name, amount, day, month, year, hour, minute);
                this.updateBalance(income);
            } else {
                System.out.println("Incorrect data!");
            }

        } else {
            System.out.println("Incorrect data!");
        }
    }

    public void addExpense() {
        System.out.println("Enter the expense amount: ");
        Scanner scanner = new Scanner(System.in);
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter a name of expense: ");
        String name = scanner.nextLine();
        System.out.println("Current date? Y/N");
        String choiceDate = scanner.nextLine();
        if (choiceDate.equals("Y") || choiceDate.equals("y")) {
            System.out.println("Current time? Y/N");
            String choiceTime = scanner.nextLine();
            if (choiceTime.equals("Y") || choiceTime.equals("y")) {
                Expense expense = new Expense(name, amount);
                this.updateBalance(expense);
            } else if (choiceTime.equals("N") || choiceTime.equals("n")) {
                System.out.println("Enter hour: ");
                int hour = scanner.nextInt();
                System.out.println("Enter minute: ");
                int minute = scanner.nextInt();
                Expense expense = new Expense(name, amount, hour, minute);
                this.updateBalance(expense);
            } else {
                System.out.println("Incorrect data!");
            }
        } else if (choiceDate.equals("N") || choiceDate.equals("n")) {
            System.out.println("Enter day: ");
            int day = scanner.nextInt();
            System.out.println("Enter month: ");
            int month = scanner.nextInt();
            System.out.println("Enter year: ");
            int year = scanner.nextInt();

            System.out.println("Current time? Y/N");
            String choiceTime = scanner.nextLine();
            if (choiceTime.equals("Y") || choiceTime.equals("y")) {
                Expense expense = new Expense(name, amount, day, month, year);
                this.updateBalance(expense);
            } else if (choiceTime.equals("N") || choiceTime.equals("n")) {
                System.out.println("Enter hour: ");
                int hour = scanner.nextInt();
                System.out.println("Enter minute: ");
                int minute = scanner.nextInt();
                Expense expense = new Expense(name, amount, day, month, year, hour, minute);
                this.updateBalance(expense);
            } else {
                System.out.println("Incorrect data!");
            }

        } else {
            System.out.println("Incorrect data!");
        }
    }
}
