package test;

import main.Club;
import main.Team;
import main.Player;
import main.Card;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClubTest {
    private Club club;
    private Team team1;
    private Team team2;

    @BeforeEach
    public void setUp() {
        club = new Club("Test Club");
        team1 = new Team("Senior Team");
        team2 = new Team("Junior Team");
    }

    @Test
    public void testAddTeam() {
        club.addTeam(team1);
        club.addTeam(team2);
        assertEquals(2, club.getTeams().size());
    }

    @Test
    public void testRemoveTeam() {
        club.addTeam(team1);
        club.addTeam(team2);
        club.removeTeam("Junior Team");
        assertEquals(1, club.getTeams().size());
    }

    @Test
    public void testCalculateTotalClubFine() {
        // Create test players and teams
        Player player1 = new Player("Nico");
        Player player2 = new Player("Alex");
        Player player3 = new Player("Jadyn");

        // Add cards to players
        player1.addCard(Card.YELLOW);
        player2.addCard(Card.RED);
        player3.addCard(Card.BLACK);

        // Add players to teams
        team1.addPlayer(player1);
        team2.addPlayer(player2);
        team2.addPlayer(player3);

        // Add teams to club
        club.addTeam(team1);
        club.addTeam(team2);

        // Calculate the total fine manually and compare it with the expected value
        assertEquals(18.32 + 41.60 + 349.76, club.calculateTotalClubFine());
    }

    @Test
    public void testGetClubFairplayAwardWinners() {
        // Create test players and teams
        Player player1 = new Player("Nico");
        Player player2 = new Player("Alex");
        Player player3 = new Player("Jadyn");

        // Add cards to players
        player1.addCard(Card.YELLOW);
        player2.addCard(Card.YELLOW);
        player2.addCard(Card.RED);
        player3.addCard(Card.YELLOW);

        // Add players to teams
        team1.addPlayer(player1);
        team2.addPlayer(player2);
        team2.addPlayer(player3);

        // Add teams to club
        club.addTeam(team1);
        club.addTeam(team2);

        assertTrue(club.getClubFairplayAwardWinners().contains(player1));
        assertTrue(club.getClubFairplayAwardWinners().contains(player3));
    }
}