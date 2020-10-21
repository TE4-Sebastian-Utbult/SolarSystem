package src.Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Render extends JPanel{

    Render() {
        super();
        this.setBackground(Color.decode("#000000"));
    }
    
    protected void paintComponent(Graphics g) {

        //BACKGROUND:
        Graphics2D g2d = (Graphics2D)g;
        super.paintComponent(g2d);

        //CELESTIALS:
        for (int i = 0; i < Display.Body.length; i++) { 
            if(Display.Body[i].visible){

                Display.Body[i].display(g2d);

                if(Display.showInfo){
                    Display.Body[i].displayDistance(g2d, Display.Body[0]);
                    Display.Body[i].paintOrbitalCourse(g2d, Display.Body[0]);
                    Display.Body[i].displayMiddlePoint(g2d);
                }

            }
        }
        
        //FRONTGROUND:
        
        for (int i = 0; i < Display.Button.length; i++) { Display.Button[i].paint(g2d);; }
        for (int i = 0; i < Display.Button.length; i++) { Display.Button[i].paintdropdown(g2d);}

        Display.player.display(g2d);

    }


}
