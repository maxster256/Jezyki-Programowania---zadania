import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class Shapes_panel extends JPanel {
    public Shapes_panel(){
        set_panel();
        create_panel_functionalities();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(50, 50, 100, 80);

        g.setColor(Color.RED);
        g.fillOval(500, 500, 120, 80);

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
                System.out.println("Przycisk myszy znalazl się wobszarze rysowania");
            }
            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("Przycisk myszy znalazl się poza obszarem rysowania");
            }
        });
        addMouseWheelListener(new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int mouse = e.getWheelRotation();

            }
        });
    }
}
