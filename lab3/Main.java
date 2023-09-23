//import java.util.Scanner;
import model.Minesweeper;
public class Main {
    public static void main(String[] args) {
//        System.out.print("Select display mode: text or gui\n");
//        Scanner scanner = new Scanner(System.in);
        String displayMode = "text";
//        displayMode = scanner.nextLine();
//        while (!displayMode.equals("text") && !displayMode.equals("gui")) {
//            System.out.println("Can't read game mode.\nSelect text or gui");
//            displayMode = scanner.nextLine();
//        }

        Minesweeper.game(displayMode);

    }
}
