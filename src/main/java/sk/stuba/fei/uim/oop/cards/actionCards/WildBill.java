package sk.stuba.fei.uim.oop.cards.actionCards;

import sk.stuba.fei.uim.oop.cards.PondCards;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;
import java.util.Objects;

public class WildBill extends ActionCards {
    String name0 = "WildBill";


    @Override
    public String getName0() {
        return name0;
    }

    @Override
    public void action(ArrayList<PondCards> pond, ArrayList<Boolean> aimers,ArrayList<PondCards> pondCards,ArrayList<ActionCards> deck) {
        int index = ZKlavesnice.readInt("Enter position on witch you want to shoot (Wild Bill): ");
        while( index>6|| index<1){
            index = ZKlavesnice.readInt("your position is  out of range <1,6> !" +
                    "Enter new position: ");

        }
        if(aimers.get(index-1)==Boolean.TRUE){
            aimers.set(index-1,false);
        }



        if(Objects.equals(pond.get(index - 1).getName(), "Duck")) {
            pond.get(index - 1).getOwner().setLives();
            pond.remove(index - 1);
            pond.add(pondCards.get(0));
            pondCards.remove(0);
        }




    }
}
