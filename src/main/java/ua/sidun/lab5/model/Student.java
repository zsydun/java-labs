package ua.sidun.lab5.model;

import java.time.LocalDate;
import java.util.Objects;

/** Студент, як він зберігається в таблиці students. */
public class Student {

    private final int id;
    private final String lastName;
    private final String firstName;
    private final String patronymic;
    private final LocalDate birthDate;
    private final String recordBookNumber;

    public Student(
            int id,
            String lastName,
            String firstName,
            String patronymic,
            LocalDate birthDate,
            String recordBookNumber) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.recordBookNumber = recordBookNumber;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getRecordBookNumber() {
        return recordBookNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return id == student.id
                && Objects.equals(lastName, student.lastName)
                && Objects.equals(firstName, student.firstName)
                && Objects.equals(patronymic, student.patronymic)
                && Objects.equals(birthDate, student.birthDate)
                && Objects.equals(recordBookNumber, student.recordBookNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, patronymic, birthDate, recordBookNumber);
    }

    @Override
    public String toString() {
        return lastName
                + " "
                + firstName
                + " "
                + patronymic
                + ", "
                + birthDate
                + ", № "
                + recordBookNumber;
    }
}
