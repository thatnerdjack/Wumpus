package com.jackdoherty.java.wumpus;

/**
 * Created by block7 on 10/17/14.
 */
public class GameOptions { //working on this

    public static int gameLevel = -1;
    public static int fatigueNum = -1;

    final static int FOOD_RESTORE_EASY = 5;
    final static int FOOD_RESTORE_NORMAL = 3;
    final static int FOOD_RESTORE_HARD = 1;

    final static int SHOOT_COST = 5;
    final static int MOVE_COST = 1;

    final static int FATIGUE_LEVEL_START_EASY = 50;
    final static int FATIGUE_LEVEL_START_NORMAL = 25;
    final static int FATIGUE_LEVEL_START_HARD = 10;

    public static void gameLevelSet(String input) {
        String rawLevel = WumpusGame.readLine(input);
        rawLevel.toLowerCase();
        if (rawLevel == "easy") {
            gameLevel = 1;
        } else if (rawLevel == "normal") {
            gameLevel = 2;
        } else if (rawLevel == "hard") {
            gameLevel = 3;
        } else {
            gameLevelSet("That is not a valid option. Please type 'easy', 'medium', or 'hard'.");
        }
    }

    public static String fatigue(int ammount, String effect) {
        if (fatigueNum < 1 && effect == "down") {
            WumpusGame.gameActive = false;
            return "You've died...";
        } if (effect == "up" && fatigueNum < 100) {
            fatigueNum = fatigueNum + ammount;
            return "You have a " + fatigueNum + " fatigue level. You're getting back some energy!";
        } else if (effect == "down") {
            fatigueNum = fatigueNum - ammount;
            if ((fatigueNum % 5) == 0) {
                return "You have a " + fatigueNum + " fatigue level. You're loosing energy!";
            } else {
                return "";
            }
        } else if (effect == "up" && fatigueNum >= 100) {
            return "You're full of energy and don't stop to eat.";
        } else {
            return "ERROR: INVALID PARAMETERS";
        }
    }

}
