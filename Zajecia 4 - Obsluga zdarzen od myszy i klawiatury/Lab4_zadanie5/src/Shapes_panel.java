import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RectangularShape;

public class Shapes_panel extends JPanel {
    Rectangle rectangle;
    Ellipse2D oval;

    public Shapes_panel(){
        rectangle = new Rectangle(50,50,100,80);
        oval = new Ellipse2D.Float(500,500,120,80);
        set_panel();
        create_panel_functionalities();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);

        g.setColor(Color.RED);
        g.fillOval((int)oval.getX(),(int)oval.getY(),(int)oval.getWidth(),(int)oval.getHeight());

        revalidate();
        repaint();
    }
    public void set_panel(){
        setFocusable(true);
        setBackground(Color.lightGray);
        setBounds(50,50,700,550);
    }
    public void create_panel_functionalities(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Przycisk myszy zostal nacisniety");
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Przycisk myszy zostal wypuszczony");
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("Przycisk myszy znalazl się w obszarze rysowania");
            }
            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("Przycisk myszy znalazl się poza obszarem rysowania");
            }
        });
        addMouseWheelListener(new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int mouse = e.getWheelRotation() * (-1);
                if(rectangle.contains(e.getX(),e.getY())){
                    change_size(rectangle,mouse);
                }
                if(oval.contains(e.getX(),e.getX())){
                    change_size(oval,mouse);
                }
            }
        });
    }
    public void change_size(RectangularShape shape, int mouse){
        double multiplier=1.0;
        switch(mouse){
            case -1: multiplier = 0.9; break;
            case 1: multiplier = 1.1; break;
            default: System.out.println("unexpected value"); break;
        }
        double X_new = shape.getCenterX() - ((shape.getCenterX() - shape.getX()) * multiplier);
        double Y_new = shape.getCenterY() - ((shape.getCenterY() - shape.getY()) * multiplier);
        double Width_new = shape.getWidth() * multiplier;
        double Height_new = shape.getHeight()*multiplier;

        shape.setFrame(X_new,Y_new,Width_new,Height_new);
    }
}
