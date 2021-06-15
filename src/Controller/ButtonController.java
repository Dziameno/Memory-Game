package Controller;

import java.awt.event.*;
import Model.Memory;
import View.*;

public class ButtonController implements ActionListener {

    private Memory model;
    private View view;

    public ButtonController(Memory model, View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("New")) {
            model.setRows(4);
            model.setCols(4);
            model.setDifficulty("New");
            model.newGame();
        } else if (e.getActionCommand().equals("Medium")) {
            model.setRows(4);
            model.setCols(5);
            model.setDifficulty("Medium");
            model.newGame();
        } else if (e.getActionCommand().equals("Hard")) {
            model.setRows(4);
            model.setCols(6);
            model.setDifficulty("Hard");
            model.newGame();
        } else if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        } else {
            model.setFlippedImage(e.getActionCommand());
            System.out.printf(" BTN " + e.getActionCommand());
        }

    }

}
