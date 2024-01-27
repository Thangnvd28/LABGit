
package utils;

import java.util.Scanner;

public class InputUtils {

    public static Scanner sc = new Scanner(System.in);

    public static String inputCode() {

        String id;
        while (true) {
            try {
                id = sc.nextLine().trim();
                if (!id.matches("[a-zA-z0-9]+")) {
                    throw new IllegalArgumentException("Invalid code. Please enter a valid code.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.err.print(e.getMessage());
            }
        }
        return id;
    }

    public static String inputName() {
        String name;
        while (true) {
            try {
                name = sc.nextLine();

                if (!name.matches("[a-zA-Z .]+")) {
                    throw new IllegalArgumentException("Invalid name. Please enter a valid name.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.err.print(e.getMessage());
            }
        }
        return name;
    }

    public static float inputFloat() {
        float fl;
        while (true) {
            try {
                fl = Float.parseFloat(sc.nextLine());
                if (fl <= 0) {
                    throw new ArithmeticException("Not valid. Enter a positive number.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Pls input a valid float number.");
            } catch (ArithmeticException ex) {
                System.err.println(ex.getMessage());
            }
        }
        return fl;
    }

    public static int inputOption(int min, int max) {
        int rs;
        while (true) {
            try {
                rs = Integer.parseInt(sc.nextLine());
                if (rs < min || rs > max) {
                    throw new ArithmeticException("Not valid. Enter a valid number from " + min + " to " + max + ".");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Pls input a valid integer number.");
            } catch (ArithmeticException ex) {
                System.err.println(ex.getMessage());
            }
        }

        return rs;
    }
}
