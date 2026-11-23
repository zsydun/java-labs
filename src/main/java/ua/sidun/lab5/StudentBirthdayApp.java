package ua.sidun.lab5;

import ua.sidun.lab5.dao.ConnectionFactory;
import ua.sidun.lab5.dao.JdbcStudentDao;
import ua.sidun.lab5.dao.StudentDao;
import ua.sidun.lab5.view.StudentConsoleView;

import java.sql.SQLException;
import java.time.Month;

/**
 * Лабораторна робота 5. JDBC. Виводить студентів, які народилися у вибраному користувачем місяці.
 */
public class StudentBirthdayApp {

    private final StudentDao studentDao;
    private final StudentConsoleView view;

    public StudentBirthdayApp(StudentDao studentDao, StudentConsoleView view) {
        this.studentDao = studentDao;
        this.view = view;
    }

    public static void main(String[] args) {
        StudentDao studentDao = new JdbcStudentDao(new ConnectionFactory());
        new StudentBirthdayApp(studentDao, new StudentConsoleView()).run();
    }

    public void run() {
        int monthNumber = view.askMonthNumber();
        while (monthNumber != StudentConsoleView.EXIT_CODE) {
            Month month = Month.of(monthNumber);
            try {
                view.showStudents(month, studentDao.findByBirthMonth(month));
            } catch (SQLException e) {
                view.showError(e.getMessage());
            }
            monthNumber = view.askMonthNumber();
        }
    }
}
