import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Open_image extends Thread{

    private Drawing_panel drawingPanel;

    public Open_image(Drawing_panel drawingPanel) {
        this.drawingPanel = drawingPanel;
    }
    @Override
    public void run() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                BufferedImage image = ImageIO.read(selectedFile);
                drawingPanel.setImage(image);
                drawingPanel.setFixed_image(null);
                drawingPanel.revalidate();
                drawingPanel.repaint();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}