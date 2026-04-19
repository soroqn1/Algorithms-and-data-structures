import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("Розробник: Сорочан Ярослав Сергійович");
        System.out.println("Лабораторна робота №2, Завдання 2, Варіант 11\n");

        String text = "Це приклад довільного тексту. Він складається з декількох речень.\n" +
                      "Тут є як довгі слова, так і короткі. Наприклад, ми спробуємо змінити цей текст.\n" +
                      "Деякі слова будуть змінені, якщо їхня довжина достатня.";

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть позицію букви k в слові, яку потрібно замінити (починаючи з 1): ");
        int k = scanner.nextInt();

        System.out.print("Введіть новий символ для заміни: ");
        char symbol = scanner.next().charAt(0);

        System.out.println("\n=== Вхідні параметри ===");
        System.out.println("Позиція k = " + k);
        System.out.println("Символ = '" + symbol + "'");

        System.out.println("\n=== Текст до обробки ===");
        System.out.println(text);

        StringBuilder result = new StringBuilder();
        int letterCountInWord = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                letterCountInWord++;

                if (letterCountInWord == k) {
                    result.append(symbol);
                } else {
                    result.append(ch);
                }
            } else {
                letterCountInWord = 0;
                result.append(ch);
            }
        }

        System.out.println("\n=== Текст після обробки ===");
        System.out.println(result.toString());

        scanner.close();
    }
}