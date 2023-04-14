import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Toolkit;

 

public class admin {
    private static JTable table;
    private static JTable table_1;
    public void main(String[] args) {
        showWindow();
    }

 

 

 

    public void showWindow() {
        JFrame admin = new JFrame("Admin");
        admin.setResizable(false);
        admin.setIconImage(Toolkit.getDefaultToolkit().getImage(admin.class.getResource("/img/130manstudent2_100617.png")));
        admin.setBackground(Color.DARK_GRAY);
        admin.getContentPane().setBackground(Color.DARK_GRAY);
        admin.setAlwaysOnTop(true);
        admin.setBounds(100,100,735,467);
        admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        admin.getContentPane().setLayout(null);
        
        JButton show = new JButton("Show ");
        show.setBackground(new Color(240, 128, 128));
        show.setForeground(Color.DARK_GRAY);
        show.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connection conn = null ;
                conn = sql_conector.dbconnector();
                try {
                    new login();
                    String query = "select * from users ";
                    PreparedStatement pst =conn.prepareStatement(query);
                    ResultSet rs = pst.executeQuery();
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                    rs.close();
                    pst.close();
                    
                }catch (Exception e1) {
                    e1.printStackTrace();
                }
                try {
                    new login();
                    String query = "select * from grades ";
                    PreparedStatement pst =conn.prepareStatement(query);
                    ResultSet rs = pst.executeQuery();
                    table_1.setModel(DbUtils.resultSetToTableModel(rs));
                    rs.close();
                    pst.close();
                    
                }catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        show.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
        show.setBounds(30, 256, 128, 37);
        admin.getContentPane().add(show);
        
        JButton add = new JButton("Add");
        add.setBackground(new Color(240, 128, 128));
        add.setForeground(Color.DARK_GRAY);
        add.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                admin.setVisible(false);
                new insert();
                insert.showWindow();
            }
        });
        add.setBounds(30, 110, 128, 37);
        admin.getContentPane().add(add);
        
        JButton delete = new JButton("Delete");
        delete.setBackground(new Color(240, 128, 128));
        delete.setForeground(Color.DARK_GRAY);
        delete.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
        delete.addActionListener(new ActionListener() {
            @SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
                admin.setVisible(false);
                delete d1 = new delete();
                d1.showWindow();
            }
        });
        delete.setBounds(30, 37, 128, 37);
        admin.getContentPane().add(delete);
        
        JScrollPane results = new JScrollPane();
        results.setBounds(186, 176, 495, 117);
        admin.getContentPane().add(results);
        
        table_1 = new JTable();
        table_1.setForeground(new Color(240, 128, 128));
        table_1.setBackground(Color.DARK_GRAY);
        results.setViewportView(table_1);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(186, 36, 495, 117);
        admin.getContentPane().add(scrollPane);
        
        table = new JTable();
        table.setForeground(new Color(240, 128, 128));
        table.setBackground(Color.DARK_GRAY);
        scrollPane.setViewportView(table);   
        
        JButton search = new JButton("Search");
        search.setBackground(new Color(240, 128, 128));
        search.setForeground(Color.DARK_GRAY);
        search.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		admin.setVisible(false);
        		search s1 = new search();
        		s1.main(null);
        	}
        });
        search.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
        search.setBounds(30, 183, 128, 37);
        admin.getContentPane().add(search);
        
        JButton logout = new JButton("Logout");
        logout.setBackground(new Color(240, 128, 128));
        logout.setForeground(Color.DARK_GRAY);
        logout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		admin.setVisible(false);
				new login();
				login.main(null);
        	}
        });
        logout.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
        logout.setBounds(30, 342, 128, 37);
        admin.getContentPane().add(logout);
        admin.setVisible(true);
    }        
}