package ru.maxima.model.enums;

public enum NameOfCard {
    TWO("Двойка", 2), THREE("Тройка", 3), FOUR("Четверка", 4), FIVE("Пятерка", 5), SIX("Шестерка", 6),
    SEVEN("Семерка", 7), EIGHT("Восьмерка", 8), NINE("Девятка", 9), TEN("Десятка", 10), JACK("Валет", 10),
    QUEEN("Дама", 10), KING("Король", 10), ACE("Туз", 1);

    private final String name;
    private int value;

    NameOfCard(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
