package sk.stuba.fei.uim.oop.cards.actionCards;

import sk.stuba.fei.uim.oop.cards.PondCards;

import java.util.ArrayList;

public abstract class ActionCards {
    String name0;

    public abstract void action(ArrayList<PondCards> pond, ArrayList<Boolean> aimers,ArrayList<PondCards> pondCards,ArrayList<ActionCards> deck);

    public String getName0() {
        return name0;
    }
}

