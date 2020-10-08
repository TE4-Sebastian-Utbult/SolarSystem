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
 
        if(Display.Button[1].click(x, y)){ Display.Xspawn-=100; Display.SelectedFocus+=0.05;}
        // else{System.out.println("!1");}
        if(Display.Button[0].click(x, y)){ Display.Xspawn+=100; Display.SelectedFocus-=0.05;}
        // else{System.out.println("!0");}

        if(Display.Button[3].click(x, y)){ Display.Yspawn-=100;}
        // else{System.out.println("!3");}
        if(Display.Button[2].click(x, y)){ Display.Yspawn+=100;}
        // else{System.out.println("!2");} 

        if(Display.Button[8].click(x, y)){ Create.Planet(Display.Xspawn, Display.Yspawn);}
        // else{System.out.println("!SUBMIT");} 

        
        
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
