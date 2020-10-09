package Objects;

public class PopulatedVessel {

    public double px = 0;
    public double py = 0;
    public double h;
    public double w;

    public double sf = 0;
    public boolean Focused = false;

    public PopulatedVessel(double x, double y, double height, double width, String color, double sf){

        this.px = x;
        this.py = y;
        this.h = height;
        this.w = width;

        this.sf = sf;
        this.Focused = false;

    }
}
