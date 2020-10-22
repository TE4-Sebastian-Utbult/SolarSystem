package src2.Main;

import javax.swing.*;

import src2.GUI.Object.*;

import java.awt.*;

public class Display{

    public static boolean Running = true;
    public static String Title = "SolarSystem";

    public static Graphics g;
    public static JFrame frame;
    public static Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static Thread thread;
    public static String BackgroundColor = "#000000";
    public static Render r;

    public static CelestialBody Body[] = {

    };

    public static void main(String[] args) {

        GameLoop Gameloop = new GameLoop();
        r = new Render();

        frame = new JFrame();
        frame.setSize(ScreenSize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(r);

        BodyHandler.add("Sun","#FFFFFF", "Planet", 0.0, 0.0, 1000);

        Gameloop.start();

    }

}
