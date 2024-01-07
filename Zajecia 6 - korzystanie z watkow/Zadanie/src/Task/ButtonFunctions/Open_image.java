package Task.ButtonFunctions;

import Task.Drawing_panel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Open_image extends SwingWorker {
    JLabel label;
    Drawing_panel drawingPanel;

    public Open_image(JLabel label, Drawing_panel drawingPanel){
        this.label = label;
        this.drawingPanel=drawingPanel;
    }
    @Override
    protected String doInBackground() throws Exception {
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
                publish(99);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        Thread.sleep(500);
        //drawingPanel.init_buffer();
        return "Open image action is done!";
    }

    @Override
    protected void process(List chunks) {
        //super.process(chunks);
        int val = (int)chunks.get(chunks.size() - 1);
        label.setText("Progress: "+ val);
    }

    @Override
    protected void done() {
        //super.done();
        try {
            label.setText((String)get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
