import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
Zadanie 1: Edytor graficzny z efektami specjalnymi

Zaprojektuj edytor graficzny z możliwością rysowania i edycji obrazów.
Wprowadź efekty specjalne, takie jak rozmycie czy zmiana kolorów.
Każdy efekt specjalny powinien działać jako osobny wątek, aby nie blokować interakcji z użytkownikiem.
Wprowadź elementy współdzielonych zasobów, takie jak obrazy, które różne wątki mogą edytować.
Upewnij się, że operacje edycji nie kolidują ze sobą
 */
public class App extends JFrame {
    Dimension screen;
    JPanel panel;
    JButton image_button, paint_button, blur_button, negative_color, mono_color;
    Drawing_panel painting_panel;
    Open_image openImage;
    Paint_image paintImage;
    public void start(){
        init_frame();
        init_panel();

        painting_panel = new Drawing_panel();
        setContentPane(panel);
        panel.add(painting_panel);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                painting_panel.initialize(screen);
            }
        });
        create_buttons();

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void init_frame(){
        setTitle("Image editor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0,0,(int)screen.getWidth(),(int)screen.getHeight());
        setLayout(null);
    }
    public void init_panel(){
        panel = new JPanel();
        setBounds(0,0,(int)screen.getWidth(),(int)screen.getHeight()-200);
        setBackground(Color.white);
    }
    public void create_buttons(){
        image_button = new JButton("Open image");
        image_button.setBounds(700,900,120,50);
        add(image_button);
        image_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openImage = new Open_image(painting_panel);
                openImage.start();
            }
        });

        paint_button =  new JButton("Paint");
        paint_button.setBounds(500,900,120,50);
        add(paint_button);
        paint_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paintImage = new Paint_image(painting_panel);
                paintImage.start();
            }
        });

        blur_button = new JButton("Blur image");
        blur_button.setBounds(900,900,120,50);
        add(blur_button);
        blur_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Blur_image blurImage = new Blur_image(painting_panel);
                blurImage.start();
            }
        });

        negative_color = new JButton("Negative color");
        negative_color.setBounds(1100,900,120,50);
        add(negative_color);
        negative_color.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Negative_color negativeColor = new Negative_color(painting_panel);
                negativeColor.start();
            }
        });

        mono_color = new JButton("Mono color");
        mono_color.setBounds(1300,900,120,50);
        add(mono_color);
        mono_color.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mono_color monoColor = new Mono_color(painting_panel);
                monoColor.start();
            }
        });
    }
}