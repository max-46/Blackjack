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
    private final Player dealer;
    private final Player player;

    public BlackjackGame(int numOfDecks) {
        cards = Card.getCardDecks(numOfDecks);
        System.out.println(cards);
        System.out.println(cards.pop());
        dealer = new Player("Dealer", new Card[]{cards.pop(), cards.pop()});
        player = new Player("Player", new Card[]{cards.pop(), cards.pop()});
    }

    public static void main(String[] args) {
        BlackjackGame bg = new BlackjackGame(3);
        System.out.println(bg.getDealer());
        if (bg.getPlayer().getTotal() > 21) {
            System.out.println("You have gone bust!");
        }
        bg.hitOrStay();
        bg.dealerPlay();
        System.out.println("The winner is " + bg.getWinner());
    }

    public Player getDealer() {
        return dealer;
    }

    public Player getPlayer() {
        return player;
    }

    public void hitOrStay() {
        String response;
        Scanner scanner = new Scanner(System.in);
        while (player.getTotal() <= 21) {
            System.out.println(player);
            System.out.println("Would you like another card? (Y/n)");
            response = scanner.nextLine();
            if (response.equalsIgnoreCase("N")) {
                break;
            }
            player.giveAnotherCard(cards.pop());
        }
    }

    public void dealerPlay() {
        System.out.println("Dealer playing...");
        int dTotal;
        while ((dTotal = dealer.getTotal()) < 21 || dTotal < player.getTotal()) {
            dealer.giveAnotherCard(cards.pop());
        }
        System.out.println(dealer);
    }

    public void dealNewCards(Card[] cards) {
        if (cards.length != 4) {
            throw new AssertionError("There should be twice as many cards as players");
        }
        int i = 0;
        for (Player p : new Player[]{dealer, player}) {
            p.giveNewCards(new Card[]{cards[i++], cards[i++]});
        }
    }

    public Player getWinner() {
        Player winner = null;
        for (var p : new Player[]{dealer, player}) {
            int pTotal = p.getTotal();
            if (pTotal <= 21 && (winner == null || pTotal > winner.getTotal())) {
                winner = p;
            }
        }
        return winner;
    }

}
