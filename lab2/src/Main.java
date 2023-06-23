import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                Scanner scanner = new Scanner(System.in);
                String line;
                while ((line = scanner.nextLine()) != null) {
                    if (line.equals("exit")) {
                        System.exit(0);
                    }
                    if (line.equals(""))
                        continue;
                    if (line.charAt(0) == '#')
                        continue;
                    String str = GetClassName.get(LineProcessing.getCommand(line));
                    Command command = CommandFactory.createCommand(str);
                    if (command == null)
                        continue;
                    command.makeCommand(LineProcessing.getArgument(line));
                }
            } else {
                String filename = args[0];            //  имя файла
                BufferedReader reader = new BufferedReader(new FileReader(filename));
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.equals(""))
                        continue;
                    if (line.charAt(0) == '#')
                        continue;

                    String str = GetClassName.get(LineProcessing.getCommand(line));
                    Command command = CommandFactory.createCommand(str);

                    assert command != null : "command == null";
                    command.makeCommand(LineProcessing.getArgument(line));
                }
            }
        }
        catch (IOException e) {
            System.out.println("Error reading file:" + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
