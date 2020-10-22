package src.InterfaceVisuals;

import java.awt.Graphics2D;
import java.awt.Color;

public class Button {

    int px = 0;
    int py = 0;

    int h = 0;
    int w = 0;

    int dh = 0;
    int dw = 0;

    boolean dd = false;

    String c = "#FFFFFF";


    public Button(int x, int y, int width, int height, String color) {

        this.px = x;
        this.py = y;
        this.h = height;
        this.w = width;

        this.c = color;

        this.dd = false;

    }

    public void paint(Graphics2D g2d) {

        g2d.setColor(Color.decode(this.c));
        g2d.fillRect(this.px, this.py, this.w, this.h);

    }

    public void paintdropdown(Graphics2D g2d) {
        if (this.dd == true) {
            g2d.setColor(Color.decode(this.c));
            g2d.fillRect(this.px + this.w, this.py + this.h, this.dw, this.dh);
        }
    }

    public boolean click(int Mx, int My) {

        if (Mx > this.px && My > this.py && Mx < this.px + this.w && My < this.py + 44) {

            return true;

        } else {

            return false;

        }

    }

}