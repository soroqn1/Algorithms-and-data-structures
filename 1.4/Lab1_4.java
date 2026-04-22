class Student {
    String lastName;
    String firstName;
    String group;
    String gender;

    public Student(String lastName, String firstName, String group, String gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.group = group;
        this.gender = gender;
    }

    public void print() {
        System.out.printf("%-12s %-12s | Група: %-6s | Стать: %-6s%n", lastName, firstName, group, gender);
    }
}

public class Lab1_4 {
    public static void selectionSort(Student[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].firstName.compareTo(arr[minIdx].firstName) < 0) {
                    minIdx = j;
                }
            }
            Student temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println("Розробник: Сорочан Ярослав Сергійович");
        System.out.println("Варіант 11, Лабораторна робота 1.4 (Мінімальний рівень)\n");

        Student[] students = {
            new Student("Іваненко", "Олександр", "КН-21", "Ч"),
            new Student("Шевченко", "Марія", "КН-22", "Ж"),
            new Student("Бондар", "Андрій", "КН-21", "Ч"),
            new Student("Коваленко", "Вікторія", "КН-23", "Ж"),
            new Student("Петренко", "Богдан", "КН-22", "Ч")
        };

        System.out.println("Масив до сортування:");
        for (Student s : students) {
            s.print();
        }

        selectionSort(students);

        System.out.println("\nМасив після сортування вибіркою (За ім'ям за алфавітом):");
        for (Student s : students) {
            s.print();
        }
    }
}
