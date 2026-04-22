import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab2_2 {
    public static void main(String[] args) {
        System.out.println("Розробник: Сорочан Ярослав Сергійович");
        System.out.println("Варіант 11, Лабораторна робота 2.2 (Мінімальний рівень)\n");

        String regex = "^#\\d*(%|\\*|[A-Z]+)#$";
        Pattern pattern = Pattern.compile(regex);

        System.out.println("Перевірка слів з файлу words.txt:\n");

        try (BufferedReader br = new BufferedReader(new FileReader("words.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    System.out.println("[ЗБІГ]     " + line);
                } else {
                    System.out.println("[НЕ ЗБІГ]  " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Помилка читання файлу: " + e.getMessage());
        }
    }
}
