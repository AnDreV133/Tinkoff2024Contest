package org.example;

import java.util.Scanner;

public class Task1 {
    private static final int DAYS_IN_SEQUENCE = 7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        if (size < 7) {
            System.out.println(-1);
            return;
        }

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        int maxAmountFiveMarks = 0;
        int currentFiveMarks = 0;
        for (int i = 0; i < size - DAYS_IN_SEQUENCE + 1; i++) {
            for (int j = 0; j < DAYS_IN_SEQUENCE; j++) {
                if (arr[i + j] == 2 || arr[i + j] == 3) {
                    currentFiveMarks = 0;
                    break;
                }

                if (arr[i + j] == 5) {
                    currentFiveMarks++;
                }
            }

            if (currentFiveMarks > maxAmountFiveMarks) {
                maxAmountFiveMarks = currentFiveMarks;
            }

            currentFiveMarks = 0;
        }

        System.out.println(maxAmountFiveMarks != 0 ? maxAmountFiveMarks : -1);
    }
}
