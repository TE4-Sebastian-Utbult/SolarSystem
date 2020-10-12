package Listeners;

import Main.*;
import Objects.*;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;

public class Mouse implements MouseInputListener {

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {

        int x = e.getX();
        int y = e.getY();
 
        if(Display.Button[1].click(x, y)){ 
            Update.FocusedObject +=1;
            if(Update.FocusedObject > Display.Body.length-1){
                Update.FocusedObject = 0;
            }
        }
        // else{System.out.println("!1");}
        if(Display.Button[0].click(x, y)){ 
            Update.FocusedObject -=1;
            if(Update.FocusedObject < 0){
                Update.FocusedObject = Display.Body.length - 1;
            }
        }

        if(Display.Button[2].click(x, y)){ 
            if(Display.running){
                Display.running = false;
            }else{
                Display.running = true;
            }
        }
        
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {}
    
}
