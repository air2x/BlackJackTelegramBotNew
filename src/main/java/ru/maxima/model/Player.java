package ru.maxima.model;

import ru.maxima.model.enums.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {

    public static final String ANSWER_YES = "да";
    public static final String ANSWER_NO = "нет";
    public static final int BLACK_JACK = 21;

    private int differenceWithBlackJack;
    private String name;
    private final List<Card> cardOnHands = new ArrayList<>();
    private int numOfPoints;
    private boolean isAnswerCardNeeded = true;

    public void takeCard(Card card) {
        if (card.getName().contains("Туз") && card.getValue() < BLACK_JACK) {
            numOfPoints += 1;
        } else if (card.getName().contains("Туз") && card.getValue() > BLACK_JACK) {
            numOfPoints += 11;
        } else {
            numOfPoints += card.getValue();
        }
        cardOnHands.add(card);
    }

    public void showCards() {
        cardOnHands.forEach(x -> System.out.println(x.getName()));
    }

    public void isNeedCard() {
        System.out.println("-----Ваши карты " + this.getName() + " -------");
        showCards();
        System.out.println(this.getNumOfPoints());
        Scanner scanner = new Scanner(System.in);
        String answer;
        System.out.println(getName() + ", нужна еще карта?");
        do {
            answer = scanner.nextLine();
            if (!ANSWER_YES.equalsIgnoreCase(answer) && !ANSWER_NO.equalsIgnoreCase(answer)) {
                System.out.println("Введите да или нет");
            }
        } while (!ANSWER_YES.equalsIgnoreCase(answer) && !ANSWER_NO.equalsIgnoreCase(answer));

        if (ANSWER_YES.equals(answer)) {
            isAnswerCardNeeded = true;
        } else if (ANSWER_NO.equals(answer)) {
            isAnswerCardNeeded = false;
        }
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

    public boolean isAnswerCardNeeded() {
        return isAnswerCardNeeded;
    }
}
