package org.example;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {

	/*
	 * 1) Welcome message 2) Check whether user is ready to play the game or
	 * not. 3) If user is ready then display the default number. 4) Check
	 * whether it's correct or not. 5) If not then ask the user to enter the I/P
	 * whether the guessing number is HIGHER or LOWER. 6) Iterate thru the same
	 * logic till the number matches. 7) Display the confirmation.
	 * 
	 */

	private int temp;
	private int min;
	private int max;

	public App() {
		temp = 50;
		max = 100;
	}

	public void resetApp() {
		min = 0;
		max = 100;
		temp = 50;
	}

	public static void main(String[] args) {
		App app = new App();
		System.out.println("Let's start the game, guess any number and type 'ready' once you are ready.");
		Scanner userInput = new Scanner(System.in);
		while (true) {
			try {
				try {
					app.startTheGame(userInput);
				} catch (QuitException e) {
					System.out.println("Sorry :( you are leaving... Please come back again!!!");
					System.exit(0);
				} catch (SuccessException e) {
					System.out.println("Hurray I did it... Do you want to play again...!!!");
				}
			} catch (InvalidRespException e) {
				System.out.println("You can only enter 'Ready' or 'Quit'!!!");
			}
		}
	}

	private void startTheGame(Scanner userInput) throws InvalidRespException, QuitException, SuccessException {

		if (isUserReady(userInput.next())) {
			boolean gameEnd = false;
			while (!gameEnd) {
				System.out.println("Is the Nunmber in your mind : " + temp + " (You Can Say Higher/Lower/Yes)");
				try {
					gameEnd = findTheNumber(userInput.next());
				} catch (InvalidRespException e) {
					System.out.println("You can only enter 'Higher' or 'Lower' or 'Yes'!!!");
				}

			}
		}
	}

	private boolean findTheNumber(String userInput) throws InvalidRespException, SuccessException {

		int numberCheck = checkNumberHigherOrLower(userInput);
		if (numberCheck == 0) {
			throw new SuccessException();
		} else if (numberCheck == -1) {
			max = temp;
			temp = guessTheNumber(max, min);
			return false;
		} else if (numberCheck == 1) {
			min = temp;
			temp = guessTheNumber(max, min);
			return false;
		}
		return false;

	}

	private boolean isUserReady(String userInput) throws InvalidRespException, QuitException {
		if ("ready".equalsIgnoreCase(userInput)) {
			return true;
		} else if ("quit".equalsIgnoreCase(userInput)) {
			throw new QuitException();
		} else {
			throw new InvalidRespException();
		}
	}

	private int checkNumberHigherOrLower(String userInput) throws InvalidRespException {
		if ("higher".equalsIgnoreCase(userInput)) {
			return 1;
		} else if ("lower".equalsIgnoreCase(userInput)) {
			return -1;
		} else if ("yes".equalsIgnoreCase(userInput)) {
			return 0;
		} else {
			throw new InvalidRespException();
		}
	}

	private int guessTheNumber(int min, int max) {
		return (min + max) / 2;
	}

}
