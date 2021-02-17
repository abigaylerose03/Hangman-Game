// Name: Abigayle Peterson
// Date: Feb 10, 2021
// Academic Honesty Statement: I affirm that I have not given or received any unauthorized help on this assignment, and that this work is my own. - Abigayle Peterson
// The purpose of this project is to demonstrate understanding the role of the Scanner class and basic arithmetic operators.

import java.util.*;
import java.lang.*;
import java.io.*;
public class Hangman {
	private static final boolean testingMode = true;
	private static int guessesRemaining;
	private static int maxSpace; // the maximum number of spaces someone can enter
	private static int[] spaceNum; // number of spaces entered to check
	private static int index; // the index of the word we want to find
	private static boolean won = false;
	private static String[] marks; // the array holding '-'
	private static String newMark; // the String version of the String array marks to print it out

	public static void main(String[] args) {


		Scanner scanDiff = new Scanner(System.in);

		System.out.println("Enter your difficulty: Easy (e), Intermediate (i), or Hard (h)");
		String diffLevel = scanDiff.nextLine();
		if(diffLevel.contains("e")) {
			maxSpace = 4;
			newGame(15, "e");

			// if user loses
			if(guessesRemaining == 0) {
				Scanner input = new Scanner(System.in);
				System.out.println("You have failed to guess the word... :( Would you like to play again? Yes(y) or No(n)");
				String choice = input.nextLine();

				if(choice.equals("y")) {
					maxSpace = 4;
					newGame(15, "e");
					won = false;
				} else if(choice.equals("n")) {
					System.exit(0);
					won = false;
				}
				
			}
			// if user won
			if(won) {
				Scanner input = new Scanner(System.in);
				System.out.println("You have guessed the word! Congratulations" + "\n" + "Would you like to play again? Yes(y) or No(n)");
				String choice = input.nextLine();


				if(choice.equals("y")) {
					maxSpace = 4;
					newGame(15, "e");
					won = false;
				} else if(choice.equals("n")) {
					System.exit(0);
					won = false;
				}

			}
		
			  // valid checks that the user only enters a speficied number of spaces
			if(spaceNum.length < 4 || spaceNum.length > 4) {
			 	System.out.println("Your input is not valid. Try again.");
				System.out.println("Guesses remaining: " + guessesRemaining);
			} 


		} else if(diffLevel.contains("i")) {
			maxSpace = 3;
			newGame(12, "i");

			// if user loses
			if(guessesRemaining == 0) {
				Scanner input = new Scanner(System.in);
				System.out.println("You have failed to guess the word... :( Would you like to play again? Yes(y) or No(n)");
				String choice = input.nextLine();

				if(choice.equals("y")) {
					maxSpace = 4;
					newGame(15, "e");
					won = false;
				} else if(choice.equals("n")) {
					System.exit(0);
					won = false;
				}
				
			}
			// if user won
			if(won) {
				Scanner input = new Scanner(System.in);
				System.out.println("You have guessed the word! Congratulations" + "\n" + "Would you like to play again? Yes(y) or No(n)");
				String choice = input.nextLine();


				if(choice.equals("y")) {
					maxSpace = 4;
					newGame(15, "e");
					won = false;
				} else if(choice.equals("n")) {
					System.exit(0);
					won = false;
				}

			}

			if(spaceNum.length < 3 || spaceNum.length > 3) {
				System.out.println("Your input is not valid. Try again.");
				System.out.println("Guesses remaining: " + guessesRemaining);
			}  

		} else if(diffLevel.contains("h")) {
			maxSpace = 2;
			newGame(10, "h");

			// if user loses
			if(guessesRemaining == 0) {
				Scanner input = new Scanner(System.in);
				System.out.println("You have failed to guess the word... :( Would you like to play again? Yes(y) or No(n)");
				String choice = input.nextLine();

				if(choice.equals("y")) {
					maxSpace = 4;
					newGame(15, "e");
					won = false;
				} else if(choice.equals("n")) {
					System.exit(0);
					won = false;
				}
				
			}
			// if user won
			if(won) {
				Scanner input = new Scanner(System.in);
				System.out.println("You have guessed the word! Congratulations" + "\n" + "Would you like to play again? Yes(y) or No(n)");
				String choice = input.nextLine();


				if(choice.equals("y")) {
					maxSpace = 4;
					newGame(15, "e");
					won = false;
				} else if(choice.equals("n")) {
					System.exit(0);
					won = false;
				}

				won = false;

			}

			if(spaceNum.length < 2 || spaceNum.length > 2) {
				System.out.println("Your input is not valid. Try again.");
				System.out.println("Guesses remaining: " + guessesRemaining);
			}  
		}	

	}

	public static void newGame(int numGuesses, String mode) {
		// the word when found
		char[] wordFound;
		String[] answer;


		// the word you want to find
		String wordToFind = RandomWord.newWord();
		String[] word = wordToFind.split(""); // converts the random word to a String array
		String[] marks = new String[word.length]; // convert the marks to a string array



		for(int i = 0; i < word.length; i++) {
			marks[i] = "-"; // adds the dashes inside the marks array
		}



		if(testingMode) {
				boolean found = false;
				
				// max number of spaces a user can enter according to level difficulty

				System.out.println("The secret word is: " + wordToFind);
				System.out.println("The word is: " + String.join("", marks));

		
				while(numGuesses > 0 && won == false) {
					

					Scanner scan = new Scanner(System.in);
					System.out.println("Please enter the letter you want to guess: ");
					String letter = String.valueOf(scan.next(".").charAt(0));

					// gets the first character only

					if(!Character.isLetter(letter.charAt(0))) {
						found = false;
						System.out.println("Your input is not valid. Try again.");
						System.out.println("Guesses Remaining: " + numGuesses);

					} else {
						Scanner scanner = new Scanner(System.in);
						System.out.println("Please enter the spaces you want to check (separated by spaces): ");
						String spaces = scanner.nextLine();

						String[] spacesArr = spaces.split(" "); // put the spaces you want to check in an array like [0, 2, 4]
						// char[] spacesArr = spaces.toCharArray();

						spaceNum = new int[maxSpace];


						// loops through the word and the spaces 
						for(int i = 0; i < word.length; i++) {

							 for (int j = 0; j < spacesArr.length; j++) {
							 	spaceNum[j] = Integer.parseInt(spacesArr[j]); // turns spaces into ints
							 	index = wordToFind.indexOf(letter);
						            if(word[i].equals(letter)){
						            	if(spaceNum[j] == index) {
						            		marks[i] = word[i]; // replaces the '-' with the appropriate word index
						                	found = true; // sets found to true to output message
						            	}
						               
						            }
						      }

					    
						  
						} // end of nested for loop

				
						   
						if(found) {
							System.out.println("You guessed correctly!");
							newMark = String.join("", marks);
							System.out.println("The updated word is: " + newMark);
							System.out.println("Guesses remaining: " + numGuesses);
							found = false;


							if(!newMark.contains("-")) {
								won = true;
							}


						} else {
					  		numGuesses--;
					  		System.out.println("Your letter was not found in the spaces you provided.");
							System.out.println("Guesses remaining: " + numGuesses);
					  	}
				
						guessesRemaining = numGuesses;


					
					}

				} // end of while loop



				

				
		}
	}
}

