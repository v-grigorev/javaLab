package controller;

import model.Data;

public interface Controller {
    int menuOption();
    void setConfig (Data data);
    String getData(Data data);
    public String getFirstMove(Data data);
}
