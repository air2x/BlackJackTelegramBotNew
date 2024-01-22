package ru.maxima.model;

import java.util.*;
import java.util.stream.Collectors;

import static ru.maxima.model.Player.BLACK_JACK;

public class Game {

    Player winner;
    private List<Player> playersInGame;
    private DeckOfCards deck;

    private Set<Long> donePlayers;

    public Game() {
        playersInGame = new ArrayList<>();
        deck = new DeckOfCards();
        donePlayers = new HashSet<>();
    }

    public void addPlayer(Player player) {
        if (player instanceof Croupier) {
            playersInGame.add(player);
        } else {
//            System.out.println("Введите имя игрока");
//            Scanner scanner = new Scanner(System.in);
//            player.setName(scanner.nextLine());
            playersInGame.add(player);
        }
    }

    public void giveTwoRandomCardsEachPlayerOnStart() {
        for (Player player : playersInGame) {
            player.takeCard(deck.getRandomCard());
            player.takeCard(deck.getRandomCard());
        }
    }

    public String oneCardIfPlayerNeed2(Long id) {
        if (donePlayers.contains(id)) {
            return "У вас перебор или вы отказались от карты. Ожидайте результатов";
        }
        Player player = playersInGame.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);
        if (player != null) {
            player.takeCard(deck.getRandomCard());
        }
        if (player.sumPointsCardOnHands() > 21) {
            donePlayers.add(id);
            return player.showCards() + "\nУ вас перебор, больше нельзя брать карты. Ожидайте результатов";
        }
        return player.showCards();
    }

    public void croupierTakeCards() {
        Player croupier = playersInGame.stream().filter(a -> a instanceof Croupier).findFirst().orElse(null);
        while (croupier.sumPointsCardOnHands() < 17) {
            croupier.takeCard(deck.getRandomCard());
        }
    }

    public void playerDontNeedCard(Long id) {
        donePlayers.add(id);
    }

    public boolean isGameEnded() {
        if (playersInGame.size() - 1 == donePlayers.size()) {
            return true;
        } else {
            return false;
        }
    }

    public List<Long> getPlayersIds() {
        return playersInGame.stream().filter(a -> a.getId() != 0).map(Player::getId).collect(Collectors.toList());
    }

    public Player getPlayer(Long id) {
        for (Player player: playersInGame) {
            if(player.getId().equals(id)) {
                return player;
            }
        }
        return null;
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

    public String determineWinner() {
        croupierTakeCards();
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
            return ("Ситуация \"ровно\"");
        } else {
            return ("Победил игрок " + winner.getName() + ", набрал " + winner.sumPointsCardOnHands() + " очков.");
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
