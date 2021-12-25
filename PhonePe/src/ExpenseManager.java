import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {
    List<Expense> expenses;
    Map<Integer, User> userMap;
    Map<Integer, Map<Integer, Double>> balanceSheet;


    public ExpenseManager(){
        expenses = new ArrayList<>();
        userMap = new HashMap<>();
        balanceSheet = new HashMap<>();
    }

    public void addUser(User user){
        userMap.put(user.getUserId(), user);
    }

    public void addExpenses(ExpenseType expenseType, Integer paidBy, List<Split> splits, double amount){
        Expense expense = ExpenseService.createExpense(expenseType, paidBy, splits, amount);
        expenses.add(expense);
        for (Split split : splits) {
            Integer paidTo = split.getUser().getUserId();

            Map<Integer, Double> balances = balanceSheet.getOrDefault(paidBy, new HashMap<>());
            balances.put(paidTo, balances.getOrDefault(paidTo, 0.0) + split.getAmount());

            balances = balanceSheet.getOrDefault(paidTo, new HashMap<>());
            balances.put(paidBy, (balances.getOrDefault(paidBy, 0.0) - split.getAmount()));
        }
    }

    public void printExpense(Integer userId){
        for (Map.Entry<Integer, Double> userBal : balanceSheet.get(userId).entrySet()) {
            if(userBal.getValue() != 0){
                this.printBalance(userId, userBal.getKey(), userBal.getValue());
            }
        }
    }

    public void printBalance(Integer user1, Integer user2, double amount){
        if (amount < 0){
            System.out.println(userMap.get(user1).getName() + " owes "+ userMap.get(user2).getName()  +" "+ Math.abs(amount));
        }
        else if (amount > 0){
            System.out.println(userMap.get(user2).getName() + " owes "+ userMap.get(user1).getName() );
        }
    }
}
