//https://open.kattis.com/problems/cetiri

import java.util.Scanner;

public class Main{
    public static void main(String args[]){ 
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLong()) {
            String A = sc.next();
            String B = sc.next();
            String C = sc.next();
            int a = Integer.parseInt(A);
            int b = Integer.parseInt(B);
            int c = Integer.parseInt(C);
            int[] arr = new int[3];
            arr[0] = a;
            arr[1] = b;
            arr[2] = c;
            
            for(int i=0; i<3; i++) {
            	for(int j=0; j<2; j++ ) {
            		if(arr[j]>arr[j+1]) {
            			int temp = arr[j];
            			arr[j] = arr[j+1];
            			arr[j+1] = temp;
            		}
            	}
            	
            }
            a = arr[0];
            b = arr[1];
            c = arr[2];
            
            if((a-b)==(b-c))
            	System.out.println(c+b-a);
            else if((b-a)==2*(c-b))
            	System.out.println(a+c-b);
            else if(2*(b-a)==(c-b))
            	System.out.println(b+b-a);
        }
    }
}
