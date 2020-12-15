import javax.swing.*;
import java.awt.event.*;

public class client implements ActionListener{
    JFrame frame;
    JPanel panel;
    JLabel head;
    JButton b1,b2,b3,b4;

    @Override
    public void actionPerformed(ActionEvent e){
        System.out.println("Logged out");
        frame.dispose();
        
        if (e.getActionCommand() == "Ongoing") {
        	 ongoing o = new ongoing();  
             
             try {
    				o.readDb();
    			} catch (Exception e1) {
    				e1.printStackTrace();
    			}
    			o.disp_table();
		}
        
        if (e.getActionCommand() == "View Progs") {
        	viewProgs v = new viewProgs();  
            
            try {
   				v.readDb();
   			} catch (Exception e1) {
   				e1.printStackTrace();
   			}
   			v.disp_table();
		}
        
        if (e.getActionCommand() == "Add Project") {
        	addProjects ap = new addProjects();  
            
            try {
    				ap.readDb();
    			} catch (Exception e1) {
    				e1.printStackTrace();
    			}
    			ap.disp_page();
		}
        
        if (e.getActionCommand() == "Latest Commits") {
        	view_commits_user vu = new view_commits_user();  
            
            try {
   				vu.readDb();
   			} catch (Exception e1) {
   				e1.printStackTrace();
   			}
   			vu.disp_table();
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
        frame.add(b);
    }

    public client(){
        frame = new JFrame("E - HUB");
        head = new JLabel("Client DashBoard");
        
        add_bttn(b1,120,100,"Ongoing");
        add_bttn(b2,120,150,"Add Project");
        add_bttn(b3,120,200,"View Progs");
        add_bttn(b3,120,250,"Latest Commits");        
        add_bttn(b4, 120, 400, "Logout");
        
        head.setSize(50, 50);
        panel = new JPanel();
        panel.add(head);
        frame.add(panel);

        frame.setSize(400,500);           
       
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
    }

    public static void main(String[] args) {
        new client();    
    
    }

}