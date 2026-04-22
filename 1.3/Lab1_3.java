class Student {
    String lastName;
    int course;
    long ticketNumber;
    double averageGrade;
    String citizenship;

    public Student(String lastName, int course, long ticketNumber, double averageGrade, String citizenship) {
        this.lastName = lastName;
        this.course = course;
        this.ticketNumber = ticketNumber;
        this.averageGrade = averageGrade;
        this.citizenship = citizenship;
    }
}

class Node {
    Student student;
    Node left, right;
    
    public Node(Student student) {
        this.student = student;
    }
}

class BinaryTree {
    Node root;

    public void insert(Student student) {
        root = insertRec(root, student);
    }

    private Node insertRec(Node current, Student student) {
        if (current == null) {
            return new Node(student);
        }
        if (student.ticketNumber < current.student.ticketNumber) {
            current.left = insertRec(current.left, student);
        } else if (student.ticketNumber > current.student.ticketNumber) {
            current.right = insertRec(current.right, student);
        }
        return current;
    }

    public void printInOrder() {
        System.out.printf("%-15s | %-4s | %-15s | %-10s | %-15s%n", "Прізвище", "Курс", "Квиток (Ключ)", "Ср. бал", "Громадянство");
        System.out.println("-------------------------------------------------------------------------");
        inOrderRec(root);
    }

    private void inOrderRec(Node current) {
        if (current != null) {
            inOrderRec(current.left);
            System.out.printf("%-15s | %-4d | %-15d | %-10.2f | %-15s%n", 
                current.student.lastName, 
                current.student.course, 
                current.student.ticketNumber, 
                current.student.averageGrade, 
                current.student.citizenship);
            inOrderRec(current.right);
        }
    }
}

public class Lab1_3 {
    public static void main(String[] args) {
        System.out.println("Розробник: Сорочан Ярослав Сергійович");
        System.out.println("Варіант 11, Лабораторна робота 1.3 (Мінімальний рівень)\n");

        BinaryTree tree = new BinaryTree();
        
        tree.insert(new Student("Іваненко", 2, 20231500L, 4.5, "Україна"));
        tree.insert(new Student("Коваленко", 1, 20241011L, 3.8, "Україна"));
        tree.insert(new Student("Сміт", 3, 20211333L, 4.9, "США"));
        tree.insert(new Student("Шевченко", 4, 20202244L, 4.0, "Канада"));
        tree.insert(new Student("Бондар", 2, 20231222L, 4.1, "Україна"));

        System.out.println("Вміст бінарного дерева (Послідовний обхід):");
        tree.printInOrder();
    }
}
