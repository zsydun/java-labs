package ua.sidun.lab3.controller;

import ua.sidun.lab3.model.Department;
import ua.sidun.lab3.model.Human;

/** Створює кафедру та її групи за допомогою {@link GroupCreator}. */
public class DepartmentCreator extends AbstractUnitCreator<Department> {

    private final GroupCreator groupCreator;

    public DepartmentCreator(HumanCreator humanCreator, GroupCreator groupCreator) {
        super(humanCreator);
        this.groupCreator = groupCreator;
    }

    @Override
    public Department create(String name, Human head, int childCount) {
        Department unit = new Department(name, head);
        for (int i = 1; i <= childCount; i++) {
            unit.addGroup(groupCreator.create(childName("Група", i), nextHead(), childCount));
        }
        return unit;
    }
}
