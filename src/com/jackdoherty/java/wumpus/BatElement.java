package com.jackdoherty.java.wumpus;

/**
 * Created by block7 on 10/7/14.
 */
public class BatElement extends RoomElement {

    public void handle() {
        System.out.println("A bat picks you up and moves you into a different room.");
        WumpusGame.currentRoomIndex = WumpusGame.map.randomEmptyRoom();
    }

    public void printSenses() {
        System.out.println("You hear fluttering and screeching noises.");
    }

}
