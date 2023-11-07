package test;

import main.Card;
import main.Player;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    private Player player;

    @BeforeEach
    public void setUp() {
        player = new Player("Nico Martinez");
    }

    @Test
    public void testAddCard() {
        // Add 1 Yellow Card and 2 Red Cards
        player.addCard(Card.YELLOW);
        player.addCard(Card.RED);
        player.addCard(Card.RED);
        // Create a temp HashMap and put the cards and counts in and compare
        HashMap<Card, Integer> expectedCards = new HashMap<>();
        expectedCards.put(Card.YELLOW, 1);
        expectedCards.put(Card.RED, 2);
        assertEquals(expectedCards, player.getCards());
    }

    @Test
    public void testRemoveCard() {
        // Same process as the test above
        player.addCard(Card.BLACK);
        player.addCard(Card.BLACK);
        player.removeCard(Card.BLACK);
        HashMap<Card, Integer> expectedCards = new HashMap<>();
        expectedCards.put(Card.BLACK, 1);
        assertEquals(expectedCards, player.getCards());
    }

    @Test
    public void testCalculateTotalPlayerFine() {
        // Add Cards
        player.addCard(Card.RED);
        player.addCard(Card.RED);
        player.addCard(Card.BLACK);
        // Create temp variable to calculate fine manually
        double expectedTotalFine = Card.RED.getFine() * 2 + Card.BLACK.getFine();
        // Compare it with the actual HashMap values (calculateFine method)
        assertEquals(expectedTotalFine, player.calculateTotalPlayerFine());
    }
}
