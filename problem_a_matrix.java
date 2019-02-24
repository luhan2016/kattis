//https://open.kattis.com/problems/matrix


import java.util.Scanner;
import java.lang.Math;
import java.lang.*;

public class Main{
    public static void main(String args[]){ 
        Scanner sc = new Scanner(System.in);
        int a,b,c,d;
        int case_number = 1;
        while(sc.hasNextLong()) {
            a =  Math.toIntExact(sc.nextLong());
            b =  Math.toIntExact(sc.nextLong());
            sc.nextLine();
            c =  Math.toIntExact(sc.nextLong());
            d =  Math.toIntExact(sc.nextLong());
            int div = a*d-b*c;
            System.out.println("Case "+case_number+":");
            System.out.println(d/div + " " + (-b/div));
            System.out.println(-c/div + " " + (a/div));
            case_number++;
        }
    }
}





import sys
import math

i=0
while True:
	string = sys.stdin.readline()
	if string == "":
		break
	(a,b)= map(int, string.split())
	(c,d)= map(int, sys.stdin.readline().split())
	div = a*d-b*c 
	i=i+1
	print("Case {}:".format(i))
	print("{} {}".format(int(d/div), int(-b/div)))
	print("{} {}".format(int(-c/div), int(a/div)))
	sys.stdin.readline()
