package View;

import Controller.ButtonController;
import Model.Card;
import Model.Memory;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class View {
    JFrame frame = new JFrame();
    JPanel gamePanel = new JPanel();
    JPanel namePanel = new JPanel();
    JPanel menuPanel = new JPanel();
    JPanel alertPanel = new JPanel();

    private List<Card> cards = new ArrayList<>();
    private Memory model;
    private ButtonController controller;
    private JLabel name, info, result, gameStatus;
    private JButton exitGame = new JButton("Exit Game");
    private JButton easy = new JButton("Easy");
    private JButton medium = new JButton("Medium");
    private JButton hard = new JButton("Hard");

    Font titleFont = new Font("Copperplate Gothic", Font.BOLD, 66);
    Font infoFont = new Font("Copperplate Gothic", Font.LAYOUT_NO_LIMIT_CONTEXT, 30);

    public View(Memory model) {
        this.model = model;
        controller = new ButtonController(model, this);

        this.frame.setTitle("MEMEory The Game");
        frame.setSize(975, 1045);

        easy.setFont(new Font("Copperplate Gothic", Font.ITALIC, 20));
        medium.setFont(new Font("Copperplate Gothic", Font.ITALIC, 20));
        hard.setFont(new Font("Copperplate Gothic", Font.ITALIC, 20));
        exitGame.setFont(new Font("Copperplate Gothic", Font.BOLD, 20));

        name = new JLabel("<html>MEMEory</html>");
        result = new JLabel(" ");

        info = new JLabel("<html>Welcome!<br>" +
                "Rules of the game are following:<br>" +
                "Match: match if two pictures are same: +5 points<br> " +
                "Miss: miss if two pictures are different: -2 points<br>" +
                "End of Game: Game continues until Player match all cards!<br><br>" +
                "Easy: 16 cards<br>" +
                "Medium: 20 cards<br>" +
                "Hard: 24 cards<br><br>" +
                "To start New Game, choose difficulty!</html>", SwingConstants.CENTER);

        namePanel.setBounds(25, 25, 600, 250);
        gamePanel.setBounds(25, 275, 900, 700);
        menuPanel.setBounds(725, 25, 200, 200);
        gamePanel.setLayout(new GridLayout());

        frame.setIconImage(new ImageIcon("src\\Resources\\Images\\rewers.png").getImage());
        frame.add(namePanel);
        frame.add(gamePanel);
        frame.add(menuPanel);
        frame.add(alertPanel);

        namePanel.setLayout(new GridLayout(3, 1));
        name.setFont(titleFont);
        name.setForeground(new Color(253,86,33));
        namePanel.add(name);
        namePanel.add(result);

        result.setFont(infoFont);
        info.setFont(infoFont);
        gamePanel.add(info);

        menuPanel.setLayout(new GridLayout(4, 1));
        menuPanel.add(easy);
        easy.setActionCommand("Easy");
        easy.addActionListener(controller);

        menuPanel.add(medium);
        medium.setActionCommand("Medium");
        medium.addActionListener(controller);

        menuPanel.add(hard);
        hard.setActionCommand("Hard");
        hard.addActionListener(controller);

        menuPanel.add(exitGame);
        exitGame.setActionCommand("Exit");
        exitGame.addActionListener(controller);

        gameStatus = new JLabel("", SwingConstants.LEFT);
        gameStatus.setFont(infoFont);
        namePanel.add(gameStatus);

        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void drawBoard(List<Card> cards, int rows, int cols) {
        this.cards = cards;
        gamePanel.removeAll();
        gamePanel.setLayout(new GridLayout(rows, cols));
        for (int i = 0; i < rows * cols; i++) {
            JButton btn = cards.get(i).getBtn();
            gamePanel.add(btn);
            btn.setActionCommand(String.valueOf(i));
            btn.addActionListener(controller);
        }
        frame.setVisible(true);
    }

    public void setScore(int score) {
        result.setText("Score : " + score);
        result.setForeground(new Color(253,86,33));
    }

    public void lossAlert() {
        gameStatus.setText("Game Over!");
        gameStatus.setForeground(new Color(165,0,0));
    }

    public void winAlert() {
        gameStatus.setText("You Won!");
        gameStatus.setForeground(new Color(0,165,0));
    }

    public void resetGameStatus() {
        gameStatus.setText("");
    }
}
