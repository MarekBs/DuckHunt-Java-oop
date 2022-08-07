package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.cards.*;
import sk.stuba.fei.uim.oop.cards.actionCards.*;
import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;
import java.util.*;

public class Game {
    private final  ArrayList<Player> players;
    private ArrayList<ActionCards> deck;
    private ArrayList<PondCards> pondCards;
    private ArrayList<PondCards> pond;
    private final ArrayList<Boolean> aimers;
    private int pos;



    public ArrayList<PondCards> getPondCards() {
        return pondCards;
    }

    public void setPondCards(ArrayList<PondCards> pondCards) {
        this.pondCards = pondCards;
    }


    public Game() {
        this.initializeDeck();
        System.out.println("Welcome to FEI Shooted Ducks");
        int numberPlayers = ZKlavesnice.readInt("Enter number of players (<2,6>): ");

        while(numberPlayers>6 || numberPlayers<2){
            numberPlayers = ZKlavesnice.readInt("Your number of players is out of range <2,6> enter number from this range! : ");
        }
        this.players = new ArrayList<>(6);
        this.initializePondCards();
        for (int i = 0; i < numberPlayers; i++) {
            players.add(new Player(ZKlavesnice.readString("Enter PLAYER " + (i + 1) + " name:")));
            for (int j = 0; j < 5; j++) {
                this.pondCards.add(new Duck(players.get(i)));

            }
        }

        Collections.shuffle(pondCards);
        this.initializePond();
        this.aimers = new ArrayList<>(6);
        aimers.addAll(Collections.nCopies(6, Boolean.FALSE));
        this.initializeCards(numberPlayers);
        this.startGame();
    }

    //____________________________MAIN_GAME_CYCLE____________________________________________
    private void startGame(){
        System.out.println("----<GAME STARTED>----");
        int i=0;
        this.printGame();
        while(players.size()>1) {
            int p=checkPlayable(i);
            if(p==0) {
                this.printTurn(i).action(pond, aimers, pondCards, deck);
            }
            this.printGame();
            if(p==0) {
                this.takeCard(i);
                this.lifeCheck();
            }
            i++;
            if(players.size()-1<i){
                i=0;
            }
            ZKlavesnice.readChar("Press ENTER to continue...");

        }
        System.out.println("**************  winner is Player: "+players.get(i).getName()+"   ***************************");
    }

    //--------------------------------------------------------------------------------

    private void lifeCheck(){
        int a,index=-5;
        for(int i=0;i<players.size();i++){
            a= players.get(i).getLives();
            if(a==0){
                index=i;
                for(int b=0;b<3;b++){
                    deck.add(players.get(i).getCards().get(b));

                }
            }
        }
        if(index!=-5){
            System.out.println();
            System.out.println("Player "+ players.get(index).getName()+" ELIMINATED");
            System.out.println();
            players.remove(index);
        }
    }

    private void takeCard(int i){
        deck.add(players.get(i).getCards().get(pos-1));
        players.get(i).getCards().remove(pos-1);
        players.get(i).getCards().add(deck.get(0));
        deck.remove(0);
    }

    private int checkPlayable(int i){
        int a=0;
        if(players.get(i).getCards().get(0) instanceof ShootCard && players.get(i).getCards().get(1) instanceof ShootCard && players.get(i).getCards().get(2) instanceof ShootCard){
            if(Collections.frequency(aimers, true)==0){
                System.out.println("--- PLAYER " + players.get(i).getName() + "'s TURN ---");
                printCards(i);
                System.out.println("\nYou cannot play any card, take new one from the deck! ");
                ZKlavesnice.readChar("Press ENTER to take new card from deck...");

                deck.add(players.get(i).getCards().get(0));
                players.get(i).getCards().remove(0);
                players.get(i).getCards().add(deck.get(0));
                deck.remove(0);
                a=1;
            }
        }
        if(players.get(i).getCards().get(0) instanceof AimCard && players.get(i).getCards().get(1) instanceof AimCard && players.get(i).getCards().get(2) instanceof AimCard){
            if(Collections.frequency(aimers, true)==6){
                System.out.println("--- PLAYER " + players.get(i).getName() + "'s TURN --- ");
                printCards(i);
                System.out.println("\nYou cannot play any card, take new one from the deck! ");
                ZKlavesnice.readChar("Press ENTER to take new card from deck...");

                deck.add(players.get(i).getCards().get(0));
                players.get(i).getCards().remove(0);
                players.get(i).getCards().add(deck.get(0));
                deck.remove(0);
                a=1;
            }
        }
        return a;
    }

    private void printCards(int i) {
        System.out.print("1-|"+ players.get(i).getCards().get(0).getName0()+"|   ");
        System.out.print("2-|"+ players.get(i).getCards().get(1).getName0()+"|   ");
        System.out.print("3-|"+ players.get(i).getCards().get(2).getName0()+"| ");
    }

    private ActionCards printTurn(int i){
        System.out.println();
        System.out.println("***********************************************************");
        System.out.println("--- PLAYER " + players.get(i).getName() + "'s TURN ---");
        System.out.println();
        System.out.print("Your cards: ");
        printCards(i);

        System.out.println();
        int index = ZKlavesnice.readInt("Choose 1 card to play with (number from 1 - 3)!");
        while(index>3 || index<1 ||((players.get(i).getCards().get(index-1) instanceof ShootCard && Collections.frequency(aimers, true)==0))||((players.get(i).getCards().get(index-1) instanceof AimCard && Collections.frequency(aimers, true)==6))){
            index = ZKlavesnice.readInt("You cant play this card! (out of range or unplayable\nChoose another: ");
        }
        this.pos=index;
        return players.get(i).getCards().get(index-1);
    }


    private void  printGame(){
        String s,b="";
        System.out.println("---------------------------------------------");
        for (int i =0; i<6;i++){
            if(aimers.get(i)){
                 s="Aimed";
            }else{
                 s="NotAimed";
            }
            if(Objects.equals(pond.get(i).getName(), "Duck")){
                b=" owned by "+pond.get(i).getOwner().getName();
            }

            System.out.println(i+1+". ◍ "+s+" - "+pond.get(i).getName()+b);
            b="";
        }
        System.out.println("---------------------------------------------");
    }


    private void initializeDeck(){
        this.deck = new ArrayList<>(34);
        deck.add(new DuckDance());
        deck.add(new Rosambo());
        deck.add(new Rosambo());
        for (int i=0;i<12;i++){
            deck.add(new ShootCard());
            if(i<6)
                deck.add(new DuckWalk());
            if(i<10)
                deck.add(new AimCard());
        }
        deck.add(new WildBill());
        deck.add(new WildBill());
        deck.add(new TurboDuck());
        Collections.shuffle(deck);


    }

    private void initializePondCards(){
        this.pondCards = new ArrayList<>();
        for(int i=0;i<5;i++){
            pondCards.add(new Water());
        }


    }
    private void initializePond(){
        this.pond = new ArrayList<>();
        for (int i=0;i<6;i++){
            pond.add(pondCards.get(0));
            pondCards.remove(0);

        }
    }

    private void initializeCards(int numberPlayers){
        for(int i=0;i<numberPlayers;i++) {
            ArrayList<ActionCards> a = new ArrayList<>(deck.subList(0, 3));
            deck.subList(0, 3).clear();
            players.get(i).setCards(a);
        }
    }

}
