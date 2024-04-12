package org.example;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        int width = scanner.nextInt();

        int[][] image = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                image[i][j] = scanner.nextInt();
            }
        }

        int[][] imageFlipped = new int[width][height];
        for (int i = 0; i < height; i++) {

            for (int j = 0; j < width; j++) {
                imageFlipped[j][height - 1 - i] = image[i][j];
            }
        }

        for (int[] ai : imageFlipped) {
            for (int aij : ai) {
                System.out.print(aij + " ");
            }
            System.out.println();
        }
    }
}
