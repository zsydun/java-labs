package ua.sidun.lab4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import ua.sidun.lab4.controller.DepartmentCreator;
import ua.sidun.lab4.controller.FacultyCreator;
import ua.sidun.lab4.controller.GroupCreator;
import ua.sidun.lab4.controller.HumanCreator;
import ua.sidun.lab4.controller.JsonManager;
import ua.sidun.lab4.controller.StudentCreator;
import ua.sidun.lab4.controller.UniversityCreator;
import ua.sidun.lab4.model.Sex;
import ua.sidun.lab4.model.University;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Перевіряє, що університет після запису у файл JSON і зчитування з нього залишається еквівалентним
 * початковому.
 */
class UniversityJsonTest {

    private static final int UNITS_PER_LEVEL = 2;

    @TempDir Path tempDir;

    @Test
    void universityRestoredFromJsonFileEqualsOriginal() throws IOException {
        HumanCreator humanCreator = new HumanCreator();
        StudentCreator studentCreator = new StudentCreator(humanCreator);
        GroupCreator groupCreator = new GroupCreator(humanCreator, studentCreator);
        DepartmentCreator departmentCreator = new DepartmentCreator(humanCreator, groupCreator);
        FacultyCreator facultyCreator = new FacultyCreator(humanCreator, departmentCreator);
        UniversityCreator universityCreator = new UniversityCreator(humanCreator, facultyCreator);

        University oldUniversity =
                universityCreator.create(
                        "Тестовий університет",
                        humanCreator.create("Петро", "Іваненко", "Олегович", Sex.MALE),
                        UNITS_PER_LEVEL);

        Path file = tempDir.resolve("university.json");
        JsonManager jsonManager = new JsonManager();
        jsonManager.writeToFile(oldUniversity, file);
        University newUniversity = jsonManager.readFromFile(file);

        assertNotSame(oldUniversity, newUniversity);
        assertEquals(UNITS_PER_LEVEL, newUniversity.getFaculties().size());
        assertEquals(UNITS_PER_LEVEL, newUniversity.getFaculties().get(0).getDepartments().size());
        assertEquals(
                UNITS_PER_LEVEL,
                newUniversity.getFaculties().get(0).getDepartments().get(0).getGroups().size());
        assertEquals(
                UNITS_PER_LEVEL,
                newUniversity
                        .getFaculties()
                        .get(0)
                        .getDepartments()
                        .get(0)
                        .getGroups()
                        .get(0)
                        .getStudents()
                        .size());
        assertTrue(oldUniversity.equals(newUniversity));
    }
}
