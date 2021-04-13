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

    private void test() {
        System.out.println("test");
    }

    public static int getBiteValue(int num, int offset) {
        return (num >> offset) & 1;
    }

    public static void main(String[] args) {
//        getOneBite();

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        // 获取一个二进制数中奇数位和偶数位
        for (int i = 31; i > 0; i -= 2) {
            System.out.printf("%d ", getBiteValue(input, i));
        }
        System.out.println();

        for (int i = 30; i >= 0; i -= 2) {
            System.out.printf("%d ", getBiteValue(input, i));
        }
        System.out.println();
    }
}
