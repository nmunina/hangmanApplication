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
      //  initializeStreams();
       mysteryWord = pickWord;
       currentGuess = initializeCurrentGuess();
    }

    private void initializeStreams() throws IOException {
        try {
            File inFile = new File("dictionary.txt");
            fileReader = new FileReader(inFile);
            bufferedReader = new BufferedReader(fileReader);
            String currentLine = bufferedReader.readLine();

            while (currentLine !=null) {
                dictionary.add(currentLine);
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

    public StringBuilder initializeCurrentGuess() {
        StringBuilder current = new StringBuilder();
        for (int i = 0; i < mysteryWord.length()*2; i++) {
            if (i % 2 == 0 ){

            }
        }
    }

}
