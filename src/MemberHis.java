import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MemberHis extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JTable table; 
	private JTextField textField;
	
	public MemberHis() {
		setResizable(false);
		setTitle("Gym Management");
		setBounds(100, 100, 497, 477);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 88, 461, 340);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		scrollPane.setViewportView(table);
		table.setBackground(new Color(255, 255, 255));
		
		
		Connection conn = ConnectionClass.connmethod();
		try {
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM packhis");
			ResultSet rs = pst.executeQuery();
		
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			table.getColumnModel().getColumn(0).setHeaderValue("NAME");
			table.getColumnModel().getColumn(1).setHeaderValue("PACKAGE NAME");
			table.getColumnModel().getColumn(2).setHeaderValue("PAID DATE");
			table.getColumnModel().getColumn(3).setHeaderValue("AMOUNT PAID");
			
			JLabel lblMembersPaymentHistory = new JLabel("Members Payment History");
			lblMembersPaymentHistory.setFont(new Font("Times New Roman", Font.BOLD, 20));
			lblMembersPaymentHistory.setBounds(120, 11, 241, 28);
			contentPanel.add(lblMembersPaymentHistory);
			
			JLabel label = new JLabel("Enter Name : ");
			label.setFont(new Font("Tahoma", Font.BOLD, 13));
			label.setBounds(10, 56, 87, 19);
			contentPanel.add(label);
			
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(107, 56, 210, 20);
			contentPanel.add(textField);
			
			JButton button = new JButton("Search!");
			button.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent arg0) {
					if(arg0.getKeyCode() == 10)
					{

						
						Connection conn = ConnectionClass.connmethod();
						try {
							
							PreparedStatement pst = conn.prepareStatement("select * from packhis where name like '"+textField.getText()+"%'");
							ResultSet rs = pst.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(rs));
							conn.close();
							
							table.getColumnModel().getColumn(0).setHeaderValue("NAME");
							table.getColumnModel().getColumn(1).setHeaderValue("PACKAGE NAME");
							table.getColumnModel().getColumn(2).setHeaderValue("PAID DATE");
							table.getColumnModel().getColumn(3).setHeaderValue("AMOUNT PAID");
							
						} catch (SQLException e) {
							JOptionPane.showMessageDialog(null, e);
						}


					}
				}
			});
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
	
					
					Connection conn = ConnectionClass.connmethod();
					try {
						
						PreparedStatement pst = conn.prepareStatement("select * from packhis where name like '"+textField.getText()+"%'");
						ResultSet rs = pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						conn.close();
						
						table.getColumnModel().getColumn(0).setHeaderValue("NAME");
						table.getColumnModel().getColumn(1).setHeaderValue("PACKAGE NAME");
						table.getColumnModel().getColumn(2).setHeaderValue("PAID DATE");
						table.getColumnModel().getColumn(3).setHeaderValue("AMOUNT PAID");
						
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, e);
					}

					
				}
			});
			button.setFont(new Font("Tahoma", Font.BOLD, 13));
			button.setBounds(325, 54, 104, 23);
			contentPanel.add(button);
	
			
			conn.close();

		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
		
		
	}
}
