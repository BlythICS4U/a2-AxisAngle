package problem3;
/**
 *
* @author cgallinaro
 */
public class Problem3 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int gradesArray[][]= 
                {{56, 38, 38, 88, 52, 42},
                {85, 35, 91, 94, 60, 47},
                {78, 62, 70, 42, 93, 65},
                {33, 75, 82, 45, 73, 83},
                {60, 80, 71, 82, 73, 38},
                {80, 55, 48, 59, 36, 80},
                {30, 91, 79, 81, 61, 61},
                {47, 54, 68, 64, 73, 65},
                {32, 54, 84, 52, 64, 80},
                {82, 82, 39, 65, 48, 41},
                {65, 81, 81, 38, 93, 86},
                {44, 74, 64, 61, 58, 77},
                {31, 31, 44, 93, 52, 94}};

        System.out.println("Name           Test 1  Test 2  Test 3  Test 4  Test 5  Test 6  Average");
        System.out.println("-------------  ------  ------  ------  ------  ------  ------  -------");
        for (int s = 0; s < gradesArray.length; s++) {
            System.out.print("Student " + (s + 1));
            for (int g = 0; g < gradesArray[s].length; g++) {
                System.out.print("\t" + gradesArray[s][g]);

            }
            System.out.print("\t");
            System.out.printf("%.2f", studentAverage(gradesArray, s));
            System.out.print("\n");
        }
        double classAverage = 0;
        System.out.print("\nTest Average");
        for (int g = 0; g < 6; g++) {
            classAverage += testAverage(gradesArray, g);
            System.out.print("\t");
            System.out.printf("%.1f", testAverage(gradesArray, g));
        }
        System.out.println("\n\nClass Average: " + (classAverage / 6));
    }
    
    public static double studentAverage(int[][] array, int s) {
        double sum = 0;
        for (int g = 0; g < 6; g++) {
            sum += array[s][g];
        }
        return sum /6;
    }
    public static double testAverage(int[][] array, int i) {
        double sum = 0;
        for (int s = 0; s < 13; s++) {
            sum += array[s][i];
        }
        return sum/13;
    }

}
