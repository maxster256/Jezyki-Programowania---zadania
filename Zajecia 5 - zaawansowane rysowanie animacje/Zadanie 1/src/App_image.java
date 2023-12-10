import java.awt.image.BufferedImage;

public class App_image{
    private BufferedImage image;
    public synchronized BufferedImage getImage(){
        return image;
    }
    public synchronized void setImage(BufferedImage image){
        this.image = image;
    }
}
