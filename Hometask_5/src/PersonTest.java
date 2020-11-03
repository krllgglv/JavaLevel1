public class PersonTest {
    public static void main(String[] args) {
    printInfo(providePersonArray());
    }
    static Person[] providePersonArray(){
        Person[] personArr = new Person[5];
        personArr[0] = new Person("Petrov Petr","CEO","p.petrov@mail.ru","+796656656555",350000, (byte) 42);
        personArr[1] = new Person("Semyonov Alex","Chief Accountant","a.semyonov@mail.ru","+796656656556",200000, (byte) 47);
        personArr[2] = new Person("Vasilyev Leonid","Chief Engineer","l.vasilyev@mail.ru","+796656656557",180000, (byte) 38);
        personArr[3] = new Person("Martynov Pavel","Engeneer","p.martynov@mail.ru","+796656654568",100000, (byte) 27);
        personArr[4] = new Person("Ivanova Anna","Secretary","a.ivanova@mail.ru","+796656654455",80000, (byte) 24);
        return personArr;
    }
    static void printInfo(Person [] personArr){
        for (Person p:
             personArr) {
            if (p.getAge() > 40) {
                p.printInfo();
                System.out.println("=======================");
            }
        }

    }
}
