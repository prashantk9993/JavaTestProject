package dsa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CountNumberOfWordsFromFile {

    public static void main(String[] args) throws FileNotFoundException {

        /*FileReader fr = new FileReader("abc.txt");
        BufferedReader br = new BufferedReader(fr);

       Long count = br.lines().count();

       System.out.println(count);*/

        try {
            FileReader fr = new FileReader("abc.txt");
            BufferedReader br = new BufferedReader(fr);
            int count = 0;
            String line;
            line = br.readLine();
            while (line != null) {
                for (int i = 0; i < line.length(); i++)
                    if (!Character.isWhitespace(line.charAt(i)))
                        count++;
                line = br.readLine();
            }
            br.close();
            System.out.println(count);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
