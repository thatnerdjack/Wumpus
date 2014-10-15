package com.jackdoherty.java.wumpus;

public class WumpusElement extends RoomElement {

	public void handle() {
		System.out.println("You are eaten by the wumpus!");
		WumpusGame.gameActive = false;
	}
	
	public void printSenses() {
		System.out.println("You smell a wumpus.");
	}
}
