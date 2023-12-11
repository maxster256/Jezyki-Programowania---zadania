package Task.ButtonFunctions;

import Task.Drawing_panel;

import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public class Blur_image extends Thread{

    private Drawing_panel drawingPanel;

    public Blur_image(Drawing_panel drawingPanel){
        this.drawingPanel = drawingPanel;
    }
    @Override
    public void run(){
        float[] blur_matrix = {
                1.0f / 9, 1.0f / 9, 1.0f / 9,
                1.0f / 9, 1.0f / 9, 1.0f / 9,
                1.0f / 9, 1.0f / 9, 1.0f / 9
        };
        Kernel kernel = new Kernel(3, 3, blur_matrix);

        ConvolveOp convolveOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        drawingPanel.setFixed_image(convolveOp.filter(drawingPanel.getA_Im().getImage(), null));
        drawingPanel.getA_Im().setImage(convolveOp.filter(drawingPanel.getA_Im().getImage(), null));
    }
}