package controller;
import model.Data;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextController implements Controller {
    public int menuOption() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        str = str.toLowerCase();
        int res;
        loop : while (true) {
            switch (str) {
                case "play":
                    res = 1;
                    break loop;
                case "exit":
                    res = 2;
                    break loop;
                default: {
                    System.out.println("Unknown command");
                    str = scanner.nextLine();
                    str = str.toLowerCase();
                }
            }
        }
        return res;
    }

    public void setConfig (Data data) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                String str = scanner.nextLine();
                if (str.equals("")) {
                    return;
                }
                String[] parameters = str.split("\\s+");
                if (parameters.length > 2) {
                    throw new Exception("Wrong number of parameters");
                }
                String[] check = parameters[0].split("x");
                if (check[0].equals("0") || check[1].equals("0")) {
                    throw new Exception("Field cannot be size 0");
                }
                String pattern = "\\d+x\\d+";
                Pattern regexPattern = Pattern.compile(pattern);
                Matcher matcher = regexPattern.matcher(parameters[0]);
                if (!matcher.matches()) {
                    throw new Exception("Wrong field size");
                }
                String[] fieldSize = parameters[0].split("x");
                data.length = Integer.parseInt(fieldSize[0]);
                data.width = Integer.parseInt(fieldSize[1]);
                if (parameters.length == 2) {
                    data.mineCount = Integer.parseInt(parameters[1]);
                }
                data.makeField(data);
                return;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String getData(Data data) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                String str = scanner.nextLine();
                String[] arguments = str.split("\\s+");
                if (arguments.length != 3) {
                    System.out.println("Wrong number of arguments");
                    continue;
                }
                int check = Integer.parseInt(arguments[0]);
                if (check >= data.length) {
                    System.out.println("Overstepping the field limits in the first argument");
                    continue;
                }
                check = Integer.parseInt(arguments[1]);
                if (check >= data.width) {
                    System.out.println("Overstepping the field limits in the second argument");
                    continue;
                }
                if (!arguments[2].equals("f") && !arguments[2].equals("o")) {
                    System.out.println("Invalid third argument");
                    continue;
                }
                return str;
            }
            catch (NumberFormatException e) {
                System.out.println("First and second arguments must be number");
            }

        }
    }

    public String getFirstMove(Data data) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                String str = scanner.nextLine();
                String[] arguments = str.split("\\s+");
                if (arguments.length != 2) {
                    System.out.println("Wrong number of arguments");
                    continue;
                }
                int check = Integer.parseInt(arguments[0]);
                if (check >= data.length) {
                    System.out.println("Overstepping the field limits in the first argument");
                    continue;
                }
                check = Integer.parseInt(arguments[1]);
                if (check >= data.width) {
                    System.out.println("Overstepping the field limits in the second argument");
                    continue;
                }
                return str;
            }
            catch (NumberFormatException e) {
                System.out.println("First and second arguments must be number");
            }

        }
    }
}
