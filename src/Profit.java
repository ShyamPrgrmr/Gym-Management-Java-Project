import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import net.proteanit.sql.DbUtils;
import java.awt.Canvas;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Profit extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model1 = new DefaultTableModel();
	private static DefaultTableModel model2 = new DefaultTableModel();
	private static DefaultTableModel model3 = new DefaultTableModel();
	private JTable table_1;
	private JTable table_2;
	public static void main(String[] args) {
		try {
			Profit dialog = new Profit();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Profit() {
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Gym Management");
		setResizable(false);
		setBounds(100, 100, 669, 441);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Check Monthly Profit");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(223, 11, 216, 25);
		contentPanel.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(SystemColor.activeCaptionBorder);
		tabbedPane.setBounds(10, 48, 643, 354);
		contentPanel.add(tabbedPane);
				
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("This Month", null, panel, null);
		panel.setLayout(null);
		
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)+1;
		int date = now.get(Calendar.DATE);
		String pass = date + "/" + month + "/" + year;
		
		JLabel lblNewLabel_1 = new JLabel("Date : "+pass);
		lblNewLabel_1.setBounds(10, 11, 101, 14);
		panel.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 34, 618, 281);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		table.setModel(model1);
		try
		{
			Connection conn =ConnectionClass.connmethod();
			int am = 0 ;
			int amp = 0;
			PreparedStatement pst = conn.prepareStatement("select expensename,amount,date from expenses where month=? and year =?");
			pst.setInt(1,month);
			pst.setInt(2, year);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
									
			ResultSet rs1 = pst.executeQuery();
		    while(rs1.next())
		    {
		    	am  = rs1.getInt("amount")+am;
		    }
		    
		    PreparedStatement pst1 = conn.prepareStatement("select amount from profit where month=? and year=?");
			pst1.setInt(1,month);
			pst1.setInt(2, year);

			ResultSet rs2 = pst1.executeQuery();
			while(rs2.next())
		    {
		    	amp  = rs2.getInt("amount")+amp;
		    }
			
			
			
			table.getColumnModel().getColumn(0).setPreferredWidth(27);
			table.getColumnModel().getColumn(1).setPreferredWidth(120);
			table.getColumnModel().getColumn(2).setPreferredWidth(50);
			table.getColumnModel().getColumn(0).setHeaderValue("EXPENSES IN.");
			table.getColumnModel().getColumn(1).setHeaderValue("AMOUNT.");
			table.getColumnModel().getColumn(2).setHeaderValue("DATE.");
			table.setBackground(Color.CYAN);
			
			JTableHeader header = table.getTableHeader();
		    header.setBackground(Color.yellow);
		    
		    
		    int tprofit = amp-am; 
		    
		    String msg=null;
		    if(tprofit<0)
		    {
		    	msg = "In Loss";
		    }
		    else if(tprofit>0)
		    {
		    	msg = "In Profit";
		    }
		    else
		    {
		    	msg = "Null";
		    }
		    
		    
		    
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.addRow(new Object[]{"","",""});
			model.addRow(new Object[]{"Total Earn Amount :",new Integer(amp),""});
			model.addRow(new Object[]{"Total Expense Amount :",new Integer(am),""});
			model.addRow(new Object[]{"","",""});
			model.addRow(new Object[]{"Total Profit Amount :",new Integer(tprofit),msg});
			conn.close();
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Check Month wise", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 34, 618, 281);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					String mon = (String)comboBox.getSelectedItem();
					Connection conn =ConnectionClass.connmethod();
					int am = 0 ;
					int amp = 0;
					PreparedStatement pst = conn.prepareStatement("select expensename,amount,date from expenses where month=? and year =?");
					pst.setString(1,mon);
					pst.setInt(2, year);
					ResultSet rs = pst.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
											
					ResultSet rs1 = pst.executeQuery();
				    while(rs1.next())
				    {
				    	am  = rs1.getInt("amount")+am;
				    }
				    
				    PreparedStatement pst1 = conn.prepareStatement("select amount from profit where month=? and year=?");
				    pst1.setString(1,mon);
					pst1.setInt(2, year);

					ResultSet rs2 = pst1.executeQuery();
					while(rs2.next())
				    {
				    	amp  = rs2.getInt("amount")+amp;
				    }
					
					table_1.getColumnModel().getColumn(0).setPreferredWidth(27);
					table_1.getColumnModel().getColumn(1).setPreferredWidth(120);
					table_1.getColumnModel().getColumn(2).setPreferredWidth(50);
					table_1.getColumnModel().getColumn(0).setHeaderValue("EXPENSES IN.");
					table_1.getColumnModel().getColumn(1).setHeaderValue("AMOUNT.");
					table_1.getColumnModel().getColumn(2).setHeaderValue("DATE.");
					table_1.setBackground(Color.CYAN);
					
					JTableHeader header = table_1.getTableHeader();
				    header.setBackground(Color.yellow);
				    
				    
				    int tprofit = amp-am; 
				    
				    String msg=null;
				    if(tprofit<0)
				    {
				    	msg = "In Loss";
				    }
				    else if(tprofit>0)
				    {
				    	msg = "In Profit";
				    }
				    else
				    {
				    	msg = "Null";
				    }
				    
				    
				    DefaultTableModel model = (DefaultTableModel) table_1.getModel();
					model.addRow(new Object[]{"","",""});
					model.addRow(new Object[]{"Total Earn Amount :",new Integer(amp),""});
					model.addRow(new Object[]{"Total Expense Amount :",new Integer(am),""});
					model.addRow(new Object[]{"","",""});
					model.addRow(new Object[]{"Total Profit Amount :",new Integer(tprofit),msg});
					conn.close();
				}
				catch(SQLException e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		comboBox.setBounds(121, 12, 45, 20);
		panel_1.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		
		JLabel lblNewLabel_2 = new JLabel("Select Month :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 14, 101, 14);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("Check Year wise", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 34, 618, 281);
		panel_2.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		JLabel lblSelectYear = new JLabel("Select Year :");
		lblSelectYear.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSelectYear.setBounds(10, 13, 101, 14);
		panel_2.add(lblSelectYear);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					String mon = (String)comboBox_1.getSelectedItem();
					Connection conn =ConnectionClass.connmethod();
					int am = 0 ;
					int amp = 0;
					PreparedStatement pst = conn.prepareStatement("select expensename,amount,date from expenses where year =?");
					pst.setString(1, mon);
					ResultSet rs = pst.executeQuery();
					table_2.setModel(DbUtils.resultSetToTableModel(rs));
											
					ResultSet rs1 = pst.executeQuery();
				    while(rs1.next())
				    {
				    	am  = rs1.getInt("amount")+am;
				    }
				    
				    PreparedStatement pst1 = conn.prepareStatement("select amount from profit where year=?");
				    pst1.setString(1, mon);

					ResultSet rs2 = pst1.executeQuery();
					while(rs2.next())
				    {
				    	amp  = rs2.getInt("amount")+amp;
				    }
					
					table_2.getColumnModel().getColumn(0).setPreferredWidth(27);
					table_2.getColumnModel().getColumn(1).setPreferredWidth(120);
					table_2.getColumnModel().getColumn(2).setPreferredWidth(50);
					table_2.getColumnModel().getColumn(0).setHeaderValue("EXPENSES IN.");
					table_2.getColumnModel().getColumn(1).setHeaderValue("AMOUNT.");
					table_2.getColumnModel().getColumn(2).setHeaderValue("DATE.");
					table_2.setBackground(Color.CYAN);
					
					JTableHeader header = table_2.getTableHeader();
				    header.setBackground(Color.yellow);
				    
				    
				    int tprofit = amp-am; 
				    
				    String msg=null;
				    if(tprofit<0)
				    {
				    	msg = "In Loss";
				    }
				    else if(tprofit>0)
				    {
				    	msg = "In Profit";
				    }
				    else
				    {
				    	msg = "Null";
				    }
				    
				    
				    DefaultTableModel model = (DefaultTableModel) table_2.getModel();
					model.addRow(new Object[]{"","",""});
					model.addRow(new Object[]{"Total Earn Amount :",new Integer(amp),""});
					model.addRow(new Object[]{"Total Expense Amount :",new Integer(am),""});
					model.addRow(new Object[]{"","",""});
					model.addRow(new Object[]{"Total Profit Amount :",new Integer(tprofit),msg});
					conn.close();
				}
				catch(SQLException e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		comboBox_1.setBounds(101, 11, 72, 20);
		panel_2.add(comboBox_1);
		Vector v = new Vector();
		int j=0;
		for(int i=2018; i<=year+25 ; i++)
		{
			
			v.add(Integer.toString(i));
			
		}
		comboBox_1.setModel(new DefaultComboBoxModel(v));
	}





}
