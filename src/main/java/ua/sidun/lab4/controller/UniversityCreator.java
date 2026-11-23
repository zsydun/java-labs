package ua.sidun.lab4.controller;

import ua.sidun.lab4.model.Human;
import ua.sidun.lab4.model.University;

/** Створює університет та його факультети за допомогою {@link FacultyCreator}. */
public class UniversityCreator extends AbstractUnitCreator<University> {

    private final FacultyCreator facultyCreator;

    public UniversityCreator(HumanCreator humanCreator, FacultyCreator facultyCreator) {
        super(humanCreator);
        this.facultyCreator = facultyCreator;
    }

    @Override
    public University create(String name, Human head, int childCount) {
        University unit = new University(name, head);
        for (int i = 1; i <= childCount; i++) {
            unit.addFaculty(
                    facultyCreator.create(childName("Факультет", i), nextHead(), childCount));
        }
        return unit;
    }
}
