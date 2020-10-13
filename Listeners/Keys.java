package Listeners;

import Main.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keys implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        if(e.getKeyCode() == KeyEvent.VK_1){
            System.out.println("1");
            Display.TimeSpeed = 1;
        }
        if(e.getKeyCode() == KeyEvent.VK_2){
            System.out.println("2");
            Display.TimeSpeed = 10;
        }
        if(e.getKeyCode() == KeyEvent.VK_3){
            System.out.println("3");
            Display.TimeSpeed = 20;
        }
        if(e.getKeyCode() == KeyEvent.VK_4){
            System.out.println("4");
            Display.TimeSpeed = 50;
        }
        if(e.getKeyCode() == KeyEvent.VK_4){
            System.out.println("5");
            Display.TimeSpeed = 100;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }
    
}
