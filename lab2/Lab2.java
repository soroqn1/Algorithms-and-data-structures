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
        // Метод хешування діленням
        return (int) Math.round(key) % size;
    }

    public boolean insert(Trapezium tr) {
        double key = tr.getPerimeter();
        int pos = hash(key);
        
        // У разі колізії елемент додаватися не буде 
        if (table[pos] != null) {
            return false; 
        }
        
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

public class Lab2 {
    public static void main(String[] args) {
        System.out.println("Розробник: Сорочан Ярослав Сергійович");
        System.out.println("Варіант 11 (Лабораторна робота 1.2)\n");

        int tableSize = 10;
        HashTable ht = new HashTable(tableSize);
        Random rand = new Random();
        
        int inserted = 0;
        // Намагаємось додати 5 трапецій без колізій
        while (inserted < 5) {
            // Щоб уникнути перетину ліній і точно отримати трапецію,
            // паралельні основи будуть горизонтальними (y1=y2, y3=y4)
            int y1 = rand.nextInt(10);
            int y2 = y1;
            int h = rand.nextInt(5) + 2; 
            int y3 = y1 + h;
            int y4 = y3;
            
            int x1 = rand.nextInt(10);
            int x2 = x1 + rand.nextInt(5) + 2;
            
            int x4 = rand.nextInt(10);
            int x3 = x4 + rand.nextInt(5) + 2;
            
            Trapezium tr = new Trapezium(x1, y1, x2, y2, x3, y3, x4, y4);
            
            if (ht.insert(tr)) {
                inserted++;
            }
        }

        ht.printTable();
    }
}
