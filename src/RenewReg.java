

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class RenewReg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RenewReg dialog = new RenewReg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RenewReg() {
		setResizable(false);
		setTitle("Gym Management");
		setBounds(100, 100, 720, 447);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 36, 684, 327);
			contentPanel.add(scrollPane);
			table = new JTable();
			scrollPane.setViewportView(table);
			table.setBackground(SystemColor.menu);
		}
		
		JLabel lblNewLabel = new JLabel("Registered Members");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(201, 11, 301, 25);
		contentPanel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Renew Package");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				int row = table.getSelectedRow();
		 		String selnamemem = (String) table.getModel().getValueAt(row, 1); 
		 		new RenewDialog2(selnamemem);
			}
		});
		btnNewButton.setBounds(246, 374, 221, 23);
		contentPanel.add(btnNewButton);
	load();
	}

	

	
	private static void load()
	{

		try {
			Connection conn=ConnectionClass.connmethod();
			PreparedStatement pst,pst1,pst2,pst3,pst4;
			ResultSet rs,rs1,rs2,rs3,rs4;
			
			int hc=0,fc=0,sc=0;
			
			pst = conn.prepareStatement("select membername from gymmember");
			rs=pst.executeQuery();

			while(rs.next())
			{
				
				pst1 = conn.prepareStatement("select membername from fullpayment where membername=?");
				pst1.setString(1, rs.getString("membername"));
				rs1= pst1.executeQuery();
				if(!rs1.next())
				{
					fc=1;
				}
				
				pst2 = conn.prepareStatement("select membername from halfpaidmember where membername=?");
				pst2.setString(1, rs.getString("membername"));
				rs2 = pst2.executeQuery();
				if(!rs2.next())
				{
					hc=1;
				}
				
				pst3 = conn.prepareStatement("select name from session where name=?");
				pst3.setString(1, rs.getString("membername"));
				rs3= pst3.executeQuery();
				if(!rs3.next())
				{
					sc=1;
				}
				
				if(fc==1 && hc==1 && sc==1)
				{
					pst4 = conn .prepareStatement("select formno,membername,phoneno,age,gender,blood,dateofadmission from gymmember where membername=?");
					pst4.setString(1,  rs.getString("membername"));
					rs4 = pst4.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs4));					
					table.getColumnModel().getColumn(0).setPreferredWidth(27);
					table.getColumnModel().getColumn(1).setPreferredWidth(120);
					table.getColumnModel().getColumn(2).setPreferredWidth(50);
					table.getColumnModel().getColumn(3).setPreferredWidth(15);
					table.getColumnModel().getColumn(4).setPreferredWidth(27);
					table.getColumnModel().getColumn(5).setPreferredWidth(50);
					table.getColumnModel().getColumn(0).setHeaderValue("Form no.");
					table.getColumnModel().getColumn(1).setHeaderValue("Member Name");
					table.getColumnModel().getColumn(2).setHeaderValue("Mobile");
					table.getColumnModel().getColumn(3).setHeaderValue("Age");
					table.getColumnModel().getColumn(4).setHeaderValue("Gender");
					table.getColumnModel().getColumn(5).setHeaderValue("Blood Group");
					table.getColumnModel().getColumn(6).setHeaderValue("DOA");
					table.setBackground(Color.CYAN);
					JTableHeader header = table.getTableHeader();
				    header.setBackground(Color.yellow);
				}
				
				
			}
			
			conn.close();

		} 
		catch (Exception m) {

		}

	}
}
