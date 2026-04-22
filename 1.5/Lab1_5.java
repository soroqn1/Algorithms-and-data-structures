class Student {
    String lastName;
    String firstName;
    int course;
    String gender;
    boolean livesInDorm;

    public Student(String lastName, String firstName, int course, String gender, boolean livesInDorm) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.course = course;
        this.gender = gender;
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
        for (int i = 0; i < count; i++) {
            students[i].print();
        }

        System.out.println("\nВиконуємо лінійний пошук та видалення (Студенти-чоловіки 6-го курсу з гуртожитку)...");

        int i = 0;
        while (i < count) {
            if (students[i].course == 6 && students[i].gender.equals("Ч") && students[i].livesInDorm) {
                for (int j = i; j < count - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[count - 1] = null;
                count--;
            } else {
                i++;
            }
        }

        System.out.println("\nМасив після видалення:");
        for (int k = 0; k < count; k++) {
            students[k].print();
        }
    }
}
