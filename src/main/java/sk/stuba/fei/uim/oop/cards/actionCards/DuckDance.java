package sk.stuba.fei.uim.oop.cards.actionCards;

import sk.stuba.fei.uim.oop.cards.PondCards;

import java.util.ArrayList;
import java.util.Collections;

public class DuckDance extends ActionCards {
    String name0  = "DuckDance";


    @Override
    public String getName0() {
        return name0;
    }

    @Override
    public void action(ArrayList<PondCards> pond, ArrayList<Boolean> aimers,ArrayList<PondCards> pondCards,ArrayList<ActionCards> deck) {
        for(int i=0;i<6;i++){
            pondCards.add(pond.get(0));
            pond.remove(0);
        }
        Collections.shuffle(pondCards);
        for(int i=0;i<6;i++){
            pond.add(pondCards.get(0));
            pondCards.remove(0);
        }

    }
}
