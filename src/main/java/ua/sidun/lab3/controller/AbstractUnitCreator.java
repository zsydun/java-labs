package ua.sidun.lab3.controller;

import ua.sidun.lab3.model.Human;
import ua.sidun.lab3.model.StructuralUnit;

/**
 * Спільна частина створювачів підрозділів: доступ до створювача людей (для призначення голів) та
 * формування назв дочірніх підрозділів.
 *
 * @param <T> тип підрозділу
 */
public abstract class AbstractUnitCreator<T extends StructuralUnit> implements UnitCreator<T> {

    private final HumanCreator humanCreator;

    protected AbstractUnitCreator(HumanCreator humanCreator) {
        this.humanCreator = humanCreator;
    }

    protected Human nextHead() {
        return humanCreator.createNext();
    }

    protected String childName(String childType, int number) {
        return childType + " " + number;
    }
}
