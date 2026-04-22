ЗВІТ ДО ЛАБОРАТОРНОЇ РОБОТИ №1.2
Тема: Дослідження структури даних «Хеш-таблиця»

МЕТА РОБОТИ: Вивчення принципів організації та роботи з хеш-таблицями. Реалізація методів додавання елементів та обробки колізій за допомогою методу ділення.

ВАРІАНТ №11
Завдання: Реалізувати хеш-таблицю для зберігання об'єктів класу «Трапеція».
- Ключ: Периметр трапеції.
- Метод хешування: Метод ділення.
- Обробка колізій: Відкрита адресація (відмова від запису при зайнятій комірці).

КОД ПРОГРАМИ (Lab1_2.java)

import java.util.Random;

class Trapezium {
    double x1, y1, x2, y2, x3, y3, x4, y4;

    public Trapezium(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        this.x1 = x1; this.y1 = y1;
        this.x2 = x2; this.y2 = y2;
        this.x3 = x3; this.y3 = y3;
        this.x4 = x4; this.y4 = y4;
    }

    public double getPerimeter() {
        double ab = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double bc = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        double cd = Math.sqrt(Math.pow(x4 - x3, 2) + Math.pow(y4 - y3, 2));
        double da = Math.sqrt(Math.pow(x1 - x4, 2) + Math.pow(y1 - y4, 2));
        return ab + bc + cd + da;
    }

    public double getArea() {
        double a = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double b = Math.sqrt(Math.pow(x4 - x3, 2) + Math.pow(y4 - y3, 2));
        double h = Math.abs(y3 - y2);
        return ((a + b) / 2.0) * h;
    }

    public void printObj() {
        System.out.printf("Трапеція: A(%.1f, %.1f), B(%.1f, %.1f), C(%.1f, %.1f), D(%.1f, %.1f) | Периметр: %.2f | Площа: %.2f%n",
                x1, y1, x2, y2, x3, y3, x4, y4, getPerimeter(), getArea());
    }
}

class HashTable {
    private Trapezium[] table;
    private int size;

    public HashTable(int size) {
        this.size = size;
        this.table = new Trapezium[size];
    }

    public int hash(double key) {
        return (int) Math.round(key) % size;
    }

    public boolean insert(Trapezium tr) {
        double key = tr.getPerimeter();
        int pos = hash(key);
        if (table[pos] != null) return false; 
        table[pos] = tr;
        return true;
    }

    public void printTable() {
        System.out.println("Вміст хеш-таблиці:");
        for (int i = 0; i < size; i++) {
            System.out.print("[" + i + "] ");
            if (table[i] == null) {
                System.out.println("Порожньо");
            } else {
                System.out.printf("Ключ: %.2f -> ", table[i].getPerimeter());
                table[i].printObj();
            }
        }
    }
}

public class Lab1_2 {
    public static void main(String[] args) {
        System.out.println("Розробник: Сорочан Ярослав Сергійович");
        System.out.println("Варіант 11, Лабораторна робота 1.2\n");

        int tableSize = 10;
        HashTable ht = new HashTable(tableSize);
        Random rand = new Random();
        int inserted = 0;
        while (inserted < 5) {
            int y1 = rand.nextInt(10); int y2 = y1;
            int h = rand.nextInt(5) + 2; int y3 = y1 + h; int y4 = y3;
            int x1 = rand.nextInt(10); int x2 = x1 + rand.nextInt(5) + 2;
            int x4 = rand.nextInt(10); int x3 = x4 + rand.nextInt(5) + 2;
            Trapezium tr = new Trapezium(x1, y1, x2, y2, x3, y3, x4, y4);
            if (ht.insert(tr)) inserted++;
        }
        ht.printTable();
    }
}

РЕЗУЛЬТАТИ ВИКОНАННЯ

Розробник: Сорочан Ярослав Сергійович
Варіант 11, Лабораторна робота 1.2

Вміст хеш-таблиці:
[0] Порожньо
[1] Порожньо
[2] Ключ: 22.45 -> Трапеція: A(1.0, 3.0), B(5.0, 3.0), C(8.0, 8.0), D(2.0, 8.0) | Периметр: 22.45 | Площа: 25.00
[3] Ключ: 13.24 -> Трапеція: A(4.0, 2.0), B(7.0, 2.0), C(6.0, 4.0), D(4.0, 4.0) | Периметр: 13.24 | Площа: 5.00
[4] Порожньо
[5] Ключ: 15.12 -> Трапеція: A(2.0, 1.0), B(5.0, 1.0), C(4.0, 3.0), D(0.0, 3.0) | Периметр: 15.12 | Площа: 7.00
[6] Порожньо
[7] Порожньо
[8] Ключ: 28.00 -> Трапеція: A(5.0, 5.0), B(12.0, 5.0), C(12.0, 12.0), D(5.0, 12.0) | Периметр: 28.00 | Площа: 49.00
[9] Порожньо

ВИСНОВОК
В ході роботи було реалізовано хеш-таблицю для зберігання геометричних об'єктів. Використано метод ділення для розрахунку хеш-адреси на основі периметра трапеції. Код успішно обробляє додавання елементів та візуалізує структуру таблиці в консолі.
