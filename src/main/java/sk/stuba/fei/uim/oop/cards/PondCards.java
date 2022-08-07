package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.player.Player;

public abstract class PondCards {
    String name;
    protected Player owner;


    public String getName() {
        return name;
    }

    public Player getOwner() {
        return owner;
    }
}
