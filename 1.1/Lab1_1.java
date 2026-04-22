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
