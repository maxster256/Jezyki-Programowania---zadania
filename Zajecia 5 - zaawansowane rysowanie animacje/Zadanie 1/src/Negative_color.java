import java.awt.image.BufferedImage;

public class Negative_color extends Thread{
    private Drawing_panel drawingPanel;
    public Negative_color(Drawing_panel drawingPanel){
        this.drawingPanel = drawingPanel;
    }
    @Override
    public void run(){
        BufferedImage image = drawingPanel.getA_Im().getImage();

        int width = image.getWidth();
        int height = image.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = image.getRGB(x, y);
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;
                r = 255 - r;
                g = 255 - g;
                b = 255 - b;
                p = (a << 24) | (r << 16) | (g << 8) | b;
                image.setRGB(x, y, p);
            }
        }
        drawingPanel.setFixed_image(image);
        drawingPanel.getA_Im().setImage(image);
    }
}
