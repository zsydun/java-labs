package ua.sidun.lab3.controller;

import ua.sidun.lab3.model.Faculty;
import ua.sidun.lab3.model.Human;

/** Створює факультет та його кафедри за допомогою {@link DepartmentCreator}. */
public class FacultyCreator extends AbstractUnitCreator<Faculty> {

    private final DepartmentCreator departmentCreator;

    public FacultyCreator(HumanCreator humanCreator, DepartmentCreator departmentCreator) {
        super(humanCreator);
        this.departmentCreator = departmentCreator;
    }

    @Override
    public Faculty create(String name, Human head, int childCount) {
        Faculty unit = new Faculty(name, head);
        for (int i = 1; i <= childCount; i++) {
            unit.addDepartment(
                    departmentCreator.create(childName("Кафедра", i), nextHead(), childCount));
        }
        return unit;
    }
}
