package src.Objects;

import src.Main.*;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player implements KeyListener {

    public double px = 0;
    public double py = 0;
    public double ax = 0;
    public double ay = 0;
    public double fx = 0;
    public double fy = 0;
    public double vx = 0;
    public double vy = 0;
    public double dx = 0;
    public double dy = 0;

    public double a = 0;
    public double h = 0.005;
    public double w = 0.0025;
    public double dh = 100;
    public double dw = 100;

    public double distance = 0;

    public boolean Focused = false;
    public boolean Controlled = false;

    public double m = 0.01;
    public double sf;

    public Player(double x, double y, double ax, double ay, double sf) {

        this.px = x;
        this.py = y;
        this.ax = ax;
        this.ay = ay;
        this.sf = sf;

    }

    public void display(Graphics2D g2d) {

        this.dx = (this.px * Display.WorldZoom) - Display.WorldX;
        this.dy = (this.py * Display.WorldZoom) - Display.WorldY;
        this.dh = this.h * Display.WorldZoom;
        this.dw = this.w * Display.WorldZoom;

        AffineTransform old = g2d.getTransform();
        g2d.rotate(Math.toRadians(Math.toDegrees(Math.atan2(Display.Body[4].py - this.py, Display.Body[4].px - this.px)) - 90),
                (int) (this.dx - this.dh / 4), (int) (this.dy - this.dh));

        g2d.setColor(Color.decode("#A6CFD5"));
        g2d.drawRect((int) (this.dx - this.dh / 4), (int) (this.dy - this.dh), (int) this.dw, (int) this.dh);
        g2d.setColor(Color.RED);
        g2d.fillOval((int) this.dx - 1, (int) this.dy - 1, 2, 2);

        g2d.transform(old);

    }

    public void attraction() {
        this.vx += (this.fx / this.m) * Display.dt;
        this.vy += (this.fy / this.m) * Display.dt;
        this.px += (this.ax + this.vx * Display.dt);
        this.py += (this.ay + this.vy * Display.dt);
    }

    public void update(Planet outher) {

        this.distance = distance(outher.px, outher.py, this.px, this.py);
        double f = 0;

        if (distance != 0) {
            f = 0.00001 * (outher.m * this.m) / (distance * distance);
        }

        this.a = Math.atan2(outher.py - this.py, outher.px - this.px);

        this.fx = f * Math.cos(this.a);
        this.fy = f * Math.sin(this.a);

    }

    public double angleToObject(Planet outher) {
        return Math.atan2(outher.py - this.py, outher.px - this.px);
    }

    public double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    public double getDistanceFromPlanet(Planet planet) {
        return distance(this.px, this.py, planet.px, planet.py);
    }

    // CONTROLLS FOR PLAYER

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

        if (Controlled) {

            switch (e.getKeyCode()) {
                case KeyEvent.VK_W:

                    break;
                case KeyEvent.VK_S:

                    break;
                case KeyEvent.VK_D:

                    break;
                case KeyEvent.VK_A:

                default:
                    break;
            }

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

}
