/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.maxg.blackjack;

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
     * Test of dealCards method, of class BlackjackGame.
     */
    @Test
    public void testDealCards() {
        System.out.println("dealCards");
        Player[] players = null;
        Card[] cards = null;
        BlackjackGame instance = null;
        instance.dealNewCards(players, cards);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dealCard method, of class BlackjackGame.
     */
    @Test
    public void testDealCard() {
        System.out.println("dealCard");
        Player player = null;
        Card card = null;
        BlackjackGame instance = null;
        instance.dealAnotherCard(player, card);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
