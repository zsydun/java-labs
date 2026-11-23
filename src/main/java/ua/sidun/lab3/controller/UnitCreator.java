package ua.sidun.lab3.controller;

import ua.sidun.lab3.model.Human;
import ua.sidun.lab3.model.StructuralUnit;

/**
 * Створювач структурного підрозділу, що містить задану кількість підрозділів нижчого рівня.
 *
 * @param <T> тип підрозділу
 */
public interface UnitCreator<T extends StructuralUnit> {

    T create(String name, Human head, int childCount);
}
