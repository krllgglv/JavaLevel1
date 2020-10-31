import java.util.Random;
import java.util.Scanner;

public class Level1_Hometask2 {


    public static void main(String[] args) {

    }


    //    1
    static void changeElements(int[] array1) {
        for (int i = 0; i < array1.length; i++) {
        array1[i] = (array1[i] == 0) ? 1 : 0;

        }
    }

    //    2
    static int initializeArray(int a) {
        return 3;
    }

    static void initializeArray() {
        System.out.println("init");
    }


    //    3
    static void changeElements1() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            } else {
                continue;
            }
        }
    }

    //    4
    static void createArray(int arraySize) {
        int[][] array = new int[arraySize][arraySize];
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                array[i][j] = i == j ? 1 : i + j == array.length - 1 ? 1 : 0;
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    //    5
    static void findMaxAndMin(int[] array) {
        int a = 0;
        //    выводим на экран исходный массив
        for (int k :
                array) {
            System.out.print(k + " ");
        }
        //"выдавливаем" максимальный элемент в конец массива
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                a = array[i];
                array[i] = array[i - 1];
                array[i - 1] = a;
            } else continue;
        }
        // " выдавливаем" минимальный элемент в начало массива
        for (int i = array.length - 1; i >= 1; i--) {
            if (array[i - 1] > array[i]) {
                a = array[i];
                array[i] = array[i - 1];
                array[i - 1] = a;
            }
        }

        System.out.print("\n" + "min value = " + array[0] + "  || max value = " + array[array.length - 1]);
    }

    //    6
    /* arrStraitSum - массив, хранящий значения сумм
     * элементов исходного массива слева направо:
     * 1-й элемент == первому элементу исходного массива,
     * 2-й элемент == сумме первого и второго эл-ов исходного массива
     * и т.д. В набор не включается последний элемент исходного массива.
     * arrBackSum - аналогичен arrStraitSum, только хранит суммы элементов
     * при проходе элементов исходного массива справа налево */
    static boolean checkBalance(int[] array) {
        boolean flag = false;
        int[] arrStraitSum = new int[array.length - 1];
        int[] arrBackSum = new int[array.length - 1];
        arrStraitSum[0] = array[0];
        arrBackSum[array.length - 2] = array[array.length - 1];
        for (int i = 1; i < array.length - 1; i++) {
            arrStraitSum[i] += arrStraitSum[i - 1] + array[i];
        }
        for (int j = array.length - 3; j >= 0; j--) {
            arrBackSum[j] += arrBackSum[j + 1] + array[j + 1];
        }

        for (int i = 0; i < arrStraitSum.length; i++) {
            if (arrStraitSum[i] == arrBackSum[i]) {
                flag = true;
            }
        }
        return flag;
    }

    //    7
// если параметр, передающийся методу > 0 - двигаем вправо, <0 - двигаем влево
    static void moveElements(int[] array, int a) {

        int d = 0;
        int var = 0;
        if (a > 0) {
            for (int i = 0; i < a; i++) {
                d = array[array.length - 1];
                array[array.length - 1] = array[0];
                for (int j = 0; j < array.length - 2; j++) {
                    var = array[j + 1];
                    array[j + 1] = array[array.length - 1];
                    array[array.length - 1] = var;
                }
                array[0] = d;
            }

        } else if (a < 0) {

            for (int i = 0; i < -a; i++) {
                d = array[0];
                array[0] = array[array.length - 1];
                for (int j = array.length - 1; j > 0; j--) {
                    var = array[j - 1];
                    array[j - 1] = array[0];
                    array[0] = var;
                }
                array[array.length - 1] = d;
            }
        }

    }
}

