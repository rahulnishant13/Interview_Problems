import java.util.List;

public class ExpenseService {
    // EQUAL, EXACT or PERCENT

    public static Expense createExpense(ExpenseType expenseType, Integer paidBy, List<Split> splits, double amount){
        switch (expenseType){
            case EXACT:
                return new Expense(amount, splits, paidBy);
            case EQUAL:
                int totalSplit = splits.size();
                double splitAmount = ((double) Math.round(amount*100 / totalSplit)) / 100.0;
                for (Split split : splits) {
                    split.setAmount(splitAmount);
                }
                splits.get(0).setAmount(amount - (splitAmount*(totalSplit -1)));
                return new Expense(amount, splits, paidBy);
            case PERCENT:
                for (Split split : splits) {
                    PercentSplit percentSplit = (PercentSplit) split;
                    split.setAmount((amount * percentSplit.getPercent())/100.0);
                }

                return new Expense(amount, splits, paidBy);

            default:
                return null;
        }

    }
}
