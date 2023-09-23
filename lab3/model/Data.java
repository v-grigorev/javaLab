package model;

public class Data {
    public int length;  //x
    public int width;   //y
    public int mineCount;
    public Cell[] field;
    public Data() {
        length = 9;
        width = 9;
        mineCount = 10;
    }

    public void makeField(Data data) {
        data.field = new Cell[data.length * data.width];
        for (int i = 0; i < data.length * data.width; i++) {
            data.field[i] = new Cell();
        }

    }
}
