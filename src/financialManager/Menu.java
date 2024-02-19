package financialManager;

public class Menu {
    public void displayMenu() {
        System.out.println("Select option:");
        System.out.println("1. Display account balance");
        System.out.println("2. Display financial history");
        System.out.println("3. Add income");
        System.out.println("4. Add expense");
        System.out.println("5. Display raport");
        System.out.println("6. Change currency");
        System.out.println("7. Exit");
    }

    public void displayRaportMenu() {
        System.out.println("Select a time period:");
        System.out.println("1. Today");
        System.out.println("2. Last week");
        System.out.println("3. Last month");
        System.out.println("4. Last 3 months");
        System.out.println("5. Last 6 month");
        System.out.println("6. Last year");
        System.out.println("7. Different period");
        System.out.println("8. Exit");
    }
}
