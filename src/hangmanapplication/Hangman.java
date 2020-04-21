package hangmanapplication;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Hangman {

    String mysteryWord;
    StringBuilder currentGuess;
    ArrayList<Character> previousGuesses = new ArrayList<>();

    int maxTry = 6;
    int currentTry = 0;

    ArrayList<String> dictionary = new ArrayList<>();

    private static FileReader fileReader;
    private static BufferedReader bufferedReader;

    public Hangman() throws IOException {
        initializeStreams();
       mysteryWord = pickWord();
       currentGuess = initializeCurrentGuess();
    }

    private void initializeStreams() throws IOException {
        try {
            File inFile = new File("/Users/nmunina/repo/hangmanApplication/dictionary.txt");
            fileReader = new FileReader(inFile);
            bufferedReader = new BufferedReader(fileReader);
            String currentLine = bufferedReader.readLine();

            while (currentLine !=null) {
                dictionary.add(currentLine);
                currentLine = bufferedReader.readLine();
            }

            bufferedReader.close();
            fileReader.close();

        } catch (IOException e) {
            System.out.println("Could not init streams");
        }
    }

    public String pickWord() {
        Random rand = new Random();
        int wordIndex = Math.abs(rand.nextInt()) % dictionary.size();
        return dictionary.get(wordIndex);
    }

    //_ A _ _ _ _ _
    public StringBuilder initializeCurrentGuess() {
        StringBuilder current = new StringBuilder();
        for (int i = 0; i < mysteryWord.length()*2; i++) {
            if (i % 2 == 0 ){
                current.append("_");
            } else {
                current.append(" ");
            }
        }
        return current;
    }

    // _ A _ _ B _ _
    public String getFormalCurrentGuess(){
        return "Current guess: " + currentGuess.toString();
    }

    public boolean isOver(){
        if(didWeWinn()) {
            System.out.println();
            System.out.println("Congratulations! You won!");
            return true;

        } else if (didWeLose()) {
            System.out.println();
            System.out.println("Sorry. You lost. The word was : " + mysteryWord);
            return true;
        }
        return false;
    }

    private boolean didWeLose() {
        return currentTry >= maxTry;
    }


    public boolean didWeWinn(){
        String guess = getCondencesedCurrentGuess();
        return guess.equals(mysteryWord);

    }
    private String getCondencesedCurrentGuess() {
        String guess = currentGuess.toString();
        return guess.replace(" ", "");
    }


    /*
    " - - - - -\n" +
    "|        |\n" +
    "|        O\n" +
    "|      / | \\ \n" +
    "|        |\n" +
    "|       / \\ \n" +
    "|\n" +
    "|\n";
     */
    public String drawPicture() {
        switch (currentTry) {
            case 0: return noPersonDraw();
            case 1: return addHeadDraw();
            case 2: return addBodyDraw();
            case 3: return addOneArmDraw();
            case 5: return addSecondArmDraw();
            case 6: return addFirstLeg();
            default: return fullPersonDraw();

        }

    }

    private String noPersonDraw() {
        return " - - - - -\n" +
                "|        |\n" +
                "|        \n" +
                "|       \n" +
                "|        \n" +
                "|        \n" +
                "|\n" +
                "|\n";
    }

    private String addHeadDraw() {
        return  " - - - - -\n" +
                "|        |\n" +
                "|        0\n" +
                "|       \n" +
                "|        \n" +
                "|        \n" +
                "|\n" +
                "|\n";
    }

    private String addFirstLeg() {
        return " - - - - -\n" +
                "|        |\n" +
                "|        O\n" +
                "|      / | \\ \n" +
                "|        |\n" +
                "|       /  \n" +
                "|\n" +
                "|\n";
    }

    private String addSecondArmDraw() {
        return  " - - - - -\n" +
                "|        |\n" +
                "|        O\n" +
                "|      / | \\ \n" +
                "|        |\n" +
                "|        \n" +
                "|\n" +
                "|\n";
    }

    private String addOneArmDraw() {
        return  " - - - - -\n" +
                "|        |\n" +
                "|        O\n" +
                "|      / |  \n" +
                "|        |\n" +
                "|        \n" +
                "|\n" +
                "|\n";
    }

    private String addBodyDraw() {
        return  " - - - - -\n" +
                "|        |\n" +
                "|        O\n" +
                "|        |  \n" +
                "|        |\n" +
                "|        \n" +
                "|\n" +
                "|\n";
    }

    private String fullPersonDraw() {
        return  " - - - - -\n" +
                "|        |\n" +
                "|        O\n" +
                "|      / | \\ \n" +
                "|        |\n" +
                "|       / \\ \n" +
                "|\n" +
                "|\n";
    }

    public boolean isGuessedAlready(char guess) {
        return previousGuesses.contains(guess);

    }

    public boolean playGuess(char guess) {
        boolean isItAGoodGuess = false;
        for (int i = 0; i < mysteryWord.length(); i++) {
            if (mysteryWord.charAt(i) == guess) {
                currentGuess.setCharAt(i *2, guess);
                isItAGoodGuess = true;
                previousGuesses.add(guess);
            }
        }

        if (!isItAGoodGuess) {
            currentTry++;
        }
        return isItAGoodGuess;
    }
}
