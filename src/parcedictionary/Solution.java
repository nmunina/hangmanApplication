package parcedictionary;

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        File text = new File("/Users/nmunina/repo/hangmanApplication/dictionaryRaw.txt");
        String file1 = "/Users/nmunina/repo/hangmanApplication/dictionaryRaw.txt";
        String file2 = "/Users/nmunina/repo/hangmanApplication/dictionary.txt";
        // String oxfordLine = "© Oxford University";

        FileInputStream fileInputStream = new FileInputStream(file1);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        Scanner sc = new Scanner(text);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.contains("Oxford University Press")) {
                continue;
            }

            String word = line.split(" ")[0] + "\n";

            fileOutputStream.write(word.getBytes());
        }

        // read nextLine from file 1


        // find string begginning with "© Oxford University Press The Oxford 5000™ " delete

        // split(" ")
        // take [0]
        // write to file 2

        fileOutputStream.close();
        fileInputStream.close();
        sc.close();


    }
}
