//https://www.testdome.com/questions/java/palindrome/7283?visibility=1&skillId=4


import java.util.Scanner;
import java.lang.Math;
import java.lang.*;


public class Main {
    public static boolean isPalindrome(String word) {
    int i1 = 0;
    int i2 = word.length() - 1;
    String newword=word.toUpperCase();
    while (i2 > i1) {
        if (newword.charAt(i1) != newword.charAt(i2)) {
            return false;
        }
        ++i1;
        --i2;
    }
    return true;
    }
    
    public static void main(String[] args) {
        System.out.println(Main.isPalindrome("Deleveled"));
    }
}


