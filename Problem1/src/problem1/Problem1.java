package problem1;

import java.util.Scanner;
/**
 *
 * @author cgallinaro
 */
public class Problem1 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Input a double value for x:  ");
        double x = keyboard.nextDouble();
        System.out.print("\nInput a double value for y: ");
        double y = keyboard.nextDouble();
        
        System.out.println("f(x) = " + f(x));
        System.out.println("g(x) = " + g(x));
        System.out.println("h(x) = " + h(x));
        System.out.println("i(x) = " + i(x));
        System.out.println("j(x, y) = " + j(x, y));
    }
    public static double f(double x)
    {
        return Math.sqrt(x + 1);
    }
    public static double g(double x)
    {
        return Math.pow(x, 3) - 2*Math.pow(x, 2) + x - 4;
    }
    public static double h(double x)
    {
        return Math.pow(Math.sin(x), 2);
    }
    public static double i(double x)
    {
        return Math.pow(Math.sin(Math.toRadians(x)), 2);
    }
    public static double j(double x, double y)
    {
        return Math.pow(x, 2) + Math.pow(y, 2);
    }
}
