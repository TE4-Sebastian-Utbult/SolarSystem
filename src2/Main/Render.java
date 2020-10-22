package src2.Main;

import javax.swing.*;

import src2.GUI.Draw.CelestialBodys;
import src2.GUI.Shapes.*;

import java.awt.*;

public class Render extends JPanel {

    //GLOBAL RENDERER: sets z-index for objects;

    public void update(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        AABB.filled(g2d, Display.BackgroundColor, 0, 0, (int)Display.ScreenSize.getWidth(), (int)Display.ScreenSize.getHeight());


        CelestialBodys.render(g2d);

        g2d.dispose();

    }



}
