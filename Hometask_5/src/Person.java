public class Person {
    private String name;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private byte age;

    public Person(){

    }

    public byte getAge() {
        return age;
    }

    public Person(String name, String position, String email, String phoneNumber, int salary, byte age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo(){
        System.out.println(String.format("%s is a %s.",name,position));
        System.out.println(String.format("e-mail:%s",email));
        System.out.println(String.format("Phone:%s",phoneNumber));
        System.out.println(String.format("Salary:%s",salary));
        System.out.println(String.format("Age:%s",age));
    }
}
