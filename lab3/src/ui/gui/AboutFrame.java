package ui.gui;

import javax.swing.*;
import java.awt.*;

import static game.Minesweeper.GAME_VERSION;

public class AboutFrame {
    public static void showAbout() {
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(UIDesigner.DEFAULT_BACKGROUND);

        JLabel programNameL = new JLabel("Minesweeper v" + GAME_VERSION);
        programNameL.setFont(UIDesigner.getFont(18, programNameL.getFont(), false));
        programNameL.setForeground(Color.LIGHT_GRAY);
        content.add(programNameL);


        JFrame frame = new JFrame();
        frame.setContentPane(content);
        frame.pack();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("About");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
