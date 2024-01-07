import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {
    Dimension screen;
    JButton addVehicle, addPedestrian, switchLights;
    Map roadMap;
    JPanel panel;

    public void start(){
        init_frame();
        init_panel();
        setContentPane(panel);
        roadMap = new Map();
        panel.add(roadMap);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                roadMap.initialize(screen);
            }
        });

        create_buttons();

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void init_frame(){
        setTitle("symulacja ruchu ulicznego");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0,0,(int)screen.getWidth(),(int)screen.getHeight());
        setLayout(null);
    }
    public void init_panel(){
        panel = new JPanel();
        panel.setBounds(0,0,(int)screen.getWidth(),(int)screen.getHeight()-200);
    }
    public void create_buttons(){
        addVehicle = new JButton("Add vehicle");
        addVehicle.setBounds(700,900,120,50);
        add(addVehicle);
        addVehicle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vehicle veh = new Vehicle(roadMap);
                roadMap.vehicles.add(veh);
                veh.start();
            }
        });

        addPedestrian = new JButton("Add pedestrian");
        addPedestrian.setBounds(900,900,120,50);
        add(addPedestrian);
        addPedestrian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pedestrian ped = new Pedestrian(roadMap);
                roadMap.pedestrians.add(ped);
                ped.start();
            }
        });

        switchLights = new JButton("Switch lights");
        switchLights.setBounds(1100,900,120,50);
        add(switchLights);
        switchLights.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                roadMap.intersection.switch_lights();
            }
        });
    }
}
