//https://open.kattis.com/problems/zamka

import java.util.Scanner;
import java.lang.Math;
import java.lang.*;
import java.util.*;

public class Main{
    public static void main(String args[]){
        ArrayList al = new ArrayList();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLong()) {
            String L = sc.next();
            sc.nextLine();
            String D = sc.next();
            sc.nextLine();
            String X = sc.next();
            int l = Integer.parseInt(L);
            int d = Integer.parseInt(D);
            int x = Integer.parseInt(X);
            int sum=0;
            for(int i=l; i<=d; i++){
                if(i<10 && i==x){
                    al.add(Integer.toString(i));
                }
                else if(i<100){
                    int a=i/10;
                    int b=i-a*10;
                    if(a+b==x){
                        al.add(Integer.toString(i));
                    }
                }
                else if(i<1000){
                    int a=i/100;
                    int b=(i-a*100)/10;
                    int c=i-a*100-b*10;
                    if(a+b+c==x){
                        al.add(Integer.toString(i));
                    }
                }
                else if(i<10000){
                    int a=i/1000;
                    int b=(i-a*1000)/100;
                    int c=(i-a*1000-b*100)/10;
                    int e=i-a*1000-b*100-c*10;
                    if(a+b+c+e==x){
                        al.add(Integer.toString(i));
                    }
                }
                else if(i==10000 && x==1){
                    al.add(Integer.toString(i));
                }
            }
            System.out.println(al.get(0));
            System.out.println(al.get(al.size()-1));
        }
    }
}

