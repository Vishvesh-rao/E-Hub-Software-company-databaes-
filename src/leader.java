import javax.swing.*;
import java.awt.event.*;

public class leader implements ActionListener{
    JFrame frame;
    JPanel panel;
    JLabel head;
    JButton b1,b2,b3,b4,b5;

    @Override
    public void actionPerformed(ActionEvent e){
        System.out.println("Logged out");
        frame.dispose();
        
        if (e.getActionCommand() == "Programmers") {
        	 programmer p = new programmer();  
             
             try {
    				p.readDb();
    			} catch (Exception e1) {
    				e1.printStackTrace();
    			}
    			p.disp_table();
             
		}
        
        if (e.getActionCommand() == "Assign Projects") {
        	assign a = new assign();  
            
            try {
    				a.readDb();
    			} catch (Exception e1) {
    				e1.printStackTrace();
    			}
    			a.disp_page();
        }        
        
        if (e.getActionCommand() == "Client Details") {
        	clientDetails d = new clientDetails();  
            
            try {
   				d.readDb();
   			} catch (Exception e1) {
   				e1.printStackTrace();
   			}
   			d.disp_table();
        }        
        
        if (e.getActionCommand() == "Client Requests") {
        	clientRequests r = new clientRequests();  
            
            try {
   				r.readDb();
   			} catch (Exception e1) {
   				e1.printStackTrace();
   			}
   			r.disp_table();
        }        
        
        if (e.getActionCommand() == "History") {
        	 history_leader hl = new history_leader();  
             
             try {
    				hl.readDb();
    			} catch (Exception e1) {
    				e1.printStackTrace();
    			}
    			hl.disp_table();
        }        
        
        if (e.getActionCommand() == "View Commits") {
        	 view_commits_leader vl = new view_commits_leader();  
             
             try {
    				vl.readDb();
    			} catch (Exception e1) {
    				e1.printStackTrace();
    			}
    			vl.disp_table();
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

    public leader(){
        frame = new JFrame("E - HUB");
        head = new JLabel("Leader DashBoard");
        
        add_bttn(b1,120,100,"Programmers");
        add_bttn(b2,120,150,"Client Details");
        add_bttn(b3,120,200,"Client Requests");
        add_bttn(b4,120,250,"Assign Projects");
        add_bttn(b4,120,300,"View Commits");
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
        new leader();    
    
    }

}