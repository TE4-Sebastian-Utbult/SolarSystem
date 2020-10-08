package Listeners;

import Main.*;

public class Collision {

    public static void Planets(){
        for (int i = 1; i < Display.Body.length; i++) {
            if(Display.Body[0].pointInCircle((int)Display.Body[i].px, (int)Display.Body[i].py)){
                Display.Body[i].visible = false;
            }
        }
    }
    
}
