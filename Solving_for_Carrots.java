//https://open.kattis.com/problems/carrots

import java.util.Scanner;
import java.lang.Math;
import java.lang.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int result = 0;
        while (sc.hasNextLong()) {
           String N = sc.next();
           String P = sc.next();
           int n = Integer.parseInt(N);
           int p = Integer.parseInt(P);
           sc.nextLine();
           for(int i=0; i<n;i++){
                String Temp = sc.next();
                if (!Temp.contains("?"))
                    result = result + p;
           }
            System.out.println(result);
        }
    }
}

