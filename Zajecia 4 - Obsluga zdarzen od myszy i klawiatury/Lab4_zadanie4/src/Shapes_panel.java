import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RectangularShape;
import java.awt.geom.RoundRectangle2D;

public class Shapes_panel extends JPanel {
    private RoundRectangle2D R_rectangle;
    private Ellipse2D oval;
    boolean move_Rrectangle = false, move_oval = false;

    public Shapes_panel(){
        oval = new Ellipse2D.Float(200,500,120,110);
        R_rectangle = new RoundRectangle2D.Float(500,300,150,100,20,20);
        set_panel();
        create_panel_functionalities();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.darkGray);
        g.fillOval((int)oval.getX(),(int)oval.getY(),(int)oval.getWidth(),(int)oval.getHeight());
        g.setColor(Color.blue);
        g.fillRoundRect((int) R_rectangle.getX(),(int) R_rectangle.getY(),(int) R_rectangle.getWidth(),(int) R_rectangle.getHeight(),(int) R_rectangle.getArcWidth(),(int) R_rectangle.getArcHeight());

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
            public void mouseClicked(MouseEvent e) {
                if(find_shape(R_rectangle, e))  {move_Rrectangle = true; move_oval = false;}
                else if(find_shape(oval, e))    {move_oval = true; move_Rrectangle = false;}
            }
        });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if(move_Rrectangle) {move_shape(R_rectangle,key);}
                else if(move_oval)  {move_shape(oval,key);}
            }
        });
    }
    public boolean find_shape(RectangularShape shape, MouseEvent e){
        if(shape.contains(e.getX(),e.getY()))   {return true;}
        return false;
    }
    public void move_shape(RectangularShape shape, int key){
        switch(key){
            case 37: shape.setFrame(shape.getX()-10,shape.getY(),shape.getWidth(),shape.getHeight()); break;
            case 38: shape.setFrame(shape.getX(),shape.getY()-10,shape.getWidth(),shape.getHeight()); break;
            case 39: shape.setFrame(shape.getX()+10,shape.getY(),shape.getWidth(),shape.getHeight()); break;
            case 40: shape.setFrame(shape.getX(),shape.getY()+10,shape.getWidth(),shape.getHeight()); break;
            default: break;
        }
    }
}