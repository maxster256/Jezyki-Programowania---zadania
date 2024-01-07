import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Map extends JPanel{
    //ArrayList<Vehicle> vehicles = new ArrayList<>();
    //ArrayList<Pedestrian> pedestrians = new ArrayList<>();
    ArrayList<Entity> entities = new ArrayList<>();
    Intersection intersection;
    public void initialize(Dimension screen){
        setBounds(0,0,(int)screen.getWidth(),(int)screen.getHeight()-200);
        setBorder(BorderFactory.createLineBorder(Color.black));
        setBackground(Color.DARK_GRAY);
        setLayout(null);
        setVisible(true);

        intersection = new Intersection(800,400);
        intersection.init_intersection();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0,200,1920,400);
        g.fillRect(600,0,400,900);

        g.setColor(Color.BLACK);
        g.fillRect(0,300,1920,200);
        g.fillRect(700,0,200,900);

        for(int i=0;i<intersection.lights.size();i++){
            if(intersection.lights.get(i))  {g.setColor(Color.GREEN);}
            else                            {g.setColor(Color.red);}
            Rectangle crossing = intersection.crossings.get(i);
            g.fillRect((int)crossing.getX(),(int)crossing.getY(),(int)crossing.getWidth(),(int)crossing.getHeight());
        }
        /*
        for(Vehicle object : vehicles){
            g.setColor(Color.orange);
            Rectangle entity = object.getVehicleBox();
            g.fillRect((int)entity.getX(),(int)entity.getY(),(int)entity.getWidth(),(int)entity.getHeight());
        }

        for(Pedestrian object : pedestrians){
            g.setColor(Color.black);
            Rectangle entity = object.getPedestrianBox();
            g.fillRect((int)entity.getX(),(int)entity.getY(),(int)entity.getWidth(),(int)entity.getHeight());
        }
        vehicles.removeIf(n -> (
                n.getVehicleBox().getX() < -99) ||
                n.getVehicleBox().getX() > 1999 ||
                n.getVehicleBox().getY() < -99 ||
                n.getVehicleBox().getY() > 999);
        pedestrians.removeIf(n -> (
                n.getPedestrianBox().getX() < -99) ||
                n.getPedestrianBox().getX() > 1999 ||
                n.getPedestrianBox().getY() < -99 ||
                n.getPedestrianBox().getY() > 999);*/

        for(Entity object : entities){
            if(object.getClass().equals(Vehicle.class))         {g.setColor(Color.orange);}
            else if(object.getClass().equals(Pedestrian.class)) {g.setColor(Color.black);}
            else {System.out.println("found error"); System.exit(17);}
            Rectangle entity = object.getEntityBox();
            g.fillRect((int)entity.getX(),(int)entity.getY(),(int)entity.getWidth(),(int)entity.getHeight());
        }
        entities.removeIf(n -> (
                n.getEntityBox().getX() < -99) ||
                n.getEntityBox().getX() > 1999 ||
                n.getEntityBox().getY() < -99 ||
                n.getEntityBox().getY() > 999);

        revalidate();
        repaint();
    }
}
