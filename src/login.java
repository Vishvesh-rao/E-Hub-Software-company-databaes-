import javax.swing.*;
import javax.swing.text.AttributeSet.ColorAttribute;
import java.awt.Color;
import java.awt.event.*;

public class login implements ActionListener{
    JFrame frame;
    JButton button;
    JPanel panel;
    JLabel label,label2;
    JTextField text;
    JCheckBox box1,box2,box3;
    
    public login(){

        frame = new JFrame("E-Hub Login");
        panel = new JPanel();
        button = new JButton("Login");
        
        box1 = new JCheckBox("Client");
        box1.setBounds(100,100,150,20);
        frame.add(box1);

        box2 = new JCheckBox("Software Engineer");
        box2.setBounds(100,120,150,20);
        frame.add(box2);

        box3 = new JCheckBox("Leader");
        box3.setBounds(100,140,150,20);
        frame.add(box3);

        frame.setSize(300,350);
        frame.add(panel);
        panel.setLayout(null);

        label = new JLabel("UserID");
        label.setBounds(10,20,80,25);
        panel.add(label);

        label2 = new JLabel("Password");
        label2.setBounds(10, 60,80,25);
        panel.add(label2); 
        
        text = new JTextField(20);
        text.setBounds(100,20,165,25);
        panel.add(text);

        JPasswordField password = new JPasswordField();
        password.setBounds(100,60,165,25);
        panel.add(password);

        button.setBounds(100,200,80,25);
        button.addActionListener(this);
        panel.add(button);
        
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        
        if(box1.isSelected()){
            new client();
        }
        if(box2.isSelected())
        {
          new Soft_eng();
            
        }
        if(box3.isSelected()){
            new leader();
        }

        System.out.println("Login Success");
        frame.dispose();
             
    }

}