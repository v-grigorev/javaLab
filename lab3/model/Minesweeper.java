package model;
import controller.TextController;
import view.NewTextDisplay;
import view.TextDisplay;

import java.util.Random;

public class Minesweeper {
    static public void game(String gameMode) {
        if (gameMode.equals("text")) {
            while (true) {
                NewTextDisplay textDisplay = new NewTextDisplay();
                TextController textController = new TextController();
                textDisplay.menu();
                int result = textController.menuOption();
                switch (result) {
                    case 1: {
                        Data data = new Data();
                        textDisplay.getConfig();
                        textController.setConfig(data);

                        textDisplay.print(data);  // первый раз показать поле
                        textDisplay.getFirstMove();
                        String arguments = textController.getFirstMove(data);  // данные для ПЕРВОГО хода: x, y
                        Minesweeper.makeFirstMove(data, arguments);
                        textDisplay.print(data);
                        while (true) {
                            arguments = textController.getData(data);
                            boolean check = Minesweeper.makeMove(data, arguments);
                            if (!check) {
                                System.out.println("boom\nYou lost");
                                break;
                            }
                            if (data.mineCount == 0) {
                                textDisplay.print(data);
                                System.out.println("You win!");
                                System.exit(0);
                            }
                            textDisplay.print(data);
                        }
                    }
                    case 2: {
                        System.out.print("Goodbye!");
                        System.exit(0);
                    }
                }
            }
        }
    }

    private static boolean makeMove(Data data, String str) {
        String[] arguments = str.split(" ");
        int x = Integer.parseInt(arguments[0]);
        int y = Integer.parseInt(arguments[1]);
        char flag = arguments[2].charAt(0);
        if (data.field[y * data.length + x].isBomb) {
            if (flag == 'o') {
                return false;
            } else {
                data.field[y * data.length + x].symbol = 'f';
                data.mineCount--;
                return true;
            }
        } else {
            if (flag == 'o') {
                data.field[y * data.length + x].symbol = (char) ('0' + data.field[y * data.length + x].bombCount);
                return true;
            } else {
                data.field[y * data.length + x].symbol = 'f';
                return true;
            }
        }
    }

    private static void makeFirstMove(Data data, String str) {
        String[] arguments = str.split("\\s+");
        int x = Integer.parseInt(arguments[0]);
        int y = Integer.parseInt(arguments[1]);
        //char flag = arguments[2].charAt(0);
        //data.field[data.length * y + x].symbol = flag;

        int max = data.length * data.width + 1;
        Random random = new Random();
        int i = 0;
        while (i < data.mineCount) {
            int num = random.nextInt(max); //???
            if (data.field[num].isBomb || (num == y * data.length + x)) {
                continue;
            }
            data.field[num].isBomb = true;
            i++;
        }
        fillField(data);
        data.field[y * data.length + x].symbol = (char) ('0' + data.field[y * data.length + x].bombCount);
    }

    private static void fillField(Data data) {
        for (int i = 0; i < data.length * data.width; i++) {
            if (data.field[i].isBomb) {
                continue;
            }
            data.field[i].bombCount = getBombCount(data, i);
        }
    }

    private static int getBombCount(Data data, int num) {
        int bombCount = 0;
        int cellIndex = num;
        switch (getPosition(data, num)) {
            case 0 -> {
                if (data.field[cellIndex - data.length - 1].isBomb)
                    bombCount++;
                if (data.field[cellIndex - data.length].isBomb)
                    bombCount++;
                if (data.field[cellIndex - data.length + 1].isBomb)
                    bombCount++;
                if (data.field[cellIndex - 1].isBomb)
                    bombCount++;
                if (data.field[cellIndex + 1].isBomb)
                    bombCount++;
                if (data.field[cellIndex + data.length - 1].isBomb)
                    bombCount++;
                if (data.field[cellIndex + data.length].isBomb)
                    bombCount++;
                if (data.field[cellIndex + data.length + 1].isBomb)
                    bombCount++;
            }
            case 1 -> {
                if (data.field[cellIndex + 1].isBomb)
                    bombCount++;
                if (data.field[cellIndex + data.length].isBomb)
                    bombCount++;
                if (data.field[cellIndex + data.length + 1].isBomb)
                    bombCount++;
            }
            case 2 -> {
                if (data.field[cellIndex - 1].isBomb)
                    bombCount++;
                if (data.field[cellIndex + 1].isBomb)
                    bombCount++;
                if (data.field[cellIndex + data.length - 1].isBomb)
                    bombCount++;
                if (data.field[cellIndex + data.length].isBomb)
                    bombCount++;
                if (data.field[cellIndex + data.length + 1].isBomb)
                    bombCount++;
            }
            case 3 -> {
                if (data.field[cellIndex - 1].isBomb)
                    bombCount++;
                if (data.field[cellIndex + data.length - 1].isBomb)
                    bombCount++;
                if (data.field[cellIndex + data.length].isBomb)
                    bombCount++;
            }
            case 4 -> {
                if (data.field[cellIndex - data.length].isBomb)
                    bombCount++;
                if (data.field[cellIndex - data.length + 1].isBomb)
                    bombCount++;
                if (data.field[cellIndex + 1].isBomb)
                    bombCount++;
                if (data.field[cellIndex + data.length].isBomb)
                    bombCount++;
                if (data.field[cellIndex + data.length + 1].isBomb)
                    bombCount++;
            }
            case 5 -> {
                if (data.field[cellIndex - data.length - 1].isBomb)
                    bombCount++;
                if (data.field[cellIndex - data.length].isBomb)
                    bombCount++;
                if (data.field[cellIndex - 1].isBomb)
                    bombCount++;
                if (data.field[cellIndex + data.length - 1].isBomb)
                    bombCount++;
                if (data.field[cellIndex + data.length].isBomb)
                    bombCount++;
            }
            case 6 -> {
                if (data.field[cellIndex - data.length - 1].isBomb)
                    bombCount++;
                if (data.field[cellIndex - data.length].isBomb)
                    bombCount++;
                if (data.field[cellIndex - data.length + 1].isBomb)
                    bombCount++;
                if (data.field[cellIndex + 1].isBomb)
                    bombCount++;
            }
            case 7 -> {
                if (data.field[cellIndex - data.length - 1].isBomb)
                    bombCount++;
                if (data.field[cellIndex - data.length].isBomb)
                    bombCount++;
                if (data.field[cellIndex - data.length + 1].isBomb)
                    bombCount++;
                if (data.field[cellIndex - 1].isBomb)
                    bombCount++;
                if (data.field[cellIndex + 1].isBomb)
                    bombCount++;
            }
            case 8 -> {
                if (data.field[cellIndex - data.length - 1].isBomb)
                    bombCount++;
                if (data.field[cellIndex - data.length].isBomb)
                    bombCount++;
                if (data.field[cellIndex - 1].isBomb)
                    bombCount++;
            }
        }
        return bombCount;
    }

    private static int getPosition(Data data, int num) {
        int x = num % data.length;
        int y = num /data.width;
        if (y == 0) {
            if (x == 0)
                return 1;
            if (x == data.length - 1)
                return 3;
            return 2;
        }
        if (y == data.width - 1) {
            if (x == 0)
                return 6;
            if (x  == data.length - 1)
                return 8;
            return 7;
        }
        if (x == 0)
            return 4;
        if (x == data.length - 1)
            return 5;
        return 0;
    }

}
