import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.TableView.TableRow;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Expenses extends JFrame {

	private JPanel contentPane;
	private JTextField txtdate;
	private JTextField txtexp;
	private JTextField Amount;
	private static JTable table;
	private JTable table1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Expenses frame = new Expenses();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public Expenses() {
		setTitle("Gym Management");	
		
		Image imageforframe = new ImageIcon(this.getClass().getResource("/gym4.png")).getImage();		
		setIconImage(imageforframe);
	
		setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setBounds(0, 0, 1690, 764);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.RED, 4, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel HOME = new JLabel("Home");
		HOME.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		HOME.setIcon(new ImageIcon(Session.class.getResource("/resources/icons/back.png")));
		HOME.setBounds(1304, 37, 56, 28);
		contentPane.add(HOME);
		
		JLabel logo = new JLabel("UNIVERSAL HEALTH CLUB");
		logo.setBounds(10, 11, 350, 28);
		logo.setForeground(Color.RED);
		logo.setFont(new Font("Khmer UI", Font.BOLD, 22));
		contentPane.add(logo);
		
		Calendar now = Calendar.getInstance();
		int ye = now.get(Calendar.YEAR);
		Vector v = new Vector();
		int j=0;
		for(int i=2018; i<=ye+25 ; i++)
		{
			
			v.add(Integer.toString(i));
			
		}
		
		
		JLabel lblNewLabel = new JLabel("Siddi Vianyak colony, Saturna, Amravati");
		lblNewLabel.setBounds(10, 37, 373, 25);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 75, 1444, 2);
		separator.setBackground(Color.RED);
		contentPane.add(separator);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.YELLOW, 2));
		panel.setBounds(10, 88, 546, 602);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		

		
		JLabel lblExpenses = new JLabel("EXPENSES");
		lblExpenses.setBounds(223, 0, 100, 28);
		panel.add(lblExpenses);
		lblExpenses.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblName = new JLabel("EXPENSE IN");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblName.setBackground(Color.GRAY);
		lblName.setBounds(10, 77, 88, 25);
		panel.add(lblName);
		
		JLabel lblAmount = new JLabel("Date");
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAmount.setBackground(Color.GRAY);
		lblAmount.setBounds(10, 41, 88, 25);
		panel.add(lblAmount);
		
		JLabel lblTodaysDate = new JLabel("Amount");
		lblTodaysDate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTodaysDate.setBackground(Color.GRAY);
		lblTodaysDate.setBounds(10, 113, 100, 25);
		panel.add(lblTodaysDate);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(-18, 185, 1444, 2);
		panel.add(separator_1);
		separator_1.setBackground(Color.RED);
		
		JButton Save = new JButton("Save");
		Save.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
			if(arg0.getKeyCode()==10)
			{
				try 
				{
				java.sql.Connection conn = ConnectionClass.connmethod();
				Calendar now = Calendar.getInstance();
				int month = now.get(Calendar.MONTH)+1;
				int year = now.get(Calendar.YEAR);
				int mon = month ;
				
				String query="insert into expenses values (?,?,?,?,?)";
				java.sql.PreparedStatement pst= conn.prepareStatement(query);
				
				
				
				pst.setString(1,txtexp.getText());
				pst.setString(2,Amount.getText());
				String date=txtdate.getText();
				pst.setString(3,date);
				pst.setInt(4,mon);
				pst.setInt(5,year);		
				
				pst.execute();
				
				JOptionPane.showMessageDialog(null,"Data Saved" );
				pst.close();
		
				load();
				conn.close();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,e1);

				}

			}
			}
		});
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try 
					{
					java.sql.Connection conn = ConnectionClass.connmethod();
					Calendar now = Calendar.getInstance();
					int month = now.get(Calendar.MONTH)+1;
					int year = now.get(Calendar.YEAR);
					int mon = month ;
					
					String query="insert into expenses values (?,?,?,?,?)";
					java.sql.PreparedStatement pst= conn.prepareStatement(query);
					
					
					
					pst.setString(1,txtexp.getText());
					pst.setString(2,Amount.getText());
					String date=txtdate.getText();
					pst.setString(3,date);
					pst.setInt(4,mon);
					pst.setInt(5,year);		
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"Data Saved" );
					pst.close();
			
					load();
					conn.close();
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null,e1);

					}
				
				
				
}
		});
		Save.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Save.setBounds(198, 149, 107, 25);
		panel.add(Save);
		
		JLabel lblTodaysExpenses = new JLabel("TODAYS EXPENSES");
		lblTodaysExpenses.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTodaysExpenses.setBounds(177, 194, 192, 28);
		panel.add(lblTodaysExpenses);
		
		txtdate = new JTextField();
		txtdate.setEditable(false);
		txtdate.setBounds(108, 44, 124, 20);
		panel.add(txtdate);
		txtdate.setColumns(10);
		
		txtexp = new JTextField();
		txtexp.setToolTipText("expense name eg.petrol");
		txtexp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				String v = txtexp.getText();
				boolean b = ValidationClass.charactercheckadd(v);
				if(b)
				{
					
				}
				else
				{
					String sub  = txtexp.getText();
					int l = sub.length();
					txtexp.setText(sub.substring(0, l-1));
				}
			}
		});
		txtexp.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				String v = txtexp.getText();
				boolean b = ValidationClass.charactercheckadd(v);
				if(b)
				{
					
				}
				else
				{
					String sub  = txtexp.getText();
					int l = sub.length();
					txtexp.setText(sub.substring(0, l-1));
				}
			}
		});
		txtexp.setColumns(10);
		txtexp.setBounds(108, 80, 172, 20);
		panel.add(txtexp);
		
		Amount = new JTextField();
		Amount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				String v = Amount.getText();
				boolean b = ValidationClass.decimalnumcheck(v);
				if(b)
				{
					
				}
				else
				{
					String sub  = Amount.getText();
					int l = sub.length();
					Amount.setText(sub.substring(0, l-1));
				}
			}
		});
		Amount.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				String v = Amount.getText();
				boolean b = ValidationClass.decimalnumcheck(v);
				if(b)
				{
					
				}
				else
				{
					String sub  = Amount.getText();
					int l = sub.length();
					Amount.setText(sub.substring(0, l-1));
				}
			}
		});
		Amount.setColumns(10);
		Amount.setBounds(108, 116, 124, 20);
		panel.add(Amount);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.YELLOW, 2));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(560, 88, 789, 602);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMontlyExpenses = new JLabel("MONTLY EXPENSES");
		lblMontlyExpenses.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMontlyExpenses.setBounds(346, 11, 192, 28);
		panel_1.add(lblMontlyExpenses);
		
		
		JLabel label = new JLabel("");
		label.setBounds(138, 60, 46, 14);
		panel_1.add(label);
		
		JLabel lblChooseMonth = new JLabel("CHOOSE MONTH :");
		lblChooseMonth.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblChooseMonth.setBackground(Color.GRAY);
		lblChooseMonth.setBounds(10, 83, 107, 25);
		panel_1.add(lblChooseMonth);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox.setBounds(127, 84, 37, 24);
		panel_1.add(comboBox);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 119, 769, 472);
		panel_1.add(scrollPane_1);
		
		table1 = new JTable();
		scrollPane_1.setViewportView(table1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(282, 85, 72, 25);
		panel_1.add(comboBox_1);
		comboBox_1.setModel(new DefaultComboBoxModel(v));
		
		JLabel lblChooseYear = new JLabel("CHOOSE YEAR :");
		lblChooseYear.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblChooseYear.setBackground(Color.GRAY);
		lblChooseYear.setBounds(174, 83, 98, 25);
		panel_1.add(lblChooseYear);
		
		JButton btnSearch = new JButton("Search!");
		btnSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==10)
				{

					Connection conn = (Connection) ConnectionClass.connmethod();
					
					int  am = 0 ;
					
					try {
						
						
					String str = (String) comboBox.getSelectedItem();
					String str1 = (String) comboBox_1.getSelectedItem();
					PreparedStatement pst = (PreparedStatement) conn .prepareStatement("select expensename,amount,date from expenses where month=? and year=?");
					pst.setString(1,str);
					pst.setString(2,str1);
					
					ResultSet rs = pst.executeQuery();
					table1.setModel(DbUtils.resultSetToTableModel(rs));
					table1.getColumnModel().getColumn(0).setPreferredWidth(27);
					table1.getColumnModel().getColumn(1).setPreferredWidth(120);
					table1.getColumnModel().getColumn(2).setPreferredWidth(50);
					table1.getColumnModel().getColumn(0).setHeaderValue("EXPENSES IN.");
					table1.getColumnModel().getColumn(1).setHeaderValue("AMOUNT.");
					table1.getColumnModel().getColumn(2).setHeaderValue("DATE.");
					table1.setBackground(Color.CYAN);
					JTableHeader header = table1.getTableHeader();
				    header.setBackground(Color.yellow);
				    
				    ResultSet rs1 = pst.executeQuery();
				    while(rs1.next())
				    {
				    	am  = rs1.getInt("amount")+am;
				    }
					conn.close();
					}
					catch (SQLException e) {
						JOptionPane.showMessageDialog(null, e);
					}
					
					DefaultTableModel model = (DefaultTableModel) table1.getModel();
					model.addRow(new Object[]{"","",""});
					model.addRow(new Object[]{"Total ",new Integer(am),""});
				

				}
			}
		});
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				Connection conn = (Connection) ConnectionClass.connmethod();
				
				int  am = 0 ;
				
				try {
					
					
				String str = (String) comboBox.getSelectedItem();
				String str1 = (String) comboBox_1.getSelectedItem();
				PreparedStatement pst = (PreparedStatement) conn .prepareStatement("select expensename,amount,date from expenses where month=? and year=?");
				pst.setString(1,str);
				pst.setString(2,str1);
				
				ResultSet rs = pst.executeQuery();
				table1.setModel(DbUtils.resultSetToTableModel(rs));
				table1.getColumnModel().getColumn(0).setPreferredWidth(27);
				table1.getColumnModel().getColumn(1).setPreferredWidth(120);
				table1.getColumnModel().getColumn(2).setPreferredWidth(50);
				table1.getColumnModel().getColumn(0).setHeaderValue("EXPENSES IN.");
				table1.getColumnModel().getColumn(1).setHeaderValue("AMOUNT.");
				table1.getColumnModel().getColumn(2).setHeaderValue("DATE.");
				table1.setBackground(Color.CYAN);
				JTableHeader header = table1.getTableHeader();
			    header.setBackground(Color.yellow);
			    
			    ResultSet rs1 = pst.executeQuery();
			    while(rs1.next())
			    {
			    	am  = rs1.getInt("amount")+am;
			    }
				conn.close();
				}
				catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e);
				}
				
				DefaultTableModel model = (DefaultTableModel) table1.getModel();
				model.addRow(new Object[]{"","",""});
				model.addRow(new Object[]{"Total ",new Integer(am),""});
			
			
			
			}
		});
		btnSearch.setBounds(364, 85, 89, 23);
		panel_1.add(btnSearch);
		
		
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)+1;
		int date = now.get(Calendar.DATE);
		String pass = date + "-" + month + "-" + year;
		txtdate.setText(pass);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 221, 526, 370);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 1350, 59);
		contentPane.add(panel_2);
		
		load();
	
	}
	
	public static void load()
	{
		Connection conn = (Connection) ConnectionClass.connmethod();
		try {
			
			Calendar now = Calendar.getInstance();
			int year = now.get(Calendar.YEAR);
			int month = now.get(Calendar.MONTH)+1;
			int date = now.get(Calendar.DATE);
			String pass = date + "-" + month + "-" + year;
			int am = 0 ;
			
			PreparedStatement pst = (PreparedStatement) conn .prepareStatement("select expensename,amount,date from expenses where date=?");
			pst.setString(1,pass);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			table.getColumnModel().getColumn(0).setPreferredWidth(27);
			table.getColumnModel().getColumn(1).setPreferredWidth(120);
			table.getColumnModel().getColumn(2).setPreferredWidth(50);
			table.getColumnModel().getColumn(0).setHeaderValue("EXPENSES IN.");
			table.getColumnModel().getColumn(1).setHeaderValue("AMOUNT.");
			table.getColumnModel().getColumn(2).setHeaderValue("DATE.");
			table.setBackground(Color.CYAN);
			 JTableHeader header = table.getTableHeader();
		     header.setBackground(Color.yellow);
		     
		     ResultSet rs1 = pst.executeQuery();
			    while(rs1.next())
			    {
			    	am  = rs1.getInt("amount")+am;
			    }
			    
			    
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[]{"","",""});
				model.addRow(new Object[]{"Total ",new Integer(am),""});
		     
		     
			conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
}