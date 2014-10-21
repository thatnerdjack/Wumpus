package com.jackdoherty.java.wumpus;

/**
 * Created by block7 on 10/17/14.
 */
public class GameOptions { //working on this

    public static int foodRestore = -1;
    final static int FOOD_RESTORE_EASY = 5;
    final static int FOOD_RESTORE_NORMAL = 3;
    final static int FOOD_RESTORE_HARD = 1;

    final static int SHOOT_COST = 5;
    final static int MOVE_COST = 1;

    public static int fatigueNum = -1;
    final static int FATIGUE_LEVEL_START_EASY = 50;
    final static int FATIGUE_LEVEL_START_NORMAL = 25;
    final static int FATIGUE_LEVEL_START_HARD = 10;

    public static void gameLevelSet(String input) {
        String rawLevel = WumpusGame.readLine(input);
        rawLevel.toLowerCase();
        if (rawLevel.equals("easy")) {
            foodRestore = FOOD_RESTORE_EASY;
            fatigueNum = FATIGUE_LEVEL_START_EASY;
        } else if (rawLevel.equals("normal")) {
            foodRestore = FOOD_RESTORE_NORMAL;
            fatigueNum = FATIGUE_LEVEL_START_NORMAL;
        } else if (rawLevel.equals("hard")) {
            foodRestore = FOOD_RESTORE_HARD;
            fatigueNum = FATIGUE_LEVEL_START_HARD;
        } else {
            gameLevelSet("That is not a valid option. Please type 'easy', 'normal', or 'hard'.");
        }
    }

    public static void fatigueAction(String effectType)/* possibilities: eat, shoot, move */{
        int moveCount = 0;
        if (effectType.equals("eat")) {
            fatigueNum = fatigueNum + foodRestore;
            System.out.println("You've gained back some energy. You now have " + fatigueNum + " energy!");
        } else if (effectType.equals("shoot")) {
            fatigueNum = fatigueNum - SHOOT_COST;
        } else if (effectType.equals("move")) {
            fatigueNum = fatigueNum - MOVE_COST;
            moveCount++;
            if (moveCount == 5) {
                System.out.println("You now have " + fatigueNum + " energy.");
            }
        } else {
            System.out.println("ERROR: INVALID PARAMETER");
        }
    }

}
