package ua.sidun.lab2;

import java.util.Random;
import java.util.Scanner;

/**
 * Лабораторна робота 2. Основи. Створення матриці цілих чисел (з клавіатури або випадково), пошук
 * мінімального та максимального елементів, розрахунок середнього арифметичного та геометричного.
 */
public class MatrixApp {

    private static final int MAX_SIZE = 20;
    private static final int MIN_SIZE = 1;
    private static final int MIN_RANDOM_VALUE = 1;
    private static final int MAX_RANDOM_VALUE = 100;

    private static final int MANUAL_MODE = 1;
    private static final int RANDOM_MODE = 2;

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        int height =
                readInt(
                        "Введіть висоту матриці (" + MIN_SIZE + "-" + MAX_SIZE + "): ",
                        MIN_SIZE,
                        MAX_SIZE);
        int width =
                readInt(
                        "Введіть ширину матриці (" + MIN_SIZE + "-" + MAX_SIZE + "): ",
                        MIN_SIZE,
                        MAX_SIZE);

        System.out.println("Оберіть спосіб створення матриці:");
        System.out.println(MANUAL_MODE + " - ввести з клавіатури");
        System.out.println(RANDOM_MODE + " - заповнити випадковими числами");
        int mode = readInt("Ваш вибір: ", MANUAL_MODE, RANDOM_MODE);

        int[][] matrix =
                mode == MANUAL_MODE
                        ? createManualMatrix(height, width)
                        : createRandomMatrix(height, width);

        printMatrix(matrix);
        System.out.println("Мінімальний елемент: " + findMin(matrix));
        System.out.println("Максимальний елемент: " + findMax(matrix));
        System.out.printf("Середнє арифметичне: %.4f%n", calculateArithmeticMean(matrix));
        printGeometricMean(matrix);
    }

    private static int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            if (SCANNER.hasNextInt()) {
                int value = SCANNER.nextInt();
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Значення має бути в межах від " + min + " до " + max + ".");
            } else {
                System.out.println("Потрібно ввести ціле число.");
                SCANNER.next();
            }
        }
    }

    private static int[][] createManualMatrix(int height, int width) {
        int[][] matrix = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] =
                        readInt(
                                "Елемент [" + i + "][" + j + "]: ",
                                Integer.MIN_VALUE,
                                Integer.MAX_VALUE);
            }
        }
        return matrix;
    }

    private static int[][] createRandomMatrix(int height, int width) {
        int[][] matrix = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] =
                        RANDOM.nextInt(MAX_RANDOM_VALUE - MIN_RANDOM_VALUE + 1) + MIN_RANDOM_VALUE;
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println("Матриця:");
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.printf("%6d", element);
            }
            System.out.println();
        }
    }

    private static int findMin(int[][] matrix) {
        int min = matrix[0][0];
        for (int[] row : matrix) {
            for (int element : row) {
                if (element < min) {
                    min = element;
                }
            }
        }
        return min;
    }

    private static int findMax(int[][] matrix) {
        int max = matrix[0][0];
        for (int[] row : matrix) {
            for (int element : row) {
                if (element > max) {
                    max = element;
                }
            }
        }
        return max;
    }

    private static double calculateArithmeticMean(int[][] matrix) {
        long sum = 0;
        int count = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                sum += element;
                count++;
            }
        }
        return (double) sum / count;
    }

    /**
     * Середнє геометричне рахується через логарифми, щоб уникнути переповнення під час множення до
     * 400 чисел. Визначене лише для додатних елементів.
     */
    private static double calculateGeometricMean(int[][] matrix) {
        double logSum = 0;
        int count = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                logSum += Math.log(element);
                count++;
            }
        }
        return Math.exp(logSum / count);
    }

    private static void printGeometricMean(int[][] matrix) {
        if (findMin(matrix) <= 0) {
            System.out.println(
                    "Середнє геометричне не визначене: матриця містить недодатні елементи.");
        } else {
            System.out.printf("Середнє геометричне: %.4f%n", calculateGeometricMean(matrix));
        }
    }
}
