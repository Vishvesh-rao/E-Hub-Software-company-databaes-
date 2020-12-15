import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.border.*;

public class update implements ActionListener {
	
	public Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
	
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	JFrame frame2;
	JPanel title,panel;
	JLabel header;
    JButton b,b1,b2,b3;
    JLabel l, l1; 
    JTextField t1,t2,t3;

	
	public void readDb() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/ehub","root","darkside");
			statement=connect.createStatement();
			System.out.println("heyyyyyy");
			
		} catch(Exception e) {
			throw e;
		}

	}
	
	   @Override
	    public void actionPerformed(ActionEvent e){
	        System.out.println("Logged out");
	        frame2.dispose();
	        
	        if (e.getActionCommand() == "Add to Ongoing") {
				String pid = t1.getText();
				
				try {
					
					if(addToOngoing(pid,connect)) {
						
						JOptionPane.showMessageDialog(frame2, "Added to Ongoing", "Success", JOptionPane.PLAIN_MESSAGE);
						new Soft_eng();
						
					}
					
					else {
						
						JOptionPane.showMessageDialog(frame2, "Update Failed.", "Error", JOptionPane.ERROR_MESSAGE);
						new Soft_eng();
						
					}
					
				} catch (Exception er) {
					
					er.printStackTrace();
				}
						
	        	
			}
	        
	        if (e.getActionCommand() == "Add to History") {
				String pid = t2.getText();
				
try {
					
					if(addToHistory(pid,connect)) {
						
						JOptionPane.showMessageDialog(frame2, "Added to History", "Success", JOptionPane.PLAIN_MESSAGE);
						new Soft_eng();
					}
					
					else {
						
						JOptionPane.showMessageDialog(frame2, "Update Failed.", "Error", JOptionPane.ERROR_MESSAGE);
						new Soft_eng();

					}
					
				} catch (Exception er) {
					
					er.printStackTrace();
				}

	        	
			}
	        else if (e.getActionCommand() == "Go Back") {
	            new Soft_eng();         

	        }
	         
	    }
	
	public void add_bttn(JButton b,int x, int y,String S) {
    	b=new JButton();
        b.setBounds(x,y,150,25);  
        b.setVisible(true);
        b.setText(S);
        b.addActionListener(this);
        panel.add(b);
    }
	
	
	public void disp_page() {
		System.out.println("hey");
		
		frame2=new JFrame();
		frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame2.setSize(dim.width,dim.height);
		
		title = new JPanel();
		title.setLayout(new GridLayout(1,2));
		title.setPreferredSize(new Dimension(dim.width, dim.height / 6));
		title.setBackground(new Color(0, 0, 0));
		title.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		header=new JLabel("                      Update Project Status");
		header.setForeground(new Color(255, 192, 203));
		header.setFont(new Font("TimesRoman", Font.BOLD, 72));
		title.add(header);
		
		frame2.add(title, BorderLayout.NORTH);
		
		panel = new JPanel();
		panel.setBackground(new Color(170, 170, 170));
		frame2.add(panel);
			
		panel.setLayout(null);
	    frame2.setAlwaysOnTop(true);
	    
	    t1 = new JTextField();
	    t1.setBounds(200, 100, 200, 25);
	    
	    t2 = new JTextField();
	    t2.setBounds(200, 230, 200, 25);
	    
	    JLabel h1 = new JLabel("PENDING TO ONGOING");
	    h1.setBounds(300,70, 500, 25);
	    
	    JLabel l1 = new JLabel("project id:");
	    l1.setBounds(100,100 , 100, 25);
	    
	    JLabel h2 = new JLabel("ONGOING TO HISTORY");
	    h2.setBounds(300, 200, 500, 25);
	    
	    JLabel l2 = new JLabel("project id:");
	    l2.setBounds(100, 230, 100, 25);
	    
	    
        add_bttn(b1, 450, 100, "Add to Ongoing");
        add_bttn(b2, 450, 230, "Add to History");
        add_bttn(b, 290, 320, "Go Back");

	    panel.add(t1);
	    panel.add(t2);
	    panel.add(l1);
	    panel.add(l2);
	    panel.add(h1);
	    panel.add(h2);
	
		frame2.setSize(1920,1080);
		frame2.setVisible(true);
		frame2.show();
		
	}
	
	public boolean addToOngoing(String pid,Connection connect) throws Exception {
        
		if(pid.equals("")) {
			return false;
		}
		else {
						
			PreparedStatement ps=null;
			ps = connect.prepareStatement("insert into ongoing select * from pending where proj_id = ?");
			ps.setString(1,pid);
	
			ps.executeUpdate();
			
			ps = connect.prepareStatement("DELETE FROM pending WHERE proj_id = ?");
			ps.setString(1,pid);
			ps.executeUpdate();
					
			return true;
		}
        
    }
	
	public boolean addToHistory(String pid,Connection connect) throws Exception {
        
		if(pid.equals(""))
			return false;
		
		else {
					
			PreparedStatement ps=null;
			ps = connect.prepareStatement("insert into history select * from ongoing where proj_id = ?");
			ps.setString(1,pid);
			
			ps.executeUpdate();

			ps = connect.prepareStatement("DELETE FROM ongoing WHERE proj_id = ?");
			ps.setString(1,pid);
			ps.executeUpdate();
			
			System.out.println("updated");
			
			return true;
		}
    }
	
	public static void main(String[] args) {
        update u = new update();  
       
        try {
				u.readDb();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			u.disp_page();
        
   }
	
}

