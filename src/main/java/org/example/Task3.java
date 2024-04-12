package org.example;

import java.util.Scanner;
import java.util.ArrayList;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amountDir = Integer.parseInt(scanner.nextLine());

        ArrayList<String> array = new ArrayList<>();
        for (int i = 0; i < amountDir; i++) {
            array.add(scanner.nextLine());
        }

        array.sort(String::compareTo);

        StringBuilder sb = new StringBuilder();
        for (String path : array) {
            int indexSlash = 0;
            for (int i = path.length() - 1; i >= 0; i--) {
                if (path.charAt(i) == '/') {
                    indexSlash = i+1;
                    break;
                }
            }
            String dir = path.substring(indexSlash, path.length());
            String shift = "  ".repeat((int) path.chars().filter(c -> c == '/').count());

            sb.append(shift).append(dir).append("\n");
        }

        System.out.print(sb);
    }
}
