import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TodayWork extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	public TodayWork() {
		setTitle("Gym Management");
		setResizable(false);
		setBounds(100, 100, 521, 404);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		table = new JTable();
		
		
	
		
		Connection conn = ConnectionClass.connmethod();
		try {
			Calendar now = Calendar.getInstance();
			int year = now.get(Calendar.YEAR);
			int month = now.get(Calendar.MONTH)+1;
			int date = now.get(Calendar.DATE);
			String pass = date + "-" + month + "-" + year;
			
			PreparedStatement pst = conn.prepareStatement("select * from towork where date=?");
			pst.setString(1, pass);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		table.getColumnModel().getColumn(0).setHeaderValue("Name Of Work");
		table.getColumnModel().getColumn(1).setHeaderValue("Date");
		table.getColumnModel().getColumn(2).setHeaderValue("Time");
		table.getColumnModel().getColumn(3).setHeaderValue("Member Name");
		
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Today's Work");
			lblNewLabel.setBounds(186, 10, 143, 25);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			contentPanel.add(lblNewLabel);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 495, 285);
		contentPanel.add(scrollPane);
		
		
		scrollPane.setViewportView(table);
		
		JDateChooser date = new JDateChooser();
		date.setDateFormatString("dd-MM-yyyy");
		date.setBounds(103, 49, 109, 20);
		contentPanel.add(date);
		
		JLabel lblNewLabel_1 = new JLabel("Select Date:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 49, 83, 20);
		contentPanel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Search!");
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==10)
				{

					Date m=date.getDateEditor().getDate();
					SimpleDateFormat form = new SimpleDateFormat("d-M-yyyy");
					String dob = form.format(m);
					
					Connection conn = ConnectionClass.connmethod();
					try {
						PreparedStatement pst = conn.prepareStatement("select * from towork where date=?");
						pst.setString(1, dob);
						ResultSet rs = pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						conn.close();
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, e);
					}
						

				}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Date m=date.getDateEditor().getDate();
				SimpleDateFormat form = new SimpleDateFormat("d-M-yyyy");
				String dob = form.format(m);
				
				Connection conn = ConnectionClass.connmethod();
				try {
					PreparedStatement pst = conn.prepareStatement("select * from towork where date=?");
					pst.setString(1, dob);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					conn.close();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e);
				}
					
			}
		});
		btnNewButton.setBounds(222, 46, 89, 23);
		contentPanel.add(btnNewButton);
	}
}
