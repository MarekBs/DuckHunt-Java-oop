package sk.stuba.fei.uim.oop.cards.actionCards;

import sk.stuba.fei.uim.oop.cards.PondCards;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;
import java.util.Objects;

public class TurboDuck extends ActionCards {
    String name0 = "TurboDuck";

    @Override
    public String getName0() {
        return name0;
    }

    @Override
    public void action(ArrayList<PondCards> pond, ArrayList<Boolean> aimers,ArrayList<PondCards> pondCards,ArrayList<ActionCards> deck) {
        int index = ZKlavesnice.readInt("Enter position of duck on witch you want to play turboDuck: ");
        while(index>6|| index<1 ||Objects.equals(pond.get(index - 1).getName(), "Water")){
            index = ZKlavesnice.readInt("Enter different position, on your position is water or position is out of range! : ");
        }


            PondCards a;
            a=pond.get(index-1);
            pond.remove(index-1);
            pond.add(0,a);




    }
}
