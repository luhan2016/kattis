//https://open.kattis.com/problems/tajna

import java.util.Scanner;

public class Main{
    public static void main(String args[]){ 
        Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            char c[] = str.toCharArray();
            int len = str.length();
            int num_yueshu=0;
            int row=0, column=0;
            for(int i=1; i<=len; i++) {
            	if(len%i==0) {
            		num_yueshu ++;
            	}
            }
            int yueshu[] = new int[num_yueshu];
            int j=0;
            for(int i=1; i<=len; i++) {
            	if(len%i==0) {
            		yueshu[j] = i;
            		j++;
            	}
            }
            for(int i=0; i<num_yueshu-1; i++) {
            	if(yueshu[i]*yueshu[i] == len) {
            		column = yueshu[i];
            		row = yueshu[i];
            	}
            	else if(yueshu[i]*yueshu[i+1] == len) {
            		column = yueshu[i];
            		row = yueshu[i+1];
            	}
            }
    		
            char ch[][] = new char[row][column];
            j=0;
            for(int i=0; i<row; i++) {
            	for(int k=0; k<column; k++) {
            		ch[i][k] = c[j];
            		j++;
            	}
            }
            for(int i=0; i<column; i++) {
            	for(int k=0; k<row; k++) {
            		System.out.print(ch[k][i]);
            	}
            }
        
    }
}

