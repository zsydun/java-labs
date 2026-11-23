package ua.sidun.lab4.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Університет, що складається з факультетів. */
public class University extends StructuralUnit {

    private List<Faculty> faculties = new ArrayList<>();

    public University() {}

    public University(String name, Human head) {
        super(name, head);
    }

    public University(String name, Human head, List<Faculty> faculties) {
        super(name, head);
        this.faculties = new ArrayList<>(faculties);
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        University that = (University) o;
        return Objects.equals(faculties, that.faculties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), faculties);
    }

    @Override
    public String toString() {
        return "University{name='"
                + getName()
                + "', head="
                + getHead()
                + ", faculties="
                + faculties
                + "}";
    }
}
