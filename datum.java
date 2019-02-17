https://open.kattis.com/problems/datum



import java.util.Scanner;
import java.lang.Math;
import java.lang.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Main{
    public static void main(String args[]){ 
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLong()) {
            String D = sc.next();
            String M = sc.next();
            int d = Integer.parseInt(D);
            int m = Integer.parseInt(M);
            int day = 0;
            while(m>1){
                if(m==2 || m==4 || m==6 || m==9 || m==11)
                    day+=31;
                else if(m==5 || m==7 || m==10 || m==12)
                    day+=30;
                else if(m==3)    
                    day+=28;
                else if(m==8)
                    day+=31;
                m--;
            }
            day = day + d;
            int datum = day % 7;
            if(datum == 5)
                System.out.println("Monday");
            else if(datum == 6)
                System.out.println("Tuesday");
            else if(datum == 0)
                System.out.println("Wednesday");
            else if(datum == 1)
                System.out.println("Thursday");
            else if(datum == 2)
                System.out.println("Friday");
            else if(datum == 3)
                System.out.println("Saturday");
            else if(datum == 4)
                System.out.println("Sunday");        
        }
    }
}
