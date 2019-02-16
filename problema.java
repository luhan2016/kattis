import java.util.Scanner;
import java.lang.Math;
import java.lang.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Main{
    private static DecimalFormat df = new DecimalFormat("#0.0000000000");
    public static void main(String args[]){        
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String X1 = sc.next();
            double x1 = Double.parseDouble(X1);            
            if(x1 == 0)
                break;
            String Y1 = sc.next();
            double y1 = Double.parseDouble(Y1);
            String X2 = sc.next();
            double x2 = Double.parseDouble(X2);
            String Y2 = sc.next();
            double y2 = Double.parseDouble(Y2);
            String P = sc.next();
            double p = Double.parseDouble(P);
            double distance = calculate_distance(x1,y1,x2,y2,p);
            System.out.println(df.format(distance));
        }
    }
    public static double calculate_distance(double x1, double y1, double x2, double y2, double p){
        double delta_x = absolute_value(x1,x2);
        double delta_y = absolute_value(y1,y2);
        double power_x = Math.pow(delta_x, p);
        double power_y = Math.pow(delta_y, p);
        double result = Math.pow((power_x+power_y), 1/p);
        //System.out.println(delta_x);
        //System.out.println(delta_y);
        //System.out.println(power_x);
        //System.out.println(power_y);
        //System.out.println(result);
        return result;
    }
    
    public static double absolute_value(double a, double b){
        if(a>b)
            return a-b;
        else
            return b-a;
    }
}
