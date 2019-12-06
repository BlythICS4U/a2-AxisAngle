package problem6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
/**
 *
 * @author cgallinaro
 */
public class Problem6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ObjectInputStream ois = null;
        try {
            File file = new File("myMatrices.bin");
            FileInputStream fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            int[][] matrix1 = (int[][]) ois.readObject();
            int[][] matrix2 = (int[][]) ois.readObject();
            int[][] product = multiplyMatrices(matrix1, matrix2);
            printArray(product);
        } catch (FileNotFoundException ex) {
            System.out.println("Exception occurred: ");
            ex.printStackTrace(System.out);
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Exception occurred:");
            ex.printStackTrace(System.out);
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ioe) {
                System.out.println("Exception occurred:");
                ioe.printStackTrace(System.out);
            }
        }
    }

    public static int[][] multiplyMatrices(int[][] one, int[][] two) {
        int rowNum=one.length;
        int colNum=two[0].length;
        int multiplicationNum=two.length;
        
        int[][] product = new int[rowNum][colNum];
        for (int r = 0; r < rowNum; r++) {
            for (int c = 0; c < colNum; c++)
            {
                int sum =0;
                for(int i =0; i < multiplicationNum ; i++)
                {
                     sum += one[r][i]*two[i][c] ;
                }
                product[r][c]=sum;
            }
        }
        return product;
    }
        
    public static void printArray(int[][] array) {
        for (int r = 0; r < array.length; r++) {
            System.out.print("Row " + (r + 1) + ": ");
            for (int c = 0; c < array[0].length; c++) {
                System.out.print(array[r][c] + "\t");
            }
            System.out.println();
        }
    }
}
