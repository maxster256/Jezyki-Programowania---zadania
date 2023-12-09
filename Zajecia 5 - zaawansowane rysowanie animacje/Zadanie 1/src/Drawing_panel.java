import javax.swing.*;
import java.awt.*;

public class Drawing_panel extends JPanel {
    public Drawing_panel(Dimension screen){
        setBounds(0,0,(int)screen.getWidth(),(int)screen.getHeight()-300);
    }
}
