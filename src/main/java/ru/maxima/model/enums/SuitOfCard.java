package ru.maxima.model.enums;

public enum SuitOfCard {
    DIAMONDS("Бубны"), HEARTS("Черви"), CLUBS("Трефы"), SPADES("Пики"),;

    private final String suit;

    SuitOfCard(String suit) {
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }
}
