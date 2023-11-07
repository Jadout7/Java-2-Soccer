package main;

import java.util.ArrayList;
import java.util.HashMap;

// Created a Club class consisting of a name and a Hashmap of Teams
public class Club {
    private String name;
    // Key is the Team name and Value is the Team itself
    private HashMap<String, Team> teams;

    public Club(String name) {
        this.name = name;
        this.teams = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public HashMap<String, Team> getTeams() {
        return teams;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addTeam(Team team) {
        teams.put(team.getName(), team);
    }

    public void removeTeam(String teamName) {
        teams.remove(teamName);
    }

    public double calculateTotalClubFine() {
        // Set totalClubFine to 0
        double totalClubFine = 0;
        // Loop through the Hashmap of Teams
        for (Team team : teams.values()) {
            // Uses the calculateTotalTeamFine method from the Team class and increments it to the totalClubFine
            totalClubFine += team.calculateTotalTeamFine();
        }
        return totalClubFine;
    }

    public ArrayList<Player> getClubFairplayAwardWinners() {
        // Create arraylist to add multiple winners
        ArrayList<Player> fairplayWinners = new ArrayList<>();
        // Sets the minimum cards to the maximum integer value (2147483647)
        int minCards = Integer.MAX_VALUE;
        // Loop through each team in the Teams Hashmap
        for (Team team : teams.values()) {
            // Gets the winners of fairplay in each team
            ArrayList<Player> currentTeamPlayers = team.getTeamFairplayAwardWinners();
            for (Player currentPlayer : currentTeamPlayers) {
                // Sets the totalCards to 0
                int totalCards = 0;
                // Gets the cards of the current player that is being looped through
                HashMap<Card, Integer> cards = currentPlayer.getCards();
                // For each card in the card count
                for (int count : cards.values()) {
                    // Increment it to the totalCards
                    totalCards += count;
                }
                // If total cards is less than minimum cards
                if (totalCards < minCards) {
                    // Set minimum cards to the total cards variable
                    minCards = totalCards;
                    // Clears the ArrayList
                    fairplayWinners.clear();
                    // Add winners to the list
                    fairplayWinners.add(currentPlayer);
                }
                // Otherwise if the total cards of players are equal to each other
                else if (totalCards == minCards) {
                    // Add them to the list
                    fairplayWinners.add(currentPlayer);
                }
            }
        }
        return fairplayWinners;
    }
}