package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Render extends JPanel{

    
    Render() {
        super();
    }
    
    protected void paintComponent(Graphics g) {

        //BACKGROUND:

        Graphics2D g2d = (Graphics2D)g;
        super.paintComponent(g2d);
        g2d.setColor(Color.decode("#080213"));
        g2d.fillRect(0, 0, (int)Display.screenSize.getWidth(), (int)Display.screenSize.getHeight());

        //CELESTIALS:
        
        for (int i = 1; i < Display.Body.length; i++) { Display.Body[i].DistanceLine(g2d, Display.Body[0]); }
        for (int i = 0; i < Display.Body.length; i++) { Display.Body[i].display(g2d); }
        
        
        //FRONTGROUND:
        g2d.setColor(Color.decode("#4E4B5C"));
        g2d.fillRect(0, 0, 200, 120);
        
        g2d.setColor(Color.WHITE);
        g2d.drawString(Double.toString(Display.SelectedZoom), 25, 65);
        
        for (int i = 0; i < Display.Button.length; i++) { Display.Button[i].paint(g2d);; }
        for (int i = 0; i < Display.Button.length; i++) { Display.Button[i].paintdropdown(g2d);}

    }


}
