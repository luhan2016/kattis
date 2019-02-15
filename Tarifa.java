import java.util.Scanner;
import java.lang.Math;
import java.lang.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLong()) {
           String X = sc.next();
           sc.nextLine();
           String N = sc.next();
           int x = Integer.parseInt(X);
           int n = Integer.parseInt(N);
           int remind = x * (n+1);
           for(int i=0; i<n;i++){
               long temp = sc.nextLong();
               int t = Math.toIntExact(temp);
               remind = remind - t;
           }
            System.out.println(remind);
        }
    }
}

