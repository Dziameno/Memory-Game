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

    private List<Card> cards = new ArrayList<>();
    private Memory model;
    private ButtonController controller;
    private JLabel name, info, result;
    private JButton startGame = new JButton("New Game");
    private JButton exitGame = new JButton("Exit Game");
    private JButton easy = new JButton("Easy");
    private JButton medium = new JButton("Medium");
    private JButton hard = new JButton("Hard");


    public View(Memory model) {
        this.model = model;
        JPanel namePanel = new JPanel();
        JPanel menuPanel = new JPanel();
        controller = new ButtonController(model, this);

        this.frame.setTitle("MEMEory The Game");
        frame.setSize(1000, 1000);
        Font titleFont = new Font("Copperplate Gothic Bold", Font.BOLD, 56);
        Font infoFont = new Font("Copperplate Gothic Bold", Font.LAYOUT_NO_LIMIT_CONTEXT, 20);
        startGame.setFont(new Font("MineCrafter", Font.BOLD, 20));
        easy.setFont(new Font("MineCrafter", Font.ITALIC, 20));
        medium.setFont(new Font("MineCrafter", Font.ITALIC, 20));
        hard.setFont(new Font("MineCrafter", Font.ITALIC, 20));
        exitGame.setFont(new Font("MineCrafter", Font.BOLD, 20));

        name = new JLabel("<html>MEMEory<br>The Game</html", SwingConstants.CENTER);
        result = new JLabel("WIN", SwingConstants.CENTER);

        info = new JLabel("<html><br><br><br><br><br><br><br>Welcome!<br>" +
                "Rules of the game are following:<br>" +
                "Match: Player make match if two turned up pictures are the same<br> " +
                "Miss: Player misses if two turned up pictures are different<br>" +
                "End of Game: Game continues until Player match all cards!<br><br>" +
                "Easy: 16 cards<br>" +
                "Medium: 20 cards<br>" +
                "Hard: 24 cards</html><br>", SwingConstants.CENTER);

        frame.setLayout(new BorderLayout());
        frame.add(namePanel, BorderLayout.NORTH);
        frame.add(gamePanel, BorderLayout.CENTER);
        frame.add(menuPanel, BorderLayout.SOUTH);

        namePanel.setSize(100, 50);
        name.setFont(titleFont);
        result.setFont(titleFont);
        namePanel.add(name);
        namePanel.add(result);

        gamePanel.setSize(200, 200);
        info.setFont(infoFont);
        gamePanel.add(info);

        menuPanel.setSize(50, 50);
        menuPanel.setLayout(new GridLayout(5, 1));

        menuPanel.add(startGame);
        startGame.setActionCommand("New");
        startGame.addActionListener(controller);

        menuPanel.add(easy);
        easy.setActionCommand("New");
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
            //btn.setBackground(Color.DARK_GRAY);
            gamePanel.add(btn);
            btn.setActionCommand(String.valueOf(i));
            btn.addActionListener(controller);
        }
        frame.setVisible(true);
    }

    public void setScore(int score) {
        // TODO USTAWIC TU SCORE NA JLABEL
    }
}
