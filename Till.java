package machine;

public class Till {
    private int income;

    public Till() {
        this.income = 550;
    }

    public int getIncome() {
        return this.income;
    }

    public void addIncome(int income) {
        this.income += income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public void takeIncome() {
        System.out.println("I gave you $" + this.income);
    }
}
