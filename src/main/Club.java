package main;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created a Club class consisting of a name and a Hashmap of Teams
 */
public class Club {
    private String name;
    // Key is the Team name and Value is the Team itself
    private HashMap<String, Team> teams;

    /**
     * Constructor for Club class
     *
     * @param name the name of the club
     */
    public Club(String name) {
        this.name = name;
        this.teams = new HashMap<>();
    }

    /**
     * Method to get the name of the club
     *
     * @return the name of the club
     */
    public String getName() {
        return name;
    }

    /**
     * Method to get the teams of the club
     *
     * @return the teams of the club
     */
    public HashMap<String, Team> getTeams() {
        return teams;
    }

    /**
     * Method to set the name of the club
     *
     * @param name the name of the club
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to add a team to the club
     *
     * @param team the team to be added
     */
    public void addTeam(Team team) {
        teams.put(team.getName(), team);
    }

    /**
     * Method to remove a team from the club
     *
     * @param teamName the name of the team to be removed
     */
    public void removeTeam(String teamName) {
        teams.remove(teamName);
    }

    /**
     * Method to calculate the total fine for the club
     *
     * @return the total fine for the club
     */
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

    /**
     * Method to get the players who won the Club Fairplay Award
     *
     * @return the list of players who won the Club Fairplay Award
     */
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
