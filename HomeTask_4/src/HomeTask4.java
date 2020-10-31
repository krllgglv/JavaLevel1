import java.util.Random;
import java.util.Scanner;

public class HomeTask4 {
    public static void main(String[] args) {
        playTicTacToe();
    }

    static void playTicTacToe() {
        char[][] field = initializeGameField();
        printField(field);
        do {
            doPlayerMove(field);
            printField(field);
            doPlayerAI(field);
            printField(field);
        } while (!checkWin(field, 'X') && !checkWin(field, '0') && !checkDraw(field));
        System.out.println("Game over");
        printResult(field, 'X', '0');
    }

    static void printResult(char[][] field, char humanChar, char aIChar) {
        if (checkDraw(field)) {
            System.out.println(" НИЧЬЯ ");
        } else if (checkWin(field, aIChar)) {
            System.out.println(" ПОБЕДИЛ КОМПЬЮТЕР");
        }
        System.out.println(" !!ВЫ ПОБЕДИЛИ!! ");

    }

    static boolean checkLine(char[][] field, char sign) {
        for (int i = 0; i < field.length; i++) {
            int count = 0;
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == sign) {
                    count++;
                }
            }
            if (count == field.length) {
                return true;
            }
        }
        return false;
    }

    static boolean checkColumn(char[][] field, char sign) {
        for (int i = 0, count = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[j][i] == sign) {
                    count++;
                }

            }
            if (count == field.length) {
                return true;
            }
        }
        return false;
    }

    static boolean checkMainDiagonal(char[][] field, char sign) {
        int count = 0;
        for (int i = 0; i < field.length; i++) {

            if (field[i][i] == sign) {
                count++;
            }
        }
        return count == field.length;

    }

    static boolean checkSecondDiagonal(char[][] field, char sign) {
        int count = 0;
        for (int i = 0; i < field.length; i++) {

            if (field[i][field.length - 1 - i] == sign) {
                count++;
            }
        }
        return count == field.length;

    }

    static boolean checkWin(char[][] field, char sign) {
        return checkLine(field, sign) || checkColumn(field, sign) || checkMainDiagonal(field, sign) || checkSecondDiagonal(field, sign);
    }

    static boolean checkDraw(char[][] field) {
        int maxMinus = field.length * field.length;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] != '-') {
                    maxMinus--;
                }
            }
        }

        return maxMinus == 0;
    }


    static char[][] initializeGameField() {
        int size;
        char[][] field;
        do {
            System.out.println(" Введите размер игрового поля (>=3)");
            size = new Scanner(System.in).nextInt();
        } while (size < 3);
        field = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = '-';
            }
        }
        return field;
    }

    static void printField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("===============================");
    }

    static void doPlayerAI(char[][] field) {
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(field.length);
            y = random.nextInt(field.length);
        } while (field[x][y] != '-');
        field[x][y] = 'O';
    }

    static void doPlayerMove(char[][] field) {
        int x, y;
        do {
            x = getIndexCoordinate('X', field.length);
            y = getIndexCoordinate('Y', field.length);
        } while (field[y][x] != '-');
        field[y][x] = 'X';

    }

    static int getIndexCoordinate(char coordName, int max) {
        return getCoordinate(coordName, max) - 1;
    }

    static int getCoordinate(char coordName, int max) {
        int coord;
        do {
            System.out.println(String.format("Please input %s-coordinate [1-%s]", coordName, max));
            Scanner scanner = new Scanner(System.in);
            coord = scanner.nextInt();
        } while (coord < 1 || coord > max);
        return coord;
    }
}

