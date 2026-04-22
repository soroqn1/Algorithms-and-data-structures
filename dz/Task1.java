import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.println("Розробник: Сорочан Ярослав Сергійович");
        System.out.println("Варіант 11, Домашня робота (Завдання 1 - LUP)\n");

        double[][] a = {
            {5, -9, -4},
            {7, 1, 2},
            {6, -9, -6}
        };
        double[] b = {57, 53, 45};
        int n = a.length;

        System.out.println("Задана система рівнянь:");
        printSystem(a, b);

        int[] p = new int[n];
        for (int i = 0; i < n; i++) p[i] = i;

        // LUP decomposition
        for (int i = 0; i < n; i++) {
            int pivot = i;
            double max = Math.abs(a[i][i]);
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(a[k][i]) > max) {
                    max = Math.abs(a[k][i]);
                    pivot = k;
                }
            }

            // Swap rows in A and P
            double[] tempA = a[i];
            a[i] = a[pivot];
            a[pivot] = tempA;

            int tempP = p[i];
            p[i] = p[pivot];
            p[pivot] = tempP;

            for (int j = i + 1; j < n; j++) {
                a[j][i] /= a[i][i];
                for (int k = i + 1; k < n; k++) {
                    a[j][k] -= a[j][i] * a[i][k];
                }
            }
        }

        System.out.println("\nМатриця P (перестановки):");
        printPermutationMatrix(p);

        System.out.println("\nМатриця L (нижня трикутна):");
        printL(a);

        System.out.println("\nМатриця U (верхня трикутна):");
        printU(a);

        // Solve Ly = Pb
        double[] y = new double[n];
        for (int i = 0; i < n; i++) {
            double sum = 0;
            for (int j = 0; j < i; j++) {
                sum += a[i][j] * y[j];
            }
            y[i] = b[p[i]] - sum;
        }

        // Solve Ux = y
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < n; j++) {
                sum += a[i][j] * x[j];
            }
            x[i] = (y[i] - sum) / a[i][i];
        }

        System.out.println("\nРезультат (x):");
        for (int i = 0; i < n; i++) {
            System.out.printf("x%d = %.4f%n", (i + 1), x[i]);
        }
    }

    static void printSystem(double[][] a, double[] b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.printf("%s%.0fx%d ", (a[i][j] >= 0 && j > 0 ? "+ " : ""), a[i][j], (j + 1));
            }
            System.out.printf("= %.0f%n", b[i]);
        }
    }

    static void printL(double[][] lu) {
        int n = lu.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > j) System.out.printf("%10.4f ", lu[i][j]);
                else if (i == j) System.out.printf("%10.4f ", 1.0);
                else System.out.printf("%10.4f ", 0.0);
            }
            System.out.println();
        }
    }

    static void printU(double[][] lu) {
        int n = lu.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i <= j) System.out.printf("%10.4f ", lu[i][j]);
                else System.out.printf("%10.4f ", 0.0);
            }
            System.out.println();
        }
    }

    static void printPermutationMatrix(int[] p) {
        int n = p.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", (p[i] == j ? 1 : 0));
            }
            System.out.println();
        }
    }
}
