import javax.swing.*;

public class myComponent{
    private JTextField field;
    private JLabel label;
    public myComponent(int x,int y,String text){
        field = new JTextField();
        field.setHorizontalAlignment(JTextField.CENTER);
        field.setBounds(x,y+50,100,40);

        label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setText("Type your "+text);
        label.setBounds(x-10,y,120,50);
    }
    public JTextField getField(){
        return field;
    }
    public JLabel getLabel(){
        return label;
    }
}