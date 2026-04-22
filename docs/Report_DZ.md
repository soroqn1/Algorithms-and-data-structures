ДОМАШНЯ РОБОТА
з дисципліни «Алгоритми та структури даних»

Тема: Обчислювальні алгоритми та алгоритми обробки графів

МЕТА РОБОТИ:
- Дослідження методів та алгоритмів для вирішення систем лінійних алгебраїчних рівнянь (СЛАР).
- Дослідження способів представлення такої структури даних як «Граф», алгоритмів її обробки та набуття практичних навичок із розв’язання задач на графах.

ВАРІАНТ №11

ЗАВДАННЯ ПЕРШОГО РІВНЯ
Написати програму на мові Java, яка вирішує методом LUP-розкладання СЛАР згідно варіанту:
5x1 - 9x2 - 4x3 = 57
7x1 + x2 + 2x3 = 53
6x1 - 9x2 - 6x3 = 45

ЗАВДАННЯ ДРУГОГО РІВНЯ
Побудувати граф згідно опису: Між населеними пунктами A, B, C, D, E, F побудовані дороги з відстанями. Написати програму на мові Java, яка реалізує цей граф у вигляді матриці суміжності та виконує його обхід у ширину (BFS) починаючи з пункту A.

-------------------------------------------------------------------------

КОД ПРОГРАМИ ЗАВДАННЯ №1 (Task1.java)

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

        for (int i = 0; i < n; i++) {
            int pivot = i;
            double max = Math.abs(a[i][i]);
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(a[k][i]) > max) {
                    max = Math.abs(a[k][i]);
                    pivot = k;
                }
            }

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

        double[] y = new double[n];
        for (int i = 0; i < n; i++) {
            double sum = 0;
            for (int j = 0; j < i; j++) sum += a[i][j] * y[j];
            y[i] = b[p[i]] - sum;
        }

        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < n; j++) sum += a[i][j] * x[j];
            x[i] = (y[i] - sum) / a[i][i];
        }

        System.out.println("\nРезультат (x):");
        for (int i = 0; i < n; i++) System.out.printf("x%d = %.4f%n", (i + 1), x[i]);
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
        for (int i = 0; i < lu.length; i++) {
            for (int j = 0; j < lu.length; j++) {
                if (i > j) System.out.printf("%10.4f ", lu[i][j]);
                else if (i == j) System.out.printf("%10.4f ", 1.0);
                else System.out.printf("%10.4f ", 0.0);
            }
            System.out.println();
        }
    }

    static void printU(double[][] lu) {
        for (int i = 0; i < lu.length; i++) {
            for (int j = 0; j < lu.length; j++) {
                if (i <= j) System.out.printf("%10.4f ", lu[i][j]);
                else System.out.printf("%10.4f ", 0.0);
            }
            System.out.println();
        }
    }

    static void printPermutationMatrix(int[] p) {
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p.length; j++) System.out.printf("%d ", (p[i] == j ? 1 : 0));
            System.out.println();
        }
    }
}

-------------------------------------------------------------------------

КОД ПРОГРАМИ ЗАВДАННЯ №2 (Task2.java)

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("Розробник: Сорочан Ярослав Сергійович");
        System.out.println("Варіант 11, Домашня робота (Завдання 2 - Граф)\n");

        String[] vertices = {"A", "B", "C", "D", "E", "F"};
        int n = vertices.length;
        int[][] matrix = {
            {0, 2, 4, 0, 0, 0},
            {2, 0, 1, 0, 7, 0},
            {4, 1, 0, 3, 4, 0},
            {0, 0, 3, 0, 3, 0},
            {0, 7, 4, 3, 0, 2},
            {0, 0, 0, 0, 2, 0}
        };

        System.out.println("Матриця суміжності (відстані між пунктами):");
        System.out.print("  ");
        for (String v : vertices) System.out.print(v + " ");
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(vertices[i] + " ");
            for (int j = 0; j < n; j++) System.out.print(matrix[i][j] + " ");
            System.out.println();
        }

        System.out.println("\nРезультат обходу в ширину (BFS) починаючи з пункту A:");
        bfs(matrix, vertices, 0);
    }

    public static void bfs(int[][] matrix, String[] vertices, int start) {
        int n = matrix.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(vertices[current] + " ");
            for (int i = 0; i < n; i++) {
                if (matrix[current][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        System.out.println();
    }
}

-------------------------------------------------------------------------

РЕЗУЛЬТАТИ ВИКОНАННЯ

Завдання 1 (СЛАР):
Матриця P (перестановки):
0 1 0 
0 0 1 
1 0 0 

Матриця L:
    1.0000     0.0000     0.0000 
    0.8571     1.0000     0.0000 
    0.7143     0.9855     1.0000 

Матриця U:
    7.0000     1.0000     2.0000 
    0.0000    -9.8571    -7.7143 
    0.0000     0.0000     2.1739 

Розв'язок:
x1 = 6.0000
x2 = -7.0000
x3 = 9.0000

Завдання 2 (Граф):
Результат обходу в ширину (BFS) починаючи з пункту A:
A B C E D F 

-------------------------------------------------------------------------

ВИСНОВОК
Під час виконання домашньої роботи було реалізовано алгоритм LUP-розкладання для розв’язання системи лінійних рівнянь, що дозволяє ефективно обчислювати корені через декомпозицію матриць. Також було побудовано граф на основі матриці суміжності та реалізовано алгоритм обходу в ширину (BFS), що дозволяє відвідувати всі вершини графа рівень за рівнем.
