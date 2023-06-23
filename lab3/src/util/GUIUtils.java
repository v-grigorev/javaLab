package util;

import game.Minesweeper;
import ui.GameViewController;

import javax.swing.*;

public class GUIUtils
{
    public static void invokeController(GameViewController controller, Runnable runnable) {
        try {
            if(controller == null || controller.isGUI()) {
                if(!Minesweeper.isMainControllerIsGUI())
                    SwingUtilities.invokeAndWait(runnable);
                else
                    runnable.run();
            }
            else
                runnable.run();
        } catch(Throwable ignored) {}
    }
}
