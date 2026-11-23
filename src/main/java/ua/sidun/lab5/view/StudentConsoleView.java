package ua.sidun.lab5.view;

import ua.sidun.lab5.model.Student;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/** Консольний інтерфейс: запит місяця та виведення списку студентів. */
public class StudentConsoleView {

    public static final int EXIT_CODE = 0;

    private static final Locale UKRAINIAN = Locale.forLanguageTag("uk");
    private static final String ROW_FORMAT = "%-4s %-14s %-12s %-14s %-12s %-8s%n";

    private final Scanner scanner = new Scanner(System.in);

    /** Повертає номер місяця від 1 до 12 або {@link #EXIT_CODE} для виходу. */
    public int askMonthNumber() {
        while (true) {
            System.out.print("Введіть номер місяця (1-12) або " + EXIT_CODE + " для виходу: ");
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                if (value >= EXIT_CODE && value <= Month.DECEMBER.getValue()) {
                    return value;
                }
            } else {
                scanner.next();
            }
            System.out.println("Некоректне значення.");
        }
    }

    public void showStudents(Month month, List<Student> students) {
        String monthName = month.getDisplayName(TextStyle.FULL_STANDALONE, UKRAINIAN);
        if (students.isEmpty()) {
            System.out.println("У місяці «" + monthName + "» немає студентів з днем народження.");
            return;
        }
        System.out.println("Студенти, що народилися у місяці «" + monthName + "»:");
        System.out.printf(
                ROW_FORMAT, "ID", "Прізвище", "Ім'я", "По батькові", "Народження", "Залікова");
        for (Student student : students) {
            System.out.printf(
                    ROW_FORMAT,
                    student.getId(),
                    student.getLastName(),
                    student.getFirstName(),
                    student.getPatronymic(),
                    student.getBirthDate(),
                    student.getRecordBookNumber());
        }
    }

    public void showError(String message) {
        System.out.println("Помилка роботи з базою даних: " + message);
    }
}
