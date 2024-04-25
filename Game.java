package Game;

import javax.swing.JFrame;

public class Game {
    public static void main(String[] args) {
        // Creating an game Frame
        JFrame GameWindow = new JFrame();
        GameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameWindow.setResizable(false);
        GamePanel game = new GamePanel();
        GameWindow.add(game);
        GameWindow.pack();
        // Thread For Fps Starts
        game.startGameThread();
        // Making the game Visible
        GameWindow.setLocationRelativeTo(null);
        GameWindow.setVisible(true);

    }

}