package ru.maxima.model;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
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
        do {
            for (Player player : playersInGame) {
                if (player instanceof Croupier) {
                    if (player.getNumOfPoints() < 17) {
                        player.takeCard(deck.getRandomCard());
                    } else {
                        tempCountPlayers--;
                    }
                } else if (player.isAnswerCardNeeded()) {
                    player.isNeedCard();
                    if (!player.isAnswerCardNeeded()) {
                        tempCountPlayers--;
                    } else {
                        player.takeCard(deck.getRandomCard());
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
            player.setDifferenceWithBlackJack(BLACK_JACK - player.getNumOfPoints());
        }
        for (Player player : playersInGame) {
            if (player.getDifferenceWithBlackJack() >= 0 &&
                    player.getDifferenceWithBlackJack() < minDifferenceWithBlackJack) {
                minDifferenceWithBlackJack = player.getDifferenceWithBlackJack();
                winner = player;
            }
            if (player instanceof Croupier) {
                croupier = player;
            }
        }
        if (!(winner instanceof Croupier) && winner.getNumOfPoints() == croupier.getNumOfPoints()) {
            System.out.println("Ситуация \"ровно\"");
        } else {
            System.out.println("Победил игрок " + winner.getName() + ", набрал " + winner.getNumOfPoints() + " очков.");
        }
    }

    public void showCardsAllPlayers() {
        for (Player player : playersInGame) {
            player.showCards();
            System.out.println("Сумма очков " + player.getName() + " = " + player.getNumOfPoints());
            System.out.println("--------------------");
        }
    }
}
