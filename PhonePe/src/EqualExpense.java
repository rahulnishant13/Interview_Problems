import java.util.List;

public class EqualExpense extends Expense{
    public EqualExpense(double amount, List<Split> splits, int paidBy) {
        super(amount, splits, paidBy);
    }
}
