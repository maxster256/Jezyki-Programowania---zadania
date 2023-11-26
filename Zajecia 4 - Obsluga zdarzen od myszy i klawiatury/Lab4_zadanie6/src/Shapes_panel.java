import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
public class Shapes_panel extends JPanel {
    Rectangle rectangle;
    Ellipse2D oval;
    Color oval_color = Color.black;
    Color rectangle_color = Color.green;
    boolean change_the_shape = false;

    public Shapes_panel(){
        rectangle = new Rectangle(350,550,100,80);
        oval = new Ellipse2D.Float(200,100,200,80);
        set_panel();
        create_panel_functionalities();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(change_the_shape) {
            g.setColor(rectangle_color);
            g.fillOval(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
            g.setColor(oval_color);
            g.fillRect((int)oval.getX(),(int)oval.getY(),(int)oval.getWidth(),(int)oval.getHeight());
        }
        else {
            g.setColor(rectangle_color);
            g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
            g.setColor(oval_color);
            g.fillOval((int)oval.getX(),(int)oval.getY(),(int)oval.getWidth(),(int)oval.getHeight());
        }

        revalidate();
        repaint();
    }
    public void set_panel(){
        setFocusable(true);
        setBackground(Color.lightGray);
        setBounds(50,50,700,550);
    }
    public void create_panel_functionalities(){
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if(key == 17){
                    change_the_shape = true;
                }
                else{
                    oval_color = Color.pink;
                    rectangle_color = Color.red;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();
                if(key == 17){
                    change_the_shape = false;
                }
                else{
                    oval_color = Color.black;
                    rectangle_color = Color.green;
                }
            }
        });
    }
}