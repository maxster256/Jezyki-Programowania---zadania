package Task;

import java.awt.*;
import java.util.ArrayList;

public class Intersection {
    private int intersectionCenterX;
    private int IntersectionCenterY;
    public ArrayList<Rectangle> crossings = new ArrayList<>();
    public ArrayList<Boolean> lights = new ArrayList<>();
    public Intersection(int x_center, int y_center){
        this.intersectionCenterX =x_center;
        this.IntersectionCenterY =y_center;
    }
    public void init_intersection(){
        crossings.add(new Rectangle());
        crossings.add(new Rectangle());
        crossings.add(new Rectangle());
        crossings.add(new Rectangle());
        crossings.get(0).setBounds(intersectionCenterX -100, IntersectionCenterY -200,200,50); //up
        crossings.get(1).setBounds(intersectionCenterX -100, IntersectionCenterY +150,200,50); //down
        crossings.get(2).setBounds(intersectionCenterX +150, IntersectionCenterY -100,50,200); //right
        crossings.get(3).setBounds(intersectionCenterX -200, IntersectionCenterY -100,50,200); //left
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
    public int getIntersectionCenterX(){
        return intersectionCenterX;
    }
    public int getIntersectionCenterY(){
        return IntersectionCenterY;
    }
}
