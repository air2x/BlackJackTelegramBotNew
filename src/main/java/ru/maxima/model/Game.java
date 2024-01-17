package ru.maxima.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static ru.maxima.model.Player.BLACK_JACK;

public class Game {

    Player winner;
    private final List<Player> playersInGame = new ArrayList<>();
    private final DeckOfCards deck = new DeckOfCards();

    public void addPlayer(Player player) {
        if (player instanceof Croupier) {
            playersInGame.add(player);
        } else {
            System.out.println("Введите имя игрока");
            Scanner scanner = new Scanner(System.in);
            player.setName(scanner.nextLine());
            playersInGame.add(player);
        }
    }

    public void giveTwoRandomCardsEachPlayerOnStart() {
        for (Player player : playersInGame) {
            player.takeCard(deck.getRandomCard());
            player.takeCard(deck.getRandomCard());
        }
    }

    public void oneCardIfPlayerNeed() {
        int tempCountPlayers = playersInGame.size();
        List<Integer> isAnswers = new ArrayList<>();
        for (int i = 0; i < playersInGame.size(); i++) {
            isAnswers.add(1);
        }
        do {
            for (int i = 0; i < playersInGame.size(); i++) {
                if (isAnswers.get(i) == 0) {
                    continue;
                }
                if (playersInGame.get(i) instanceof Croupier) {
                    if (playersInGame.get(i).sumPointsCardOnHands() < 17) {
                        playersInGame.get(i).takeCard(deck.getRandomCard());
                    } else {
                        tempCountPlayers--;
                        isAnswers.set(i, 0);
                    }
                } else {
                    if (!playersInGame.get(i).isNeedCard()) {
                        tempCountPlayers--;
                        isAnswers.set(i, 0);
                    } else {
                        playersInGame.get(i).takeCard(deck.getRandomCard());
                    }
                }
            }
        } while (tempCountPlayers > 0);
    }

    public void determineWinner() {
        int minDifferenceWithBlackJack = Integer.MAX_VALUE;
        Player croupier = null;
        showCardsAllPlayers();
        for (Player player : playersInGame) {
            int differenceWithBlackJack = BLACK_JACK - player.sumPointsCardOnHands();
            if (differenceWithBlackJack >= 0 && differenceWithBlackJack < minDifferenceWithBlackJack) {
                minDifferenceWithBlackJack = differenceWithBlackJack;
                winner = player;
            }
            if (player instanceof Croupier) {
                croupier = player;
            }
        }
        if (!(winner instanceof Croupier) && winner.sumPointsCardOnHands()
                == Objects.requireNonNull(croupier).sumPointsCardOnHands()) {
            System.out.println("Ситуация \"ровно\"");
        } else {
            System.out.println("Победил игрок " + winner.getName() + ", набрал " + winner.sumPointsCardOnHands() + " очков.");
        }
    }

    public void showCardsAllPlayers() {
        for (Player player : playersInGame) {
            player.showCards();
            System.out.println("Сумма очков " + player.getName() + " = " + player.sumPointsCardOnHands());
            System.out.println("--------------------");
        }
    }
}
