package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
    // Sound files
    File file = new File("C:\\Users\\akeer\\OneDrive\\Desktop\\JG\\Game\\tom_and_jerry_theme.wav");
    Clip clip;
    // For options
    int count = 0;
    // Thread for FPS
    Thread gameThread;
    // Key Handling
    KeyHandler keyH = new KeyHandler();
    // Timer
    Time timer = new Time(this);
    // Orange
    Enemy enemy = new Enemy(this, keyH);
    // Black
    Player player = new Player(this, keyH);
    // Collision
    Collision collision = new Collision(this, keyH, player, enemy, timer);
    // Image
    Image img = new ImageIcon("C:\\Users\\akeer\\OneDrive\\Desktop\\JG\\Game\\download.png").getImage();

    public GamePanel() {
        this.setPreferredSize(new Dimension(1500, 770));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();

    }

    public void run() {
        sound();
        double drawInterval = 1000000000 / 60;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        timer.second = 30;
        timer.simpleTimer();
        timer.time.start();
        while (gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                Update();
                // repaint ==> paintComponent (this is default way to call the paintComponet
                // method)
                repaint();
                delta--;
            }
            if (collision.coloid == true) {
                timer.time.stop();
                if (keyH.option && count == 0) {
                    timer.time.stop();
                    player.x = 100;
                    enemy.x = 400;
                    player.y = 100;
                    enemy.y = 100;
                    player.speed = 4;
                    enemy.speed = 4;
                    timer.second = 30;
                    timer.time.start();
                }
                if (keyH.option && count == 1) {
                    System.exit(ABORT);
                }
            }
        }
    }

    public void Update() {
        collision.Update();
        player.Update();
        enemy.Update();
        // For selection
        if (keyH.up) {
            count = 0;
        }
        if (keyH.down) {
            count = 1;
        }

    }

    public void paintComponent(Graphics g) {
        if (keyH.start) {
            // to stop the theme
            // clip.stop();
            // ----------------
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            timer.draw(g2);
            collision.draw(g2);
            g2.dispose();
        } else {
            // For starting page
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(img, 630, 180, null);
            g2.setColor(new Color(181, 36, 36));
            g2.setFont(new Font("Arial Rounded MT", Font.PLAIN, 50));
            g2.drawString("PRESS \"ENTER\" TO START GAME", 400, 460);
        }

    }

    // For sound effects
    public void sound() {
        if (keyH.start == false) {
            try {
                AudioInputStream theme = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(theme);
                clip.start();
                clip.loop(clip.LOOP_CONTINUOUSLY);
            } catch (Exception e) {
            }
        }

    }
}
