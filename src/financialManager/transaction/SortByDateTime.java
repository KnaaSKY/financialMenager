package financialManager.transaction;

import java.util.Comparator;

public class SortByDateTime implements Comparator<Transaction> {
    public int compare(Transaction t1, Transaction t2) {
        int dateComparison = t1.getDate().compareTo(t2.getDate());

        if (dateComparison == 0) {
            int timeComparison = t1.getTime().compareTo(t2.getTime());
            return timeComparison;
        }

        return dateComparison;
    }
}
