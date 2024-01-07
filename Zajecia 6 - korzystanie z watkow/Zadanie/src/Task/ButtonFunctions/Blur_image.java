package Task.ButtonFunctions;

import Task.Drawing_panel;

import javax.swing.*;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public class Blur_image extends SwingWorker{
    Drawing_panel drawingPanel;
    JLabel label;
    public Blur_image(JLabel label,Drawing_panel drawingPanel){
        this.label=label;
        this.drawingPanel=drawingPanel;
    }

    @Override
    protected String doInBackground() throws Exception {
        float[] blur_matrix = {
                1.0f / 9, 1.0f / 9, 1.0f / 9,
                1.0f / 9, 1.0f / 9, 1.0f / 9,
                1.0f / 9, 1.0f / 9, 1.0f / 9
        };
        Kernel kernel = new Kernel(3, 3, blur_matrix);

        ConvolveOp convolveOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        drawingPanel.setFixed_image(convolveOp.filter(drawingPanel.getA_Im().getImage(), null));
        drawingPanel.getA_Im().setImage(convolveOp.filter(drawingPanel.getA_Im().getImage(), null));
        return "Blurring image is done!";
    }

    @Override
    protected void process(List chunks) {
        //super.process(chunks);
    }

    @Override
    protected void done() {
        try {
            label.setText((String)get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } catch (CancellationException e) {
            label.setText("cancelled operation");
        }
    }
}
