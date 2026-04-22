ЗВІТ ДО ЛАБОРАТОРНОЇ РОБОТИ №1.5
Тема: Дослідження алгоритмів пошуку

МЕТА РОБОТИ: Вивчення методів пошуку даних у масивах. Реалізація алгоритму послідовного (лінійного) пошуку та операції видалення елементів за заданими критеріями.

ВАРІАНТ №11
Завдання: 
- Поля класу «Студент»: Прізвище, ім’я, курс, стать, ознака проживання в гуртожитку (так/ні).
- Правило формування структури даних: Невпорядкований масив.
- Алгоритм пошуку: Послідовний (лінійний).
- Дія: Видалити студентів-чоловіків 6-го курсу, що проживають у гуртожитку.

КОД ПРОГРАМИ (Lab1_5.java)

class Student {
    String lastName; String firstName;
    int course; String gender;
    boolean livesInDorm;

    public Student(String lastName, String firstName, int course, String gender, boolean livesInDorm) {
        this.lastName = lastName; this.firstName = firstName;
        this.course = course; this.gender = gender;
        this.livesInDorm = livesInDorm;
    }

    public void print() {
        System.out.printf("%-12s %-12s | Курс: %d | Стать: %s | Гуртожиток: %s%n", 
            lastName, firstName, course, gender, livesInDorm ? "Так" : "Ні");
    }
}

public class Lab1_5 {
    public static void main(String[] args) {
        System.out.println("Розробник: Сорочан Ярослав Сергійович");
        System.out.println("Варіант 11, Лабораторна робота 1.5 (Мінімальний рівень)\n");

        Student[] students = new Student[10];
        int count = 0;
        students[count++] = new Student("Іваненко", "Дмитро", 6, "Ч", true); 
        students[count++] = new Student("Шевченко", "Марія", 3, "Ж", true);
        students[count++] = new Student("Бондар", "Максим", 6, "Ч", false); 
        students[count++] = new Student("Коваленко", "Олег", 6, "Ч", true); 
        students[count++] = new Student("Петренко", "Іван", 2, "Ч", true);

        System.out.println("Початковий масив:");
        for (int i = 0; i < count; i++) students[i].print();

        System.out.println("\nВиконуємо лінійний пошук та видалення...");

        int i = 0;
        while (i < count) {
            if (students[i].course == 6 && students[i].gender.equals("Ч") && students[i].livesInDorm) {
                for (int j = i; j < count - 1; j++) students[j] = students[j + 1];
                students[count - 1] = null;
                count--;
            } else i++;
        }

        System.out.println("\nМасив після видалення:");
        for (int k = 0; k < count; k++) students[k].print();
    }
}

РЕЗУЛЬТАТИ ВИКОНАННЯ

Розробник: Сорочан Ярослав Сергійович
Варіант 11, Лабораторна робота 1.5 (Мінімальний рівень)

Початковий масив:
Іваненко     Дмитро       | Курс: 6 | Стать: Ч | Гуртожиток: Так
Шевченко     Марія        | Курс: 3 | Стать: Ж | Гуртожиток: Так
Бондар       Максим       | Курс: 6 | Стать: Ч | Гуртожиток: Ні
Коваленко    Олег         | Курс: 6 | Стать: Ч | Гуртожиток: Так
Петренко     Іван         | Курс: 2 | Стать: Ч | Гуртожиток: Так

Виконуємо лінійний пошук та видалення (Студенти-чоловіки 6-го курсу з гуртожитку)...

Масив після видалення:
Шевченко     Марія        | Курс: 3 | Стать: Ж | Гуртожиток: Так
Бондар       Максим       | Курс: 6 | Стать: Ч | Гуртожиток: Ні
Петренко     Іван         | Курс: 2 | Стать: Ч | Гуртожиток: Так

ВИСНОВОК
В лабораторній роботі було реалізовано лінійний пошук елементів у масиві за декількома умовами одночасно. Також відпрацьовано механізм видалення елементів шляхом зсуву залишку масиву вліво.
