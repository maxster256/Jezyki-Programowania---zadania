import org.w3c.dom.css.Rect;

import java.awt.*;
import java.util.ArrayList;

public class Intersection {
    private int x_center;
    private int y_center;
    ArrayList<Rectangle> crossings = new ArrayList<>();
    ArrayList<Boolean> lights = new ArrayList<>();
    public Intersection(int x_center, int y_center){
        this.x_center=x_center;
        this.y_center=y_center;
    }
    public void init_intersection(){
        crossings.add(new Rectangle());
        crossings.add(new Rectangle());
        crossings.add(new Rectangle());
        crossings.add(new Rectangle());
        crossings.get(0).setBounds(x_center-100,y_center-200,200,50); //up
        crossings.get(1).setBounds(x_center-100,y_center+150,200,50); //down
        crossings.get(2).setBounds(x_center+150,y_center-100,50,200); //right
        crossings.get(3).setBounds(x_center-200,y_center-100,50,200); //left
        lights.add(true);
        lights.add(true);
        lights.add(false);
        lights.add(false);
    }
    public void switch_lights(){
        for(int i=0;i<lights.size();i++){
            lights.set(i, !lights.get(i));
        }
    }
    public int getX_center(){
        return x_center;
    }
    public int getY_center(){
        return y_center;
    }
}
