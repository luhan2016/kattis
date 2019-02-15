// https://open.kattis.com/problems/oddities

import java.util.Scanner;
import java.lang.Math;
import java.lang.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int result = 0;
        while (sc.hasNextLong()) {
           String N = sc.next();
           int n = Integer.parseInt(N);
           int array[] = new int[n];
           for(int i=0; i<n; i++){
                String X = sc.next();
                int x = Integer.parseInt(X);
                array[i] = x;
           }
           for(int i=0; i<n; i++){
               if(array[i]%2==0)
                    System.out.println(array[i] + " is even");
                else
                    System.out.println(array[i] + " is odd");
           }
        }
    }
}

