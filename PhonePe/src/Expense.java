import java.util.List;

public class Expense {
    private String id;
    private double amount;
    private List<Split> splits;
    private Integer paidBy;

    public Expense(double amount, List<Split> splits, Integer paidBy) {
        this.amount = amount;
        this.splits = splits;
        this.paidBy = paidBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    public Integer getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(Integer paidBy) {
        this.paidBy = paidBy;
    }
}
