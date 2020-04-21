package hangmanapplication;
// blondiebytes 2015 (c)
// author katrynhodge

import java.io.IOException;
import java.util.Scanner;

public class HangmanApplication {

    public static void main(String[] args) throws IOException {
	// how do we play the game

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to hangman! I will pick up a world and you will guess it. " +
                "If you guess wring 6 times I winn. If you guess  before - I winn. " +
                "Are you ready? I hope so, because I am!");

        System.out.println();
        System.out.println("I have picked my world. Below is a picture and below that is your current guess." +
                "Wich starts off with nothing. Every wrong guess I add hands, body etc. When the body is complete - you loose.");

        // allows multiply games
        boolean doYouWantToPlay = true;

        // setup game
        while (doYouWantToPlay) {
            //keep playing

            System.out.println("All right. Let's play!");

            Hangman game = new Hangman();

            do {
                // Draw the things
                System.out.println();
                System.out.println(game.drawPicture());
                System.out.println();
                System.out.println(game.getFormalCurrentGuess());
                System.out.println(game.mysteryWord);

                // Get the guess
                System.out.println("Enter a character that you think is in the word");
                char guess = (sc.next().toLowerCase()).charAt(0);

                // check if in is guessed already
                while (game.isGuessedAlready(guess)) {
                    System.out.println("Try again! You have already guessed this");
                    guess = (sc.next().toLowerCase()).charAt(0);
                }

                if (game.playGuess(guess)) {
                    System.out.println("Great guess! That character is in the word");
                } else {
                    System.out.println("Unfortunately it is in the word");
                }


                // Play the game

            }
            while(!game.isOver()); // keep playing untill over

            //play again?
            System.out.println();
            System.out.println("Do you want to play other game? Press Y if you do.");
            Character response = (sc.next().toUpperCase()).charAt(0);
            doYouWantToPlay = (response == 'Y');

        }

    }
}
