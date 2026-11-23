package ua.sidun.lab3;

import ua.sidun.lab3.controller.DepartmentCreator;
import ua.sidun.lab3.controller.FacultyCreator;
import ua.sidun.lab3.controller.GroupCreator;
import ua.sidun.lab3.controller.HumanCreator;
import ua.sidun.lab3.controller.StudentCreator;
import ua.sidun.lab3.model.Department;
import ua.sidun.lab3.model.Faculty;
import ua.sidun.lab3.model.Group;
import ua.sidun.lab3.model.Sex;
import ua.sidun.lab3.model.Student;
import ua.sidun.lab3.model.University;

/**
 * Лабораторна робота 3. ООП. Точка входу: створює типовий університет і виводить його структуру.
 */
public class Run {

    private static final int STUDENTS_PER_GROUP = 4;
    private static final int CHILDREN_PER_GENERATED_UNIT = 2;

    private final HumanCreator humanCreator = new HumanCreator();
    private final StudentCreator studentCreator = new StudentCreator(humanCreator);
    private final GroupCreator groupCreator = new GroupCreator(humanCreator, studentCreator);
    private final DepartmentCreator departmentCreator =
            new DepartmentCreator(humanCreator, groupCreator);
    private final FacultyCreator facultyCreator =
            new FacultyCreator(humanCreator, departmentCreator);

    public static void main(String[] args) {
        Run run = new Run();
        University university = run.createTypycalUniversity();
        printUniversity(university);
    }

    /**
     * Створює типовий університет: частина підрозділів задається вручну, частина генерується
     * створювачами нижчого рівня.
     */
    public University createTypycalUniversity() {
        University university =
                new University(
                        "НТУ «Дніпровська політехніка»",
                        humanCreator.create("Василь", "Гончар", "Андрійович", Sex.MALE));

        Department systemAnalysis =
                new Department(
                        "Кафедра системного аналізу та управління",
                        humanCreator.create("Ольга", "Марченко", "Вікторівна", Sex.FEMALE));
        systemAnalysis.addGroup(
                groupCreator.create("124-23-1", humanCreator.createNext(), STUDENTS_PER_GROUP));
        systemAnalysis.addGroup(
                groupCreator.create("124-23-2", humanCreator.createNext(), STUDENTS_PER_GROUP));

        Faculty informationTechnologies =
                new Faculty(
                        "Факультет інформаційних технологій",
                        humanCreator.create("Сергій", "Руденко", "Павлович", Sex.MALE));
        informationTechnologies.addDepartment(systemAnalysis);
        informationTechnologies.addDepartment(
                departmentCreator.create(
                        "Кафедра програмного забезпечення",
                        humanCreator.createNext(),
                        CHILDREN_PER_GENERATED_UNIT));

        university.addFaculty(informationTechnologies);
        university.addFaculty(
                facultyCreator.create(
                        "Гірничий факультет",
                        humanCreator.createNext(),
                        CHILDREN_PER_GENERATED_UNIT));
        return university;
    }

    private static void printUniversity(University university) {
        System.out.println(university.getName() + " | ректор: " + university.getHead());
        for (Faculty faculty : university.getFaculties()) {
            System.out.println("  " + faculty.getName() + " | декан: " + faculty.getHead());
            for (Department department : faculty.getDepartments()) {
                System.out.println(
                        "    " + department.getName() + " | завідувач: " + department.getHead());
                for (Group group : department.getGroups()) {
                    System.out.println(
                            "      " + group.getName() + " | куратор: " + group.getHead());
                    for (Student student : group.getStudents()) {
                        System.out.println("        " + student);
                    }
                }
            }
        }
    }
}
