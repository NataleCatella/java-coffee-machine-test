package machine.states;

import machine.CoffeeMachineContext;

import java.util.Scanner;

public class ReadyState extends State {
    private enum actions {
        BUY, FILL, TAKE, REMAINING, EXIT
    }

    public ReadyState(CoffeeMachineContext coffeMachine) {
        super(coffeMachine);
    }

    public void processAction() {
        String action;
        
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            Scanner scanner = new Scanner(System.in);
            action = scanner.next();

            switch (action) {
                case "buy":
                    State buyState = new BuyState(this.coffeeMachine);
                    this.coffeeMachine.setState(buyState);
                    break;
                case "fill":
                    State fillState = new FillState(this.coffeeMachine);
                    this.coffeeMachine.setState(fillState);
                    break;
                case "take":
                    State takeState = new TakeState(this.coffeeMachine);
                    this.coffeeMachine.setState(takeState);
                    break;
                case "remaining":
                    State remainingState = new RemainingState(this.coffeeMachine);
                    this.coffeeMachine.setState(remainingState);
                    break;
                case "exit":
                    State exitState = new ExitState(this.coffeeMachine);
                    this.coffeeMachine.setState(exitState);
                    break;
                default:
                    System.out.println("Invalid action");
            }
        } while (!isValidAction(action));
        
        this.coffeeMachine.processAction();
    }
    
    private boolean isValidAction(String action) {
        for (actions a : actions.values()) {
            if (a.name().toLowerCase().equals(action)) return true;
        }
        return false;
    }
}
