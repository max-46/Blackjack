/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.maxg.blackjack;

import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author max
 */
public class BlackjackGame {

    private final Deque<Card> cards;

    public BlackjackGame(int numOfDecks) {
        this.cards = Card.getCardDecks(numOfDecks);
    }

    public static void main(String[] args) {
        BlackjackGame bg = new BlackjackGame(3);
        Player dealer = new Player("Dealer", new Card[]{bg.cards.pop(), bg.cards.pop()});
        Player player = new Player("Player", new Card[]{bg.cards.pop(), bg.cards.pop()});
        bg.dealCard(player, bg.cards.pop());
        System.out.println(dealer);
        System.out.println(player);
        System.out.println("Winner is: " + bg.getWinner(new Player[]{dealer, player}));
    }

    public void dealCards(Player[] players, Card[] cards) {
        if (cards.length != players.length * 2) {
            throw new AssertionError("There should be twice as many cards as players");
        }
        int i = 0;
        for (Player player : players) {
            player.giveNewCards(new Card[]{cards[i++], cards[i++]});
        }
    }
    
    public Player getWinner(Player[] players){
        Player winner = null;
        for (Player player : players) {
            int pTotal = player.getTotal();
            if (pTotal <= 21 && (winner == null || pTotal > winner.getTotal())) {
                winner = player;
            }
        }
        return winner;
    }

    public void dealCard(Player player, Card card) {
        player.giveAnotherCard(card);
    }

}
