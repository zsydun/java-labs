package ua.sidun.lab4.controller;

import ua.sidun.lab4.model.Group;
import ua.sidun.lab4.model.Human;

/** Створює групу та наповнює її студентами за допомогою {@link StudentCreator}. */
public class GroupCreator extends AbstractUnitCreator<Group> {

    private final StudentCreator studentCreator;

    public GroupCreator(HumanCreator humanCreator, StudentCreator studentCreator) {
        super(humanCreator);
        this.studentCreator = studentCreator;
    }

    @Override
    public Group create(String name, Human head, int studentCount) {
        Group group = new Group(name, head);
        for (int i = 0; i < studentCount; i++) {
            group.addStudent(studentCreator.createNext());
        }
        return group;
    }
}
