import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Halfpaid extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	public Halfpaid() {
		setResizable(false);
		setTitle("Gym Management");
		setBounds(100, 100, 707, 421);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Half Paid Members");
			lblNewLabel.setBounds(238, 9, 207, 23);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			contentPanel.add(lblNewLabel);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 671, 329);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		scrollPane.setViewportView(table);
		table.setBackground(new Color(255, 255, 255));
		
		
		Connection conn = ConnectionClass.connmethod();
		try {
			PreparedStatement pst = conn.prepareStatement("SELECT membername,package,amountremaining,lastpaiddate,amountpaid FROM halfpaidmember");
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			table.getColumnModel().getColumn(0).setHeaderValue("NAME");
			table.getColumnModel().getColumn(1).setHeaderValue("PACKAGE NAME");
			table.getColumnModel().getColumn(2).setHeaderValue("AMOUNT REMAINING");
			table.getColumnModel().getColumn(3).setHeaderValue("LAST PAID DATE");
			table.getColumnModel().getColumn(4).setHeaderValue("LAST AMOUNT PAID");
			
			conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(contentPanel, e);
		}
		
		
	}
}
