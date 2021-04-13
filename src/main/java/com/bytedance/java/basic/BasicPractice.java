package com.bytedance.java.basic;

import java.util.Scanner;

public class BasicPractice {
    public static void getOneBite() {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        int count = 0;
        while (input != 0) {
            input &= input - 1;
            count++;
        }

        System.out.println(count);
    }


    public static void main(String[] args) {
        getOneBite();
    }
}
