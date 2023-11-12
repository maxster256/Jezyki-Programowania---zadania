import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Buttons {
    private JButton button;
    public Buttons(JButton button, int x){
        this.button = button;
        button.setBounds(x,25,110,50);
        String function = button.getText();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(function){
                    case "NEW":     NEW(); break;
                    case "OPEN":    OPEN(); break;
                    case "SAVE":    try {SAVE();} catch (IOException ex) {Notebook.getField().setText("An error occurred!"); throw new RuntimeException(ex);} break;
                    case "CLOSE":   CLOSE(); break;
                    default: System.out.println("oops"); break;
                }
            }
        });
    }
    public JButton getButton(){
        return button;
    }
    public void NEW(){
        Notebook.getArea().setText("");
    }
    public void OPEN(){
        Notebook.getArea().setText("");
        String file_name = Notebook.getField().getText();
        try {
            FileReader input = new FileReader(file_name+".txt");
            BufferedReader buffer = new BufferedReader(input);
            String line;
            while((line = buffer.readLine()) != null){
                Notebook.getArea().append(line+"\n");
            }
        } catch (FileNotFoundException e) {
            Notebook.getField().setText("The file couldn't be found...");
        } catch (IOException e) {
            Notebook.getField().setText("Error in reading a file...");
        }
    }
    public void SAVE() throws IOException {
        String file_name = Notebook.getField().getText();
        FileWriter output = new FileWriter(file_name+".txt");
        output.write(Notebook.getArea().getText());
        output.close();
        Notebook.getField().setText("The .txt file "+file_name+" is saved");
    }
    public void CLOSE(){
        System.exit(2);
    }
}
