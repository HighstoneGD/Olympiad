package com.example.chernegaeg.corruption;

import java.util.Scanner;

public class Corruption {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int accountCount = in.nextInt();
        int percentage = in.nextInt();
        int accounts[] = new int[accountCount];
        for (int i = 0; i < accountCount; i++) {
           accounts[i] = in.nextInt();
        }
        sort(accounts, accountCount);

    }

    public static void swap(int a, int b) {
        int t = a;
        a = b;
        b = t;
    }

    public static void sort(int[] array, int arrayLength) {
        for (int i = 0; i < arrayLength - 1; i++) {
            for (int j = 0; j < arrayLength - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array[j], array[j + 1]);
                }
            }
        }
    }
}
