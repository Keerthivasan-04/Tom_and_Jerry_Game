package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Time{
    public int second;
    public Timer time;
    GamePanel gPanel;
    public Time(GamePanel gPanel){
        this.gPanel = gPanel;
    }
    public void simpleTimer(){
        time= new Timer(1000,new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(gPanel.keyH.start)
                second--;
            }
        });
    }
   
    public void draw(Graphics2D g2){
        g2.setColor(new Color(43,43,43));
        g2.setFont(new Font("Bebas Neue", Font.BOLD, 50));
        g2.drawString( "Timer : "+second, 50, 50);
        
    }
    
}
