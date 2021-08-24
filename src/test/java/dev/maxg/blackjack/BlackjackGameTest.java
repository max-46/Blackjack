/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.maxg.blackjack;

import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author max
 */
public class BlackjackGameTest {
    
    public BlackjackGameTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of autoPlay method, of class BlackjackGame.
     */
    @Test
    public void testAutoPlay() {
        System.out.println("autoPlay");
        Card[] dCards = new Card[]{new Card(CardType.ACE), new Card(CardType.JACK)};
        Player dealer = new Player("Dealer", dCards);
        Card[] pCards = new Card[]{new Card(CardType.KING), new Card(CardType.THREE)};
        Player player = new Player("Dealer", pCards);
        BlackjackGame instance = new BlackjackGame(3);
        instance.autoPlay(dealer, player);
        assertTrue(dealer.getTotal() > player.getTotal());
    }

    /**
     * Test of dealNewCards method, of class BlackjackGame.
     */
    @Test
    public void testDealNewCards() {
        System.out.println("dealNewCards");
        Card[] dCards = new Card[]{new Card(CardType.ACE), new Card(CardType.JACK)};
        Player dealer = new Player("Dealer", dCards);
        Card[] pCards = new Card[]{new Card(CardType.KING), new Card(CardType.THREE)};
        Player player = new Player("Dealer", pCards);
        BlackjackGame bg = new BlackjackGame(2);
        bg.dealNewCards(new Player[]{dealer, player}, new Card[]{new Card(CardType.TWO), new Card(CardType.SIX), new Card(CardType.TWO), new Card(CardType.SIX)});
        assertFalse(Arrays.equals(pCards, player.getCards()));
    }

    /**
     * Test of getWinner method, of class BlackjackGame.
     */
    @Test
    public void testGetWinner() {
        System.out.println("getWinner");
        Card[] dCards = new Card[]{new Card(CardType.ACE), new Card(CardType.JACK)};
        Player dealer = new Player("Dealer", dCards);
        Card[] pCards = new Card[]{new Card(CardType.KING), new Card(CardType.THREE)};
        Player player = new Player("Dealer", pCards);
        Player[] players = new Player[]{dealer, player};
        BlackjackGame bg = new BlackjackGame(3);
        Player winner = bg.getWinner(players);
        assertTrue(winner.getTotal() <= 21);
    }

    /**
     * Test of dealAnotherCard method, of class BlackjackGame.
     */
    @Test
    public void testDealAnotherCard() {
        System.out.println("dealAnotherCard");
        Card[] pCards = new Card[]{new Card(CardType.KING), new Card(CardType.THREE)};
        Player player = new Player("Dealer", pCards);
        Card card = new Card(CardType.FOUR);
        BlackjackGame bg = new BlackjackGame(3);
        bg.dealAnotherCard(player, card);
        assertEquals(3, player.getCards().length);
    }
    
    /**
     * Test of makePlayer method, of class BlackjackGame.
     */
    @Test
    public void testmakePlayer() {
        System.out.println("makePlayer");
        BlackjackGame bg = new BlackjackGame(1);
        Player player = bg.makePlayer("Player 1");
        assertEquals("Player 1", player.getName());
    }
    
}
