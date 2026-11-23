package ua.sidun.lab3.model;

import java.util.Objects;

/** Абстрактний структурний підрозділ університету: має назву та голову. */
public abstract class StructuralUnit {

    private String name;
    private Human head;

    protected StructuralUnit() {}

    protected StructuralUnit(String name, Human head) {
        this.name = name;
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Human getHead() {
        return head;
    }

    public void setHead(Human head) {
        this.head = head;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StructuralUnit that = (StructuralUnit) o;
        return Objects.equals(name, that.name) && Objects.equals(head, that.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, head);
    }
}
