package src.Listeners;

import src.Main.*;
import src.Objects.Planet;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;

public class Mouse implements MouseInputListener {

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

        int x = e.getX();
        int y = e.getY();

        System.out.println(x);
        System.out.println(x * Display.WorldZoom);

        if (Display.createPlanet) {
            Display.Body = addX(Display.Body.length, Display.Body, new Planet("name", (x / Display.WorldZoom) - Display.WorldX / Display.WorldZoom, (y / Display.WorldZoom) - Display.WorldY / Display.WorldZoom, 100, 10, 0, 2, "#FFFFFF", 10.0, true));
        }

        for (int i = 0; i < Display.Body.length; i++) {
            if (Display.Body[i].pointInCircle(x, y) && Display.Body[i].Focusable) {
                Update.FocusedObject = i;
                System.out.println("!: " + i);
            }
        }

        // else{System.out.println("!1");}
        if (Display.Button[0].click(x, y)) {
            Update.FocusedObject = 0;
        }

        if (Display.Button[1].click(x, y)) {
            if (Display.running) {
                Display.running = false;
            } else {
                Display.running = true;
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    public Planet[] addX(int n, Planet Planet[], Planet x) {

        Planet newarr[] = new Planet[n + 1];
        for (int i = 0; i < n; i++) {
            newarr[i] = Planet[i];
        }

        newarr[n] = x;

        return newarr;

    }

}
