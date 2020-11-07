package ProdAnimal;

public abstract class Animal {
    private String name;
    private int runDistanceLimit;
    private float jumpHeightLimit;
   protected int swimDistanceLimit;


    protected Animal(String name, int runDistanceLimit, float jumpHeightLimit) {
        this.name = name;
        this.runDistanceLimit = runDistanceLimit;
        this.jumpHeightLimit = jumpHeightLimit;

    }





    public void setRunDistanceLimit(int runDistanceLimit) {
        this.runDistanceLimit = runDistanceLimit;
    }

    public void setJumpHeightLimit(float jumpHeightLimit) {
        this.jumpHeightLimit = jumpHeightLimit;
    }



    public void run(int distance) {
        System.out.println("run :" + (distance <= runDistanceLimit));
    }


    public void jump(float height) {
        System.out.println("jump :" + (height <= jumpHeightLimit));
    }

    public void swim(int distance) {
        System.out.println("swim :" + (distance <= swimDistanceLimit));

    }




}
