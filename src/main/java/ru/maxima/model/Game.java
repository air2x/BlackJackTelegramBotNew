package ru.maxima.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> playersInGame = new ArrayList<>();
    private DeckOfCards deck = new DeckOfCards();

    public void addPlayer(Player player) {
        playersInGame.add(player);
    }

    public void giveTwoRandomCardsEachPlayerOnStart() {
        for (Player player : playersInGame) {
            player.takeCard(deck.getRandomCard());
            player.takeCard(deck.getRandomCard());
        }
    }

    public void oneCardIfPlayerNeed() {
        for (Player player : playersInGame) {
            while (player.isNeedCard()) {
                player.takeCard(deck.getRandomCard());
            }
        }
    }


    public void determineWinner() {

    }
}
