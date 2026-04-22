ЗВІТ ДО ЛАБОРАТОРНОЇ РОБОТИ №2.2
Тема: Дослідження алгоритмів ідентифікації

МЕТА РОБОТИ: Вивчення та практичне застосування регулярних виразів для ідентифікації та перевірки синтаксичної будови слів.

ВАРІАНТ №11
Завдання: Скласти регулярний вираз для розпізнавання слова з такою синтаксичною будовою:
- Слово обов’язково починається символом «#».
- Потім може йти послідовність із символів «0-9».
- А далі обов’язково слідують символи або «%», або «*», або послідовність із символів «A-Z».
- Закінчується слово обов’язковим символом «#».

Регулярний вираз: ^#\d*(%|\*|[A-Z]+)#$

КОД ПРОГРАМИ (Lab2_2.java)

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab2_2 {
    public static void main(String[] args) {
        System.out.println("Розробник: Сорочан Ярослав Сергійович");
        System.out.println("Варіант 11, Лабораторна робота 2.2\n");

        String regex = "^#\\d*(%|\\*|[A-Z]+)#$";
        Pattern pattern = Pattern.compile(regex);

        System.out.println("Перевірка слів з файлу words.txt:\n");

        try (BufferedReader br = new BufferedReader(new FileReader("words.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) System.out.println("[ЗБІГ]     " + line);
                else System.out.println("[НЕ ЗБІГ]  " + line);
            }
        } catch (IOException e) {
            System.err.println("Помилка читання файлу: " + e.getMessage());
        }
    }
}

РЕЗУЛЬТАТИ ВИКОНАННЯ

Розробник: Сорочан Ярослав Сергійович
Варіант 11, Лабораторна робота 2.2

Перевірка слів з файлу words.txt:

[ЗБІГ]     #123%#
[ЗБІГ]     #*#
[ЗБІГ]     #999ABCD#
[ЗБІГ]     #ABC#
[НЕ ЗБІГ]  %123#
[НЕ ЗБІГ]  #123#
[НЕ ЗБІГ]  ##
[НЕ ЗБІГ]  #abC#
[ЗБІГ]     #555*#

ВИСНОВОК
В ході лабораторної роботи було створено регулярний вираз згідно з вимогами варіанту №11. Програма успішно зчитує тестові слова з файлу та класифікує їх на основі відповідності заданому шаблону синтаксису.
