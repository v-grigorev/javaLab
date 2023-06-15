import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Stats {
    private final HashMap<String, Integer> map;
    int generalCount;

    Stats(String inputFileName) {
        map = new HashMap<String, Integer>();
        generalCount = 0;
        try (FileReader fileReader = new FileReader(inputFileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader))
        {
            while (true) {
                String readString = bufferedReader.readLine();
                if (readString == null) {
                    break;
                }
                String[] wordArr = readString.split("\\W+");
                addToStats(wordArr);
            }
        }
        catch (IOException e) {
            System.err.println("Error while reading file: " + e.getLocalizedMessage());
        }
    }

    public void addToStats(String[] wordArr) {
        for (String word : wordArr) {
            if (word.length() == 0)
                continue;
            map.merge(word, 1, Integer::sum);
            generalCount++;
        }
    }

    public int getGeneralCount() {
        return generalCount;
    }

    public ArrayList<Map.Entry<String, Integer>> getArrayList() {
        return new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
    }
}
