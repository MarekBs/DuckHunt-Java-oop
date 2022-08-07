package sk.stuba.fei.uim.oop.cards.actionCards;

import sk.stuba.fei.uim.oop.cards.PondCards;

import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;

public class AimCard extends  ActionCards {
    String name0 = "AimCard";

    @Override
    public String getName0() {
        return name0;
    }

    @Override
    public void action(ArrayList<PondCards> pond, ArrayList<Boolean> aimers,ArrayList<PondCards> pondCards,ArrayList<ActionCards> deck) {
        int index = ZKlavesnice.readInt("Enter position on witch you want to aim: ");
        while(index<1|| index-1>5 || aimers.get(index-1)==Boolean.TRUE){
            index = ZKlavesnice.readInt("your position is already aimed or out of range <1,6>,  choose another: ");

        }

        aimers.set(index-1, true);


    }
}
