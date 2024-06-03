package machine.states;

import machine.CoffeeMachineContext;

public class ExitState extends State {
    public ExitState(CoffeeMachineContext coffeMachine) {
        super(coffeMachine);
    }

    @Override
    public void processAction() {
        System.exit(0);
    }
}
