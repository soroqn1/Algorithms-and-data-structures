import java.util.Random;
import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        System.out.println("Розробник: Сорочан Ярослав Сергійович");
        System.out.println("Варіант 11\n");

        int[][] A = new int[3][3];
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                A[i][j] = random.nextInt(100); 
            }
        }

        System.out.println("- матриця А:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%4d", A[i][j]);
            }
            System.out.println();
        }

        Scanner scanner = new Scanner(System.in);
        int i = -1;
        int j = -1;

        while (true) {
            System.out.print("\nВведіть номер рядка i (від 0 до 2): ");
            if (scanner.hasNextInt()) {
                i = scanner.nextInt();
                if (i >= 0 && i < 3) {
                    break;
                } else {
                    System.out.println("Помилка: індекс рядка має бути від 0 до 2.");
                }
            } else {
                System.out.println("Помилка: введіть ціле число.");
                scanner.next(); 
            }
        }

        while (true) {
            System.out.print("Введіть номер стовпця j (від 0 до 2): ");
            if (scanner.hasNextInt()) {
                j = scanner.nextInt();
                if (j >= 0 && j < 3) {
                    break;
                } else {
                    System.out.println("Помилка: індекс стовпця має бути від 0 до 2.");
                }
            } else {
                System.out.println("Помилка: введіть ціле число.");
                scanner.next(); 
            }
        }

        System.out.println("\n- значення a_ij матриці А: " + A[i][j]);

        scanner.close();
    }
}