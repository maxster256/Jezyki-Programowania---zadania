import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Mono_color extends Thread{
    private Drawing_panel drawingPanel;
    private Color chosenColor;
    public Mono_color(Drawing_panel drawingPanel){
        this.drawingPanel = drawingPanel;
    }
    @Override
    public void run(){
        SwingUtilities.invokeLater(() -> {
            chosenColor = JColorChooser.showDialog(null, "Choose a color", Color.black);
            if (chosenColor != null) {
                fix_image();
            }
        });
    }
    public void fix_image(){
        BufferedImage image = drawingPanel.getA_Im().getImage();
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage mono_image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = new Color(image.getRGB(x, y));

                int grayscale = (int) (color.getRed() * 0.3 + color.getGreen() * 0.59 + color.getBlue() * 0.11);

                int red = (int) (chosenColor.getRed() * (grayscale / 255.0));
                int green = (int) (chosenColor.getGreen() * (grayscale / 255.0));
                int blue = (int) (chosenColor.getBlue() * (grayscale / 255.0));

                Color newColor = new Color(red, green, blue);
                mono_image.setRGB(x, y, newColor.getRGB());
            }
        }
        drawingPanel.setFixed_image(mono_image);
        drawingPanel.getA_Im().setImage(mono_image);
    }
}
