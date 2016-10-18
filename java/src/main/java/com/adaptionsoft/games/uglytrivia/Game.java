package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Game {
    ArrayList players = new ArrayList();
    int[] places = new int[6];
    int[] purses  = new int[6];
    boolean[] inPenaltyBox  = new boolean[6];

    LinkedList<String> popQuestions = new LinkedList<String>();
    LinkedList<String> scienceQuestions = new LinkedList<String>();
    LinkedList<String> sportsQuestions = new LinkedList<String>();
    LinkedList<String> rockQuestions = new LinkedList<String>();
    
    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;
    
    public  Game(){
    	for (int i = 0; i < 50; i++) {
			popQuestions.addLast(createQuestion("Pop", i));
			scienceQuestions.addLast(createQuestion("Science", i));
			sportsQuestions.addLast(createQuestion("Sports", i));
			rockQuestions.addLast(createQuestion("Rock", i));
    	}
    }

	public String createQuestion(String category, int index){
		return category + " Question " + index;
	}

	public boolean add(String playerName) {

	    players.add(playerName);
	    places[howManyPlayers()] = 0;
	    purses[howManyPlayers()] = 0;
	    inPenaltyBox[howManyPlayers()] = false;
	    
	    System.out.println(playerName + " was added");
	    System.out.println("They are player number " + howManyPlayers());
		return true;
	}
	
	public int howManyPlayers() {
		return players.size();
	}

	public void roll(int roll) {
		System.out.println(players.get(currentPlayer) + " is the current player");
		System.out.println("They have rolled a " + roll);
		
		if (inPenaltyBox[currentPlayer]) {
			if (roll % 2 != 0) {
				updateIsGettingOutOfPenaltyBox(true);
				advancePlayerPlace(roll);
			} else {
				updateIsGettingOutOfPenaltyBox(false);
			}
			
		} else {
			advancePlayerPlace(roll);
		}
		
	}

	private void updateIsGettingOutOfPenaltyBox(boolean isGettingOut)
	{
		isGettingOutOfPenaltyBox = isGettingOut;
		String message = " is getting out of the penalty box";
		if (!isGettingOut) {
			message = " is not getting out of the penalty box";
		}
		System.out.println(players.get(currentPlayer) + message);
	}

	private void advancePlayerPlace(int roll) {
		places[currentPlayer] = places[currentPlayer] + roll;
		if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

		System.out.println(players.get(currentPlayer)
				+ "'s new location is "
				+ places[currentPlayer]);
		System.out.println("The category is " + currentCategory());
		askQuestion();
	}

	private void askQuestion() {
		if (currentCategory() == "Pop")
			System.out.println(popQuestions.removeFirst());
		if (currentCategory() == "Science")
			System.out.println(scienceQuestions.removeFirst());
		if (currentCategory() == "Sports")
			System.out.println(sportsQuestions.removeFirst());
		if (currentCategory() == "Rock")
			System.out.println(rockQuestions.removeFirst());		
	}
	
	
	private String currentCategory() {
		switch(places[currentPlayer]) {
			case 0:
			case 4:
			case 8:
				return "Pop";
			case 1:
			case 5:
			case 9:
				return "Science";
			case 2:
			case 6:
			case 10:
				return "Sports";
			case 3:
			case 7:
			default:
				return "Rock";
		}
	}

	public boolean wasCorrectlyAnswered() {
		if (inPenaltyBox[currentPlayer]){
			if (isGettingOutOfPenaltyBox) {
				return handleCorrectAnswer("Answer was correct!!!!");
			} else {
				setCurrentPlayer();
				return true;
			}
		} else {
			return handleCorrectAnswer("Answer was corrent!!!!");
		}
	}

	private boolean handleCorrectAnswer(String msg) {
		updatePurse(msg);
		printPurse();

		boolean winner = didPlayerWin();
		setCurrentPlayer();

		return winner;
	}

	private void setCurrentPlayer() {
		currentPlayer++;
		if (currentPlayer == howManyPlayers()) currentPlayer = 0;
	}

	private void printPurse() {
		System.out.println(players.get(currentPlayer)
                + " now has "
                + purses[currentPlayer]
                + " Gold Coins.");
	}

	private void updatePurse(String msg) {
		System.out.println(msg);
		purses[currentPlayer]++;
	}

	public boolean wrongAnswer(){
		System.out.println("Question was incorrectly answered");
		System.out.println(players.get(currentPlayer)+ " was sent to the penalty box");
		inPenaltyBox[currentPlayer] = true;

		setCurrentPlayer();
		return true;
	}


	private boolean didPlayerWin() {
		return !(purses[currentPlayer] == 6);
	}
}
