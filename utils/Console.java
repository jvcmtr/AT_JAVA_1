package utils;

import java.util.Scanner;

public class Console {

    public static int width = 80;
    public static int spacing = 3;

    public static void Clear() {
        printBottomBorder();
        System.out.println("\n\n\n");
        printTopBorder();
        // │─┌ └┘░▒▓┐
    }

    public static void println(String s) {

        printBorderIn();
        for (int i = 0; i < width; i++) {
            if (i < s.length()) {
                System.out.print(s.charAt(i));
            } else {
                System.out.print(" ");
            }
        }
        printBorderOut();

        if (s.length() > width) {
            String overflow = s.substring(width);
            println(overflow);
        }
    }

    public static String getString(String Prompt, Scanner scan) {
        printBorderOut();

        printBorderOut();
    }

    private static void printTopBorder() {
        System.out.print("░░░░" + spacing("░"));
        printAllLine("░");
        System.out.println(spacing("░") + "░░░░");

        System.out.print("░░▒▒" + spacing("▓"));
        printAllLine("▓");
        System.out.println(spacing("▓") + "▒▒░░");

        System.out.print("░▒▓┌" + spacing("─"));
        printAllLine("─");
        System.out.println(spacing("─") + "┐▓▒░");

        for (int i = 0; i < spacing; i += 2) {
            println(" ");
        }

    }

    private static void printBottomBorder() {
        for (int i = 0; i < spacing; i += 2) {
            println(" ");
        }

        System.out.print("░▒▓└" + spacing("─"));
        printAllLine("─");
        System.out.println(spacing("─") + "┘▓▒░");

        System.out.print("░░▒▒" + spacing("▓"));
        printAllLine("▓");
        System.out.println(spacing("▓") + "▒▒░░");

        System.out.print("░░░░" + spacing("░"));
        printAllLine("░");
        System.out.println(spacing("░") + "░░░░");
    }

    private static String spacing(String s) {
        String r = "";
        for (int i = 0; i < spacing; i++) {
            r += s;
        }
        return r;
    }

    private static void printAllLine(String s) {
        int l = width / s.length();
        for (int i = 0; i < l; i++) {
            System.out.print(s);
        }
    }

    private static void printBorderIn() {

        System.out.print("░▒▓│" + spacing(" "));
    }

    private static void printBorderOut() {

        System.out.println(spacing(" ") + "│▓▒░");
    }
}
