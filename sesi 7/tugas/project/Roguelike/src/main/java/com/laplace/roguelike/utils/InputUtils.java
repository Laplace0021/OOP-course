package com.laplace.roguelike.utils;

import java.util.Scanner;
public class InputUtils {
    private static final Scanner input = new Scanner(System.in);
    public static int getInt(String text){
        while (true) {
            System.out.print(text);
            try {
                return Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
            }
        }
    }
    public static String getString(String text){
        System.out.print(text);
        return input.nextLine();
    }
}
