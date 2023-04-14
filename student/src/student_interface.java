import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;

public class student_interface {
	private static JTable table;
	static String username;
	private static JTable table_1;
	public student_interface(String uname) {
		student_interface.username = uname;
	}

	public void main(String[] args) {
		showWindow();
		
		
	}

	public void showWindow() {
		JFrame frmStudentInterface = new JFrame("WINDOW 1");
		frmStudentInterface.setResizable(false);
		frmStudentInterface.setIconImage(Toolkit.getDefaultToolkit().getImage(student_interface.class.getResource("/img/130manstudent2_100617.png")));
		frmStudentInterface.getContentPane().setBackground(Color.DARK_GRAY);
		frmStudentInterface.setBackground(Color.DARK_GRAY);
		frmStudentInterface.setTitle("Student Data");
		frmStudentInterface.setAlwaysOnTop(true);
		frmStudentInterface.setBounds(100,100,768,497);
		frmStudentInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStudentInterface.getContentPane().setLayout(null);
		
		JButton logout = new JButton("Logout");
		logout.setForeground(Color.DARK_GRAY);
		logout.setBackground(new Color(240, 128, 128));
		logout.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		logout.setBounds(307, 336, 140, 37);
		frmStudentInterface.getContentPane().add(logout);
		JButton showrecordes= new JButton("Show Records");
		showrecordes.setForeground(Color.DARK_GRAY);
		showrecordes.setBackground(new Color(240, 128, 128));
		showrecordes.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		showrecordes.setBounds(456, 222, 140, 37);
		frmStudentInterface.getContentPane().add(showrecordes);
		showrecordes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn = null ;
                conn = sql_conector.dbconnector();
			 try {
				 String query1 = "select id from users where user_name = '"+username+"'";
                 PreparedStatement pst =conn.prepareStatement(query1);
                 ResultSet rs = pst.executeQuery();
                 int id=rs.getInt("id");
                    new login();
                    String query = "select * from grades where id ='"+id+"'";
                    PreparedStatement pst1 =conn.prepareStatement(query);
                    ResultSet rs1 = pst1.executeQuery();
                    table_1.setModel(DbUtils.resultSetToTableModel(rs1));
                    rs1.close();
                    pst1.close();
                    rs.close();
                    pst.close();
                  
                }catch (Exception e1) {
                	JOptionPane.showMessageDialog(null, e1);
                }
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBounds(37, 23, 679, 76);
		frmStudentInterface.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(240, 128, 128));
		table.setBackground(Color.DARK_GRAY);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setShowGrid(false);
		table.setBorder(null);
		scrollPane.setViewportView(table);
		
		JButton studentData = new JButton("Show Data");
		studentData.setForeground(Color.DARK_GRAY);
		studentData.setBackground(new Color(240, 128, 128));
		studentData.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		studentData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null ;
				conn = sql_conector.dbconnector();
				try {
					new login();
					String query = "select name ,address ,birthdate , id_number ,id from users Where user_name ='"+username+"'";
					PreparedStatement pst =conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
                    rs.close();
                    pst.close();
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
				
			}
		});
		studentData.setBounds(158, 222, 140, 37);
		frmStudentInterface.getContentPane().add(studentData);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(37, 123, 677, 76);
		frmStudentInterface.getContentPane().add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setShowGrid(false);
		table_1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table_1.setForeground(new Color(240, 128, 128));
		table_1.setBorder(null);
		table_1.setBackground(Color.DARK_GRAY);
		
		
		
		
		
		logout.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				frmStudentInterface.setVisible(false);
				new login();
				login.main(null);
			}
		});
		
		
		frmStudentInterface.setVisible(true);
		
	}
}
