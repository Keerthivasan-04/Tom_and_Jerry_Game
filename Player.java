package Game;

import java.awt.Graphics2D;

public class Player {
    public int x = 100, y = 100, speed = 100, d = 50;
    GamePanel gPanel;
    KeyHandler keyH;

    public Player(GamePanel gPanel, KeyHandler keyH) {
        this.gPanel = gPanel;
        this.keyH = keyH;
    }

    public void Update() {
        if (this.keyH.upPressed1 && y > 10) {
            y -= speed;
        }
        if (this.keyH.downPressed1 && y < 710) {
            y += speed;
        }
        if (this.keyH.rightPressed1 && x < 1441) {
            x += speed;
        }
        if (this.keyH.leftPressed1 && x > 10) {
            x -= speed;
        }
    }

    public void draw(Graphics2D g2) {
    }

}
