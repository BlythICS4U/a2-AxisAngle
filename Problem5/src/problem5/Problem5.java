package problem5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author cgallinaro
 */
public class Problem5 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String test = readTextFile("Teacher Data.txt");
        String[][] teacherData = textIntoArray(test);
        double math = findValueAndReturnAverage("math", teacherData);
        double science = findValueAndReturnAverage("science", teacherData);
        double tech = findValueAndReturnAverage("tech", teacherData);
        System.out.print("Average  teaching experience for math is: ");
        System.out.printf("%.2f%n", findValueAndReturnAverage("math", teacherData));
        
        System.out.print("Average  teaching experience for science is: ");
        System.out.printf("%.2f%n", findValueAndReturnAverage("science", teacherData));
        
        System.out.print("Average  teaching experience for tech is: ");
        System.out.printf("%.2f%n", findValueAndReturnAverage("tech", teacherData));
        
    }

    public static String readTextFile(String fileName) {
        BufferedReader readFile = null;
        StringBuilder reval = new StringBuilder();
        try {
            readFile = new BufferedReader(new FileReader(fileName));
            String contentLine = readFile.readLine();
            System.out.println("Currently reading file.......");
            reval.append(contentLine);
            reval.append(" ");
            while ((contentLine = readFile.readLine()) != null) {
                reval.append(contentLine);
                reval.append(" ");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace(System.out);
        } finally {
            try {
                if (readFile != null) {
                    readFile.close();
                }
            } catch (IOException ioe) {
                System.out.println("Error in closing the BufferedReader");
                ioe.printStackTrace(System.out);
            }
        }
        return reval.toString();
    }
    public static String[][] textIntoArray(String input) {
        String[] words = input.split("\\s+");
        String[][] teacherData = new String[words.length / 3][3];
        
        for (int r = 0; r < words.length / 3; r++) {
            for (int c = 0; c < 3; c++) {
                teacherData[r][c] = words[3 * r + c];
            }
        }
        return teacherData;
    }

    public static double findValueAndReturnAverage(String target, String[][] array) {
        double occurence = 0;
        double sum = 0;
        for (String[] array1 : array) {
            if (array1[1].equalsIgnoreCase(target)) {
                occurence += 1;
                sum += Integer.parseInt(array1[2]);
            }
        }
        double average = sum / occurence;
        return average;
    }
}