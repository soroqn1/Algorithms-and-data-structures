ЗВІТ ДО ЛАБОРАТОРНОЇ РОБОТИ №1.1
Тема: Дослідження лінійних структур даних

МЕТА РОБОТИ: Ознайомлення з лінійною структурою даних — Стеком. Реалізація стеку на базі статичного масиву та виконання основних операцій (додавання, видалення, перевірка стану).

ВАРІАНТ №11
Завдання: Реалізувати Стек з векторним (масив) способом розміщення елементів. Тип елементів — цілі числа (int). Реалізувати методи: push, pop, isEmpty, isFull.

КОД ПРОГРАМИ (Lab1_1.java)

class IntStack {
    private int[] elements;
    private int top;

    public IntStack(int size) {
        elements = new int[size];
        top = -1;
    }

    public boolean isFull() {
        return top == elements.length - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean push(int value) {
        if (isFull()) {
            return false;
        }
        elements[++top] = value;
        return true;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Стек порожній");
        }
        return elements[top--];
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Стек порожній");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }
}

public class Lab1_1 {
    public static void main(String[] args) {
        System.out.println("Розробник: Сорочан Ярослав Сергійович");
        System.out.println("Варіант 11, Лабораторна робота 1.1\n");

        IntStack stack = new IntStack(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.print("Початковий стан стеку: ");
        stack.printStack();

        System.out.println("\nВидаляємо 2 елементи:");
        System.out.println("Видалено: " + stack.pop());
        System.out.println("Видалено: " + stack.pop());

        System.out.print("\nСтек після видалення: ");
        stack.printStack();
    }
}

РЕЗУЛЬТАТИ ВИКОНАННЯ

Розробник: Сорочан Ярослав Сергійович
Варіант 11, Лабораторна робота 1.1

Початковий стан стеку: 40 30 20 10 

Видаляємо 2 елементи:
Видалено: 40
Видалено: 30

Стек після видалення: 20 10 

ВИСНОВОК
Під час виконання лабораторної роботи було вивчено принципи роботи структури даних Стек (LIFO). Стек успішно реалізовано на основі цілочисельного масиву. Всі операції (push, pop) працюють коректно згідно з завданням.
