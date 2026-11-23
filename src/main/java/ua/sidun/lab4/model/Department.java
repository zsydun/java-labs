package ua.sidun.lab4.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Кафедра, що складається з груп. */
public class Department extends StructuralUnit {

    private List<Group> groups = new ArrayList<>();

    public Department() {}

    public Department(String name, Human head) {
        super(name, head);
    }

    public Department(String name, Human head, List<Group> groups) {
        super(name, head);
        this.groups = new ArrayList<>(groups);
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        Department that = (Department) o;
        return Objects.equals(groups, that.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), groups);
    }

    @Override
    public String toString() {
        return "Department{name='"
                + getName()
                + "', head="
                + getHead()
                + ", groups="
                + groups
                + "}";
    }
}
