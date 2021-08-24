/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.maxg.blackjack;

import java.util.Deque;
import java.util.Scanner;

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
        Player dealer = bg.makePlayer("Dealer");
        Player player = bg.makePlayer("Player");
        System.out.println(dealer);
        String response;
        Scanner scanner = new Scanner(System.in);
        while (player.getTotal() <= 21) {
            System.out.println(player);
            System.out.println("Would you like another card? (Y/n)");
            response = scanner.nextLine();
            if (response.equalsIgnoreCase("N")) break;
            bg.dealAnotherCard(player, bg.cards.pop());
        }
        if (player.getTotal() > 21) System.out.println("You have gone bust!");
        bg.autoPlay(dealer, player);
        System.out.println("The winner is " + bg.getWinner(new Player[]{dealer, player}));
    }

    public Player makePlayer(String name) {
        return new Player(name, new Card[]{cards.pop(), cards.pop()});
    }

    public void autoPlay(Player dealer, Player player) {
        int pTotal = player.getTotal();
        if (pTotal > 21) {
            return;
        }
        System.out.println("Dealer playing...");
        if (pTotal <= 21 && dealer.getTotal() < pTotal) {
            dealAnotherCard(dealer, cards.pop());
        }
        System.out.println(dealer);
    }

    public void dealNewCards(Player[] players, Card[] cards) {
        if (cards.length != players.length * 2) {
            throw new AssertionError("There should be twice as many cards as players");
        }
        int i = 0;
        for (Player player : players) {
            player.giveNewCards(new Card[]{cards[i++], cards[i++]});
        }
    }

    public Player getWinner(Player[] players) {
        Player winner = null;
        for (Player player : players) {
            int pTotal = player.getTotal();
            if (pTotal <= 21 && (winner == null || pTotal > winner.getTotal())) {
                winner = player;
            }
        }
        return winner;
    }

    public void dealAnotherCard(Player player, Card card) {
        player.giveAnotherCard(card);
    }

}
