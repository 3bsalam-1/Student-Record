//Insert class
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

 

 

 

public class insert {

 

 

 

    public static void main(String[] args) {
        showWindow();

    }
    Connection conn =null ;
    private static JTextField student_id;
    private static JTextField birthdate;
    private static JTextField name;
    private static JTextField address;
    private static JTextField id_number;
    private static JTextField username;
    private static JTextField password;
    public static void showWindow() {
        JFrame frmAddStudent = new JFrame("Delete");
        frmAddStudent.setResizable(false);
        frmAddStudent.getContentPane().setBackground(Color.DARK_GRAY);
        frmAddStudent.setTitle("Add Student");
        frmAddStudent.setIconImage(Toolkit.getDefaultToolkit().getImage(insert.class.getResource("/img/130manstudent2_100617.png")));
        frmAddStudent.setBackground(Color.DARK_GRAY);
        frmAddStudent.setBounds(100,100,620,314);
        frmAddStudent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmAddStudent.getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Student ID");
        lblNewLabel.setForeground(new Color(240, 128, 128));
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        lblNewLabel.setBounds(35, 12, 78, 30);
        frmAddStudent.getContentPane().add(lblNewLabel);
        
        JButton btnNewButton = new JButton("Back");
        btnNewButton.setForeground(Color.DARK_GRAY);
        btnNewButton.setBackground(new Color(240, 128, 128));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmAddStudent.setVisible(false);
                admin a1= new admin();
                a1.main(null);
            }
        });
        btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        btnNewButton.setBounds(48, 199, 125, 30);
        frmAddStudent.getContentPane().add(btnNewButton);
        
        student_id = new JTextField();
        student_id.setForeground(Color.DARK_GRAY);
        student_id.setBackground(new Color(245, 245, 245));
        student_id.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        student_id.setBounds(124, 17, 160, 20);
        frmAddStudent.getContentPane().add(student_id);
        student_id.setColumns(10);
        
        JLabel lblBirthdate = new JLabel("Birthdate");
        lblBirthdate.setForeground(new Color(240, 128, 128));
        lblBirthdate.setHorizontalAlignment(SwingConstants.LEFT);
        lblBirthdate.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        lblBirthdate.setBounds(36, 43, 78, 30);
        frmAddStudent.getContentPane().add(lblBirthdate);
        
        birthdate = new JTextField();
        birthdate.setForeground(Color.DARK_GRAY);
        birthdate.setBackground(new Color(245, 245, 245));
        birthdate.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        birthdate.setColumns(10);
        birthdate.setBounds(124, 50, 160, 20);
        frmAddStudent.getContentPane().add(birthdate);
        
        JButton btnAdd = new JButton("Add Student");
        btnAdd.setForeground(Color.DARK_GRAY);
        btnAdd.setBackground(new Color(240, 128, 128));
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connection conn = null ;
                conn = sql_conector.dbconnector();
                try {
                	Statement stmt1=conn.createStatement();
                    String sql1 = "select * from users where user_name = '"+username.getText()+"' and id ='"+student_id.getText()+"'";
                    ResultSet rs1 =stmt1.executeQuery(sql1);
                    
                    
                    if(rs1.next()) {
                    	JOptionPane.showMessageDialog(null, "This user already exist!");
                    	stmt1.close();
                    }
                    else {
                    	stmt1.close();
                    	Statement stmt=conn.createStatement();
                    	String sql = "INSERT INTO users values("+student_id.getText()+",'"+birthdate.getText()+"','"+name.getText()+"','"+address.getText()+"',"+id_number.getText()+",'"+username.getText()+"',"+password.getText()+")";
                    	stmt.executeUpdate(sql);
						
                    	student_id.setText("");
                        birthdate.setText("");
                        name.setText("");
                        address.setText("");
                        id_number.setText("");
                        username.setText("");
                        password.setText("");
                    	JOptionPane.showMessageDialog(null, "Added successfully");
                    	stmt.close();
                    }
           
                }catch (Exception e1) {
                	JOptionPane.showMessageDialog(null, e1);
                }
                
                
            }
        });
        btnAdd.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        btnAdd.setBounds(221, 199, 125, 30);
        frmAddStudent.getContentPane().add(btnAdd);
        
        JLabel lblFullName = new JLabel("Full Name");
        lblFullName.setForeground(new Color(240, 128, 128));
        lblFullName.setHorizontalAlignment(SwingConstants.LEFT);
        lblFullName.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        lblFullName.setBounds(35, 78, 78, 30);
        frmAddStudent.getContentPane().add(lblFullName);
        
        name = new JTextField();
        name.setForeground(Color.DARK_GRAY);
        name.setBackground(new Color(245, 245, 245));
        name.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        name.setColumns(10);
        name.setBounds(124, 83, 160, 20);
        frmAddStudent.getContentPane().add(name);
        
        JLabel LabelAddress = new JLabel("Address");
        LabelAddress.setForeground(new Color(240, 128, 128));
        LabelAddress.setHorizontalAlignment(SwingConstants.LEFT);
        LabelAddress.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        LabelAddress.setBounds(36, 111, 78, 30);
        frmAddStudent.getContentPane().add(LabelAddress);
        
        address = new JTextField();
        address.setForeground(Color.DARK_GRAY);
        address.setBackground(new Color(245, 245, 245));
        address.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        address.setColumns(10);
        address.setBounds(124, 118, 160, 20);
        frmAddStudent.getContentPane().add(address);
        
        JLabel lblIdNumber = new JLabel("ID Number");
        lblIdNumber.setForeground(new Color(240, 128, 128));
        lblIdNumber.setHorizontalAlignment(SwingConstants.LEFT);
        lblIdNumber.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        lblIdNumber.setBounds(317, 10, 88, 30);
        frmAddStudent.getContentPane().add(lblIdNumber);
        
        id_number = new JTextField();
        id_number.setForeground(Color.DARK_GRAY);
        id_number.setBackground(new Color(245, 245, 245));
        id_number.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        id_number.setColumns(10);
        id_number.setBounds(420, 17, 160, 20);
        frmAddStudent.getContentPane().add(id_number);
        
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setForeground(new Color(240, 128, 128));
        lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
        lblUsername.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        lblUsername.setBounds(317, 43, 93, 30);
        frmAddStudent.getContentPane().add(lblUsername);
        
        username = new JTextField();
        username.setForeground(Color.DARK_GRAY);
        username.setBackground(new Color(245, 245, 245));
        username.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        username.setColumns(10);
        username.setBounds(420, 50, 160, 20);
        frmAddStudent.getContentPane().add(username);
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(new Color(240, 128, 128));
        lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
        lblPassword.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        lblPassword.setBounds(317, 78, 93, 30);
        frmAddStudent.getContentPane().add(lblPassword);
        
        password = new JTextField();
        password.setForeground(Color.DARK_GRAY);
        password.setBackground(new Color(245, 245, 245));
        password.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        password.setColumns(10);
        password.setBounds(420, 85, 160, 20);
        frmAddStudent.getContentPane().add(password);
        
        JButton records = new JButton("Add Grades");
        records.setForeground(Color.DARK_GRAY);
        records.setBackground(new Color(240, 128, 128));
        records.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmAddStudent.setVisible(false);

                add_records.showWindow();
            }
        });
        records.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        records.setBounds(394, 199, 125, 30);
        frmAddStudent.getContentPane().add(records);
        
        frmAddStudent.setVisible(true);
        
        
    }
}