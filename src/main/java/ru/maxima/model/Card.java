package ru.maxima.model;

public enum Card {
    TWO_DIAMONDS("Двойка бубны"), THREE_DIAMONDS("Тройка бубны"), FOUR_DIAMONDS("Четверка бубны"),
    FIVE_DIAMONDS("Пятерка бубны"), SIX_DIAMONDS("Шестерка бубны"), SEVEN_DIAMONDS("Семерка бубны"),
    EIGHT_DIAMONDS("Восьмерка бубны"), NINE_DIAMONDS("Девятка бубны"), TEN_DIAMONDS("Десятка бубны"),
    JACK_DIAMONDS("Валет бубны"), QUEEN_DIAMONDS("Дама бубны"), KING_DIAMONDS("Король бубны"),
    ACE_DIAMONDS("Туз бубны"),
    TWO_HEARTS("Двойка черви"), THREE_HEARTS("Тройка черви"), FOUR_HEARTS("Четверка черви"),
    FIVE_HEARTS("Пятерка черви"), SIX_HEARTS("Шестерка черви"), SEVEN_HEARTS("Семерка черви"),
    EIGHT_HEARTS("Восьмерка черви"), NINE_HEARTS("Девятка черви"), TEN_HEARTS("Десятка черви"),
    JACK_HEARTS("Валет черви"), QUEEN_HEARTS("Дама черви"), KING_HEARTS("Король черви"),
    ACE_HEARTS("Туз черви"),
    TWO_CLUBS("Двойка трефы"), THREE_CLUBS("Тройка трефы"), FOUR_CLUBS("Четверка трефы"),
    FIVE_CLUBS("Пятерка трефы"), SIX_CLUBS("Шестерка трефы"), SEVEN_CLUBS("Семерка трефы"),
    EIGHT_CLUBS("Восьмерка трефы"), NINE_CLUBS("Девятка трефы"), TEN_CLUBS("Десятка трефы"),
    JACK_CLUBS("Валет трефы"), QUEEN_CLUBS("Дама трефы"), KING_CLUBS("Король трефы"),
    ACE_CLUBS("Туз трефы"),
    TWO_SPADES("Двойка пики"), THREE_SPADES("Тройка пики"), FOUR_SPADES("Четверка пики"),
    FIVE_SPADES("Пятерка пики"), SIX_SPADES("Шестерка пики"), SEVEN_SPADES("Семерка пики"),
    EIGHT_SPADES("Восьмерка пики"), NINE_SPADES("Девятка пики"), TEN_SPADES("Десятка пики"),
    JACK_SPADES("Валет пики"), QUEEN_SPADES("Дама пики"), KING_SPADES("Король пики"),
    ACE_SPADES("Туз пики");
    private final String name;

    Card(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
