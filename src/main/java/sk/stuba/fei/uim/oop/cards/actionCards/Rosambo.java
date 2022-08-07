package sk.stuba.fei.uim.oop.cards.actionCards;

import sk.stuba.fei.uim.oop.cards.PondCards;


import java.util.ArrayList;
import java.util.Collections;

public class Rosambo extends ActionCards {
    String name0 = "Rosambo";

    @Override
    public String getName0() {
        return name0;
    }

    @Override
    public void action(ArrayList<PondCards> pond, ArrayList<Boolean> aimers,ArrayList<PondCards> pondCards,ArrayList<ActionCards> deck) {
        Collections.shuffle(pond);

    }
}
