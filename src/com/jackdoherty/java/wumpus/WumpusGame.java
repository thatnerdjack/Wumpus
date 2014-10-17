package com.jackdoherty.java.wumpus;/* class com.jackdoherty.java.wumpus.WumpusGame -- main game class; provides main loop and some utilities.  */

import java.io.*;

public class WumpusGame {

	public static WumpusMap map = new WumpusMap();
	public static boolean gameActive = true;
	
	public static int currentRoomIndex = 1;
    public static int fatigueNum = 100;
	
	// special i/o method required because Eclipse does not provide a Console object
	private static String readLine(String prompt) {
	        String line = null;
	        Console c = System.console();
	        if (c != null) {
	             line = c.readLine(prompt);
	        } else {
	            System.out.print(prompt);
	            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	            try {
	                 line = bufferedReader.readLine();
	            } catch (IOException e) { 
	                //Ignore    
	            }
	        }
	        return line;
	 }

	
	public static void shootArrow(String input) {
		String direction = input.substring(6);  // direction should be input after "shoot " part
		int dirNum = WumpusMap.directionNumber(direction);
		if (dirNum == 0) {
			System.out.println("Huh?");   // bad shoot direction
		} else {
			WumpusRoom room = currentRoom();
			WumpusRoom targetRoom = room.roomInDirection(dirNum); 
			if (targetRoom != null) {
				if (targetRoom.getElement() != null && (targetRoom.getElement() instanceof WumpusElement)) {
					System.out.println("You shoot the wumpus.  Victory!!");
					gameActive = false;
				} else {
					System.out.println("You missed and scared the wumpus.");
					map.moveWumpus();
				}
			} else {
				System.out.println("Can't fire that way.");
			}
		}
	}

    public static String fatigueLevel(int ammount, String effect) {
        if (fatigueNum < 1 && effect == "down") {
                gameActive = false;
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
	
	public static WumpusRoom currentRoom() {
		return map.getRoom(currentRoomIndex);
	}
	
	public static void main(String[] args) {
		
		map.addElement(new WumpusElement());
        map.addElement(new PitElement());
        map.addElement(new PitElement());
        map.addElement(new BatElement());
        map.addElement(new BatElement());
        map.addElement(new FoodElement());
        map.addElement(new FoodElement());
        map.addElement(new FoodElement());
        RoomElement isFood = new FoodElement();
		
		currentRoomIndex = map.randomEmptyRoom();
		
		do  {
			map.getRoom(currentRoomIndex).printInfo();
			String userInput = readLine("> ");			
			int direction = 0;
			if (userInput.startsWith("shoot")) {
				shootArrow(userInput);
                System.out.println(fatigueLevel(5, "down"));
			} else if ((direction = WumpusMap.directionNumber(userInput)) != 0) {
				WumpusRoom nowRoom = map.getRoom(currentRoomIndex);
				WumpusRoom targetRoom = nowRoom.roomInDirection(direction);
				if (targetRoom != null) {
					currentRoomIndex = targetRoom.getIndex();
					targetRoom.handleElement();
                    if (targetRoom.getElement() != isFood) //not working. start here.
                    System.out.println(fatigueLevel(1, "down"));
				} else {
					System.out.println("You can't move in that direction.");
				}
			} else if (userInput.equals("bye")) {
                gameActive = false;
            } else if (userInput.equals("fatigue")) {
                System.out.println("You have a " + fatigueNum + " fatigue level.");
			} else {
				System.out.println("Command not understood.");
			}
		} while (gameActive);
		System.out.println("GAME OVER");
	}

}
