package foodSource;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getBalanceOfFood() {
        return food;
    }

    public void decreaseFood(int value) {
        food -= value;
    }
    public void addFood(int value) {
        food += value;
    }


    public void info() {
        System.out.println("plate: " + food);
    }
}

