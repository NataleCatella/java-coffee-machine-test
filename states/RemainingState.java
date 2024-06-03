package machine.states;

import machine.CoffeeMachineContext;

public class RemainingState extends State {
    public RemainingState(CoffeeMachineContext coffeMachine) {
        super(coffeMachine);
    }

    @Override
    public void processAction() {
        System.out.println("The coffee machine has:");
        System.out.println(this.coffeeMachine.getMlWater() + " ml of water");
        System.out.println(this.coffeeMachine.getMlMilk() + " ml of milk");
        System.out.println(this.coffeeMachine.getGCoffeeBeans() + " g of coffee beans");
        System.out.println(this.coffeeMachine.getDisposableCups() + " disposable cups");
        System.out.println("$" + this.coffeeMachine.getIncome() + " of money");
        System.out.println();
        System.out.println();
        this.coffeeMachine.returnToReadyState();
    }
}
