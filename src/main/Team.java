package main;

import java.util.ArrayList;
import java.util.HashMap;

// Created a Team class consisting of a name and a Hashmap of Players
public class Team {
    // Forgot to add the minimum amount of players
    private static final int MIN_PLAYERS = 11;
    private static final int MAX_PLAYERS = 22;
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
        // If the size of HashMap is less than 22
        if (players.size() < MAX_PLAYERS) {
            // Add selected player
            players.put(player.getName(), player);
        } else {
            // Otherwise Console output error
            System.out.println("Cannot add more players. Team is already at maximum capacity.");
        }
    }

    public void removePlayer(String playerName) {
        // If the size of the HashMap is more than 11
        if (players.size() > MIN_PLAYERS) {
            // Remove the selected player
            players.remove(playerName);
        } else {
            // Otherwise Console output error
            System.out.println("Cannot remove more players. Team is at the minimum required capacity.");
        }
    }

    public ArrayList<Player> getTeamFairplayAwardWinners() {
        // Create arraylist to add multiple winners
        ArrayList<Player> fairplayWinners = new ArrayList<>();
        // Sets the minimum cards to the maximum integer value (2147483647)
        int minCards = Integer.MAX_VALUE;
        // Loop through each player in the Hashmap
        for (Player player : players.values()) {
            // Sets the total Cards to 0
            int totalCards = 0;
            // Gets the cards and their counts
            HashMap<Card, Integer> cards = player.getCards();
            // For each card in the card counts
            for (int count : cards.values()) {
                // Increment it to the total cards
                totalCards += count;
            }
            // If total cards is less than minimum cards
            if (totalCards < minCards) {
                // Set minimum cards to the total cards variable
                minCards = totalCards;
                // Clears the ArrayList
                fairplayWinners.clear();
                // Add winners to the list
                fairplayWinners.add(player);
            }
            // Otherwise if the total cards of players are equal to each other
            else if (totalCards == minCards) {
                // Add them to the list
                fairplayWinners.add(player);
            }
        }
        return fairplayWinners;
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
        // Create a list to hold players to be removed
        ArrayList<String> playersToRemove = new ArrayList<>();
        // Loops through the players
        for (Player player : players.values()) {
            // Checks if the player has a card that contains the key "Black"
            if (player.getCards().containsKey(Card.BLACK)) {
                // Console outputs the name of the player removed
                System.out.println("Player removed: " + player.getName());
                // Add the player's name to the list of players to be removed
                playersToRemove.add(player.getName());
                // Sets the boolean variable to true meaning player is removed
                removed = true;
            }
        }
        // Loops through players in the arraylist
        for (String playerName : playersToRemove) {
            // Console outputs the name of the player removed
            System.out.println("Player removed: " + playerName);
            // Removes the player from the team
            players.remove(playerName);
        }
        // If no one is removed
        if (!removed) {
            // Console output that no one has a Black card
            System.out.println("No player has a Black card");
        }
    }
}