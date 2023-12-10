import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Paint_image extends Thread{
    private Drawing_panel drawingPanel;
    private Color chosenColor;

    public Paint_image(Drawing_panel drawingPanel) {
        this.drawingPanel = drawingPanel;
    }

    @Override
    public void run() {
        SwingUtilities.invokeLater(() -> {
            chosenColor = JColorChooser.showDialog(null, "Choose a color", Color.black);
            if (chosenColor != null) {
                addPaintingMouseListeners();
            }
        });
    }

    private void addPaintingMouseListeners() {
        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                drawingPanel.paintOnCanvas(e.getX(), e.getY(),chosenColor);
            }
        });

        drawingPanel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                drawingPanel.paintOnCanvas(e.getX(), e.getY(),chosenColor);
            }
        });
    }
}
