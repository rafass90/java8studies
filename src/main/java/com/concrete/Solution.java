package com.concrete;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();

        Double d = scan.hasNextDouble()? scan.nextDouble() : null;
        String s = "";
        while(scan.hasNext()){ 
            s += scan.next() + " ";
        }

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}
