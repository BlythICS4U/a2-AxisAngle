    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 *
 * @author cgallinaro
 */
public class Problem4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        returnValues v= readTextFile("myText.txt");
        String test=v.text;
        outputDataText(wordCount(test), v.numOfLine, longestWord(test), longestWordLength(longestWord(test)), averageWordLength(test), "myText.txt");
    }   

     public static returnValues readTextFile(String fileName) {
        int lines = 0;
         BufferedReader readFile = null;
        StringBuilder reval = new StringBuilder();
        try {
            readFile = new BufferedReader(new FileReader(fileName));
            String contentLine = "";
            System.out.println("Currently reading file.......");
           
            while ((contentLine = readFile.readLine()) != null) {
                 lines++;
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
        return new returnValues(reval.toString(), lines);
    }
    public static int wordCount(String input) {
        String[] size = input.split("\\s+");
        return size.length;
    }

    public static String longestWord(String input) {
        String longestWord = null;
        int length = 0;
        String[] words = input.split(" ");
        for (String word : words) {
            if (length < word.length()) {
                length = word.length();
                longestWord = word;
            }
        }
        return longestWord;
    }
    public static int longestWordLength(String input) {
        return input.length();
    }
    
    public static double averageWordLength(String input) {
        double sum = 0;
        String[] words = input.split("\\s+");  
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].trim();
            sum += words[i].length();
        }
        return  sum / words.length;
    }
    public static void outputDataText(int wordCount, int lineCount, String longestWord, int longestWordLength, double averageWordLength, String fileName) {
        try {
            File output = new File("myTextData.txt");
            if (!output.exists()) {
                output.createNewFile();
            }
            FileWriter outputFW = new FileWriter(output, false);
            BufferedWriter outputBW = new BufferedWriter(outputFW);
            PrintWriter outputPW = new PrintWriter(outputBW);

            outputPW.println("The file " + fileName + " was successfully read.\n");
            outputPW.printf("%-21s%-5d", "Number of words: ", wordCount);
            outputPW.println();
            outputPW.printf("%-21s%-5d", "Number of lines: ", lineCount);
            outputPW.println();
            outputPW.printf("%-21s%-5s", "Longest word: ", longestWord);
            outputPW.println();
            outputPW.printf("%-21s%-5s", "Longest word length: ", longestWordLength);
            outputPW.println();
            outputPW.printf("%-21s%-5.1f", "Average word length: ", averageWordLength);
       
            outputPW.close();
            System.out.println("Data successfully written to myTextData.txt");
        } catch (IOException ioe) {
            System.out.println("Exception occurred:");
            ioe.printStackTrace(System.out);
        }
    }
    
}
 class returnValues {
        public String text;
        public int numOfLine;
        
        public  returnValues(String text, int numOfLine) {
            this.text = text;
            this.numOfLine = numOfLine;
        }
    }