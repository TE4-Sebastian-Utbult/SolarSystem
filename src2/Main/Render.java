package src2.Main;

import javax.swing.*;

import src2.GUI.Draw.CelestialBodys;

import java.awt.*;

public class Render extends JPanel {

    public static Graphics g;

    Render(){
        super();
        this.setBackground(Color.decode(Display.BackgroundColor));
    }

    //GLOBAL RENDERER: sets z-index for objects;

    public void update() {

        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);

        g2d.setColor(Color.WHITE);
        g2d.fillRect(100, 100, 100, 100);

        CelestialBodys.render(g2d);

    }



}
