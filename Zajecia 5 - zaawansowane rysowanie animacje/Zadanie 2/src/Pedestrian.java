import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Pedestrian extends Entity{

    private ArrayList<Integer> direction = new ArrayList<>();
    private Rectangle pedestrianBox = new Rectangle();
    Map roadMap;
    public Pedestrian(Map roadMap){
        super(roadMap);
        /*
        this.roadMap = roadMap;
        Random random = new Random();
        switch (random.nextInt(8)){
            case 0: direction.add(0); direction.add(1); pedestrianBox.setBounds(600,-50,20,20); break; // up left
            case 1: direction.add(0); direction.add(-1);  pedestrianBox.setBounds(600,950,20,20); break; // down left
            case 2: direction.add(-1); direction.add(0);  pedestrianBox.setBounds(1930,200,20,20); break; // right up
            case 3: direction.add(1); direction.add(0); pedestrianBox.setBounds(-50,200,20,20); break; // left up
            case 4: direction.add(0); direction.add(1); pedestrianBox.setBounds(950,-50,20,20); break; // up right
            case 5: direction.add(0); direction.add(-1);  pedestrianBox.setBounds(950,950,20,20); break; // down right
            case 6: direction.add(-1); direction.add(0);  pedestrianBox.setBounds(1930,550,20,20); break; // right down
            case 7: direction.add(1); direction.add(0); pedestrianBox.setBounds(-50,550,20,20); break; // left down
            default: break;
        }*/
    }/*
    @Override
    public void run(){
        while(pedestrianBox.getX() > -100 && pedestrianBox.getX() < 2000 && pedestrianBox.getY() > -100 && pedestrianBox.getY() < 1000){
            if(check_lights()){
                pedestrianBox.x+= direction.get(0);
                pedestrianBox.y+= direction.get(1);
            }
            try {Thread.sleep(5);} catch (InterruptedException e) {throw new RuntimeException(e);}
        }
    }
    public boolean check_lights(){
        for(int i=0;i<4;i++){
            if(roadMap.intersection.crossings.get(i).contains(pedestrianBox.getCenterX()+(50*direction.get(0)),pedestrianBox.getCenterY()+(50*direction.get(1)))){
                if(roadMap.intersection.lights.get(i)) {
                    if(Math.abs(pedestrianBox.getCenterX() - roadMap.intersection.getX_center()) < 100 && Math.abs(pedestrianBox.getCenterY() - roadMap.intersection.getY_center()) < 100){
                        return true;
                    } else {
                        if(roadMap.intersection.crossings.get(i).contains(pedestrianBox.getCenterX()-(direction.get(0)),pedestrianBox.getCenterY()-(direction.get(1)))){
                            return true;
                        }
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public Rectangle getPedestrianBox(){
        return pedestrianBox;
    }*/
}
