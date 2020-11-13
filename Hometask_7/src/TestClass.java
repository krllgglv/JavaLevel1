import animals.Cat;
import foodSource.Plate;

public class TestClass {
    public static void main(String[] args) {
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Cat1",10);
        cats[1] = new Cat("Cat2",15);
        cats[2] = new Cat("Cat3",20);
        Plate plate = new Plate(20);
        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat);
        }
        System.out.println("--------------------------------");
        plate.addFood(15);
        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat);
        }
    }
}
