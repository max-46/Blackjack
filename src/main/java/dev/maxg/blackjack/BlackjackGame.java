/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.maxg.blackjack;

import java.util.Deque;

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
        player.giveAnotherCard(bg.cards.pop());
        bg.cards.forEach(c -> System.out.println(c));
        System.out.println(bg.cards.size());
        System.out.println(dealer);
        System.out.println(player);
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

    public void dealCard(Player player, Card card) {
        player.giveAnotherCard(card);
    }

}
