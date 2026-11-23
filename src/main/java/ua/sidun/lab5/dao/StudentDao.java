package ua.sidun.lab5.dao;

import ua.sidun.lab5.model.Student;

import java.sql.SQLException;
import java.time.Month;
import java.util.List;

/** Доступ до даних про студентів. */
public interface StudentDao {

    List<Student> findByBirthMonth(Month month) throws SQLException;
}
