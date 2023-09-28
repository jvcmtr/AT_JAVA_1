package utils;

public class Console {

    public static int width = 60;

    public static void Clear() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
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

    private static void printTopBorder() {
        System.out.print("░░░░░");
        printAllLine("░");
        System.out.println("░░░░░");

        System.out.print("░░▒▒▒");
        printAllLine("▒");
        System.out.println("▒▒▒░░");
        /*
         * System.out.println("▓░▒");
         * printAllLine("▓");
         * System.out.println("▓▒░");
         */
        System.out.print("░▒▓┌─");
        printAllLine("─");
        System.out.println("─┐▓▒░");
    }

    private static void printAllLine(String s) {
        int l = width / s.length();
        for (int i = 0; i < l; i++) {
            System.out.print(s);
        }
    }

    private static void printBorderIn() {

        System.out.print("░▒▓│ ");
    }

    private static void printBorderOut() {

        System.out.println(" │▓▒░");
    }
}
