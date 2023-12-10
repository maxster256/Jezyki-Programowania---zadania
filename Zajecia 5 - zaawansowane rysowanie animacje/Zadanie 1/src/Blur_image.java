import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public class Blur_image extends Thread{

    private Drawing_panel drawingPanel;

    public Blur_image(Drawing_panel drawingPanel){
        this.drawingPanel = drawingPanel;
    }
    @Override
    public void run(){
        float[] matrix = {
                1.0f / 16, 2.0f / 16, 1.0f / 16,
                2.0f / 16, 4.0f / 16, 2.0f / 16,
                1.0f / 16, 2.0f / 16, 1.0f / 16
        };
        Kernel kernel = new Kernel(3, 3, matrix);

        ConvolveOp convolveOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        drawingPanel.setBlurredImage(convolveOp.filter(drawingPanel.getA_Im().getImage(), null));
    }
}