package Task;

import Task.ButtonFunctions.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class App extends JFrame {
    Dimension screen;
    JPanel panel;
    JButton image_button, paint_button, blur_button, negative_color, mono_color, save_image, clear_button;
    JButton cancel_button;
    Drawing_panel painting_panel;
    JLabel label;
    ArrayList<SwingWorker> actions = new ArrayList<>();
    public void start(){
        init_frame();
        init_panel();
        setContentPane(panel);
        painting_panel = new Drawing_panel();
        panel.add(painting_panel);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                painting_panel.initialize(screen);
            }
        });
        create_buttons();
        init_label();

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void init_frame(){
        setTitle("Lab 6 zadanie");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0,0,(int)screen.getWidth(),(int)screen.getHeight());
    }
    public void init_panel(){
        panel = new JPanel();
        setBounds(0,0,(int)screen.getWidth(),(int)screen.getHeight()-200);
        setBackground(Color.white);
    }
    public void init_label(){
        label = new JLabel("T");
        label.setBounds(500,950,800,50);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label);
    }
    public void create_buttons(){
        image_button = new JButton("Open image");
        image_button.setBounds(500,900,120,50);
        add(image_button);
        image_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Open_image(label,painting_panel).execute();
            }
        });
        paint_button =  new JButton("Paint tool");
        paint_button.setBounds(300,900,120,50);
        add(paint_button);
        paint_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("");
                new Paint_image(painting_panel).execute();
            }
        });

        blur_button = new JButton("Blur image");
        blur_button.setBounds(700,900,120,50);
        add(blur_button);
        blur_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Blur_image blurImage = new Blur_image(label,painting_panel);
                actions.add(blurImage);
                actions.get(actions.size()-1).execute();
            }
        });

        negative_color = new JButton("Negative color");
        negative_color.setBounds(900,900,120,50);
        add(negative_color);
        negative_color.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Negative_color negativeColor = new Negative_color(label,painting_panel);
                actions.add(negativeColor);
                actions.get(actions.size()-1).execute();
            }
        });

        mono_color = new JButton("Mono color");
        mono_color.setBounds(1100,900,120,50);
        add(mono_color);
        mono_color.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mono_color monoColor = new Mono_color(label,painting_panel);
                actions.add(monoColor);
                actions.get(actions.size()-1).execute();
            }
        });

        save_image = new JButton("Save image");
        save_image.setBounds(1300,900,120,50);
        add(save_image);
        save_image.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    File imageToSave = new File("saved.png");
                    ImageIO.write(painting_panel.getA_Im().getImage(), "png", imageToSave);
                    label.setText("Saved image");
                } catch (IOException ex) {throw new RuntimeException(ex);}
            }
        });

        clear_button = new JButton("Clear image");
        clear_button.setBounds(1500,900,120,50);
        add(clear_button);
        clear_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                painting_panel.init_template();
                painting_panel.setBuffer(null);
                painting_panel.setFixed_image(null);
                label.setText("Cleared image");
            }
        });
        cancel_button = new JButton("Cancel operation");
        cancel_button.setBounds(1700,900,120,50);
        add(cancel_button);
        cancel_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(SwingWorker Sw : actions){
                    Sw.cancel(true);
                }
                actions.clear();
            }
        });
    }
}
