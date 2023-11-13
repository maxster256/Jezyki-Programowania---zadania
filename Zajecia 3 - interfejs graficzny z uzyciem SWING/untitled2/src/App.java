import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame{
    JButton button;
    public void start(){
        init_frame();
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
        add(button);
    }
}