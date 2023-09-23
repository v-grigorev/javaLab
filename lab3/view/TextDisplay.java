package view;
import model.*;

public class TextDisplay implements Viewer {
    @Override
    public void print(Data data) {
        System.out.print(' ');
        for (int i = 0; i < data.length; i++)
            System.out.print(i);
        for (int i = 0; i < data.width; i++) {
            System.out.println();
            System.out.print(i);
            for (int j = 0; j < data.length; j++) {
                System.out.print(data.field[data.length * i + j].symbol);
            }
        }
        System.out.println();
    }
}
