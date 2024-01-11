package ru.maxima.model;

public enum Card {
    TWO_DIAMONDS("Двойка бубны", 2), THREE_DIAMONDS("Тройка бубны", 3), FOUR_DIAMONDS("Четверка бубны", 4),
    FIVE_DIAMONDS("Пятерка бубны", 5), SIX_DIAMONDS("Шестерка бубны", 6), SEVEN_DIAMONDS("Семерка бубны", 7),
    EIGHT_DIAMONDS("Восьмерка бубны", 8), NINE_DIAMONDS("Девятка бубны", 9), TEN_DIAMONDS("Десятка бубны", 10),
    JACK_DIAMONDS("Валет бубны", 10), QUEEN_DIAMONDS("Дама бубны", 10), KING_DIAMONDS("Король бубны", 10),
    ACE_DIAMONDS("Туз бубны", 1),
    TWO_HEARTS("Двойка черви", 2), THREE_HEARTS("Тройка черви", 3), FOUR_HEARTS("Четверка черви", 4),
    FIVE_HEARTS("Пятерка черви", 5), SIX_HEARTS("Шестерка черви", 6), SEVEN_HEARTS("Семерка черви", 7),
    EIGHT_HEARTS("Восьмерка черви", 8), NINE_HEARTS("Девятка черви", 9), TEN_HEARTS("Десятка черви", 10),
    JACK_HEARTS("Валет черви", 10), QUEEN_HEARTS("Дама черви", 10), KING_HEARTS("Король черви", 10),
    ACE_HEARTS("Туз черви", 1),
    TWO_CLUBS("Двойка трефы", 2), THREE_CLUBS("Тройка трефы", 3), FOUR_CLUBS("Четверка трефы", 4),
    FIVE_CLUBS("Пятерка трефы", 5), SIX_CLUBS("Шестерка трефы", 6), SEVEN_CLUBS("Семерка трефы", 7),
    EIGHT_CLUBS("Восьмерка трефы", 8), NINE_CLUBS("Девятка трефы", 9), TEN_CLUBS("Десятка трефы", 10),
    JACK_CLUBS("Валет трефы", 10), QUEEN_CLUBS("Дама трефы", 10), KING_CLUBS("Король трефы", 10),
    ACE_CLUBS("Туз трефы", 1),
    TWO_SPADES("Двойка пики", 2), THREE_SPADES("Тройка пики", 3), FOUR_SPADES("Четверка пики", 4),
    FIVE_SPADES("Пятерка пики", 5), SIX_SPADES("Шестерка пики", 6), SEVEN_SPADES("Семерка пики", 7),
    EIGHT_SPADES("Восьмерка пики", 8), NINE_SPADES("Девятка пики", 9), TEN_SPADES("Десятка пики", 10),
    JACK_SPADES("Валет пики", 10), QUEEN_SPADES("Дама пики", 10), KING_SPADES("Король пики", 10),
    ACE_SPADES("Туз пики", 1);
    private final String name;
    private int value;


    Card(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
