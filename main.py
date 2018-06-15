#!usr/bin/env python3

#arp <3

"""

Hangman Game
a game where you will try to guess a word by guessing
each individual letter of that word

"""

import random

def main():
    print("This is a simple fun-filled game where you try to guess the hidden word, " + "\n" +
          "you can guess an individual letter OR the entire word of your choosing. " + "\n" +
          "You have 10 lives, good luck!")
    
    retry = "y"
    """ while loop that loops as long as you want to retry """
    while retry == "y":
        
        """ initialzation """
        word_bank = ["snake", "zebra", "slay", "howdy", "rhyme"]
        text = []
        wrong_guesses = []
        
        random_word = word_bank[random.randint(0, 4)]   # chooses random word from bank
        not_play = False
        
        wrong = 0                                       # a variable that will increment every time you guess wrong
        guess = 0                                       # a variable tht checks how many times you guess


        for letter in random_word:                      # appends blanks to the text that represent the hidden letters of the randomly chosen word
            text.append("_")
    
        """ while loop that loops as long as your lives are less than 0 and you're still playing """
        while wrong < 10 and not not_play:
            print(text)                                  # shows the blank word with the underscores
            ltr_guess = input("Guess a letter: ")

            if random_word.find(ltr_guess) == -1:     # if the guessed letter isn't contained in the secret word
                wrong += 1
                guess += 1
                wrong_guesses.append(ltr_guess)
                print("Ahh! You have "  + str(wrong - 10) + " lives left. " + ",".join(wrong_guesses))
            

            else:
                guess += 1
                text[random_word.find(ltr_guess)] = ltr_guess    # gets index of the random word which corresponds to the guessed letter and inserts it 
            
            """ asks each time you guess, if you want to guess the entire word or not """
            y_or_n = input("Do you want to guess the entire word?(y/n) ").lower()
            entire_word = ""
            if y_or_n == "y":           
                entire_word = input("The word: ")
                wrong = 10                                      # game proclaims you win (the win cooditional statement) if you guess the entire word
            
            # win conditional
            if "".join(text) == random_word or entire_word == random_word:   # if the entered text equals the randomly chosen word, print this message
                print("You won!! Got it in " + str(guess) + " tries!")
                not_play = True
                retry = input("Would you like to play again? Enter (y/n): ").lower()

            # lose conditional 
            if wrong >= 10 and not not_play:                                  # if you guess 10 times, prints this message and prompt the user to play again or not
                print("You lost hangman!! " + "\n" + "The word was " + random_word)
                not_play = True
                retry = input("Would you like to play again? Enter (y/n): ").lower()
                
            else:
                print("Let's go!")
    
            
                

if __name__ == "__main__":
    main()
