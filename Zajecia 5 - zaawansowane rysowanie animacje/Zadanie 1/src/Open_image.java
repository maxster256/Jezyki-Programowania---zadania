import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Open_image extends Thread{

    //private App_image A_Im = new App_image();
    private Drawing_panel drawingPanel;

    public Open_image(Drawing_panel drawingPanel) {
        this.drawingPanel = drawingPanel;
    }
    /*
    public App_image getA_Im(){
        return A_Im;
    }*/

    @Override
    public void run() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try {
                    BufferedImage image = ImageIO.read(selectedFile);
                    //A_Im.setImage(image);
                    SwingUtilities.invokeLater(() -> drawingPanel.setImage(image));

                    drawingPanel.newCanvas();
                    drawingPanel.setBlurredImage(null);
                    drawingPanel.revalidate();
                    drawingPanel.repaint();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            Thread.sleep(100);
        }catch(InterruptedException e){}
    }
}
