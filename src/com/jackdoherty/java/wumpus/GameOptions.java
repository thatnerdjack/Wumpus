package com.jackdoherty.java.wumpus;

/**
 * Created by block7 on 10/17/14.
 */
public class GameOptions { //working on this

    public static String gameLevel = null;

    public static String fatigue(int ammount, String effect) {
        if (WumpusGame.fatigueNum < 1 && effect == "down") {
            WumpusGame.gameActive = false;
            return "You've died...";
        } if (effect == "up" && WumpusGame.fatigueNum < 100) {
            WumpusGame.fatigueNum = WumpusGame.fatigueNum + ammount;
            return "You have a " + WumpusGame.fatigueNum + " fatigue level. You're getting back some energy!";
        } else if (effect == "down") {
            WumpusGame.fatigueNum = WumpusGame.fatigueNum - ammount;
            if ((WumpusGame.fatigueNum % 5) == 0) {
                return "You have a " + WumpusGame.fatigueNum + " fatigue level. You're loosing energy!";
            } else {
                return "";
            }
        } else if (effect == "up" && WumpusGame.fatigueNum >= 100) {
            return "You're full of energy and don't stop to eat.";
        } else {
            return "ERROR: INVALID PARAMETERS";
        }
    }

}
