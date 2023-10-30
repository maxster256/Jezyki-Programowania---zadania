import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main().start();
            }
        });
    }

    public void start(){
        JFrame frame = new JFrame("FirstSwingApp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Hi!");
        frame.getContentPane().add(label);

        frame.pack();
        frame.setVisible(true);
    }
}