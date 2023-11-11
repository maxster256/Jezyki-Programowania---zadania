import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.getColor;

public class GUI {
    JFrame frame;
    JPanel panel;
    JTextField field;
    Button button;
    public void start(){
        init_frame();

        create_elements();

        frame.add(panel);
        frame.add(button);
        frame.add(field);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void init_frame(){
        frame = new JFrame("Paint me :DDD");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setMinimumSize(new Dimension(800,500));
    }
    public void create_elements(){
        button = new Button("Type color in the Text Field and click me!");
        button.setBounds(525,300,250,50);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paint_panel();
            }
        });

        field = new JTextField();
        field.setBounds(525,200,250,50);
        field.setHorizontalAlignment(JTextField.CENTER);

        panel = new JPanel();
        panel.setBackground(Color.BLUE);
        panel.setBounds(0,0,500,500);
    }

    public void paint_panel(){
        try {
            String color_name = field.getText().toUpperCase();
            Color color = (Color) Color.class.getField(color_name).get(null);
            panel.setBackground(color);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            field.setText("Unknown color!");
        }
    }
}
