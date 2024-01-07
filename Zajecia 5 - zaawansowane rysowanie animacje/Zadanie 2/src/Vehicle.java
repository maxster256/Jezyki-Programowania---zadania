import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Vehicle extends Entity{
    private ArrayList<Integer> direction = new ArrayList<>();
    private Rectangle vehicleBox = new Rectangle();
    Map roadMap;

    public Vehicle(Map roadMap){
        super(roadMap);
        /*
        this.roadMap = roadMap;
        Random random = new Random();
        switch (random.nextInt(4)){
            case 0: direction.add(0); direction.add(-1); vehicleBox.setBounds(850,900,25,50); break; // up
            case 1: direction.add(0); direction.add(1);  vehicleBox.setBounds(725,-50,25,50); break; // down
            case 2: direction.add(1); direction.add(0);  vehicleBox.setBounds(-50,450,50,25); break; // right
            case 3: direction.add(-1); direction.add(0); vehicleBox.setBounds(1930,325,50,25); break; // left
            default: break;
        }*/
    }/*
    @Override
    public void run(){
        while(vehicleBox.getX() > -100 && vehicleBox.getX() < 2000 && vehicleBox.getY() > -100 && vehicleBox.getY() < 1000){
            if(check_lights() && check_cars()){
                vehicleBox.x+= direction.get(0);
                vehicleBox.y+= direction.get(1);
            }
            try {Thread.sleep(2);} catch (InterruptedException e) {throw new RuntimeException(e);}
        }
    }
    public boolean check_lights(){
        for(int i=0;i<4;i++){
            if(roadMap.intersection.crossings.get(i).contains(vehicleBox.getCenterX()+(50*direction.get(0)), vehicleBox.getCenterY()+(50*direction.get(1)))){
                if(!roadMap.intersection.lights.get(i)) {
                    if(Math.abs(vehicleBox.getCenterX() - roadMap.intersection.getX_center()) < 200 && Math.abs(vehicleBox.getCenterY() - roadMap.intersection.getY_center()) < 200){
                        return true;
                    } else {return false;}
                }
            }
        }
        return true;
    }
    public boolean check_cars(){
        for(Vehicle entity : roadMap.vehicles){
            if(entity.vehicleBox.contains(vehicleBox.getCenterX()+(40*direction.get(0)), vehicleBox.getCenterY()+(40*direction.get(1)))){
                return false;
            }
        }
        return true;
    }

    public Rectangle getVehicleBox(){
        return vehicleBox;
    }*/
}
