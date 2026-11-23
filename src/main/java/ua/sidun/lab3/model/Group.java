package ua.sidun.lab3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Академічна група, що складається зі студентів. */
public class Group extends StructuralUnit {

    private List<Student> students = new ArrayList<>();

    public Group() {}

    public Group(String name, Human head) {
        super(name, head);
    }

    public Group(String name, Human head, List<Student> students) {
        super(name, head);
        this.students = new ArrayList<>(students);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        Group that = (Group) o;
        return Objects.equals(students, that.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), students);
    }

    @Override
    public String toString() {
        return "Group{name='" + getName() + "', head=" + getHead() + ", students=" + students + "}";
    }
}
