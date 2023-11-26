import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame {
    JPanel panel;
    JLabel label;
    public void start(){
        init_frame();
        create_label();
        create_panel();
        create_panel_functionalities();
        add_elements();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void init_frame(){
        setTitle("Kliknij panel :]");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setMinimumSize(new Dimension(800,700));
    }
    public void create_panel(){
        panel = new JPanel();
        panel.setFocusable(true);
        panel.setBackground(Color.lightGray);
        panel.setBounds(50,50,700,550);
    }
    public void create_label(){
        label = new JLabel("<Pole tekstowe do wyswietlania wpolrzednych klikniecia> (nacisnecie Enter spowoduje wyczyszczenie pola tekstowego)");
        label.setBounds(50,625,700,50);
        label.setHorizontalAlignment(JLabel.CENTER);
    }
    public void create_panel_functionalities(){
        panel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                label.setText("X axis: "+e.getX()+"          Y axis: "+e.getY());
            }
        });
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //super.keyPressed(e);
                if(e.getKeyCode() == 10) {label.setText("");}
            }
        });
    }
    public void add_elements(){
        add(panel);
        add(label);
    }
}