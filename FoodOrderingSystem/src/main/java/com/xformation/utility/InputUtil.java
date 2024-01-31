package com.xformation.utility;

import java.util.Scanner;

public class InputUtil {

    public static String getStringInput(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(text);
        String result = scanner.nextLine();
        return result;
    }

    public static int getIntegerInput(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(text);
        int result = scanner.nextInt();
        return result;
    }
}
