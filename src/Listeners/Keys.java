package src.Listeners;

import src.Main.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keys implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {

            case KeyEvent.VK_1:
                Display.TimeSpeed = 1;
                break;
            case KeyEvent.VK_2:
                Display.TimeSpeed = 10;
                break;
            case KeyEvent.VK_3:
                Display.TimeSpeed = 20;
                break;
            case KeyEvent.VK_4:
                Display.TimeSpeed = 50;
                break;
            case KeyEvent.VK_5:
                Display.TimeSpeed = 100;
                break;
            case KeyEvent.VK_0:

                if (Display.player.Focused) {
                    Display.player.Focused = false;
                    Display.player.Controlled = false;
                } else {
                    Display.player.Focused = true;
                    Display.player.Controlled = true;
                }
                break;
            case KeyEvent.VK_W:
                if (!Display.player.Controlled) {

                }
                break;
            case KeyEvent.VK_S:
                if (!Display.player.Controlled) {

                }
                break;
            case KeyEvent.VK_D:
                if (!Display.player.Controlled) {

                }
                break;
            case KeyEvent.VK_A:
                if (!Display.player.Controlled) {
                    System.out.println("PLAYER NOT CONTROLLED");
                }
                break;
            case KeyEvent.VK_Q:
                if (Display.showInfo) {
                    Display.showInfo = false;
                } else {
                    Display.showInfo = true;
                }
                break;
            case KeyEvent.VK_C:
                if (Display.createPlanet) {
                    Display.createPlanet = false;
                } else {
                    Display.createPlanet = true;
                }
                break;
            default:

                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

}
