package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Pause extends JPanel{

    Pause() {
        super();
        this.setBackground(Color.decode("#00FF00"));
    }
    
    protected void paintComponent(Graphics g) {

        //BACKGROUND:
        Graphics2D g2d = (Graphics2D)g;
        super.paintComponent(g2d);

        g2d.setColor(Color.BLACK);
        g2d.fillRect(100, 100, 100, 100);

    }


}
