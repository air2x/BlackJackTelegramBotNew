package ru.maxima.model;

import ru.maxima.model.enums.Card;
import ru.maxima.model.enums.NameOfCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {

    public static final String ANSWER_YES = "да";
    public static final String ANSWER_NO = "нет";
    public static final int BLACK_JACK = 21;

    private final List<Card> cardOnHands = new ArrayList<>();

    private Long id;
    private String name;

    public Player(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public void takeCard(Card card) {
        cardOnHands.add(card);
    }

    public int sumPointsCardOnHands() {
        int temp = 0;
        int numOfPoints = 0;
        for (Card card : cardOnHands) {
            if (NameOfCard.ACE.equals(card.getName())) {
                temp += 1;
            } else {
                numOfPoints += card.getValue();
            }
        }
        while (temp > 0) {
            if (numOfPoints < BLACK_JACK) {
                numOfPoints += 11;
            } else {
                numOfPoints += 1;
            }
            temp--;
        }
        return numOfPoints;
    }

    public String showCards() {
        StringBuilder sb = new StringBuilder();
        sb.append("-----Ваши карты ").append(name).append(" -------\n");
        cardOnHands.forEach(x -> sb.append(x.getName().getName()).append("\n"));
        return sb.toString();
    }

    public boolean isNeedCard() {
        showCards();
        System.out.println(sumPointsCardOnHands());
        Scanner scanner = new Scanner(System.in);
        String answer;
        System.out.println(name + ", нужна еще карта?");
        do {
            answer = scanner.nextLine();
            if (!ANSWER_YES.equalsIgnoreCase(answer) && !ANSWER_NO.equalsIgnoreCase(answer)) {
                System.out.println("Введите да или нет");
            }
        } while (!ANSWER_YES.equalsIgnoreCase(answer) && !ANSWER_NO.equalsIgnoreCase(answer));

        if (ANSWER_YES.equals(answer)) {
            return true;
        } else if (ANSWER_NO.equals(answer)) {
            return false;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
