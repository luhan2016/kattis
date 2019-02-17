//https://open.kattis.com/problems/quickestimate

import java.util.Scanner;
import java.lang.Math;
import java.lang.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Main{
    public static void main(String args[]){ 
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLong()) {
            String N = sc.next();
            sc.nextLine();
            int n = Integer.parseInt(N);
            for(int i=0; i<n; i++){
                String str = sc.next();
                System.out.println(str.length());
                sc.nextLine();
            }
        }
    }
}
