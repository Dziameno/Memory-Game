package Model;

import View.View;

public class Memory {

    private int rows;
    private int cols;
    private View view;
    //private Model model;

    public void newGame() {
        view.drawBoard(rows, cols);
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

    //public void gameRules(Card card) {
    //    if (card.isFlipped()) {
    //        if (card.ifEquals()) {
    //            card.isMatched();
    //        } else {
    //            card.flip();
    //        }
    //    }
    //}

    //public void gameImages(Card images) {

    //}
}
