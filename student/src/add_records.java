//add_records class
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

 


public class add_records {
    private static JTextField id;
    public static void main(String[] args) {
        showWindow();
    }
    
    Connection conn =null ;
    private static JTextField conc;
    private static JTextField graph;
    private static JTextField assem;
    private static JTextField web;
    private static JTextField network;
    private static JTextField algo;
    public static void showWindow() {
        JFrame add_record = new JFrame("add_Records");
        add_record.setTitle("Add Grades");
        add_record.setIconImage(Toolkit.getDefaultToolkit().getImage(add_records.class.getResource("/img/130manstudent2_100617.png")));
        add_record.getContentPane().setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        add_record.getContentPane().setForeground(new Color(240, 128, 128));
        add_record.getContentPane().setBackground(Color.DARK_GRAY);
        add_record.setBackground(Color.DARK_GRAY);
        add_record.setBounds(100,100,598,378);
        add_record.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add_record.getContentPane().setLayout(null);
        
        id = new JTextField();
        id.setBackground(new Color(245, 245, 245));
        id.setForeground(Color.DARK_GRAY);
        id.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        id.setBounds(183, 14, 92, 30);
        add_record.getContentPane().add(id);
        id.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Student Id");
        lblNewLabel.setForeground(new Color(240, 128, 128));
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        lblNewLabel.setBounds(10, 11, 117, 30);
        add_record.getContentPane().add(lblNewLabel);
        
        JButton confirm = new JButton("Confirm");
        confirm.setForeground(Color.DARK_GRAY);
        confirm.setBackground(new Color(240, 128, 128));
        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connection conn =null ;
                conn =sql_conector.dbconnector();
                try {
                	Statement stmt=conn.createStatement();
                    String sql = "select * from grades where id ='"+id.getText()+"'";
                    ResultSet rs1 = stmt.executeQuery(sql);
                	if(rs1.next()) {
                		stmt.close();
                		Statement stmt1=conn.createStatement();
                		String sql1 ="UPDATE grades SET concept="+conc.getText()+",graphics="+graph.getText()+",assembly="+assem.getText()+",web="+web.getText()+",network="+network.getText()+",algo="+algo.getText()+" WHERE ID = '"+id.getText()+"'";
                		stmt1.executeUpdate(sql1);
                		id.setText("");
                	    conc.setText("");
                	    graph.setText("");
                	    assem.setText("");
                	    web.setText("");
                	    network.setText("");
                	    algo.setText("");
                		JOptionPane.showMessageDialog(null, "Grades updated!");
                		stmt1.close();
                		
                	}
                	else {
                		stmt.close();
	                	Statement stmt2=conn.createStatement();
	                    String sql2 = "INSERT INTO grades values("+id.getText()+","+conc.getText()+","+graph.getText()+","+assem.getText()+","+web.getText()+","+network.getText()+","+algo.getText()+")";
	                    stmt2.executeUpdate(sql2);	
                		id.setText("");
                	    conc.setText("");
                	    graph.setText("");
                	    assem.setText("");
                	    web.setText("");
                	    network.setText("");
                	    algo.setText("");
	                    JOptionPane.showMessageDialog(null, "Grades added!");
	                    stmt2.close();
                	}
                	
                    
                }catch (Exception e1) {
                
                	JOptionPane.showMessageDialog(null, e1);
                }
            }
        });
        confirm.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        confirm.setBounds(183, 258, 92, 30);
        add_record.getContentPane().add(confirm);
        
        JButton btnNewButton = new JButton("Back");
        btnNewButton.setForeground(Color.DARK_GRAY);
        btnNewButton.setBackground(new Color(240, 128, 128));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                add_record.setVisible(false);
                new insert();
                insert.main(null);
            }
        });
        btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        btnNewButton.setBounds(450, 260, 92, 30);
        add_record.getContentPane().add(btnNewButton);
        
        JLabel lblComputerScience = new JLabel("Concept");
        lblComputerScience.setForeground(new Color(240, 128, 128));
        lblComputerScience.setHorizontalAlignment(SwingConstants.LEFT);
        lblComputerScience.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        lblComputerScience.setBounds(10, 52, 141, 30);
        add_record.getContentPane().add(lblComputerScience);
        
        conc = new JTextField();
        conc.setBackground(new Color(245, 245, 245));
        conc.setForeground(Color.DARK_GRAY);
        conc.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        conc.setColumns(10);
        conc.setBounds(183, 52, 92, 30);
        add_record.getContentPane().add(conc);
        
        JLabel lblInformationSystem = new JLabel("Graphics");
        lblInformationSystem.setForeground(new Color(240, 128, 128));
        lblInformationSystem.setHorizontalAlignment(SwingConstants.LEFT);
        lblInformationSystem.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        lblInformationSystem.setBounds(10, 93, 156, 30);
        add_record.getContentPane().add(lblInformationSystem);
        
        graph = new JTextField();
        graph.setBackground(new Color(245, 245, 245));
        graph.setForeground(Color.DARK_GRAY);
        graph.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        graph.setColumns(10);
        graph.setBounds(183, 93, 92, 30);
        add_record.getContentPane().add(graph);
        
        JLabel lblIntroductionToProgramming = new JLabel("Assembly");
        lblIntroductionToProgramming.setForeground(new Color(240, 128, 128));
        lblIntroductionToProgramming.setHorizontalAlignment(SwingConstants.LEFT);
        lblIntroductionToProgramming.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        lblIntroductionToProgramming.setBounds(10, 133, 117, 30);
        add_record.getContentPane().add(lblIntroductionToProgramming);
        
        JLabel lblOop = new JLabel("Web");
        lblOop.setForeground(new Color(240, 128, 128));
        lblOop.setHorizontalAlignment(SwingConstants.LEFT);
        lblOop.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        lblOop.setBounds(10, 174, 156, 30);
        add_record.getContentPane().add(lblOop);
        
        assem = new JTextField();
        assem.setBackground(new Color(245, 245, 245));
        assem.setForeground(Color.DARK_GRAY);
        assem.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        assem.setColumns(10);
        assem.setBounds(183, 136, 92, 30);
        add_record.getContentPane().add(assem);
        
        web = new JTextField();
        web.setBackground(new Color(245, 245, 245));
        web.setForeground(Color.DARK_GRAY);
        web.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        web.setColumns(10);
        web.setBounds(183, 177, 92, 30);
        add_record.getContentPane().add(web);
        
        JLabel lblDatabase = new JLabel("Network");
        lblDatabase.setForeground(new Color(240, 128, 128));
        lblDatabase.setHorizontalAlignment(SwingConstants.LEFT);
        lblDatabase.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        lblDatabase.setBounds(323, 14, 117, 30);
        add_record.getContentPane().add(lblDatabase);
        
        network = new JTextField();
        network.setBackground(new Color(245, 245, 245));
        network.setForeground(Color.DARK_GRAY);
        network.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        network.setColumns(10);
        network.setBounds(450, 14, 92, 30);
        add_record.getContentPane().add(network);
        
        JLabel LabelCalc = new JLabel("Algorithms");
        LabelCalc.setForeground(new Color(240, 128, 128));
        LabelCalc.setHorizontalAlignment(SwingConstants.LEFT);
        LabelCalc.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        LabelCalc.setBounds(323, 52, 117, 30);
        add_record.getContentPane().add(LabelCalc);
        
        algo = new JTextField();
        algo.setBackground(new Color(245, 245, 245));
        algo.setForeground(Color.DARK_GRAY);
        algo.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        algo.setColumns(10);
        algo.setBounds(450, 55, 92, 30);
        add_record.getContentPane().add(algo);
        add_record.setVisible(true);        
    }
}