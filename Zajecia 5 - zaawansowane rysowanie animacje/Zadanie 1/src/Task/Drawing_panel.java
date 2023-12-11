package Task;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Drawing_panel extends JPanel{
    private App_image A_Im = new App_image();
    private BufferedImage imported_image, fixed_image;
    private int paintSize = 20;

    public void initialize(Dimension screen){
        setBounds(0,0,(int)screen.getWidth(),(int)screen.getHeight()-200);
        setBorder(BorderFactory.createLineBorder(Color.black));
        init_template();
        setLayout(null);
        setVisible(true);
    }
    public void init_template(){
        try {
            imported_image = ImageIO.read(new File("TEMPLATE.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void paintByMouse(int x, int y, Color color) {
        Graphics2D g2d;
        if(fixed_image == null) {g2d = imported_image.createGraphics();}
        else                    {g2d = fixed_image.createGraphics();}
        g2d.setColor(color);
        g2d.fillOval(x, y, paintSize, paintSize);
        g2d.dispose();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imported_image != null) {
            g.drawImage(imported_image, 0, 0, this);
            A_Im.setImage(imported_image);
        }
        if(fixed_image != null){
            g.drawImage(fixed_image, 0, 0, this);
            A_Im.setImage(fixed_image);
        }
        revalidate();
        repaint();
    }

    public void setImage(BufferedImage image) {
        this.imported_image = image;
        repaint();
    }
    public void setFixed_image(BufferedImage image) {
        this.fixed_image = image;
        repaint();
    }
    public App_image getA_Im(){
        return A_Im;
    }
    public void paintSize(int x){
        paintSize+= x;
    }
}