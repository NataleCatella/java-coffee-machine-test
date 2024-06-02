package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public enum State {
        BUY, FILL, TAKE, REMAINING, EXIT, ERROR
    }

    public static void main(String[] args) {
        Cupboard ingredients = new Cupboard();
        Till money = new Till();
        State state;

        System.out.println("Write action (buy, fill, take):");
        Scanner scanner = new Scanner(System.in);

        do {
            state = readAction(scanner);
            processAction(scanner, state, ingredients, money);
        } while (state != State.EXIT);
    }

    public static State readAction(Scanner scanner) {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = scanner.next();

        try {
            return State.valueOf(action.toUpperCase());
        } catch (Exception e) {
            return State.ERROR;
        }
    }

    public static void processAction(Scanner scanner, State state, Cupboard ingredients, Till money) {
        switch (state) {
            case BUY:
                buy(scanner, ingredients, money);
                break;
            case FILL:
                fill(scanner, ingredients);
                break;
            case TAKE:
                take(money);
                break;
            case REMAINING:
                printState(ingredients, money);
                break;
            case EXIT:
                break;
            default:
                System.out.println("Invalid action");
        }
    }

    public static void printState(Cupboard ingredients, Till till) {
        System.out.println("The coffee machine has:");
        System.out.println(ingredients.getMlWater() + " ml of water");
        System.out.println(ingredients.getMlMilk() + " ml of milk");
        System.out.println(ingredients.getGCoffeeBeans() + " g of coffee beans");
        System.out.println(ingredients.getDisposableCups() + " disposable cups");
        System.out.println("$" + till.getIncome() + " of money");
        System.out.println();
        System.out.println();
    }

    public static void buy(Scanner scanner, Cupboard ingredients, Till till) {
        int price;
        int mlWaterToUse;
        int mlMilkToUse;
        int gCoffeeBeansToUse;
        int disposableCupsToUse;
        int storedMlWater = ingredients.getMlWater();
        int storedMlMilk = ingredients.getMlMilk();
        int storedGCoffeeBeans = ingredients.getGCoffeeBeans();
        int storedDisposableCups = ingredients.getDisposableCups();

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String product = scanner.next();
        switch (product) {
            case "1":
                price = 4;
                mlWaterToUse = 250;
                mlMilkToUse = 0;
                gCoffeeBeansToUse = 16;
                disposableCupsToUse = 1;
                break;
            case "2":
                price = 7;
                mlWaterToUse = 350;
                mlMilkToUse = 75;
                gCoffeeBeansToUse = 20;
                disposableCupsToUse = 1;
                break;
            case "3":
                price = 6;
                mlWaterToUse = 200;
                mlMilkToUse = 100;
                gCoffeeBeansToUse = 12;
                disposableCupsToUse = 1;
                break;
            default:
                System.out.println("Invalid product");
                return;
        }

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
            till.addIncome(price);
            ingredients.setMlWater(storedMlWater - mlWaterToUse);
            ingredients.setMlMilk(storedMlMilk - mlMilkToUse);
            ingredients.setgCoffeeBeans(storedGCoffeeBeans - gCoffeeBeansToUse);
            ingredients.setDisposableCups(storedDisposableCups - disposableCupsToUse);
        }
    }

    public static void fill(Scanner scanner, Cupboard ingredients) {
        System.out.println("Write aaahow many ml of water do you want to add:");
        int mlOfWaterToAdd = scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        int mlOfMilkToAdd = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int gOfCoffeeToAdd = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int disposableCupsToAdd = scanner.nextInt();

        ingredients.setMlWater(ingredients.getMlWater() + mlOfWaterToAdd);
        ingredients.setMlMilk(ingredients.getMlMilk() + mlOfMilkToAdd);
        ingredients.setgCoffeeBeans(ingredients.getGCoffeeBeans() + gOfCoffeeToAdd);
        ingredients.setDisposableCups(ingredients.getDisposableCups() + disposableCupsToAdd);
    }

    public static void take(Till till) {
        till.takeIncome();
        till.setIncome(0);
    }
}
