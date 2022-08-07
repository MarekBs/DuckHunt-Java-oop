package sk.stuba.fei.uim.oop.player;

import sk.stuba.fei.uim.oop.cards.actionCards.ActionCards;

import java.util.ArrayList;

public class Player {
    private final String name;
    private int lives;
    private ArrayList<ActionCards> cards;




    public void setLives() {
        this.lives = lives-1;
    }

    public int getLives() {
        return lives;
    }

    public Player(String name) {
        this.name = name;
        this.lives=5;
        this.cards = new ArrayList<>(3);


    }


    public ArrayList<ActionCards> getCards() {
        return cards;
    }

    public void setCards(ArrayList<ActionCards> cards) {
        this.cards = cards;
    }



    public String getName() {
        return name;
    }

}
