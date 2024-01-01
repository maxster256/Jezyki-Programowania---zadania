package Task.ButtonFunctions;

import Task.Drawing_panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class Paint_image extends Thread{
    private Drawing_panel drawingPanel;
    private Color chosenColor;

    public Paint_image(Drawing_panel drawingPanel) {
        this.drawingPanel = drawingPanel;
    }

    @Override
    public void run() {
        chosenColor = JColorChooser.showDialog(null, "Choose a color", Color.black);
        if (chosenColor != null) {
            addPaintingMouseListeners();
        }
    }

    private void addPaintingMouseListeners() {
        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                drawingPanel.paintByMouse(e.getX(), e.getY(),chosenColor);
            }
        });

        drawingPanel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                drawingPanel.paintByMouse(e.getX(), e.getY(),chosenColor);
            }
        });

        drawingPanel.addMouseWheelListener(new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                super.mouseWheelMoved(e);
                drawingPanel.paintSize(e.getWheelRotation()*(-3));
            }
        });
    }
}