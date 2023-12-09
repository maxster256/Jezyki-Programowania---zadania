import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
    JButton image_button;
    Drawing_panel panel;
    JLabel label;
    public void start(){
        init_frame();
        panel = new Drawing_panel(screen);
        create_buttons();
        add_elements();

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void create_buttons(){
        image_button = new JButton("Open image");
        image_button.setBounds(900,900,120,50);
        add(image_button);
        image_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        BufferedImage image = ImageIO.read(selectedFile);
                        label = new JLabel();
                        label.setIcon(new ImageIcon(image));

                        panel.add(label);
                        revalidate();
                        repaint();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
    }
    public void init_frame(){
        setTitle("Shapes features");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0,0,(int)screen.getWidth(),(int)screen.getHeight());
        setLayout(null);
    }
    public void add_elements(){
        add(panel);
    }
}