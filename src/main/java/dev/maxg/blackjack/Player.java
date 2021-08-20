/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.maxg.blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author max
 */
public class Player {

    String name;
    List<Card> cards;

    public Player(String name, Card[] cards) {
        this.name = name;
        this.cards = new ArrayList<>(Arrays.asList(cards));
    }

    public void giveNewCards(Card[] cards) {
        this.cards = new ArrayList<>(Arrays.asList(cards));
    }

    public void giveAnotherCard(Card card) {
        cards.add(card);
    }

    public int getTotal() {
        int numOfAces = cards.stream()
                .filter(c -> c.getCardType() == CardType.ACE)
                .mapToInt(c -> 1)
                .sum();
        int total = cards.stream().mapToInt(c -> c.getValue()).sum();
        if (numOfAces == 0) return total;
        return total <= 11 ? total + 10 : total;
    }
    
    @Override
    public String toString() {
        return "Player{" + "cards=" + cards + '}';
    }

}