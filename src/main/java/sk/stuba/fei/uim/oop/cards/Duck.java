package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.player.Player;

public class Duck extends PondCards {
    String name = "Duck";
    protected Player owner;



    public Duck(Player owner) {
        this.owner = owner;

    }

    public String getName() {
        return name;
    }

    public Player getOwner() {
        return owner;
    }



}
