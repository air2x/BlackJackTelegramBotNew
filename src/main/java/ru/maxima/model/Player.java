package ru.maxima.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {

    private List<Card> cardOnHands = new ArrayList<>();

    public void takeCard(Card card) {
        cardOnHands.add(card);
    }

    public int sumValuesOnHand() {
        int count = 0;
        for (Card card: cardOnHands) {
            count += card.getValue();
        }
        return count;
    }

    public void showCards() {
        cardOnHands.forEach(x -> System.out.println(x.getName()));
    }

    public boolean isNeedCard() {
        System.out.println("-----Âàøè êàðòû-------");
        showCards();
        System.out.println("Íóæíà ëè âàì åùå îäíà êàðòà?");
        Scanner scanner = new Scanner(System.in);
        if (!"äà".equals(scanner.nextLine()) && !"íåò".equals(scanner.nextLine())) {
            System.out.println("ß ïîíèìàþ òîëüêî äà èëè íåò, ââåäèòå ýòè çíà÷åíèÿ");
        }

        if ("äà".equals(scanner.nextLine())) {
            return true;
        } else if ("íåò".equals(scanner.nextLine())) {
            return false;
        }
        return false;
    }
}
