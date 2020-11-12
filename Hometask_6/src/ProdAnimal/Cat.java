package ProdAnimal;

public class Cat extends Animal{
    public Cat(String name) {
        super(name,200, 2.0f);
    }

    @Override
    public void swim(int distance) {
        System.out.println("swim : false! Cats can`t swim");
    }
}
