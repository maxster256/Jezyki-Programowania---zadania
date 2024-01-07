package Task.ButtonFunctions;

import Task.Drawing_panel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public class Negative_color extends SwingWorker{
    Drawing_panel drawingPanel;
    JLabel label;
    public Negative_color(JLabel label,Drawing_panel drawingPanel){
        this.label=label;
        this.drawingPanel=drawingPanel;
    }

    @Override
    protected String doInBackground() throws Exception {
        synchronized (drawingPanel) {
            BufferedImage image = drawingPanel.getA_Im().getImage();
            int width = image.getWidth();
            int height = image.getHeight();
            int progress = 0;
            BufferedImage negative_image = drawingPanel.getBuffer();
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
                    negative_image.setRGB(x, y, p);
                    progress++;
                    publish((progress * 100) / (height * width));
                }
                Thread.sleep(1);
            }
            drawingPanel.setFixed_image(negative_image);
            drawingPanel.getA_Im().setImage(negative_image);
        }
        return "Negative image is done!";
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
