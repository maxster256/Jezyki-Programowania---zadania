import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;

public class Kwadrat extends Figura {

    public Kwadrat(Graphics2D buf, int del, int w, int h) {
        super(buf, del, w, h);
    }

    @Override
    protected void prepareFigure() {
        shape = new Rectangle(rand.nextInt(getWidth()), rand.nextInt(getHeight()), 20, 20);
        area = new Area(shape);
        aft = new AffineTransform();
    }
}
