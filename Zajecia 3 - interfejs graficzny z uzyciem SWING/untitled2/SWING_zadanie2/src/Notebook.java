import javax.swing.*;
import java.awt.*;

public class Notebook {
    private static JFrame frame;
    private static JTextField field;
    private static JTextArea area;
    Buttons NEW, OPEN, SAVE, CLOSE;
    public void start(){
        init_frame();
        create_area();
        create_field();
        create_buttons();
        add_elements();

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static JTextField getField(){
        return field;
    }
    public static JTextArea getArea(){
        return area;
    }
    public void init_frame(){
        frame = new JFrame("Notebook");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setMinimumSize(new Dimension(1000,800));
    }
    public void create_field(){
        field = new JTextField("Use this field to name the file you want to save/open");
        field.setHorizontalAlignment(JTextField.CENTER);
        field.setBounds(100,650,800,50);
    }
    public void create_area(){
        area = new JTextArea();
        area.setBounds(100,100,800,500);
        area.setBorder(BorderFactory.createLineBorder(Color.black));
    }
    public void create_buttons(){
        NEW = new Buttons(new JButton("NEW"),100);
        OPEN = new Buttons(new JButton("OPEN"),330);
        SAVE = new Buttons(new JButton("SAVE"),560);
        CLOSE = new Buttons(new JButton("CLOSE"),790);
    }
    public void add_elements(){
        frame.add(area);
        frame.add(field);
        frame.add(NEW.getButton());
        frame.add(OPEN.getButton());
        frame.add(SAVE.getButton());
        frame.add(CLOSE.getButton());
    }
}