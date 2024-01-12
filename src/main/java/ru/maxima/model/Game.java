package ru.maxima.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ru.maxima.model.Player.BLACK_JACK;

public class Game {

    Player winner;
    private List<Player> playersInGame = new ArrayList<>();
    private DeckOfCards deck = new DeckOfCards();

    public void addPlayer(Player player) {
        if ("croupier".equals(player.getName())) {
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
        for (Player player : playersInGame) {
            while (player.isNeedCard()) {
                player.takeCard(deck.getRandomCard());
            }
        }
    }

    public void determineWinner() {
        int temp = 0;
        int minDifferenceWithBlackJack = Integer.MAX_VALUE;
        showCardsAllPlayers();
        for (Player player : playersInGame) {
            player.setDifferenceWithBlackJack(Math.abs(BLACK_JACK - player.getNumOfPoints()));
        }
        for (Player player : playersInGame) {
            if (player.getDifferenceWithBlackJack() < minDifferenceWithBlackJack) {
                minDifferenceWithBlackJack = player.getDifferenceWithBlackJack();
                winner = player;
            } else if (minDifferenceWithBlackJack == player.getDifferenceWithBlackJack()) {
                temp++;
            }
        }

        if (temp > 0) {
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
