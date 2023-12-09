import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.AffineTransform;

public class Elipsa extends Figura {

    public Elipsa(Graphics2D buf, int del, int w, int h) {
        super(buf, del, w, h);
    }

    @Override
    protected void prepareFigure() {
        shape = new Ellipse2D.Double(rand.nextInt(getWidth()), rand.nextInt(getHeight()), 20, 10);
        area = new Area(shape);
        aft = new AffineTransform();
    }
}
