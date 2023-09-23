package view;

import model.Data;

public interface Viewer {
    default void menu() {
        System.out.println("""
                              Choose option:
                              Play
                              Exit""");
    }
  
    default void getConfig() {
        System.out.println("Enter field size(LENGTHxWIDTH) and number of mines");
    }
  
    void print(Data data);
  
    default void getFirstMove() {
        System.out.println("""
                To make a move enter the cell number(X Y) and what you want to do:
                f - mine in this place
                o - open this cell
                
                To start the game, enter the coordinates of the cell you want to open(X Y)""");
    }
}
