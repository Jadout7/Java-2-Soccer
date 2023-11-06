package main;

import java.util.HashMap;

// Created a Player class consisting of a name and a Hashmap of cards to keep track of fines
public class Player {
    private String name;

    // HashMap<Card,Integer> because the key(Card) can either be Yellow, Red or Black and the value(Integer) is to show the number of cards received
    private final HashMap<Card, Integer> cards;

    public Player(String name) {
        this.name = name;
        this.cards = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    // Returns each card with their respective card count
    public HashMap<Card, Integer> getCards() {
        return cards;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Increase the card count (Integer) by 1 by getting the type of card and incrementing 1
    public void addCard(Card card) {
        cards.put(card, cards.get(card) + 1);
    }


    public void removeCard(Card card) {
        // If the cards HashMap contains that card
        if (cards.containsKey(card)) {
            // Get that card's count
            int count = cards.get(card);
            // If card's count is more than 1, subtract 1 from the count
            if (count > 1) {
                cards.put(card, count - 1);
            }
            // Otherwise if the card count is 1, remove the card (Make it 0)
            else if (count == 1) {
                cards.remove(card);
            }
            // Otherwise if the card count is already 0, Console print error
            else {
                System.out.println("Card count: 0. Cannot remove more cards");
            }
        }
    }

    public double calculateTotalPlayerFine() {
        double totalFine = 0;
        // Gets all the cards and their counts
        HashMap<Card, Integer> cards = getCards();
        // For each card in the card HashMap
        for (Card card : cards.keySet()) {
            // Increment the totalFine by the fine of each card (card.getFine()) multiplied by their respective card counts (cards.get(card))
            totalFine += card.getFine() * cards.get(card);
        }
        return totalFine;
    }
}