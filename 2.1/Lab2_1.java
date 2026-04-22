public class Lab2_1 {
    public static double f(double x) {
        return (8 * Math.sin(x)) / (x * x + 1);
    }

    public static void main(String[] args) {
        System.out.println("Розробник: Сорочан Ярослав Сергійович");
        System.out.println("Варіант 11, Лабораторна робота 2.1 (Мінімальний рівень)\n");

        double a = 0.0;
        double b = 1.0;
        double h = 0.1;
        int n = (int) Math.round((b - a) / h);

        // Метод прямокутників
        double sumRect = 0.0;
        for (int i = 0; i < n; i++) {
            sumRect += f(a + i * h);
        }
        double resRect = h * sumRect;

        // Метод трапецій
        double sumTrap = (f(a) + f(b)) / 2.0;
        for (int i = 1; i < n; i++) {
            sumTrap += f(a + i * h);
        }
        double resTrap = h * sumTrap;

        // Метод Сімпсона
        double sumSimp = f(a) + f(b);
        double sumOdd = 0.0;
        double sumEven = 0.0;
        for (int i = 1; i < n; i++) {
            if (i % 2 == 1) {
                sumOdd += f(a + i * h);
            } else {
                sumEven += f(a + i * h);
            }
        }
        double resSimp = (h / 3.0) * (sumSimp + 4 * sumOdd + 2 * sumEven);

        System.out.println("Обчислення інтеграла на інтервалі [0; 1] з кроком h=0.1\n");
        System.out.printf("Метод прямокутників: %.5f%n", resRect);
        System.out.printf("Метод трапецій:      %.5f%n", resTrap);
        System.out.printf("Метод Сімпсона:      %.5f%n", resSimp);
    }
}
