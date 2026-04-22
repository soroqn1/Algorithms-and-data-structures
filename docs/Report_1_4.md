ЗВІТ ДО ЛАБОРАТОРНОЇ РОБОТИ №1.4
Тема: Дослідження алгоритмів сортування

МЕТА РОБОТИ: Вивчення та практична реалізація алгоритмів сортування масивів об'єктів. Ознайомлення з методом сортування вибіркою.

ВАРІАНТ №11
Завдання: Реалізувати сортування масиву об'єктів класу «Студент».
- Поля класу «Студент»: Прізвище, ім’я, група, стать.
- Алгоритм сортування: Вибіркою (Selection Sort).
- Порядок сортування: За ім’ям за алфавітом.

КОД ПРОГРАМИ (Lab1_4.java)

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
        for (Student s : students) s.print();

        selectionSort(students);

        System.out.println("\nМасив після сортування вибіркою (За ім'ям за алфавітом):");
        for (Student s : students) s.print();
    }
}

РЕЗУЛЬТАТИ ВИКОНАННЯ

Розробник: Сорочан Ярослав Сергійович
Варіант 11, Лабораторна робота 1.4 (Мінімальний рівень)

Масив до сортування:
Іваненко     Олександр    | Група: КН-21  | Стать: Ч     
Шевченко     Марія        | Група: КН-22  | Стать: Ж     
Бондар       Андрій       | Група: КН-21  | Стать: Ч     
Коваленко    Вікторія     | Група: КН-23  | Стать: Ж     
Петренко     Богдан       | Група: КН-22  | Стать: Ч     

Масив після сортування вибіркою (За ім'ям за алфавітом):
Бондар       Андрій       | Група: КН-21  | Стать: Ч     
Петренко     Богдан       | Група: КН-22  | Стать: Ч     
Коваленко    Вікторія     | Група: КН-23  | Стать: Ж     
Шевченко     Марія        | Група: КН-22  | Стать: Ж     
Іваненко     Олександр    | Група: КН-21  | Стать: Ч     

ВИСНОВОК
В ході лабораторної роботи було вивчено алгоритм сортування вибіркою. Програма успішно виконує впорядкування масиву об'єктів класу «Студент» за алфавітом, використовуючи метод порівняння рядків compareTo.
