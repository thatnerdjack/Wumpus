package com.jackdoherty.java.wumpus;

/**
 * Created by block7 on 10/7/14.
 */
public class PitElement extends RoomElement {

    public void handle() {
        System.out.print("You have fallen into a bottomless pit.");
        WumpusGame.gameActive = false;
    }

    public void printSenses() {
        System.out.println("You feel a draft.");
    }

}