package Game;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
public class KeyHandler implements KeyListener{

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public boolean upPressed1=false, downPressed1=false, rightPressed1=false, leftPressed1 =false,option=false,start=false,up=false; 
    public boolean upPressed2=false, downPressed2=false, rightPressed2=false, leftPressed2 =false,down=false; 
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_ENTER){
            start=true;
        }
        
        if(key == KeyEvent.VK_W){
            upPressed1 = true;
        }
        if(key == KeyEvent.VK_S){
            downPressed1 = true;
        }
        if(key == KeyEvent.VK_D){
            rightPressed1 = true;
        }
        if(key == KeyEvent.VK_A){
            leftPressed1 = true;
        }
        if(key == KeyEvent.VK_UP){
            upPressed2 = true;
        }
        if(key == KeyEvent.VK_DOWN){
            downPressed2 = true;
        }
        if(key == KeyEvent.VK_RIGHT){
            rightPressed2 = true;
        }
        if(key == KeyEvent.VK_LEFT){
            leftPressed2 = true;
        }
        if(key == KeyEvent.VK_ENTER){
            option=true;
        }
        if(key == KeyEvent.VK_UP){
            up=true;
        }
        if(key == KeyEvent.VK_DOWN){
            down = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_W){
            upPressed1 = false;
        }
        if(key == KeyEvent.VK_S){
            downPressed1 = false;
        }
        if(key == KeyEvent.VK_D){
            rightPressed1 = false;
        }
        if(key == KeyEvent.VK_A){
            leftPressed1 = false;
        }
        if(key == KeyEvent.VK_UP){
            upPressed2 = false;
        }
        if(key == KeyEvent.VK_DOWN){
            downPressed2 = false;
        }
        if(key == KeyEvent.VK_RIGHT){
            rightPressed2 = false;
        }
        if(key == KeyEvent.VK_LEFT){
            leftPressed2 = false;
        }
        if(key == KeyEvent.VK_ENTER){
            option=false;
        }
        if(key == KeyEvent.VK_UP){
            up=false;
        }
        if(key == KeyEvent.VK_DOWN){
            down = false;
        }
    }

}
