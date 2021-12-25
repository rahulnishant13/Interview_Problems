import java.util.ArrayList;
import java.util.List;

public class ExpenseController {
    public static void main(String[] args) {
        ExpenseManager expenseManager = new ExpenseManager();

        expenseManager.addUser( new User(1, "rahul", "rahul@gmail.com", "9876543210"));
        expenseManager.addUser(new User(2, "nishant", "asas@gmail.com", "9876243210"));

        List<Split> splits = new ArrayList<>();
        splits.add(new EqualSplit(expenseManager.userMap.get(1)));
        splits.add(new EqualSplit(expenseManager.userMap.get(2)));
        expenseManager.addExpenses(ExpenseType.EXACT, 1, splits, 50);

        expenseManager.printExpense(1);
    }
}
