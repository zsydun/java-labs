package ua.sidun.lab4.controller;

import ua.sidun.lab4.model.Human;
import ua.sidun.lab4.model.Sex;
import ua.sidun.lab4.model.Student;

/**
 * Створювач студентів. Використовує {@link HumanCreator} для отримання особистих даних і додає
 * номер залікової книжки.
 */
public class StudentCreator {

    private static final int FIRST_RECORD_BOOK_NUMBER = 230001;

    private final HumanCreator humanCreator;
    private int nextRecordBookNumber = FIRST_RECORD_BOOK_NUMBER;

    public StudentCreator(HumanCreator humanCreator) {
        this.humanCreator = humanCreator;
    }

    public Student create(
            String firstName,
            String lastName,
            String patronymic,
            Sex sex,
            String recordBookNumber) {
        return new Student(firstName, lastName, patronymic, sex, recordBookNumber);
    }

    public Student createNext() {
        Human human = humanCreator.createNext();
        return create(
                human.getFirstName(),
                human.getLastName(),
                human.getPatronymic(),
                human.getSex(),
                String.valueOf(nextRecordBookNumber++));
    }
}
