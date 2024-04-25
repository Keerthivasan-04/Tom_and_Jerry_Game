package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Collision {
    public int x = 100, y = 100, speed = 4, d = 50;
    public boolean coloid = false;
    Image img1 = new ImageIcon("C:\\Users\\akeer\\OneDrive\\Desktop\\JG\\Game\\tom.png").getImage();
    Image img2 = new ImageIcon("C:\\Users\\akeer\\OneDrive\\Desktop\\JG\\Game\\jerry.png").getImage();
    // Image img3 = new
    // ImageIcon("C:\\Users\\Asus\\OneDrive\\Desktop\\JG\\Game\\dog.png").getImage();

    GamePanel gPanel;
    KeyHandler keyH;
    Player re1;
    Enemy re2;
    Time timer;

    public Collision(GamePanel gPanel, KeyHandler keyH, Player r1, Enemy r2, Time timer) {
        this.gPanel = gPanel;
        this.keyH = keyH;
        this.re1 = r1;
        this.re2 = r2;
        this.timer = timer;
    }

    public void Update() {
        coloid = false;
    }

    public void draw(Graphics2D g2) {
        Rectangle r1 = new Rectangle(this.re1.x, this.re1.y, this.re1.d, this.re1.d);
        Rectangle r2 = new Rectangle(this.re2.x, this.re2.y, this.re2.d, this.re2.d);
        Rectangle o1 = new Rectangle(500, 100, 200, 200);
        Rectangle o2 = new Rectangle(500, 600, 200, 100);
        Rectangle o3 = new Rectangle(1000, 400, 300, 100);
        Rectangle o4 = new Rectangle(100, 400, 100, 100);

        g2.setColor(Color.GRAY);
        g2.fillRect(o1.x, o1.y, o1.width, o1.height);

        g2.setColor(Color.GRAY);
        g2.fillRect(o4.x, o4.y, o4.width, o4.height);

        g2.setColor(Color.GRAY);
        g2.fillRect(o3.x, o3.y, o3.width, o3.height);

        g2.setColor(Color.GRAY);
        g2.fillRect(o2.x, o2.y, o2.width, o2.height);

        g2.setColor(new Color(72, 101, 122));
        g2.fillRect(r1.x, r1.y, r1.width - 5, r1.height - 1);

        // g2.drawImage(img3, o1.x, o1.y, o1.width, o1.height,null);
        // g2.drawImage(img3, o2.x, o2.y, o2.width, o2.height,null);
        // g2.drawImage(img3, o3.x, o3.y, o3.width, o3.height,null);
        // g2.drawImage(img3, o4.x, o4.y, o4.width, o4.height,null);

        g2.setColor(Color.WHITE);
        g2.fillRect(r2.x, r2.y, r2.width - 20, r2.height - 20);

        g2.drawImage(img2, r2.x - 39, r2.y - 42, 100, 106, null);
        g2.drawImage(img1, r1.x - 32, r1.y - 19, 120, 80, null);

        if (r1.intersects(o1) || r1.intersects(o2) || r1.intersects(o3)) {
            re1.speed = 2;
        } else {
            re1.speed = 4;
        }
        if (r1.intersects(r2)) {
            g2.setColor(new Color(63, 81, 107));
            g2.setFont(new Font("Bebas Neue", Font.BOLD, 50));
            g2.drawString("Tom Wins !", 649, 50);
            coloid = true;
            re1.speed = 0;
            re2.speed = 0;
            g2.setColor(new Color(43, 43, 43));
            g2.setFont(new Font("Bebas Neue", Font.BOLD, 30));
            if (gPanel.count == 0)
                g2.drawString(">", 635 + 51, 400);
            g2.drawString("RESTART", 653 + 51, 400);
            if (gPanel.count == 1)
                g2.drawString(">", 670 + 40, 470);
            g2.drawString("QUIT", 686 + 39, 470);
        }
        if (timer.second == 0) {
            coloid = true;
            g2.setColor(new Color(242, 168, 82));
            g2.setFont(new Font("Bebas Neue", Font.BOLD, 50));
            g2.drawString("Jerry Wins !", 620, 50);
            re1.speed = 0;
            re2.speed = 0;
            g2.setColor(new Color(43, 43, 43));
            g2.setFont(new Font("Bebas Neue", Font.BOLD, 30));
            if (gPanel.count == 0)
                g2.drawString(">", 635 + 51, 400);
            g2.drawString("RESTART", 653 + 51, 400);
            if (gPanel.count == 1)
                g2.drawString(">", 670 + 40, 470);
            g2.drawString("QUIT", 686 + 39, 470);
        }

    }
}
