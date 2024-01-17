package ru.maxima.model.enums;

public class Card {

    private NameOfCard name;
    private SuitOfCard suit;

    public Card(NameOfCard name, SuitOfCard suit) {
        this.name = name;
        this.suit = suit;

    }

    public String getName() {
        return name.getName();
    }

    public NameOfCard getNameOfCard() {
        return name;
    }

    public int getValue() {
        return name.getValue();
    }

}
