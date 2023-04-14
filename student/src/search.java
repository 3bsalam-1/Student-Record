import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class search {
	private static JTextField id;

	public void main(String[] args) {
	    showWindow();

	}
	Connection conn =null ;
	private static JTable student_data;
	private static JTable results;
	public static void showWindow() {
		JFrame frmSearch = new JFrame("Delete");
		frmSearch.setResizable(false);
		frmSearch.getContentPane().setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		frmSearch.getContentPane().setForeground(new Color(240, 128, 128));
		frmSearch.getContentPane().setBackground(Color.DARK_GRAY);
		frmSearch.setIconImage(Toolkit.getDefaultToolkit().getImage(search.class.getResource("/img/130manstudent2_100617.png")));
		frmSearch.setTitle("Search");
		frmSearch.setBackground(Color.DARK_GRAY);
		frmSearch.setAlwaysOnTop(true);
		frmSearch.setBounds(100,100,644,395);
		frmSearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSearch.getContentPane().setLayout(null);
		
		id = new JTextField();
		id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					Connection conn = null ;
	                conn = sql_conector.dbconnector();
	                try {
	                    new login();
	                    String query = "select * from users where id ="+id.getText();
	                    PreparedStatement pst =conn.prepareStatement(query);
	                    ResultSet rs = pst.executeQuery();
	                    student_data.setModel(DbUtils.resultSetToTableModel(rs));
	                    rs.close();
	                    pst.close();
	                }catch (Exception e1) {
	                    e1.printStackTrace();
	                }
	                try {
	                    new login();
	                    String query = "select * from grades where id ="+id.getText() ;
	                    PreparedStatement pst =conn.prepareStatement(query);
	                    ResultSet rs = pst.executeQuery();
	                    results.setModel(DbUtils.resultSetToTableModel(rs));
	                    rs.close();
	                    pst.close();
	                }catch (Exception e1) {
	                    e1.printStackTrace();
	                }
					
				}
			}
		});
		id.setForeground(Color.DARK_GRAY);
		id.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		id.setBackground(new Color(245, 245, 245));
		id.setBounds(238, 222, 141, 30);
		frmSearch.getContentPane().add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Student Id");
		lblNewLabel.setForeground(new Color(240, 128, 128));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewLabel.setBounds(119, 222, 109, 30);
		frmSearch.getContentPane().add(lblNewLabel);
		
		JButton confirm = new JButton("Confirm");
		confirm.setForeground(Color.DARK_GRAY);
		confirm.setBackground(new Color(240, 128, 128));
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                Connection conn = null ;
                conn = sql_conector.dbconnector();
                try {
                    new login();
                    String query = "select * from users where id ="+id.getText();
                    PreparedStatement pst =conn.prepareStatement(query);
                    ResultSet rs = pst.executeQuery();
                    student_data.setModel(DbUtils.resultSetToTableModel(rs));
                    rs.close();
                    pst.close();
                }catch (Exception e1) {
                    e1.printStackTrace();
                }
                try {
                    new login();
                    String query = "select * from grades where id ="+id.getText() ;
                    PreparedStatement pst =conn.prepareStatement(query);
                    ResultSet rs = pst.executeQuery();
                    results.setModel(DbUtils.resultSetToTableModel(rs));
                    rs.close();
                    pst.close();
                }catch (Exception e1) {
                    e1.printStackTrace();
                }
			}
		});
		confirm.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		confirm.setBounds(399, 222, 101, 30);
		frmSearch.getContentPane().add(confirm);
		
		JButton back = new JButton("Back");
		back.setForeground(Color.DARK_GRAY);
		back.setBackground(new Color(240, 128, 128));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSearch.setVisible(false);
                admin a1 = new admin();
                a1.main(null);
			}
		});
		back.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		back.setBounds(264, 290, 101, 30);
		frmSearch.getContentPane().add(back);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 35, 496, 72);
		frmSearch.getContentPane().add(scrollPane);
		
		student_data = new JTable();
		student_data.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		student_data.setForeground(new Color(240, 128, 128));
		student_data.setBackground(Color.DARK_GRAY);
		scrollPane.setViewportView(student_data);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(66, 129, 497, 65);
		frmSearch.getContentPane().add(scrollPane_1);
		
		results = new JTable();
		results.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		results.setForeground(new Color(240, 128, 128));
		results.setBackground(Color.DARK_GRAY);
		scrollPane_1.setViewportView(results);
		
		frmSearch.setVisible(true);
		
		
	}
}
