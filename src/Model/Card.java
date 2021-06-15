package Model;

import javax.swing.*;

public class Card {
    //Icon icon = new ImageIcon("/Resources/Images/...");
    private JButton btn = new JButton();
    private final String image;
    private boolean matched;
    private boolean flipped;

    public Card(String image) {
        this.image = image;
        this.matched = true;
        this.flipped = true;
    }

    public String getImage() {
        return image;
    }

    public boolean ifEquals(Card otherCard) {
        return image.equals(otherCard.getImage());
    }

    public boolean isFlipped() {
        return flipped;
    }

    public void setFlipped(boolean flipped) {
        this.flipped = flipped;
    }

    public void flip() {
        flipped = !flipped;
    }

    public boolean isMatched() {
        return matched;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    public JButton getBtn() {
        return this.btn;
    }
}
