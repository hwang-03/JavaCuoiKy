package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {
    public static int getInt(Scanner scanner, String prompString) {
        int value = 0;
        boolean isValid = false;
        do {
            System.out.print(prompString);
            try {
                value = scanner.nextInt();
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Error! Invalid number, try again");
                scanner.nextLine();
            }
        } while (!isValid);
        return value;
    }

    public static double getDouble(Scanner scanner, String prompString) {
        double value = 0;
        boolean isValid = false;
        do {
            System.out.print(prompString);
            try {
                value = scanner.nextDouble();
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Error! Invalid number, try again");
                scanner.nextLine();
            }
        } while (!isValid);
        return value;
    }

    public static float getFloat(Scanner scanner, String prompString) {
        float value = 0;
        boolean isValid = false;
        do {
            System.out.print(prompString);
            try {
                value = scanner.nextFloat();
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Error! Invalid number, try again");
                scanner.nextLine();
            }
        } while (!isValid);
        return value;
    }

    public static String getString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.next().trim();
    }

    public static float getGPA(Scanner scanner, String prompt) {
        float gpa = -1;
        while (gpa <= 0 || gpa > 4) {
            System.out.print(prompt);
            try {
                gpa = scanner.nextFloat();
                scanner.nextLine();
                if (gpa <= 0 || gpa > 4) {
                    System.out.println("GPA must be between 0 and 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }
        return gpa;
    }

    // Phương thức nhập tuổi
    public static int getAge(Scanner scanner, String prompt) {
        int age = -1;
        while (age <= 0) {
            System.out.print(prompt);
            try {
                age = scanner.nextInt();
                scanner.nextLine();
                if (age <= 0) {
                    System.out.println("Age must be a positive number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }
        return age;
    }
}
