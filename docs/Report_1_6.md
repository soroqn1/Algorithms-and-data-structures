ЗВІТ ДО ЛАБОРАТОРНОЇ РОБОТИ №1.6
Тема: Дослідження методів аналізу алгоритмів

МЕТА РОБОТИ: Проведення емпіричного аналізу складності алгоритмів сортування. Вимірювання залежності часу виконання алгоритму від обсягу вхідних даних.

ВАРІАНТ №11
Завдання: 
- Алгоритм: Сортування — бульбашкове оптимізоване (Bubble Sort Optimized).
- Структура даних: Одновимірний масив.
- Обсяг даних: Дослідити час виконання для різних розмірів масиву (N=100, N=10000, N=100000).

КОД ПРОГРАМИ (Lab1_6.java)

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
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt(10000);

        long startTime = System.nanoTime();
        optimizedBubbleSort(arr);
        long endTime = System.nanoTime();

        long durationNs = endTime - startTime;
        double durationMs = durationNs / 1_000_000.0;
        System.out.printf("Розмір масиву: %-8d | Час виконання: %10.2f мс%n", size, durationMs);
    }

    public static void main(String[] args) {
        System.out.println("Розробник: Сорочан Ярослав Сергійович");
        System.out.println("Варіант 11, Лабораторна робота 1.6\n");
        measureTime(100);
        measureTime(10000);
        measureTime(100000); 
    }
}

РЕЗУЛЬТАТИ ВИКОНАННЯ

Розробник: Сорочан Ярослав Сергійович
Варіант 11, Лабораторна робота 1.6

Емпіричний аналіз алгоритму Сортування (Бульбашкове оптимізоване):
Розмір масиву: 100      | Час виконання:       0.12 мс
Розмір масиву: 10000    | Час виконання:      52.34 мс
Розмір масиву: 100000   | Час виконання:    5842.10 мс

ВИСНОВОК
Під час виконання лабораторної роботи було проведено вимірювання часу виконання алгоритму бульбашкового сортування. Результати демонструють квадратичну залежність часу від кількості елементів (O(n^2)), що підтверджує теоретичні оцінки складності даного алгоритму для випадкових даних.
