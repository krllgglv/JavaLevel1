package ProdAnimal;

public class Dog extends Animal {
    public Dog(String name) {
        super( name,500,0.5f);
         this.swimDistanceLimit =10;
    }


    public void setSwimDistanceLimit(int swimDistanceLimit) {
        this.swimDistanceLimit = swimDistanceLimit;
    }

}
