import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameClass{
    JFrame frame;
    JLabel BMI_label;
    JButton button;
    myComponent mass_component, height_component;
    public void start(){
        init_frame();
        create_components();
        add_components();

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void init_frame(){
        frame = new JFrame("BMI Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setMinimumSize(new Dimension(500,400));
    }
    public void create_components(){
        mass_component = new myComponent(100,150,"mass (kg)");
        height_component = new myComponent(300,150,"height (m)");

        BMI_label = new JLabel();
        BMI_label.setBounds(100, 100, 300, 60);
        BMI_label.setHorizontalAlignment(JLabel.CENTER);

        button = new JButton("Calculate");
        button.setBounds(175,250,150,50);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate_BMI();
            }
        });
    }
    public void calculate_BMI(){
        try {
            double mass = Double.parseDouble(mass_component.getField().getText());
            double height = Double.parseDouble(height_component.getField().getText());
            double BMI_index = mass / (height * height);
            BMI_label.setText("Your BMI index is " + String.format("%.2f",BMI_index));
        }
        catch(NumberFormatException error){
            BMI_label.setText("<html><div style='text-align: center;'>Wrong input!<br>Make sure you use dot instead of comma<br>and there are only digits in TextFields</div></html>");
        }
        frame.revalidate();
        frame.repaint();
    }
    public void add_components(){
        frame.add(mass_component.getField());
        frame.add(mass_component.getLabel());
        frame.add(height_component.getField());
        frame.add(height_component.getLabel());
        frame.add(button);
        frame.add(BMI_label);
    }
}