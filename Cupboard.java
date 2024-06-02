package machine;

public class Cupboard {
    private int mlWater;
    private int mlMilk;
    private int gCoffeeBeans;
    private int disposableCups;

    public Cupboard() {
        this.mlWater = 400;
        this.mlMilk = 540;
        this.gCoffeeBeans = 120;
        this.disposableCups = 9;
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

    public void setgCoffeeBeans(int gCoffeeBeans) {
        this.gCoffeeBeans = gCoffeeBeans;
    }

    public int getDisposableCups() {
        return this.disposableCups;
    }

    public void setDisposableCups(int disposableCups) {
        this.disposableCups = disposableCups;
    }
}
