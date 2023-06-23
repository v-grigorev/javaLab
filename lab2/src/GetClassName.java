import java.io.*;

public class GetClassName {
    public static String get(String command) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./input/config.txt"));
            String l;
            while ((l = bufferedReader.readLine()) != null) {
                String[] configParts = l.split(" ");
                if (command.equals(configParts[0])) {
                    return configParts[1];
                }
            }
            throw new Exception("Wrong command");
        }
        catch (IOException e) {
            System.out.println("Config file not found");
            System.out.println("can't find ./input/config.txt");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "Error in GetClassName.get()";
    }

}
