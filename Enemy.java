package Game;

public class Enemy {
    public int x = 400, y = 100, speed = 7, d = 50;
    GamePanel gPanel;
    KeyHandler keyH;

    public Enemy(GamePanel gPanel, KeyHandler keyH) {
        this.gPanel = gPanel;
        this.keyH = keyH;
    }

    public void Update() {
        if (this.keyH.upPressed2 && y > 10) {
            y -= speed;
        }
        if (this.keyH.downPressed2 && y < 710) {
            y += speed;
        }
        if (this.keyH.rightPressed2 && x < 1441) {
            x += speed;
        }
        if (this.keyH.leftPressed2 && x > 10) {
            x -= speed;
        }
    }
}
