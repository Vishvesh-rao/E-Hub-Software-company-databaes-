import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class Soft_eng implements ActionListener{
    JFrame frame;
    JPanel panel;
    JLabel head;
    JButton b1,b2,b3,b4,b5;

    @Override
    public void actionPerformed(ActionEvent e){
        System.out.println("Logged out");
        frame.dispose();
        
        if (e.getActionCommand() == "Ongoing") {
        	 ongoing_se os = new ongoing_se();  
             
             try {
    				os.readDb();
    			} catch (Exception e1) {
    				e1.printStackTrace();
    			}
    			os.disp_table();
		}
        
        if (e.getActionCommand() == "Pending") {
        	 pending pend_obj = new pending();  
             
             try {
    				pend_obj.readDb();
    			} catch (Exception e1) {
    				e1.printStackTrace();
    			}
    			pend_obj.disp_table();
       	 
		}
        
        if (e.getActionCommand() == "Update") {
        	 update u = new update();  
             
             try {
     				u.readDb();
     			} catch (Exception e1) {
     				e1.printStackTrace();
     			}
     			u.disp_page();
             
        }
        
        if (e.getActionCommand() == "Commit") {
        	commits c = new commits();  
            
            try {
    				c.readDb();
    			} catch (Exception e1) {
    				e1.printStackTrace();
    			}
    			c.disp_page();
            
       }
        
        if (e.getActionCommand() == "History") {
        	 history_se h = new history_se();  
             
             try {
    				h.readDb();
    			} catch (Exception e1) {
    				e1.printStackTrace();
    			}
    			h.disp_table();
       }
        
        else if (e.getActionCommand() == "Logout") {
            new login();         

        }
    }
    
    public void add_bttn(JButton b,int x, int y,String S) {
    	b=new JButton();
        b.setBounds(x,y,150, 50);  
        b.setVisible(true);
        b.setText(S);
        b.addActionListener(this);
        frame.add(b);;
    }

    public Soft_eng(){
        frame = new JFrame("E - HUB");
        head = new JLabel(" Software Engineer DashBoard");
        
        add_bttn(b1,120,100,"Ongoing");
        add_bttn(b2,120,150,"Pending");
        add_bttn(b3,120,200,"Update");
        add_bttn(b4,120,250,"Commit");
        add_bttn(b4,120,300,"History");        
        add_bttn(b5, 120, 400, "Logout");
        				
        head.setSize(50, 50);
        panel = new JPanel();
        panel.add(head);
        frame.add(panel);
        frame.setSize(400,500);           
       
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
    }

    public static void main(String[] args) {
        new Soft_eng();    
    
    }

}