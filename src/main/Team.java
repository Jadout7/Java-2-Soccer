package main;

import java.util.HashMap;

// Created a Team class consisting of a name and a Hashmap of Players
public class Team {
    private String name;

    // Key is the player's name and value is the player itself
    private HashMap<String, Player> players;

    public Team(String name) {
        this.name = name;
        this.players = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public HashMap<String, Player> getPlayers() {
        return players;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPlayer(Player player) {
        players.put(player.getName(), player);
    }

    public void removePlayer(String playerName) {
        players.remove(playerName);
    }

    public Player getTeamFairplayAwardWinner() {
        // Setting the fairplay winner to nobody/nothing
        Player fairplayWinner = null;
        // Sets the minimum cards to the maximum integer value (2147483647)
        int minCards = Integer.MAX_VALUE;
        // Loop through each player in the Hashmap
        for (Player player : players.values()) {
            // Sets the total Cards to 0
            int totalCards = 0;
            // Gets the cards and their counts
            HashMap<Card, Integer> cards = player.getCards();
            // For each count in the card counts
            for (int count : cards.values()) {
                // Increment it to the total cards
                totalCards += count;
            }
            // If total cards is less than minimum cards
            if (totalCards < minCards) {
                // Set minimum cards to the total cards variable
                minCards = totalCards;
                // Set the fairplay winner to the player with the minimum cards
                fairplayWinner = player;
            }
        }
        return fairplayWinner;
    }

    public double calculateTotalTeamFine() {
        double totalTeamFine = 0;
        // Loops through each player in the HashMap
        for (Player player : players.values()) {
            // Uses the calculateTotalPlayerFine method from the Player class and increments it to the totalTeamFine
            totalTeamFine += player.calculateTotalPlayerFine();
        }
        return totalTeamFine;
    }

    public void removePlayerWithBlackCard() {
        // Set a boolean variable to tell if the player is removed or not
        boolean removed = false;
        // Loops through the players
        for (Player player : players.values()) {
            // Checks if the player has a card that contains the key "Black"
            if (player.getCards().containsKey(Card.BLACK)) {
                // Console outputs the name of the player removed
                System.out.println("Player removed: " + player.getName());
                // Removes the player from the team
                players.remove(player.getName());
                // Sets the boolean variable to true meaning player is removed
                removed = true;
            }
        }
        // If no one is removed
        if (!removed) {
            // Console output that no one has a Black card
            System.out.println("No player has a Black card");
        }
    }
}