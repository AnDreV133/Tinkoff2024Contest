package org.example;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int turn = scanner.next().equals("L") ? -1 : 1;

        int[][] image = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                image[i][j] = scanner.nextInt();
            }
        }

        int counterOperations = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int temp = image[i][j];
                image[i][j] = image[j][i];
                image[j][i] = temp;
                sb.append(String.format("%d %d %d %d\n", i, j, j, i));
                counterOperations++;
            }
        }

        if (turn > 0) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size / 2; j++) {
                    int temp = image[i][j];
                    image[i][j] = image[i][size - j - 1];
                    image[i][size - j - 1] = temp;
                    sb.append(String.format("%d %d %d %d\n", i, j, i, size - j - 1));
                    counterOperations++;
                }
            }
        } else {
            for (int j = 0; j < size / 2; j++) {
                for (int i = 0; i < size; i++) {
                    int temp = image[j][i];
                    image[j][i] = image[size - j - 1][i];
                    image[size - j - 1][i] = temp;
                    sb.append(String.format("%d %d %d %d\n", j, i, size - j - 1, i));
                    counterOperations++;
                }
            }
        }

        sb.insert(0, counterOperations + "\n");
        System.out.println(sb);
    }
}
