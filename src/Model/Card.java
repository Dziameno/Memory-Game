package Model;

import javax.swing.*;
import java.awt.*;

public class Card {
    private JButton btn;
    private final String image;
    private boolean matched;
    private boolean flipped;

    public Card(String image) {
        this.image = image;
        this.matched = false;
        this.flipped = false;

        this.btn = new JButton(new ImageIcon("src\\Resources\\Images\\rewers.png"));
        btn.setBackground(new Color(238, 238, 238));
        btn.setBorderPainted(false);
    }

    @Override
    public boolean equals(Object otherCard) {
        return image.equals(((Card) otherCard).image);
    }

    public boolean isFlipped() {
        return flipped;
    }

    public void setFlipped(boolean flipped) {
        this.flipped = flipped;
        if (this.flipped) {
            this.btn.setIcon(new ImageIcon("src\\Resources\\Images\\" + this.image));
        } else {
            this.btn.setIcon(new ImageIcon("src\\Resources\\Images\\rewers.png"));
        }
    }

    public boolean isMatched() {
        return matched;
    }

    public void setMatched() {
        this.matched = true;
        this.btn.setIcon(new ImageIcon("src\\Resources\\Images\\" + this.image));
    }

    public JButton getBtn() {
        return this.btn;
    }
}
