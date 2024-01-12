package ru.maxima.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {

    public static final String ANSWER_YES = "да";
    public static final String ANSWER_NO = "нет";
    public static final int BLACK_JACK = 21;

    private int differenceWithBlackJack;
    private String name;

    private List<Card> cardOnHands = new ArrayList<>();

    private int numOfPoints;

    public void takeCard(Card card) {
        cardOnHands.add(card);
        sumValuesOnHand();
    }

    public int sumValuesOnHand() {
        int temp = 0;
        for (Card card : cardOnHands) {
            if (card.getName().contains("Туз")) {
                temp++;
            } else {
                numOfPoints += card.getValue();
            }
        }
        if (temp > 0) {
            if (numOfPoints < BLACK_JACK) {
                numOfPoints += 11 * temp;
            } else {
                numOfPoints += temp;
            }
        }
        return numOfPoints;
    }

    public void showCards() {
        cardOnHands.forEach(x -> System.out.println(x.getName()));
    }

    public boolean isNeedCard() {
        System.out.println("-----Ваши карты " + this.getName() + " -------");
        showCards();
        System.out.println(this.getNumOfPoints());
        Scanner scanner = new Scanner(System.in);
        String answer;
        System.out.println("Нужна еще карта?");
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

    public int getNumOfPoints() {
        return numOfPoints;
    }

    public int getDifferenceWithBlackJack() {
        return differenceWithBlackJack;
    }

    public void setDifferenceWithBlackJack(int differenceWithBlackJack) {
        this.differenceWithBlackJack = differenceWithBlackJack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
