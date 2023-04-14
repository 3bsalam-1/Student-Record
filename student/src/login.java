import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class login {

	public JFrame frmStudentRecord;
	public JTextField username;
	public JPasswordField password;
	public String uname ;
	public String pass ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frmStudentRecord.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	Connection conn =null ;
	
	
	
	public login() {
		initialize();
        conn =sql_conector.dbconnector();
	}
	

	
	    /**
	     * Initialize the contents of the frame.
	     */
	    public void initialize() {
	        frmStudentRecord = new JFrame();
	        frmStudentRecord.setResizable(false);
	        frmStudentRecord.setTitle("Student");
	        frmStudentRecord.getContentPane().setBackground(Color.DARK_GRAY);
	        frmStudentRecord.setBackground(Color.DARK_GRAY);
	        frmStudentRecord.setIconImage(Toolkit.getDefaultToolkit().getImage(login.class.getResource("/img/130manstudent2_100617.png")));
	        frmStudentRecord.setBounds(100, 100, 243, 350);
	        frmStudentRecord.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frmStudentRecord.getContentPane().setLayout(null);
	        
	        JLabel lblNewLabel_1 = new JLabel("Username");
	        lblNewLabel_1.setBackground(new Color(205, 92, 92));
	        lblNewLabel_1.setForeground(new Color(240, 128, 128));
	        lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
	        lblNewLabel_1.setBounds(74, 66, 81, 20);
	        frmStudentRecord.getContentPane().add(lblNewLabel_1);
	        
	        JLabel lblNewLabel_2 = new JLabel("Password");
	        lblNewLabel_2.setBackground(new Color(205, 92, 92));
	        lblNewLabel_2.setForeground(new Color(240, 128, 128));
	        lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
	        lblNewLabel_2.setBounds(74, 161, 89, 20);
	        frmStudentRecord.getContentPane().add(lblNewLabel_2);
	        
	        username = new JTextField();
	        username.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
	        username.setForeground(Color.DARK_GRAY);
	        username.setBackground(new Color(245, 245, 245));
	        username.setBounds(46, 97, 136, 26);
	        frmStudentRecord.getContentPane().add(username);
	        username.setColumns(10);
	        
	        password = new JPasswordField();
	        password.addKeyListener(new KeyAdapter() {
	        	@SuppressWarnings("deprecation")
				@Override
	        	public void keyPressed(KeyEvent e) {
	        		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
	        			conn = sql_conector.dbconnector()  ; 
	    	        	
		                try {
		                	
		                	uname = username.getText();
		    	        	pass = password.getText();
		                    new student_interface(uname);
		    	        	
		    	        	Statement stmt=conn.createStatement();
		                    String sql = "select * from admin where user_name = '"+username.getText()+"' and password ='"+password.getText()+"'";
		                    ResultSet rs = stmt.executeQuery(sql);
		                    
		                    if(rs.next()) {
		                       
		                        frmStudentRecord.setVisible(false);
		                    	
		                    	admin ad = new admin();
		                    	
		                    	ad.showWindow();
		                    	
		                    }
		                    else {    Statement stmt1=conn.createStatement();
		                    String sql1 = "select * from users where user_name = '"+username.getText()+"' and password ='"+password.getText()+"'";
		                    ResultSet rs1 = stmt1.executeQuery(sql1);
		                    if(rs1.next()) {
		                    	
		                    	frmStudentRecord.setVisible(false);
		                    	
		                    	student_interface si = new student_interface(uname);
		                    	
		                    	si.showWindow();
		                    	
		                    }else {
		                        JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
		                        }
		                    
		                   }
		                    conn.close();
		                }catch(Exception exp) {
		                    System.out.println(exp);
		                }
	        		}
	        	}
	        });
	        password.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
	        password.setForeground(Color.DARK_GRAY);
	        password.setBackground(new Color(245, 245, 245));
	        password.setBounds(44, 193, 140, 26);
	        frmStudentRecord.getContentPane().add(password);
	        
	        JButton login = new JButton("Login");
	        login.setForeground(Color.DARK_GRAY);
	        login.setVerticalAlignment(SwingConstants.TOP);
	        login.setBackground(new Color(240, 128, 128));
	        login.addActionListener(new ActionListener() {
	        	
	            @SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
	            
	        conn = sql_conector.dbconnector()  ; 
	        	
	                try {
	                	
	                	uname = username.getText();
	    	        	pass = password.getText();
	                    new student_interface(uname);
	    	        	
	    	        	Statement stmt=conn.createStatement();
	                    String sql = "select * from admin where user_name = '"+username.getText()+"' and password ='"+password.getText()+"'";
	                    ResultSet rs = stmt.executeQuery(sql);
	                    
	                    if(rs.next()) {
	                       
	                        frmStudentRecord.setVisible(false);
	                    	
	                    	admin ad = new admin();
	                    	
	                    	ad.showWindow();
	                    	
	                    }
	                    else {    Statement stmt1=conn.createStatement();
	                    String sql1 = "select * from users where user_name = '"+username.getText()+"' and password ='"+password.getText()+"'";
	                    ResultSet rs1 = stmt1.executeQuery(sql1);
	                    if(rs1.next()) {
	                    	
	                    	frmStudentRecord.setVisible(false);
	                    	
	                    	student_interface si = new student_interface(uname);
	                    	
	                    	si.showWindow();
	                    	
	                    }else {
	                        JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
	                        }
	                    
	                   }
	                    conn.close();
	                }catch(Exception exp) {
	                    System.out.println(exp);
	                }
	            }
	        });
	        login.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
	        login.setBounds(70, 244, 89, 31);
	        frmStudentRecord.getContentPane().add(login);
	    }
	}
