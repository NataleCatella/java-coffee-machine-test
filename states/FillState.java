package machine.states;

import machine.CoffeeMachineContext;

import java.util.Scanner;

public class FillState extends State {
    public FillState(CoffeeMachineContext coffeMachine) {
        super(coffeMachine);
    }

    @Override
    public void processAction() {
        Scanner scanner = new Scanner(System.in);
        // TODO: Validate inputs here and insert potential do while loop
        System.out.println("Write how many ml of water do you want to add:");
        int mlOfWaterToAdd = scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        int mlOfMilkToAdd = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int gOfCoffeeToAdd = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int disposableCupsToAdd = scanner.nextInt();

        this.coffeeMachine.setMlWater(this.coffeeMachine.getMlWater() + mlOfWaterToAdd);
        this.coffeeMachine.setMlMilk(this.coffeeMachine.getMlMilk() + mlOfMilkToAdd);
        this.coffeeMachine.setGCoffeeBeans(this.coffeeMachine.getGCoffeeBeans() + gOfCoffeeToAdd);
        this.coffeeMachine.setDisposableCups(this.coffeeMachine.getDisposableCups() + disposableCupsToAdd);
        this.coffeeMachine.returnToReadyState();
    }
}
