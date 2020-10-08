package Main;

import Listeners.*;

public class Update {
    public static void run(){

        Display.screenSize = Display.frame.getSize();
        Display.WorldY = (int)-Display.frame.getHeight()/2;
        Display.WorldX = (int)-Display.frame.getWidth()/2;
        
        for (int i = 0; i < Display.Body.length; i++) {
            for (int j = 0; j < Display.Body.length; j++) {
                Display.Body[i].update(Display.Body[j]);
                Display.Body[i].attraction();
                Display.frame.repaint();
                Collision.Planets();
            }
        }
    };
}
