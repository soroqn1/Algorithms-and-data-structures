public class Lab2_3 {
    public static long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("Розробник: Сорочан Ярослав Сергійович");
        System.out.println("Варіант 11, Лабораторна робота 2.3 (Мінімальний рівень)\n");

        System.out.println("Завдання: Кількість кімнат у гуртожитку з одним вільним місцем – 14.");
        System.out.println("Скількома способами можна розмістити 14 першокурсників на ці місця?");
        System.out.println("Тип вибірки: Перестановка без повторень (Permutations), P(n) = n!\n");

        int n = 14;
        long ways = factorial(n);

        System.out.printf("Відповідь: P(14) = 14! = %d способів.%n", ways);
    }
}
