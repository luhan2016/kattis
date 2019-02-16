import java.util.Scanner;
import java.lang.Math;
import java.lang.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Main{
    private static DecimalFormat df = new DecimalFormat(".##########");
    public static void main(String args[]){
        double distance = calculate_distance(1.0,1.0,2.0,2.0,1.0);
        System.out.println(df.format(distance));
    }
    public static double calculate_distance(double x1, double y1, double x2, double y2, double p){
        double delta_x = absolute_value(x1,x2);
        double delta_y = absolute_value(y1,y2);
        double power_x = Math.pow(delta_x, p);
        double power_y = Math.pow(delta_y, p);
        double result = Math.pow((power_x+power_y), 1/p);
        System.out.println(delta_x);
        System.out.println(delta_y);
        System.out.println(power_x);
        System.out.println(power_y);
        System.out.println(result);
        return result;
    }
    
    public static double absolute_value(double a, double b){
        if(a>b)
            return a-b;
        else
            return b-a;
    }
}
