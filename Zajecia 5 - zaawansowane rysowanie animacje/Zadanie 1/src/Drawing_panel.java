import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Drawing_panel extends JPanel{
    private App_image A_Im = new App_image();
    private Image image;
    Graphics2D buffer;
    private BufferedImage imageToDraw, canvas, fixed_image;

    public Drawing_panel(){
        super();
        setBackground(Color.white);
    }

    public void initialize(Dimension screen){
        setBounds(0,0,(int)screen.getWidth(),(int)screen.getHeight()-200);
        setBorder(BorderFactory.createLineBorder(Color.black));
        image = createImage((int)screen.getWidth(),(int)screen.getHeight()-200);
        buffer = (Graphics2D) image.getGraphics();
        newCanvas();
        setLayout(null);
        setVisible(true);
    }

    public void paintByMouse(int x, int y, Color color) {
        Graphics2D g2d;
        if(fixed_image == null) {g2d = imageToDraw.createGraphics();}
        else                    {g2d = fixed_image.createGraphics();}
        g2d.setColor(color);
        g2d.fillOval(x, y, 20, 20);
        g2d.dispose();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imageToDraw != null) {
            g.drawImage(imageToDraw, 0, 0, this);
            A_Im.setImage(imageToDraw);
        }
        if (canvas != null) {
            g.drawImage(canvas, 0, 0, this);
        }
        if(fixed_image != null){
            g.drawImage(fixed_image, 0, 0, this);
            A_Im.setImage(fixed_image);
        }
        revalidate();
        repaint();
    }

    public void setImage(BufferedImage image) {
        this.imageToDraw = image;
        repaint();
    }

    public void setFixed_image(BufferedImage image) {
        this.fixed_image = image;
        repaint();
    }

    public App_image getA_Im(){
        return A_Im;
    }

    public void newCanvas(){
        canvas = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
    }
}
