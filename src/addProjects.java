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
import java.text.DateFormat;


import java.text.SimpleDateFormat;
import javax.swing.border.*;

public class addProjects implements ActionListener {
	
	public Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	JFrame frame2;
	JPanel title,panel;
	JLabel header;
    JButton b,b1;
    JLabel l, l1; 
    JTextField t1,t2,t3,t4,t5,t6;

	
	public void readDb() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/ehub","root","darkside");
			statement=connect.createStatement();
//			preparedStatement=connect.createStatement();
			System.out.println("heyyyyyy");
			
		} catch(Exception e) {
			throw e;
		}

	}
	
	   @Override
	    public void actionPerformed(ActionEvent e){
	        System.out.println("Logged out");
	        frame2.dispose();
	        
	        if (e.getActionCommand() == "Sumbit") {
				String proj_id = t1.getText();
				String proj_name = t2.getText();
				String client_id = t3.getText();
				String programmer_id = t4.getText();
				String leader_id = t5.getText();
				
				try {
					
					if(addProject(proj_id,proj_name,client_id,programmer_id,leader_id,connect)) {
						
						JOptionPane.showMessageDialog(frame2, "Added Project!!", "Success", JOptionPane.PLAIN_MESSAGE);
						new client();
						
					}
					
					else {
						
						JOptionPane.showMessageDialog(frame2, "Update Failed.", "Error", JOptionPane.ERROR_MESSAGE);
						new client();
						
					}
					
				} catch (Exception er) {
					
					er.printStackTrace();
				}
						
	        	
			}
	        	
	        else if (e.getActionCommand() == "Go Back") {
	            new leader();         

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
		
		header=new JLabel("                            Add Projects");
		header.setForeground(new Color(255, 192, 203));
		header.setFont(new Font("TimesRoman", Font.BOLD, 72));
		title.add(header);
		
		frame2.add(title, BorderLayout.NORTH);
		
		panel = new JPanel();
		panel.setBackground(new Color(170, 170, 170));
		frame2.add(panel);
			
		panel.setLayout(null);
	    frame2.setAlwaysOnTop(true);
	   	    
	    JLabel h1 = new JLabel("PROJECT ID");
	    h1.setBounds(300,60, 500, 25);

	    t1 = new JTextField();
	    t1.setBounds(280, 100, 200, 25); 
	    
	    JLabel h2 = new JLabel("PROJECT NAME");
	    h2.setBounds(300,140, 500, 25);
	    
	    t2 = new JTextField();
	    t2.setBounds(280, 180, 200, 25); 	   
	    
	    JLabel h3 = new JLabel("CLIENT ID");
	    h3.setBounds(300,220, 500, 25);
	    
	    t3 = new JTextField();
	    t3.setBounds(280, 260, 200, 25); 	    
	   
	    
	    JLabel h4 = new JLabel("PROGRAMMER ID");
	    h4.setBounds(300,300, 500, 25);
	    
	    t4 = new JTextField();
	    t4.setBounds(280, 340, 200, 25);	    
	    
	    JLabel h5 = new JLabel("LEADER ID");
	    h5.setBounds(300,380, 500, 25);
	    
	    t5 = new JTextField();
	    t5.setBounds(280, 420, 200, 25); 
	   
	    JLabel h6 = new JLabel("DUE DATE");
	    h6.setBounds(300,460, 500, 25);	  
    
	    t6 = new JTextField();
	    t6.setBounds(280, 500, 200, 25);    
	   
	   
        add_bttn(b1, 600, 280, "Sumbit");
        add_bttn(b, 600, 320, "Go Back");


	    panel.add(t1);
	    panel.add(t2);
	    panel.add(t3);
	    panel.add(t4);
	    panel.add(t5);
	    panel.add(t6);

	    panel.add(h1);
	    panel.add(h2);
	    panel.add(h3);
	    panel.add(h4);
	    panel.add(h5);
	    panel.add(h6);

	    frame2.setSize(1920,1080);
		frame2.setVisible(true);
		frame2.show();
		
	}
	
	public boolean addProject(String proj_id,String proj_name,String client_id,String programmer_id,String leader_id,Connection connect) throws Exception {
        
		if(proj_id.equals("")) {
			return false;
		}
		else {			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			java.sql.Date dueDate = new java.sql.Date(df.parse("2021-05-02").getTime());

			PreparedStatement ps=null;

			ps = connect.prepareStatement("INSERT INTO clientreq VALUES(?,?,?,?,?,?)");
			ps.setString(1,proj_id);
			ps.setString(2,proj_name);
			ps.setString(3,client_id);
			ps.setString(4,programmer_id);
			ps.setString(5,leader_id);	
			ps.setDate(6,dueDate);
			
			ps.executeUpdate();
			
			
			//System.out.println("Album Removed");
			
			return true;
		}
        
    }
	
	
	public static void main(String[] args) {
		addProjects ap = new addProjects();  
       
        try {
				ap.readDb();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			ap.disp_page();
        
   }
	
}

