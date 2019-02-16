import java.util.Scanner;
import java.lang.Math;
import java.lang.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Main{
    public static void main(String args[]){  
        int max=-1;
        int min;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLong()) {
            String N = sc.next();
            String K = sc.next();
            int n = Integer.parseInt(N);
            int k = Integer.parseInt(K);
            int[] req = new int[n];
            for(int i=0; i<n; i++){
                sc.nextLine();
                req[i] = Integer.parseInt(sc.next());
            }
            int i,j;
            for(i=0; i<n; i++){
                min = n-i;
                for(j=i; j<n; j++){
                    if(req[j]-req[i]>=1000){
                        min=j-i;
                        break;
                    }
                }
                if(max<min)
                    max=min;
                if(j==n)
                    break;
            }
            if(max%k==0)
                System.out.println(max/k);
            else
                System.out.println(max/k+1);
        }
    }
}
