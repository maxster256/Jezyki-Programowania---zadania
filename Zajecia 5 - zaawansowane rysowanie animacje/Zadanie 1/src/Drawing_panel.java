import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Drawing_panel extends JPanel{
    private App_image A_Im = new App_image();
    private int delay = 50;
    private Timer timer;
    private Image image;
    Graphics2D buffer;
    private BufferedImage imageToDraw, canvas, blurredImage, merged_image;

    public Drawing_panel(){
        super();
        setBackground(Color.white);
        //timer = new Timer(delay,this);
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

    public void paintOnCanvas(int x, int y, Color color) {
        Graphics2D g2d = canvas.createGraphics();
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
            A_Im.setImage(mergeImages(imageToDraw,canvas));
        }
        if (canvas != null) {
            g.drawImage(canvas, 0, 0, this);
        }
        if(blurredImage != null){
            g.drawImage(blurredImage, 0, 0, this);
        }
        revalidate();
        repaint();
    }
    public BufferedImage mergeImages(BufferedImage PNG, BufferedImage painted) {
        BufferedImage mergedImage = new BufferedImage(
                PNG.getWidth(), PNG.getHeight(), BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = mergedImage.createGraphics();
        g2d.drawImage(PNG, 0, 0, null);
        g2d.drawImage(painted, 0, 0, null);
        g2d.dispose();

        return mergedImage;
    }

    public void setImage(BufferedImage image) {
        this.imageToDraw = image;
        repaint();
    }

    public void setBlurredImage(BufferedImage image) {
        this.blurredImage = image;
        repaint();
    }

    public App_image getA_Im(){
        return A_Im;
    }

    public BufferedImage getCanvas(){
        return canvas;
    }
    public void newCanvas(){
        canvas = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
    }
}
