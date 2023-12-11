import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{
    JPanel panel;
    JTextField field;
    Button button;
    public void start(){
        init_frame();
        create_elements();
        add_elements();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void init_frame(){
        setTitle("Paint me :DDD");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setMinimumSize(new Dimension(800,500));
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

    public void add_elements(){
        add(panel);
        add(button);
        add(field);
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
