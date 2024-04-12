package org.example;

import java.util.HashSet;
import java.util.Scanner;

public class Task5 {
    private static final HashSet<Pair> cache = new HashSet<>();
    private static int maxC = 0;

    static void recursionDeep(char[][] forest, Pair currentPosition, int length, int amountC) {
        if (cache.contains(currentPosition) || currentPosition.first() == length
                || forest[currentPosition.first()][currentPosition.second()] == 'W') {
            if (amountC > maxC) {
                maxC = amountC;
            }

            amountC = 0;
            return;
        }

        cache.add(currentPosition);
        if (forest[currentPosition.first()][currentPosition.second()] == 'C') {
            amountC++;
        }

        if (currentPosition.second() != 0) {
            recursionDeep(forest, new Pair(currentPosition.first() + 1, 0), length, amountC);
        }
        if (currentPosition.second() != 2) {
            recursionDeep(forest, new Pair(currentPosition.first() + 1, 2), length, amountC);
        }
        recursionDeep(forest, new Pair(currentPosition.first() + 1, 1), length, amountC);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        
        char[][] forest = new char[length][3];
        for (int i = 0; i < length; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < 3; j++) {
                forest[i][j] = line.charAt(j);
            }
        }
        
        for (int i = 0; i < 3; i++) {
            recursionDeep(forest, new Pair(0, i), length, 0);
        }

        System.out.println(maxC);
    }

}

record Pair(int first, int second) {
}