package ua.sidun.lab5.dao;

import ua.sidun.lab5.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * Реалізація {@link StudentDao} через JDBC. Відбір за місяцем народження виконує сервер баз даних:
 * місяць передається параметром SQL-запиту.
 */
public class JdbcStudentDao implements StudentDao {

    private static final String FIND_BY_BIRTH_MONTH_SQL =
            "SELECT id, last_name, first_name, patronymic, birth_date, record_book_number "
                    + "FROM students "
                    + "WHERE EXTRACT(MONTH FROM birth_date) = ? "
                    + "ORDER BY EXTRACT(DAY FROM birth_date), last_name";

    private final ConnectionFactory connectionFactory;

    public JdbcStudentDao(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public List<Student> findByBirthMonth(Month month) throws SQLException {
        List<Student> students = new ArrayList<>();
        try (Connection connection = connectionFactory.getConnection();
                PreparedStatement statement =
                        connection.prepareStatement(FIND_BY_BIRTH_MONTH_SQL)) {
            statement.setInt(1, month.getValue());
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    students.add(mapStudent(resultSet));
                }
            }
        }
        return students;
    }

    private Student mapStudent(ResultSet resultSet) throws SQLException {
        return new Student(
                resultSet.getInt("id"),
                resultSet.getString("last_name"),
                resultSet.getString("first_name"),
                resultSet.getString("patronymic"),
                resultSet.getDate("birth_date").toLocalDate(),
                resultSet.getString("record_book_number"));
    }
}
