import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ProfitPass extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfitPass frame = new ProfitPass();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ProfitPass() {
		setResizable(false);
		Image imageforframe = new ImageIcon(this.getClass().getResource("/gym4.png")).getImage();		
		setIconImage(imageforframe);
		setTitle("Gym Management");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 232, 153);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username : ");
		lblNewLabel.setBounds(10, 36, 75, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password : ");
		lblNewLabel_1.setBounds(10, 62, 75, 14);
		contentPane.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setBounds(95, 33, 111, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(95, 59, 111, 20);
		contentPane.add(password);
		
		JButton btnNewButton = new JButton("Go!");
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
			if(arg0.getKeyCode() == 10)
			{
				
				String user=username.getText();
				String pass=password.getText();
				
				try {
					Connection conn=ConnectionClass.connmethod();
					String query = "select * from login where username=? and password=?"; 
					PreparedStatement pst = conn.prepareStatement(query); 
					pst.setString(1,user); 
					pst.setString(2,pass); 
					ResultSet rs = pst.executeQuery(); 
					int count = 0; 
					while (rs.next())
					{
						count++; 
					}
					if (count == 1) 
					{
						Profit exp = new Profit();
						exp.setVisible(true);	
						dispose();
					} else 
					{
						JOptionPane.showMessageDialog(contentPane,"Please give correct login credential...");
					}
					
					conn.close();

				} 
				catch (Exception m) {

				}
			}
			
			
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String user=username.getText();
				String pass=password.getText();
				
				try {
					Connection conn=ConnectionClass.connmethod();
					String query = "select * from login where username=? and password=?"; 
					PreparedStatement pst = conn.prepareStatement(query); 
					pst.setString(1,user); 
					pst.setString(2,pass); 
					ResultSet rs = pst.executeQuery(); 
					int count = 0; 
					while (rs.next())
					{
						count++; 
					}
					if (count == 1) 
					{
						Profit exp = new Profit();
						exp.setVisible(true);	
						dispose();
					} else 
					{
						JOptionPane.showMessageDialog(contentPane,"Please give correct login credential...");
					}
					
					conn.close();

				} 
				catch (Exception m) {

				}

			
			
			
			}
		});
		btnNewButton.setBounds(63, 87, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Login Credential");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 11, 196, 14);
		contentPane.add(lblNewLabel_2);
	}

}
