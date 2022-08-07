package sk.stuba.fei.uim.oop.cards.actionCards;

import sk.stuba.fei.uim.oop.cards.PondCards;


import java.util.ArrayList;

public class DuckWalk extends ActionCards {
    String name0 = "DuckWalk";

    @Override
    public String getName0() {
        return name0;
    }

    @Override
    public void action(ArrayList<PondCards> pond, ArrayList<Boolean> aimers,ArrayList<PondCards> pondCards,ArrayList<ActionCards> deck) {
        pondCards.add(pond.get(0));
        pond.remove(0);
        pond.add(pondCards.get(0));
        pondCards.remove(0);

    }
}
