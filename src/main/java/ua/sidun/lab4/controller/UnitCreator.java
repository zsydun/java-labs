package ua.sidun.lab4.controller;

import ua.sidun.lab4.model.Human;
import ua.sidun.lab4.model.StructuralUnit;

/**
 * Створювач структурного підрозділу, що містить задану кількість підрозділів нижчого рівня.
 *
 * @param <T> тип підрозділу
 */
public interface UnitCreator<T extends StructuralUnit> {

    T create(String name, Human head, int childCount);
}
