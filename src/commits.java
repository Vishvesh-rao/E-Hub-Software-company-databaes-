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

public class commits implements ActionListener {
	
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
	        
	        if (e.getActionCommand() == "Commit") {
				String commitid = t1.getText();
				String commitmsg = t2.getText();
				
				try {
					
					if(addcommit(commitid,commitmsg,connect)) {
						
						JOptionPane.showMessageDialog(frame2, "Commit pushed!!", "Sucess", JOptionPane.PLAIN_MESSAGE);
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
		
		header=new JLabel("                          Add Commit");
		header.setForeground(new Color(255, 192, 203));
		header.setFont(new Font("TimesRoman", Font.BOLD, 72));
		title.add(header);
		
		frame2.add(title, BorderLayout.NORTH);
		
		panel = new JPanel();
		panel.setBackground(new Color(170, 170, 170));
		frame2.add(panel);
			
		panel.setLayout(null);
	    frame2.setAlwaysOnTop(true);
	    
	    JLabel h1 = new JLabel("COMMIT ID");
	    h1.setBounds(300,60, 500, 25);

	    t1 = new JTextField();
	    t1.setBounds(280, 100, 200, 25); 
	    
	    JLabel h2 = new JLabel("COMMIT");
	    h2.setBounds(300,140, 500, 25);
	    
	    t2 = new JTextField();
	    t2.setBounds(280, 180, 200, 25); 	   
	    	    	   
        add_bttn(b1, 600, 280, "Commit");
        add_bttn(b, 600, 320, "Go Back");


	    panel.add(t1);
	    panel.add(t2);

	    panel.add(h1);
	    panel.add(h2);

	    frame2.setSize(1920,1080);
		frame2.setVisible(true);
		frame2.show();
		
	}
	
	public boolean addcommit(String commitid,String commitmsg,Connection connect) throws Exception {
        
		if(commitid.equals("")) {
			return false;
		}
		else {
						
			PreparedStatement ps=null;
															
			ps = connect.prepareStatement("INSERT INTO commit VALUES(?,?)");
			ps.setString(1,commitid);
			ps.setString(2,commitmsg);
					
			ps.executeUpdate();
						
			return true;
		}
        
    }
	
	public static void main(String[] args) {
        commits c = new commits();  
       
        try {
				c.readDb();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			c.disp_page();
        
   }
	
}

