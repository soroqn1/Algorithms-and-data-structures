import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("Розробник: Сорочан Ярослав Сергійович");
        System.out.println("Варіант 11, Домашня робота (Завдання 2 - Граф)\n");

        String[] vertices = {"A", "B", "C", "D", "E", "F"};
        int n = vertices.length;
        
        // Adjacency Matrix (Distances)
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
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
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
