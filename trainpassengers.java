//https://open.kattis.com/problems/trainpassengers

import java.util.Scanner;
import java.lang.Math;
import java.lang.*;

public class Main{
    public static void main(String args[]){ 
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLong()) {
            long C = sc.nextLong();
            int c = Math.toIntExact(C);
            long N = sc.nextLong();
            int n = Math.toIntExact(N);
            sc.nextLine();
            boolean possible = true;
            int train = 0;
            long L,E,S;
            int l=0,e=0,s=0;
            for(int i=0; i<n; i++) {
                L = sc.nextLong();
                l = Math.toIntExact(L);
                E = sc.nextLong();
                e = Math.toIntExact(E);
                S = sc.nextLong();
                s = Math.toIntExact(S);
            	if(l>train) {
            		possible = false;
            	}
            	train -= l;
            	if(train+e>c)
            		possible = false;
            	train += e;
            	if(s!=0 && train !=c)
            		possible = false;
            }
        	if(e!=0 || s!=0 || train!=0)
        		possible = false;
            if(possible)
            	System.out.println("possible");
            else
            	System.out.println("impossible");
        }
    }
}

