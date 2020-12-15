import javax.swing.*;
import java.awt.event.*;

public class err{
    JFrame frame;
    JPanel panel;
    JLabel head;

    public err(){
        frame = new JFrame("Error");
        head = new JLabel("Please make only one Selection");

        head.setSize(70, 70);
        panel = new JPanel();
        panel.add(head);
        frame.add(panel);

        frame.setSize(300,200);           
       
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
    }

    public static void main(String[] args) {
        new err();    
    
    }

}