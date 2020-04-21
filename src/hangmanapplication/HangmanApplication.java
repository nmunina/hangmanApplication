package hangmanapplication;
// blondiebytes 2015 (c)
// author katrynhodge

import java.util.Scanner;

public class HangmanApplication {

    public static void main(String[] args) {
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

            while(!game.isOver()) {

            }

            //play again?
            System.out.println();
            System.out.println("Do you want to play other game? Press Y if you do.");
            Character response = (sc.next().toUpperCase()).charAt(0);
            doYouWantToPlay = (response == 'Y');

        }

    }
}
