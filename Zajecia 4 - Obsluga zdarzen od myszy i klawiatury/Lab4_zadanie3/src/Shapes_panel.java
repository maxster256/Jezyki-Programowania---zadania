import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.awt.geom.RoundRectangle2D;

public class Shapes_panel extends JPanel {
    private RoundRectangle2D R_rectangle;
    private Rectangle2D.Float rectangle;
    private Ellipse2D oval;
    int mouse_x = -1, mouse_y = -1, mouse_new_x = -1, mouse_new_y = -1;
    int distance_x = 2000, distance_y = 2000;
    double time;
    boolean move = false, move_rectangle = false, move_Rrectangle = false, move_oval = false;

    public Shapes_panel(){
        rectangle = new Rectangle2D.Float(200, 350, 120, 80);
        oval = new Ellipse2D.Float(180,100,120,130);
        R_rectangle = new RoundRectangle2D.Float(500,500,150,100,20,20);
        set_panel();
        create_panel_functionalities();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.cyan);         //painting rectangle
        g.fillRect((int)rectangle.x, (int)rectangle.y, (int)rectangle.width, (int)rectangle.height);
        g.setColor(Color.orange);       //painting oval
        g.fillOval((int)oval.getX(),(int)oval.getY(),(int)oval.getWidth(),(int)oval.getHeight());
        g.setColor(Color.red);          //painting rounded rectangle
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
                if(mouse_x == -1 && mouse_y == -1){
                    time = System.nanoTime();
                    if(find_shape(R_rectangle, e))       {move_Rrectangle = true;}
                    else if(find_shape(rectangle, e))   {move_rectangle = true;}
                    else if(find_shape(oval, e))        {move_oval = true;}
                }
                else{
                    time = (System.nanoTime() - time)/1000000;
                    mouse_new_x = e.getX();
                    mouse_new_y = e.getY();
                    if(move_Rrectangle)     { move_shape(R_rectangle); move_Rrectangle = false;}
                    else if(move_rectangle) { move_shape(rectangle); move_rectangle = false;}
                    else if(move_oval)      { move_shape(oval); move_oval = false;}
                    mouse_x = -1;
                    mouse_y = -1;
                }
            }
        });
    }
    public boolean find_shape(RectangularShape shape, MouseEvent e){ //locate shape at the click [x,y] coordinates
        if(shape.contains(e.getX(),e.getY())){
            mouse_x = e.getX();
            mouse_y = e.getY();
            return true;
        }
        return false;
    }

    public void move_shape(RectangularShape shape){
        double speed_x = (mouse_new_x - (int) shape.getX()) / (time/15);
        double speed_y = (mouse_new_y - (int) shape.getY()) / (time/15);
        Timer animationTimer = new Timer(0, null);
        animationTimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Math.abs((int)shape.getX() - mouse_new_x) <= distance_x && Math.abs((int)shape.getY() - mouse_new_y) <= distance_y) {
                    distance_x = Math.abs((int)shape.getX() - mouse_new_x);
                    distance_y = Math.abs((int)shape.getY() - mouse_new_y);
                    shape.setFrame(shape.getX() + speed_x, shape.getY() + speed_y, shape.getWidth(), shape.getHeight());
                    repaint();
                } else {
                    move = false;
                    ((Timer) e.getSource()).stop();
                    distance_x = 2000;
                    distance_y = 2000;
                }
            }
        });
        move = true;
        animationTimer.start();
    }
}