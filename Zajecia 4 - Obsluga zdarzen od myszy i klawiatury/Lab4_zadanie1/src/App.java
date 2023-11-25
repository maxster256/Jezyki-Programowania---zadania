import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame {
    JPanel panel;
    JButton button;
    public void start(){
        init_frame();
        create_panel();
        create_button();
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

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("press");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("released");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("entered");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("exited");
            }
        });

    }
    public void create_button(){
        button = new JButton("Click me!");
        button.setBounds(350,325,100,50);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(button);
                validate();
                repaint();
            }
        });
    }
    public void add_elements(){
        //add(button);
        add(panel);
    }
}