package problem2;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author cgallinaro
 */
public class Problem2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int size = askForInput();
        boolean[] placeHolder = initializeArray(size);
        algorithm(placeHolder);
        printArray(placeHolder, size);
    }

    public static int askForInput() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int input = keyboard.nextInt();
        return input;
    }
    public static boolean[] initializeArray(int size) {
        boolean[] array = new boolean[size+1];
        Arrays.fill(array, true);
        return array;
    }
    public static void algorithm(boolean[] array) {
        for (int i = 2; i <= Math.floor(Math.sqrt(array.length)); i++) {
            if (array[i] == true) {
                int a = 0;
                int j = (int) (i*i);
                while (j < array.length) {
                    array[j] = false;
                    j = (int) (i*i) + a * i;
                    a++;
                }
            }
        }
    }
    public static void printArray(boolean[] printArray, int size) {
        int newLine = 0;
        System.out.println("All primes less than or equal to " + size + " are:");
        for (int i = 2; i < printArray.length; i++) {
            if (printArray[i] == true) {
                System.out.print((i) + "\t");
                newLine++;
                if (newLine % 10 == 0) {
                System.out.println();
            }
            }
        }
    }
}
