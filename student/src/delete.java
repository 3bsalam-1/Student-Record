import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class delete {
	private static JTextField id;

	public static void main(String[] args) {
	    showWindow();

	}
	Connection conn =null ;
	public static void showWindow() {
		JFrame delete1 = new JFrame("Delete");
		delete1.setResizable(false);
		delete1.setIconImage(Toolkit.getDefaultToolkit().getImage(delete.class.getResource("/img/130manstudent2_100617.png")));
		delete1.getContentPane().setBackground(Color.DARK_GRAY);
		delete1.setBackground(Color.DARK_GRAY);
		delete1.setBounds(100,100,315,395);
		delete1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		delete1.getContentPane().setLayout(null);
		
		id = new JTextField();
		id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					Connection conn =null ;
					conn =sql_conector.dbconnector();
					try {
						
						Statement stmt1=conn.createStatement();
	                    String sql4 = "select * from users where id ='"+id.getText()+"'";
	                    ResultSet rs1 = stmt1.executeQuery(sql4);
	                	if(rs1.next()) {
	                	stmt1.close();
						Statement stmt=conn.createStatement();
						String sql = "DELETE FROM grades WHERE id ="+id.getText();
	                    String sql1 = "DELETE FROM users WHERE id ="+id.getText();
	                    stmt.executeUpdate(sql1);
	                    stmt.executeUpdate(sql);
	                    id.setText("");
	                    JOptionPane.showMessageDialog(null, "Data deleted successfully!");
	                	}
	                	else {
	                	id.setText("");
	                	JOptionPane.showMessageDialog(null, "User dosen't exist!");
	                	}
					}catch (Exception e1) {
					
						JOptionPane.showMessageDialog(null, e1);
					}
					
				}
			}
		});
		id.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		id.setForeground(Color.DARK_GRAY);
		id.setBackground(new Color(245, 245, 245));
		id.setBounds(27, 118, 117, 30);
		delete1.getContentPane().add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Student Id");
		lblNewLabel.setForeground(new Color(240, 128, 128));
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 19));
		lblNewLabel.setBounds(92, 60, 117, 30);
		delete1.getContentPane().add(lblNewLabel);
		
		JButton confirm = new JButton("Confirm");
		confirm.setForeground(Color.DARK_GRAY);
		confirm.setBackground(new Color(240, 128, 128));
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn =null ;
				conn =sql_conector.dbconnector();
				try {
					
					Statement stmt1=conn.createStatement();
                    String sql4 = "select * from users where id ='"+id.getText()+"'";
                    ResultSet rs1 = stmt1.executeQuery(sql4);
                	if(rs1.next()) {
					stmt1.close();
					Statement stmt=conn.createStatement();
					String sql = "DELETE FROM grades WHERE id ="+id.getText();
                    String sql1 = "DELETE FROM users WHERE id ="+id.getText();
                    stmt.executeUpdate(sql1);
                    stmt.executeUpdate(sql);
                    id.setText("");
                    JOptionPane.showMessageDialog(null, "Data deleted successfully!");
                    stmt.close();
                	}
                	else {
                	id.setText("");
                	JOptionPane.showMessageDialog(null, "User dosen't exist!");
                	}
				}catch (Exception e1) {
				
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		confirm.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		confirm.setBounds(171, 118, 101, 30);
		delete1.getContentPane().add(confirm);
		
		JButton delete_all = new JButton("Delete All");
		delete_all.setForeground(Color.DARK_GRAY);
		delete_all.setBackground(new Color(240, 128, 128));
		delete_all.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn =null ;
				conn =sql_conector.dbconnector();
				try {
					Statement stmt=conn.createStatement();
					String sql1 = "DELETE FROM grades ";
                    String sql = "DELETE FROM users ";
                    stmt.executeUpdate(sql);
                    stmt.executeUpdate(sql1);
                    id.setText("");
					JOptionPane.showMessageDialog(null, "All data deleted successfully!");
					stmt.close();
				}catch (Exception e1) {
				
					JOptionPane.showMessageDialog(null, e1);
				}
				
			
			}
		});
		delete_all.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		delete_all.setBounds(88, 268, 124, 44);
		delete1.getContentPane().add(delete_all);
		
		JButton back = new JButton("Back");
		back.setForeground(Color.DARK_GRAY);
		back.setBackground(new Color(240, 128, 128));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete1.setVisible(false);
                admin a1= new admin();
                a1.main(null);
			}
		});
		back.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		back.setBounds(100, 200, 101, 30);
		delete1.getContentPane().add(back);
		
		delete1.setVisible(true);
		
		
	}
}
