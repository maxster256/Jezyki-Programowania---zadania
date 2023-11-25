import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame {
    JPanel panel;
    public void start(){
        init_frame();
        create_panel();
        add_elements();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void init_frame(){
        setTitle("Lab 4 app");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setMinimumSize(new Dimension(800,700));
    }
    public void create_panel(){
        panel = new JPanel();
        panel.setBounds(50,50,700,600);
        panel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Panel clicked at: " + e.getX() + ", " + e.getY());
                panel.setBackground(Color.red);
            }
        });
    }
    public void add_elements(){
        add(panel);
    }
}