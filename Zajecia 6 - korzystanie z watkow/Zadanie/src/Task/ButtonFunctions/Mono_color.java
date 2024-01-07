package Task.ButtonFunctions;

import Task.Drawing_panel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public class Mono_color extends SwingWorker{
    Drawing_panel drawingPanel;
    JLabel label;
    Color chosenColor;
    public Mono_color(JLabel label,Drawing_panel drawingPanel){
        this.label=label;
        this.drawingPanel=drawingPanel;
    }

    @Override
    protected String doInBackground() throws Exception {
        chosenColor = JColorChooser.showDialog(null, "Choose a color", Color.black);
        if (chosenColor != null) {
            fix_image();
        }
        return "Mono color image is done!";
    }
    public void fix_image() throws Exception{
        synchronized (drawingPanel) {
            BufferedImage image = drawingPanel.getA_Im().getImage();
            int width = image.getWidth();
            int height = image.getHeight();
            int progress = 0;
            BufferedImage mono_image = drawingPanel.getBuffer();
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    Color color = new Color(image.getRGB(x, y));

                    int grayscale = (int) (color.getRed() * 0.3 + color.getGreen() * 0.59 + color.getBlue() * 0.11);

                    int red = (int) (chosenColor.getRed() * (grayscale / 255.0));
                    int green = (int) (chosenColor.getGreen() * (grayscale / 255.0));
                    int blue = (int) (chosenColor.getBlue() * (grayscale / 255.0));

                    Color newColor = new Color(red, green, blue);
                    mono_image.setRGB(x, y, newColor.getRGB());
                    progress++;
                    publish((progress * 100) / (height * width));
                }
                Thread.sleep(2);
            }
            drawingPanel.setFixed_image(mono_image);
            drawingPanel.getA_Im().setImage(mono_image);
        }
    }

    @Override
    protected void process(List chunks) {
        //super.process(chunks);
        int val = (int)chunks.get(chunks.size() - 1);
        if(!isCancelled()) {label.setText("Progress: "+ val);}
    }

    @Override
    protected void done() {
        try {
            label.setText((String)get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } catch (CancellationException e) {
            drawingPanel.setBuffer(null);
            label.setText("cancelled operation");
        }
    }
}
