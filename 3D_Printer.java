//https://open.kattis.com/problems/3dprinter

import java.util.Scanner;
import java.lang.Math;
import java.lang.*;

public class Main{
    public static void main(String args[]){
        int printer, statue, min_days, days;
        int n;
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLong()) {
           long temp = sc.nextLong();
            //n = (int) temp;
            //n = temp.intValue();
            n = Math.toIntExact(temp);
            min_days = n;
            for(printer=1; printer<n; printer++){
                days = (int)Math.ceil(Math.log(printer) / Math.log(2));
                //System.out.print("days are:");
                //System.out.println(days);
                //System.out.println((int)Math.pow(2,days));
                //System.out.println(printer);
                statue = (int)Math.pow(2,days) - printer;
                //System.out.print("statue are:");
                //System.out.println(statue);
                for(int i=statue; i<n; i+=printer)
                    days++;
                if(min_days>days)
                    min_days = days;
                //System.out.println();
            }
            System.out.println(min_days);
        }
    }
}
