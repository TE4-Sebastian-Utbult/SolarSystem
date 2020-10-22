package src2.Main;

import javax.swing.*;

import src2.GUI.Object.*;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Display implements Runnable{

    public static JFrame frame;
    public static String Title = "SolarSystem";
    public static String BackgroundColor = "#000000";
    public static Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public static boolean Running = true;
    public Thread thread;

    public static Graphics g;
    public static Render r = new Render();

    public static CelestialBody Body[] = {

    };

    public Display() {
        frame = new JFrame();
    }

    public static void main(String[] args) {

        Display Display = new Display();

        frame.setSize(ScreenSize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(r);

        BodyHandler.add("Sun", "Planet", "#FFD131", 0.0, 0.0, 0.0, 0.0, 500, 100);
        BodyHandler.add("Sun", "Planet", "#7A6F9B", 0.0, 1000.0, 3, 0.0, 100, 0.1);

        Display.start();

    }

    public synchronized void start() {
        Running = true;
        this.thread = new Thread(this, "Display");
        this.thread.start();
    }

    public synchronized void stop(){
        Running = false;
        try{
            this.thread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void run(){

        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 30;
        double delta = 0;
        int frames = 0;

        while(Running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                Update.update();
                delta--;
            }
            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                frame.setTitle(Title + " | fps: " + frames);
                frames = 0;
            }
        }

        stop();
    }

    private void render(){

        BufferStrategy bs = Display.frame.getBufferStrategy();
        if (bs == null) {
            Display.frame.createBufferStrategy(3);
            return;
        }
        java.awt.Graphics g = bs.getDrawGraphics();
        r.update(g);
        bs.show();
        
    }

}
