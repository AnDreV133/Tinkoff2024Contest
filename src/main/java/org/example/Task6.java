package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Task6 {
    private static final HashMap<StepInfo, Integer> cache = new HashMap<>();
    private static int minStep = Integer.MAX_VALUE;

    private static ArrayList<StepInfo> getStepsK(StepInfo pair, int size) {
        ArrayList<StepInfo> steps = new ArrayList<>();
        int[] sign = {-1, 1};
        for (int for1 : sign) {
            for (int for2 : sign) {
                int x = pair.first() + for1;
                int y = pair.second() + for2 * 2;
                if (x >= 0 && y >= 0 && x < size && y < size) {
                    steps.add(new StepInfo(x, y, pair.figure()));
                }

                x = pair.first() + for1 * 2;
                y = pair.second() + for2;
                if (x >= 0 && y >= 0 && x < size && y < size) {
                    steps.add(new StepInfo(x, y, pair.figure()));
                }
            }
        }

        return steps;
    }

    private static ArrayList<StepInfo> getStepsG(StepInfo pair, int size) {
        ArrayList<StepInfo> steps = new ArrayList<>();
        int[] sign = {-1, 0, 1};
        for (int for1 : sign) {
            for (int for2 : sign) {
                    int x = pair.first() + for1;
                    int y = pair.second() + for2;
                    if (x >= 0 && y >= 0 && x < size && y < size) {
                        steps.add(new StepInfo(x, y, pair.figure()));
                    }
            }
        }

        return steps;
    }

    static void recursionFindPath(char[][] board, StepInfo currentPosition, int size, int amountStep) {
        if (board[currentPosition.first()][currentPosition.second()] == 'F') {
            if (amountStep != 0 && amountStep < minStep) {
                minStep = amountStep;
            }

            return;
        }

        if (cache.containsKey(currentPosition)) {
            if (cache.get(currentPosition) <= amountStep) {
                return;
            }
        } else {
            cache.put(currentPosition, amountStep);
        }

        if (currentPosition.figure() == 'K' || currentPosition.figure() == 'G') {
            for (StepInfo stepInfo : getStepsK(currentPosition, size)) {
                if (cache.containsKey(stepInfo) && cache.get(stepInfo) <= amountStep) {
                    continue;
                }

                if (currentPosition.figure() == 'K') {
                    recursionFindPath(board, new StepInfo(stepInfo.first(), stepInfo.second(),
                            board[stepInfo.first()][stepInfo.second()] != 'G' ? currentPosition.figure() : 'G'), size, amountStep + 1);
                } else {
                    recursionFindPath(board, new StepInfo(stepInfo.first(), stepInfo.second(),
                            board[stepInfo.first()][stepInfo.second()] != 'K' ? currentPosition.figure() : 'K'), size, amountStep + 1);

                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        char[][] board = new char[size][size];
        StepInfo start = null;
        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < size; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'S') {
                    start = new StepInfo(i, j, 'K');
                }
            }
        }

        recursionFindPath(board, start, size, 0);

        System.out.println(minStep != Integer.MAX_VALUE ? minStep : -1);
    }

}

record StepInfo(int first, int second, char figure) {
}