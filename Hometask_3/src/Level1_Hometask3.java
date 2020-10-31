import java.util.*;

public class Level1_Hometask3 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
       playGameGuessTehWord();
//        playGameGuessTheNumber();
    }

    //1
    static void playGameGuessTheNumber() {

        System.out.println("Введите число от 0 до 9");
        compareNumbers(provideTheNumber(10));

        System.out.println("===============================================");
        System.out.println("введите 1 чтобы попробовать еще раз с новым числом,\nили 0 для завершения игры");
        System.out.println("===============================================");
        while (true) {
            if (scanner.nextInt() == 0) {
                System.out.println(" вы завершили игру");
                scanner.close();
                return;
            }
            System.out.println("===============================================");
            System.out.println("введите число от 0 до 9");

            compareNumbers(provideTheNumber(10));

            System.out.println("введите 1 \nчтобы попробовать еще раз с новым числом,\nили 0 для завершения игры");

        }
    }

    static void compareNumbers(int guessedNumber) {
        int userInput;
        for (int i = 0; i < 3; i++) {
            userInput = scanner.nextInt();
            if (guessedNumber == userInput) {
                System.out.println("===============================================");
                System.out.println(" !!ВЫ УГАДАЛИ!!");
                System.out.println("===============================================");
                return;
            } else if (guessedNumber > userInput) {
                System.out.println("загаданное число больше введенного");
            } else if (guessedNumber < userInput) {
                System.out.println("загаданное число меньше введенного");
            }
        }
            System.out.println("===============================================");
            System.out.println(" !!ВЫ НЕ УГАДАЛИ!!");
            System.out.println("===============================================");
        }

    static int provideTheNumber(int bound) {
        Random random = new Random();
        int a = random.nextInt(bound);
        System.out.println("_загаданное число =" + a);
        return a;
    }

    //2
    static void playGameGuessTehWord() {
        System.out.println("введите слово или напишите 'exit' для завершения игры");
        String concievedWord = provideTheWord();
        while (areWordsTheSame(concievedWord, scanner.next())) {
        }
        scanner.close();
    }

    static String provideTheWord() {
        String[] words = {"apple", "orange", "lemon", "banana",
                "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango",
                "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        Random random = new Random();
        return words[random.nextInt(25)];
    }

    static boolean areWordsTheSame(String concievedWord, String introdusedWord) {
        if (concievedWord.matches(introdusedWord)) {
            System.out.println(" вы угадали");
            return false;
        } else if (introdusedWord.matches("(?i)exit")) {
            System.out.println("вы завершили игру");
            return false;
        }
        System.out.println("Во введенном слове может быть несколько букв,\n совпадающих с буквами в загаданном слове");
        System.out.println(String.format("%-15s", concievedWord).replaceAll("([^" + introdusedWord + "]|\\s+)", "#"));
        System.out.println(" Попробуйте угадать слово еще раз \n или введите 'exit' для завершения игры");
        return true;
    }
}
