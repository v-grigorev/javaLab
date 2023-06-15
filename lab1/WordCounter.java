public class WordCounter {
    public static void main(String[] args) {
        Stats stats = new Stats("./input/input.txt");
        CSVWriter.write(stats, "outStats.txt");
    }
}
