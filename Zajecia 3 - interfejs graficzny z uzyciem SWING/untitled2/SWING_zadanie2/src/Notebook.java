import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Notebook {
    JFrame frame;
    JTextField field;
    JTextArea area; //it works
    JButton NEW, OPEN, SAVE, CLOSE;
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
        NEW = new JButton("NEW");
        OPEN = new JButton("OPEN");
        SAVE = new JButton("SAVE");
        CLOSE = new JButton("CLOSE");

        Buttons(NEW,100);
        Buttons(OPEN,330);
        Buttons(SAVE,560);
        Buttons(CLOSE,790);
    }
    public void add_elements(){
        frame.add(area);
        frame.add(NEW);
        frame.add(OPEN);
        frame.add(SAVE);
        frame.add(CLOSE);
        frame.add(field);
    }
    public void Buttons(JButton button, int x){
        button.setBounds(x,25,110,50);
        String function = button.getText();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(function){
                    case "NEW":     NEW(); break;
                    case "OPEN":    OPEN(); break;
                    case "SAVE":    try {SAVE();} catch (IOException ex) {field.setText("An error occurred!"); throw new RuntimeException(ex);} break;
                    case "CLOSE":   CLOSE(); break;
                    default: System.out.println("oops"); break;
                }
            }
        });
    }

    public void NEW(){
        area.setText("");
    }
    public void OPEN(){
        area.setText("");
        String file_name = field.getText();
        try {
            FileReader input = new FileReader(file_name+".txt");
            BufferedReader buffer = new BufferedReader(input);
            String line;
            while((line = buffer.readLine()) != null){
                area.append(line+"\n");
            }
        } catch (FileNotFoundException e) {
            field.setText("The file couldn't be found...");
        } catch (IOException e) {
            field.setText("Error in reading a file...");
        }
    }
    public void SAVE() throws IOException {
        String file_name = field.getText();
        FileWriter output = new FileWriter(file_name+".txt");
        output.write(area.getText());
        output.close();
        field.setText("The .txt file "+file_name+" is saved");
    }
    public void CLOSE(){
        System.exit(2);
    }
}