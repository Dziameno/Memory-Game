package Model;

import View.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;

public class Memory {

    String[] cardImages = { "test.png", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
    private int rows;
    private int cols;
    private View view;
    private String difficulty;
    private Card flippedImage;
    private List<Card> cards;
    private int score;

    public void newGame() {
        cards = new ArrayList<>();
        score = 0;
        int imagesNum = rows * cols / 2;
        List<String> chosenImages = new ArrayList<>();
        Random randomizer = new Random();
        while (chosenImages.size() < imagesNum) {
            int idx = randomizer.nextInt(cardImages.length);
            if (!chosenImages.contains(cardImages[idx])) {
                chosenImages.add(cardImages[idx]);
            }
        }

        for (String img : chosenImages) {
            cards.add(new Card(img));
            cards.add(new Card(img));
        }

        Collections.shuffle(cards);

        view.drawBoard(cards, rows, cols);
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public String getDifficulty(){
        return difficulty;
    }

    public void setDifficulty(String difficulty){
        this.difficulty = difficulty;
    }

    public void setFlippedImage(String flippedCardIndex) {
        Card c = cards.get(Integer.parseInt(flippedCardIndex));
        if (c.isFlipped() || c.isMatched()) {
            return;
        } else if (this.flippedImage == null) {
            for (Card a : cards) {
                if (a.isFlipped() && !a.isMatched()) {
                    a.setFlipped(false);
                }
            }
            this.flippedImage = c;
            this.flippedImage.setFlipped(true);
        } else if (this.flippedImage.equals(c)) {
            this.flippedImage.setMatched();
            c.setMatched();
            c.setFlipped(true);
            this.flippedImage = null;
        } else {
            c.setFlipped(true);
            this.flippedImage = null;
        }
        ++score;
        view.setScore(score);
    }
}
