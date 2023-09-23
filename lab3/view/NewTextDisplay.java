package view;

import model.Data;

public class NewTextDisplay implements Viewer {
    @Override
    public void print(Data data) {
        int widthCapacity;
        if (data.width == 1)
            widthCapacity = (int)Math.log10(data.width) + 1;
        else
            widthCapacity = (int)Math.log10(data.width - 1) + 1;
        int lengthCapacity = (int)Math.log10(data.length) + 2;
        int tmp;
        System.out.print("  ");
        for (int i = 0; i < data.length; i++) {
            if (i == 0) {
                tmp = lengthCapacity - 1;
            }
            else {
                tmp = lengthCapacity - (int) Math.log10(i) - 1;
            }
            while (tmp != 0) {
                System.out.print(' ');
                tmp--;
            }
            System.out.print(i);
        }


        System.out.println();
        System.out.print("  ");
        for (int i = 0; i < data.length * lengthCapacity; i++) {
            System.out.print('-');
        }

        for (int i = 0; i < data.width; i++) {
            System.out.println();

            if (i == 0) {
                tmp = widthCapacity - 1;
            }
            else {
                tmp = widthCapacity - ((int) Math.log10(i) + 1);
            }
            while (tmp != 0) {
                System.out.print(' ');
                tmp--;
            }
            System.out.print(i + "|");


            for (int j = 0; j < data.length; j++) {
                if (j == 0)
                    tmp = Math.abs(lengthCapacity - widthCapacity);
                else
                    tmp = lengthCapacity - 1;
                while (tmp != 0) {
                    System.out.print(' ');
                    tmp--;
                }
                System.out.print(data.field[data.length * i + j].symbol);
            }
        }
        System.out.println();
    }
}
