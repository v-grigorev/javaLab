package model;
public class Cell {
    boolean isBomb;
    int bombCount;
    public char symbol;
    public Cell() {
        isBomb = false;
        bombCount = 0;
        symbol = '*';
    }
}
