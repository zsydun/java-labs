package ua.sidun.lab3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Факультет, що складається з кафедр. */
public class Faculty extends StructuralUnit {

    private List<Department> departments = new ArrayList<>();

    public Faculty() {}

    public Faculty(String name, Human head) {
        super(name, head);
    }

    public Faculty(String name, Human head, List<Department> departments) {
        super(name, head);
        this.departments = new ArrayList<>(departments);
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        Faculty that = (Faculty) o;
        return Objects.equals(departments, that.departments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), departments);
    }

    @Override
    public String toString() {
        return "Faculty{name='"
                + getName()
                + "', head="
                + getHead()
                + ", departments="
                + departments
                + "}";
    }
}
