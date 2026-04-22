import java.util.Random;

public class Lab1_6 {
    public static void optimizedBubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void measureTime(int size) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10000);
        }

        long startTime = System.nanoTime();
        optimizedBubbleSort(arr);
        long endTime = System.nanoTime();

        long durationNs = endTime - startTime;
        double durationMs = durationNs / 1_000_000.0;
        
        System.out.printf("Розмір масиву: %-8d | Час виконання: %10.2f мс (або %d нс)%n", size, durationMs, durationNs);
    }

    public static void main(String[] args) {
        System.out.println("Розробник: Сорочан Ярослав Сергійович");
        System.out.println("Варіант 11, Лабораторна робота 1.6 (Мінімальний рівень)\n");

        System.out.println("Емпіричний аналіз алгоритму Сортування (Бульбашкове оптимізоване):");
        
        measureTime(100);
        measureTime(10000);
        measureTime(100000); 
    }
}
