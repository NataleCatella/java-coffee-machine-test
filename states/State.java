package machine.states;
import machine.CoffeeMachineContext;

public abstract class State {
    CoffeeMachineContext coffeeMachine;
    
    State(CoffeeMachineContext coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }
    
    public abstract void processAction();
}
