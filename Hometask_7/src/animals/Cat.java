package animals;


import foodSource.Plate;

public class Cat {
    private String name;
    private int appetite;
    private boolean isWellFed;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.isWellFed = false;
    }

    public void eat (Plate plate) {
        if (plate.getBalanceOfFood()>=appetite) {
            plate.decreaseFood(appetite);
            this.isWellFed=true;
        }else {
            System.out.println(String.format("%s cannot eat from tis plate. Not enough food", name));
        }
    }

    @Override
    public String toString() {
        return  name +
                " isWellFed = " + isWellFed;
    }
}

