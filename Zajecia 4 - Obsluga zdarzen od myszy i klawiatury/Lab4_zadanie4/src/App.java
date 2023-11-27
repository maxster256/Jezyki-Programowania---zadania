import javax.swing.*;

public class App extends JFrame {
    Shapes_panel shapes;
    public void start(){
        init_frame();
        create_shapes();
        add_elements();

        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void init_frame(){
        setTitle("Shapes moving by key");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,700);
        setLayout(null);
    }

    public void create_shapes(){ // and the panel itself
        shapes = new Shapes_panel();
        shapes.setBounds(0, 0, 800, 700);
    }
    public void add_elements(){
        add(shapes);
    }
}