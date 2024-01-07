import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public abstract class Entity extends Thread{
    ArrayList<Integer> direction = new ArrayList<>();
    private Rectangle entityBox = new Rectangle();
    int randomizer;
    Map roadMap;
    int entityWidth, entityHeight;
    int entitySpawnOffset;
    int movementDelay;
    public Entity(Map roadMap){
        this.roadMap = roadMap;
        if(this.getClass().equals(Vehicle.class))         {randomizer=4; entityWidth=50; entityHeight=25; movementDelay=2; entitySpawnOffset=0;}
        else if(this.getClass().equals(Pedestrian.class)) {randomizer=8; entityWidth=25; entityHeight=25; movementDelay=4; entitySpawnOffset=25;}
        else {System.out.println("found error"); System.exit(13);}

        create_entity();
    }
    @Override
    public void run(){
        while(entityBox.getX() > -100 && entityBox.getX() < 2000 && entityBox.getY() > -100 && entityBox.getY() < 1000){
            if(check_lights() && check_entities()){
                entityBox.x+= direction.get(0);
                entityBox.y+= direction.get(1);
            }
            try {Thread.sleep(movementDelay);} catch (InterruptedException e) {throw new RuntimeException(e);}
        }
    }
    public boolean check_lights(){
        for(int i=0;i<4;i++){
            if(roadMap.intersection.crossings.get(i).contains(entityBox.getCenterX()+(50*direction.get(0)),entityBox.getCenterY()+(50*direction.get(1)))){
                if(roadMap.intersection.lights.get(i)) {
                    if(Math.abs(entityBox.getCenterX() - roadMap.intersection.getX_center()) < 100 && Math.abs(entityBox.getCenterY() - roadMap.intersection.getY_center()) < 100){
                        return true;
                    } else {
                        if(roadMap.intersection.crossings.get(i).contains(entityBox.getCenterX()-(direction.get(0)),entityBox.getCenterY()-(direction.get(1)))){
                            return true;
                        }
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean check_entities(){
        for(Entity entity : roadMap.entities){
            if(entity.entityBox.contains(entityBox.getCenterX()+(40*direction.get(0)),entityBox.getCenterY()+(40*direction.get(1)))){
                return false;
            }
        }
        return true;
    }
    public void create_entity(){
        Random random = new Random();
        switch (random.nextInt(randomizer)){
            case 0: direction.add(0); direction.add(-1); entityBox.setBounds(850+(4*entitySpawnOffset),900,entityHeight,entityWidth); break; // up right
            case 1: direction.add(0); direction.add(1);  entityBox.setBounds(725-(5*entitySpawnOffset),-50,entityHeight,entityWidth); break; // down left
            case 2: direction.add(1); direction.add(0);  entityBox.setBounds(-50,450+(4*entitySpawnOffset),entityWidth,entityHeight); break; // right down
            case 3: direction.add(-1); direction.add(0); entityBox.setBounds(1930,325-(5*entitySpawnOffset),entityWidth,entityHeight); break; // left up
            case 4: direction.add(0); direction.add(-1); entityBox.setBounds(600,950,entityHeight,entityWidth); break; // up left
            case 5: direction.add(0); direction.add(1);  entityBox.setBounds(950,-50,entityHeight,entityWidth); break; // down right
            case 6: direction.add(1); direction.add(0);  entityBox.setBounds(-50,200,entityWidth,entityHeight); break; // right up
            case 7: direction.add(-1); direction.add(0); entityBox.setBounds(1930,550,entityWidth,entityHeight); break; // left down
            default: break;
        }
    }
    public Rectangle getEntityBox(){
        return entityBox;
    }
}
