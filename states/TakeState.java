package machine.states;

import machine.CoffeeMachineContext;

public class TakeState extends State {
    public TakeState(CoffeeMachineContext coffeMachine) {
        super(coffeMachine);
    }

    @Override
    public void processAction() {
        this.coffeeMachine.takeIncome();
        this.coffeeMachine.setIncome(0);
        this.coffeeMachine.returnToReadyState();
    }
}
