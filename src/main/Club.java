package main;

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

    public Player getClubFairplayAwardWinner() {
        // Setting the fairplay winner to nobody/nothing
        Player fairplayWinner = null;
        // Sets the minimum cards to the maximum integer value (2147483647)
        int minCards = Integer.MAX_VALUE;
        // Loop through each team in the Teams Hashmap
        for (Team team : teams.values()) {
            // Sets the currentPlayer variable to the TeamFairplayWinner of said team
            Player currentPlayer = team.getTeamFairplayAwardWinner();
            if (currentPlayer != null) {
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
                    // Set the fairplay winner to the player with the minimum cards
                    fairplayWinner = currentPlayer;
                }
            }
        }
        return fairplayWinner;
    }
}