package test;

import main.Card;
import main.Player;
import main.Team;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TeamTest {
    private Team team;
    private Player player1;
    private Player player2;
    private Player player3;

    @BeforeEach
    public void setUp() {
        team = new Team("Test Team");
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        player3 = new Player("Player 3");
    }

    @Test
    public void testAddPlayer() {
        // For loop to create 22 players
        for (int i = 0; i < 22; i++) {
            Player player = new Player("Player " + (i + 1));
            team.addPlayer(player);
        }
        // Checks for 22 players in the team
        assertEquals(22, team.getPlayers().size());
    }

    @Test
    public void testRemovePlayer() {
        // Same logic as the test above
        for (int i = 0; i < 22; i++) {
            Player player = new Player("Player " + (i + 1));
            team.addPlayer(player);
        }
        team.removePlayer("Player 1");
        team.removePlayer("Player 3");
        assertEquals(20, team.getPlayers().size());
    }

    @Test
    public void testGetTeamFairplayAwardWinners() {
        // Add cards to players
        player1.addCard(Card.YELLOW);
        player2.addCard(Card.YELLOW);
        player2.addCard(Card.RED);
        player3.addCard(Card.YELLOW);
        player3.addCard(Card.RED);
        team.addPlayer(player1);
        team.addPlayer(player2);
        team.addPlayer(player3);
        // checks if the fairplay winners array contains player 1 and has only 1 player in it
        ArrayList<Player> fairplayWinners = team.getTeamFairplayAwardWinners();
        assertTrue(fairplayWinners.contains(player1));
        assertEquals(1, fairplayWinners.size());
    }

    @Test
    public void testGetTeamFairplayAwardWinnersWithEqualCards() {
        // Same logic as previous test but 2 players have equal cards
        player1.addCard(Card.YELLOW);
        player2.addCard(Card.RED);
        team.addPlayer(player1);
        team.addPlayer(player2);
        ArrayList<Player> fairplayWinners = team.getTeamFairplayAwardWinners();
        assertTrue(fairplayWinners.contains(player1));
        assertEquals(2, fairplayWinners.size());
    }

    @Test
    public void testRemovePlayerWithBlackCard() {
        // Same logic as previous test but checks for players with black card and removes them
        player1.addCard(Card.YELLOW);
        player2.addCard(Card.BLACK);
        team.addPlayer(player1);
        team.addPlayer(player2);
        team.removePlayerWithBlackCard();
        assertEquals(1, team.getPlayers().size());
    }
}