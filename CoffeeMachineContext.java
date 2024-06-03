package machine;

import machine.states.ReadyState;
import machine.states.State;

public class CoffeeMachineContext {
    private int mlWater;
    private int mlMilk;
    private int gCoffeeBeans;
    private int disposableCups;
    private int income;
    private State state;

    public CoffeeMachineContext() {
        this.setMlWater(400);
        this.setMlMilk(540);
        this.setGCoffeeBeans(120);
        this.setDisposableCups(9);
        this.setIncome(550);
        this.setState(new ReadyState(this));
        processAction();
    }

    public int getMlWater() {
        return mlWater;
    }

    public void setMlWater(int mlWater) {
        this.mlWater = mlWater;
    }

    public int getMlMilk() {
        return mlMilk;
    }

    public void setMlMilk(int mlMilk) {
        this.mlMilk = mlMilk;
    }

    public int getGCoffeeBeans() {
        return gCoffeeBeans;
    }

    public void setGCoffeeBeans(int gCoffeeBeans) {
        this.gCoffeeBeans = gCoffeeBeans;
    }

    public int getDisposableCups() {
        return this.disposableCups;
    }

    public void setDisposableCups(int disposableCups) {
        this.disposableCups = disposableCups;
    }

    public int getIncome() {
        return this.income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public void addIncome(int income) {
        this.income += income;
    }

    public void takeIncome() {
        System.out.println("I gave you $" + this.income);
    }

    public State getState() {
        return state;
    }
    
    public void setState(State state) {
        this.state = state;
    }
    
    public void processAction() {
        state.processAction();
    }
    
    public void returnToReadyState(){
        this.setState(new ReadyState(this));
        processAction();
    }
}
