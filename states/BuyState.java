package machine.states;

import machine.CoffeeMachineContext;

import java.util.Scanner;

public class BuyState extends State {
    BuyState(CoffeeMachineContext coffeMachine) {
        super(coffeMachine);
    }

    @Override
    public void processAction() {
        CoffeeType selectedType;
        int storedMlWater = this.coffeeMachine.getMlWater();
        int storedMlMilk = this.coffeeMachine.getMlMilk();
        int storedGCoffeeBeans = this.coffeeMachine.getGCoffeeBeans();
        int storedDisposableCups = this.coffeeMachine.getDisposableCups();
        Scanner scanner = new Scanner(System.in);
        String selection;

        do {
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
            selection = scanner.next();
            switch (selection) {
                case "1":
                    selectedType = CoffeeType.ESPRESSO;
                    break;
                case "2":
                    selectedType = CoffeeType.LATTE;
                    break;
                case "3":
                    selectedType = CoffeeType.CAPPUCCINO;
                    break;
                default:
                    System.out.println("Invalid product");
                    return;
            }
        } while (!isSelectionValid(selection));

        int mlWaterToUse = selectedType.getMlWater();
        int mlMilkToUse = selectedType.getMlMilk();
        int gCoffeeBeansToUse = selectedType.getgCoffeeBeans();
        int disposableCupsToUse = 1;
        int price = selectedType.getPrice();

        boolean isWaterSufficient = storedMlWater >= mlWaterToUse;
        boolean isMilkeSufficient = storedMlMilk >= mlMilkToUse;
        boolean isCoffeeBeansSufficient = storedGCoffeeBeans >= gCoffeeBeansToUse;
        boolean isCupsSufficient = storedDisposableCups >= disposableCupsToUse;

        if (!isWaterSufficient) {
            System.out.println("Sorry, not enough water!");
        } else if (!isMilkeSufficient) {
            System.out.println("Sorry, not enough milk!");
        } else if (!isCoffeeBeansSufficient) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (!isCupsSufficient) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            System.out.println("      )  (");
            System.out.println("     (   ) )");
            System.out.println("      ) ( (");
            System.out.println(" mrf_______)_");
            System.out.println(".-'---------|");
            System.out.println("( C|/\\/\\/\\/\\/|");
            System.out.println("'-./\\/\\/\\/\\/|");
            System.out.println("  '_________'");
            System.out.println("   '-------'");
            this.coffeeMachine.addIncome(price);
            this.coffeeMachine.setMlWater(storedMlWater - mlWaterToUse);
            this.coffeeMachine.setMlMilk(storedMlMilk - mlMilkToUse);
            this.coffeeMachine.setGCoffeeBeans(storedGCoffeeBeans - gCoffeeBeansToUse);
            this.coffeeMachine.setDisposableCups(storedDisposableCups - disposableCupsToUse);
        }

        this.coffeeMachine.returnToReadyState();
    }

    private boolean isSelectionValid(String selection) {
        String[] options = {"1", "2", "3"};
        for (String option : options) {
            if (option.equals(selection)) return true;
        }
        return false;
    }

    enum CoffeeType {
        ESPRESSO(1, 250, 0, 16, 4),
        LATTE(2, 350, 75, 20, 7),
        CAPPUCCINO(3, 200, 100, 12, 6);

        private final int id;
        private final int mlWater;
        private final int mlMilk;
        private final int gCoffeeBeans;
        private final int price;

        CoffeeType(int id, int mlWater, int mlMilk, int gCoffeeBeans, int price) {
            this.id = id;
            this.mlWater = mlWater;
            this.mlMilk = mlMilk;
            this.gCoffeeBeans = gCoffeeBeans;
            this.price = price;
        }

        public int getId() {
            return id;
        }

        public int getMlWater() {
            return mlWater;
        }

        public int getMlMilk() {
            return mlMilk;
        }

        public int getgCoffeeBeans() {
            return gCoffeeBeans;
        }

        public int getPrice() {
            return price;
        }
    }
}
