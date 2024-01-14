package ru.maxima.model;

import ru.maxima.model.enums.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeckOfCards {

    int sizeCards;

    private List<NameOfCard> names = List.of(NameOfCard.TWO, NameOfCard.THREE, NameOfCard.FOUR, NameOfCard.FIVE,
            NameOfCard.SIX, NameOfCard.SEVEN, NameOfCard.EIGHT, NameOfCard.NINE, NameOfCard.TEN, NameOfCard.JACK,
            NameOfCard.QUEEN, NameOfCard.KING, NameOfCard.ACE);
    private List<SuitOfCard> suits = List.of(SuitOfCard.CLUBS, SuitOfCard.DIAMONDS, SuitOfCard.HEARTS, SuitOfCard.SPADES);
    private List<Card> cards = new ArrayList<>();

    public DeckOfCards() {
        createDeck();
        sizeCards = cards.size();
    }

    private void createDeck() {
        for (int i = 0; i < suits.size(); i++) {
            for (int j = 0; j < names.size(); j++) {
                cards.add(new Card(names.get(j).getName(), suits.get(i).getSuit(), names.get(j).getValue()));
            }
        }
    }

    public Card getRandomCard() {
        Random random = new Random();
        return cards.get(random.nextInt(sizeCards));
    }

}
