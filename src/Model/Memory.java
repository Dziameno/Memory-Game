package Model;

import View.View;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;

public class Memory {

    String[] cardImages = {"1.png", "2.png", "3.png", "4.png", "5.png", "6.png", "7.png", "8.png", "9.png", "10.png", "11.png", "12.png"};
    private int rows;
    private int cols;
    private View view;
    private Card flippedImage;
    private List<Card> cards;
    private int score;

    public void newGame() {
        cards = new ArrayList<>();
        score = 25;
        view.setScore(score);
        view.resetGameStatus();
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

    public void setFlippedImage(String flippedCardIndex) {
        Card c = cards.get(Integer.parseInt(flippedCardIndex));
        if (score <= 0 || c.isFlipped() || c.isMatched()) {
            return;
        } else if (this.flippedImage == null) {
            for (Card a : cards) {
                if (a.isFlipped() && !a.isMatched()) {
                    a.setFlipped(false);
                    score--;
                }
            }
            this.flippedImage = c;
            this.flippedImage.setFlipped(true);
        } else if (this.flippedImage.equals(c)) {
            this.flippedImage.setMatched();
            c.setMatched();
            c.setFlipped(true);
            this.flippedImage = null;
            score += 5;

            if (isWin()) {
                view.winAlert();
                saveScore();
            }
        } else {
            c.setFlipped(true);
            this.flippedImage = null;
        }
        if (score <= 0) {
            score = 0;
            view.lossAlert();
        }
        view.setScore(score);
    }

    private boolean isWin() {
        return cards.stream().allMatch(Card::isMatched);
    }

    private void saveScore() {
        try{
            LocalDateTime date = LocalDateTime.now();
            String path = "src\\Resources\\Score\\TableOfScores.txt";
            File file = new File(path);

            file.createNewFile();
            FileWriter fileWriter = new FileWriter(path,true);
            fileWriter.write(date+" Score: "+score+"\n");
            fileWriter.close();

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
