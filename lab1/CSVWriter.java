import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public class CSVWriter {

    public static void write(Stats stats, String outputFileName) {
        try (FileWriter fileWriter = new FileWriter(outputFileName)) {
            ArrayList<Map.Entry<String, Integer>> list = stats.getArrayList();

            var comparator = new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    int res = (o2.getValue().compareTo(o1.getValue()));
                    if (res == 0)
                        return o1.getKey().compareTo(o2.getKey());
                    else
                        return res;
                }
            };

            //list.sort(Map.Entry.comparingByValue(comparator));
            list.sort(comparator);
            for (var elem : list) {
                float frequency = (float)elem.getValue() / stats.getGeneralCount();
                fileWriter.write(elem.getKey() + ","
                        + elem.getValue() + "," + (frequency * 100) + "\n");
            }


        } catch (IOException e) {
            System.err.println("Error while writing file: " + e.getLocalizedMessage());
        }
    }
}
