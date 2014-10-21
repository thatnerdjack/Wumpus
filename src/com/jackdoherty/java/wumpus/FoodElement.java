package com.jackdoherty.java.wumpus;

/**
 * Created by block7 on 10/16/14.
 */
public class FoodElement extends RoomElement {

    public void handle() {
        System.out.println("You see some food!");
        GameOptions.fatigueAction("eat");
    }

    public void printSenses() {
        System.out.println("You smell something in the distance.");
    }

}
