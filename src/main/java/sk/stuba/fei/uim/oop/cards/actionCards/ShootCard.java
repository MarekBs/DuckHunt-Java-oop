package sk.stuba.fei.uim.oop.cards.actionCards;

import sk.stuba.fei.uim.oop.cards.PondCards;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;
import java.util.Objects;

public class ShootCard extends ActionCards {
    String name0 = "ShootCard";


    @Override
    public String getName0() {
        return name0;
    }

    @Override
    public void action(ArrayList<PondCards> pond, ArrayList<Boolean> aimers,ArrayList<PondCards> pondCards,ArrayList<ActionCards> deck) {
        int index = ZKlavesnice.readInt("Enter position on witch you want to shoot: ");
        while(index>6|| index<1 || aimers.get(index-1)==Boolean.FALSE){
            index = ZKlavesnice.readInt("your position is not aimed or out or range <1,6>, chose only aimed position! : " +
                    "Enter new position: ");

        }

        aimers.set(index-1,false);



        if(Objects.equals(pond.get(index - 1).getName(), "Duck")) {
            pond.get(index - 1).getOwner().setLives();
            pond.remove(index - 1);
            pond.add(pondCards.get(0));
            pondCards.remove(0);
        }




    }
}
