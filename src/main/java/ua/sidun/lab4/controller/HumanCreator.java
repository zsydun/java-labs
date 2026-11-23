package ua.sidun.lab4.controller;

import ua.sidun.lab4.model.Human;
import ua.sidun.lab4.model.Sex;

/**
 * Створювач людей. Може створити людину із заданими даними або наступну людину з вбудованого
 * переліку імен.
 */
public class HumanCreator {

    private static final String[] MALE_FIRST_NAMES = {
        "Олександр", "Андрій", "Дмитро", "Максим", "Іван", "Тарас", "Богдан", "Євгеній"
    };
    private static final String[] FEMALE_FIRST_NAMES = {
        "Олена", "Марія", "Ірина", "Анна", "Софія", "Наталія", "Юлія", "Катерина"
    };
    private static final String[] LAST_NAMES = {
        "Шевченко",
        "Коваленко",
        "Бондаренко",
        "Ткаченко",
        "Кравченко",
        "Олійник",
        "Мельник",
        "Лисенко"
    };
    private static final String[] MALE_PATRONYMICS = {
        "Петрович", "Іванович", "Сергійович", "Миколайович", "Васильович", "Олегович"
    };
    private static final String[] FEMALE_PATRONYMICS = {
        "Петрівна", "Іванівна", "Сергіївна", "Миколаївна", "Василівна", "Олегівна"
    };

    private int sequence;

    public Human create(String firstName, String lastName, String patronymic, Sex sex) {
        return new Human(firstName, lastName, patronymic, sex);
    }

    /** Створює наступну людину з переліку. Стать чергується. */
    public Human createNext() {
        int index = sequence++;
        if (index % 2 == 0) {
            return create(
                    pick(MALE_FIRST_NAMES, index),
                    pick(LAST_NAMES, index / 2),
                    pick(MALE_PATRONYMICS, index / 3),
                    Sex.MALE);
        }
        return create(
                pick(FEMALE_FIRST_NAMES, index),
                pick(LAST_NAMES, index / 2),
                pick(FEMALE_PATRONYMICS, index / 3),
                Sex.FEMALE);
    }

    private String pick(String[] values, int index) {
        return values[index % values.length];
    }
}
