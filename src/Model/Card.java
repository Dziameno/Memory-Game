package Model;

import javax.swing.*;

public class Card {
    private JButton btn;
    private final String image;
    private boolean matched;
    private boolean flipped;

    public Card(String image) {
        this.image = image;
        this.matched = false;
        this.flipped = false;

        this.btn = new JButton();
    }

    @Override
    public boolean equals(Object otherCard) {
        return image.equals(((Card)otherCard).image);
    }

    public boolean isFlipped() {
        return flipped;
    }

    public void setFlipped(boolean flipped) {
        this.flipped = flipped;
        if (this.flipped) {
            this.btn.setText(this.image);   // TODO obrazek a nie napis -setIcon
        } else {
            this.btn.setText("");
        }
    }

    public boolean isMatched() {
        return matched;
    }

    public void setMatched() {
        this.matched = true;
        this.btn.setText(this.image);   // TODO obrazek a nie napis -setIcon
    }

    public JButton getBtn() {
        return this.btn;
    }
}
