package TestAnimal;

import ProdAnimal.*;



public class TestClass {
    public static void main(String[] args) {

        Animal cat1 = new Cat("Barsik");
        Cat cat2 = new Cat("Murzik");
        Dog dog1 = new Dog("Bobik");
        Animal dog2 = new Dog("Druzhok");
        cat1.jump(8);
        cat1.swim(1);
        cat2.run(700);
        cat2.setRunDistanceLimit(800);
        cat2.run(700);
        dog1.swim(10);
        dog1.jump(0.7f);
        dog2.setJumpHeightLimit(1.0f);
        dog2.jump(0.7f);






    }
}
