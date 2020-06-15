import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class RenewDialog2 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTextField txtmemname;
	private static JTextField txtphon;
	private static JTextField txtadm;
	private static JLabel txtphoto;
	private static JTextArea txtmemaddress; 
	private static JComboBox selpak;
	private static JLabel txtformno;
	
	private JTextField validity;
	private JTextField amount;
	private JTextField amopaid;
	private JTextField amorem;
	static  String mname = null;
	private static int fip = 0;
	static int comb = 0;
	
	static String formnoofmem;
	
	
	public RenewDialog2(String memname) {
		setResizable(false);
		mname = memname ; 
		setVisible(true);
		ButtonGroup bg = new ButtonGroup();
		
		
		setTitle("Gym Management");
		setBounds(100, 100, 742, 417);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("Member Name:");
		label.setBounds(10, 77, 122, 25);
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBackground(Color.GRAY);
		contentPanel.add(label);
		
		txtmemname = new JTextField();
		txtmemname.setBounds(112, 79, 326, 20);
		txtmemname.setEditable(false);
		txtmemname.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtmemname.setColumns(10);
		contentPanel.add(txtmemname);
		
		JLabel label_1 = new JLabel("Address:");
		label_1.setBounds(10, 99, 122, 25);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBackground(Color.GRAY);
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("Phone No:");
		label_2.setBounds(10, 153, 97, 25);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBackground(Color.GRAY);
		contentPanel.add(label_2);
		
		txtphon = new JTextField();
		txtphon.setBounds(112, 155, 164, 20);
		txtphon.setEditable(false);
		txtphon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtphon.setColumns(10);
		contentPanel.add(txtphon);
		
		JLabel label_3 = new JLabel("Select Package:");
		label_3.setBounds(10, 239, 109, 25);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBackground(Color.GRAY);
		contentPanel.add(label_3);
		
	
		
		JLabel label_4 = new JLabel("Valid Till:");
		label_4.setBounds(251, 239, 72, 25);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_4.setBackground(Color.GRAY);
		contentPanel.add(label_4);
		
		validity = new JTextField();
		validity.setBounds(325, 241, 136, 20);
		validity.setFont(new Font("Tahoma", Font.PLAIN, 13));
		validity.setEditable(false);
		validity.setColumns(10);
		contentPanel.add(validity);
		
		amount = new JTextField();
		amount.setBounds(132, 277, 109, 20);
		amount.setFont(new Font("Tahoma", Font.PLAIN, 13));
		amount.setEditable(false);
		amount.setColumns(10);
		contentPanel.add(amount);
		
		JLabel label_5 = new JLabel("Amount:");
		label_5.setBounds(10, 275, 63, 25);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_5.setBackground(Color.GRAY);
		contentPanel.add(label_5);
		
		JLabel label_7 = new JLabel("Amount Paid");
		label_7.setBounds(10, 315, 109, 25);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_7.setBackground(Color.GRAY);
		contentPanel.add(label_7);
		
		amopaid = new JTextField();
		amopaid.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				

				String v = amopaid.getText();
				boolean b = ValidationClass.numcheck(v);
				if(b)
				{
					
				}
				else
				{
					String sub  = amopaid.getText();
					int l = sub.length();
					amopaid.setText(sub.substring(0, l-1));
				}
					
				
			amorem.setText((Integer.toString((Integer.parseInt(amount.getText())-Integer.parseInt(amopaid.getText())))));	
				
			}
		});
		amopaid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String v = amopaid.getText();
				boolean b = ValidationClass.numcheck(v);
				if(b)
				{
					
				}
				else
				{
					String sub  = amopaid.getText();
					int l = sub.length();
					amopaid.setText(sub.substring(0, l-1));
				}	
				
			amorem.setText((Integer.toString((Integer.parseInt(amount.getText())-Integer.parseInt(amopaid.getText())))));	
			
			}
		});
		amopaid.setBounds(132, 317, 109, 20);
		amopaid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		amopaid.setEditable(false);
		amopaid.setColumns(10);
		contentPanel.add(amopaid);
		
		JLabel label_8 = new JLabel("Amount Remaining:");
		label_8.setBounds(248, 315, 137, 25);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_8.setBackground(Color.GRAY);
		contentPanel.add(label_8);
		
		amorem = new JTextField();
		amorem.setBounds(385, 317, 76, 20);
		amorem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		amorem.setEditable(false);
		amorem.setColumns(10);
		contentPanel.add(amorem);
		
		JRadioButton fpay = new JRadioButton("Full Payment");
		fpay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			amopaid.setEditable(false);
			fip=1;
			amopaid.setText(amount.getText());
			
			}
		});
		fpay.setBounds(251, 276, 109, 23);
		fpay.setFont(new Font("Tahoma", Font.BOLD, 13));
		fpay.setBackground(Color.WHITE);
		contentPanel.add(fpay);
		
		JRadioButton inpay = new JRadioButton("Installment");
		inpay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			fip=2;
			amopaid.setText("");
			amopaid.setEditable(true);
			
			}
		});
		inpay.setBounds(362, 276, 99, 23);
		inpay.setFont(new Font("Tahoma", Font.BOLD, 13));
		inpay.setBackground(Color.WHITE);
		contentPanel.add(inpay);
		
		bg.add(fpay);
		bg.add(inpay);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(112, 106, 326, 39);
		contentPanel.add(scrollPane);
		
		txtmemaddress = new JTextArea();
		txtmemaddress.setEditable(false);
		scrollPane.setViewportView(txtmemaddress);
		
		JLabel label_9 = new JLabel("Renew Package");
		label_9.setBounds(288, 11, 159, 28);
		label_9.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPanel.add(label_9);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 48, 760, 2);
		separator.setBackground(Color.RED);
		contentPanel.add(separator);
		
		txtphoto = new JLabel("");
		txtphoto.setBounds(448, 77, 146, 141);
		txtphoto.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPanel.add(txtphoto);
		
		JLabel label_6 = new JLabel("Date of Admission:");
		label_6.setBounds(10, 184, 122, 25);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_6.setBackground(Color.GRAY);
		contentPanel.add(label_6);
		
		txtadm = new JTextField();
		txtadm.setBounds(132, 186, 109, 20);
		txtadm.setText("26-7-2018");
		txtadm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtadm.setEditable(false);
		txtadm.setColumns(10);
		contentPanel.add(txtadm);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(SystemColor.inactiveCaptionBorder);
		separator_1.setBounds(0, 229, 736, 2);
		contentPanel.add(separator_1);
	
		selpak = new JComboBox();
		selpak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
					if(comb == 1)
					{
						Connection conn1 = ConnectionClass.connmethod();
						String selected = (String) selpak.getSelectedItem();			
						try {
							
							Connection conn= ConnectionClass.connmethod();
							
							
							if(selected.equals("1 Month"))
							{
								Calendar now = Calendar.getInstance();
								now.add(Calendar.MONTH, 1);
								int year = now.get(Calendar.YEAR);
								int month = now.get(Calendar.MONTH)+1;
								int date = now.get(Calendar.DATE);
								String pass = date + "-" + month + "-" + year;
								validity.setText(pass);
							}
							else if(selected.equals("3 Month"))
							{
								Calendar now = Calendar.getInstance();
								now.add(Calendar.MONTH, 3);
								int year = now.get(Calendar.YEAR);
								int month = now.get(Calendar.MONTH)+1;
								int date = now.get(Calendar.DATE);
								String pass = date + "-" + month + "-" + year;
								validity.setText(pass);
							}
							else if(selected.equals("6 Month"))
							{
								Calendar now = Calendar.getInstance();
								now.add(Calendar.MONTH, 6);
								int year = now.get(Calendar.YEAR);
								int month = now.get(Calendar.MONTH)+1;
								int date = now.get(Calendar.DATE);
								String pass = date + "-" + month + "-" + year;
								validity.setText(pass);
							}
							else if(selected.equals("1 Year"))
							{
								Calendar now = Calendar.getInstance();
								now.add(Calendar.MONTH, 12);
								int year = now.get(Calendar.YEAR);
								int month = now.get(Calendar.MONTH)+1;
								int date = now.get(Calendar.DATE);
								String pass = date + "-" + month + "-" + year;
								validity.setText(pass);
							}
							
							conn.close();	
						}
						catch(SQLException se)
						{
							JOptionPane.showMessageDialog(null, "Not consist data");
						}
						catch(Exception m)
						{
							
						}
			
							
						try {
							
							PreparedStatement pst = conn1.prepareStatement("select rs from package where name= ?");
							pst.setString(1,selected);
							ResultSet rs = pst.executeQuery();
							rs.next();
							amount.setText(rs.getString("rs"));
							
							conn1.close();
						} catch (SQLException e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
					}
			}
		});
		selpak.setBounds(132, 242, 109, 20);
		contentPanel.add(selpak);
		
		txtformno = new JLabel("");
		txtformno.setBounds(604, 83, 122, 14);
		contentPanel.add(txtformno);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				okButton.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent arg0) {
						
						if(arg0.getKeyCode()==10)
						{
						String name = txtmemname.getText();
						String amount = amopaid.getText(); 
						String msg = ValidAll.validation1(amount, name);
						
						if(msg=="pass")
						{
						Connection conn = ConnectionClass.connmethod();
						
						try {
							
						if(fip == 1)
						{
							//full payment
						
							PreparedStatement pst = conn.prepareStatement("delete from fullpayment where membername=? and formno=?");
							pst.setString(1, mname);
							pst.setString(2, formnoofmem);
							pst.execute();
							
							pst = conn.prepareStatement("delete from session where name=?");
							pst.setString(1, mname);
							pst.execute();
		
							pst = conn.prepareStatement("insert into fullpayment values(?,?,?,?)");
							pst.setString(1, formnoofmem);
							pst.setString(2, name);
							pst.setString(3, txtadm.getText());
							pst.setString(4, (String) selpak.getSelectedItem());
							pst.execute();
							
							Calendar now = Calendar.getInstance();
							int year = now.get(Calendar.YEAR);
							int month = now.get(Calendar.MONTH)+1;
							int date = now.get(Calendar.DATE);
							String pass = date + "-" + month + "-" + year;
							
							//hererererererrerer
							pst = conn.prepareStatement("insert into session values(?,?,?,?,?)");
							pst.setString(1, name);
							pst.setString(2, pass);
							pst.setString(3, validity.getText());
							pst.setString(4, (String) selpak.getSelectedItem());
							Calendar checkmat = Calendar.getInstance();
							checkmat.add(checkmat.MONTH, 1);
							int checkmatdate = checkmat.get(Calendar.DATE);
							int checkmatmonth = checkmat.get(Calendar.MONTH);
							int checkmatyear = checkmat.get(Calendar.YEAR);
							String checkmatstring = checkmatdate+"-"+checkmatmonth+"-"+checkmatyear;
							pst.setString(5, checkmatstring);
							pst.execute();	
							//hererererererrerer

							pst = conn.prepareStatement("insert into packhis values(?,?,?,?)");
							pst.setString(1, name);
							pst.setString(2, (String) selpak.getSelectedItem());
							pst.setString(3, pass);
							pst.setString(4, amopaid.getText());
							pst.execute();

							pst = conn.prepareStatement("insert into profit values(?,?,?,?)");
							pst.setString(1, amopaid.getText());
							pst.setString(2, pass);
							pst.setInt(3, month);
							pst.setInt(4, year);
							pst.execute();
							
							String tprnt = 
							"        UNIVERSAL GYM\n"+
							"        Siddi Vianyak colony,\n"
							+ "        Saturna, Amravati  \n"+
							"\n      ===============================================\n"+
							"\n      Form No : "+formnoofmem+
							"\n      Name : "+name+
							"\n      Package : "+(String)selpak.getSelectedItem()+
							"\n      Amount : "+amopaid.getText()+
							"\n      Date : "+txtadm.getText()+
							"\n\n     Sign\n   _______________";
							
							JTextArea fpr  = new JTextArea(tprnt);
							try {
								boolean isprint = fpr.print();
							} catch (PrinterException e) {
								JOptionPane.showMessageDialog(null, e);
							}
													}
						else if(fip==2)
						{
							//half payment
							

							Calendar now = Calendar.getInstance();
							int year = now.get(Calendar.YEAR);
							int month = now.get(Calendar.MONTH)+1;
							int date = now.get(Calendar.DATE);
							String pass = date + "-" + month + "-" + year;

							
							PreparedStatement pst = conn.prepareStatement("delete from session where name=?");
							pst.setString(1, mname);
							pst.execute();
							
							pst = conn.prepareStatement("delete from fullpayment where membername=? and formno=?");
							pst.setString(1, mname);
							pst.setString(2, formnoofmem);
							pst.execute();
							
							pst = conn.prepareStatement("insert into halfpaidmember values(?,?,?,?,?)");
							pst.setString(1,name);
							pst.setString(2,(String) selpak.getSelectedItem());
							pst.setString(3,amopaid.getText());
							pst.setString(4,amorem.getText());
							pst.setString(5,txtadm.getText());
							pst.execute();
						
							//hererererererrerer
							 pst = conn.prepareStatement("insert into session values(?,?,?,?,?)");
								pst.setString(1, name);
								pst.setString(2,pass);
								pst.setString(3, validity.getText());
								pst.setString(4, (String) selpak.getSelectedItem());
								Calendar checkmat = Calendar.getInstance();
								checkmat.add(checkmat.MONTH, 1);
								int checkmatdate = checkmat.get(Calendar.DATE);
								int checkmatmonth = checkmat.get(Calendar.MONTH);
								int checkmatyear = checkmat.get(Calendar.YEAR);
								String checkmatstring = checkmatdate+"-"+checkmatmonth+"-"+checkmatyear;
								pst.setString(5, checkmatstring);
								pst.execute();
							//hererererererrerer
								
								

								pst = conn.prepareStatement("insert into packhis values(?,?,?,?)");
								pst.setString(1, name);
								pst.setString(2, (String) selpak.getSelectedItem());
								pst.setString(3, pass);
								pst.setString(4, amopaid.getText());
								pst.execute();

								pst = conn.prepareStatement("insert into profit values(?,?,?,?)");
								pst.setString(1, amopaid.getText());
								pst.setString(2, pass);
								pst.setInt(3, month);
								pst.setInt(4, year);
								pst.execute();
							
							String tprnt = 
									"        UNIVERSAL GYM\n"+
									"        Siddi Vianyak colony,\n"
									+ "        Saturna, Amravati  \n"+
									"\n      ===============================================\n"+
									"\n      Name : "+name+
									"\n      Package : "+(String)selpak.getSelectedItem()+
									"\n      Amount Paid : "+amopaid.getText()+
									"\n      Amount Rem. : "+amorem.getText()+
									"\n      Date : "+pass+
									"\n\n       Sign\n    _______________";
									
									JTextArea fpr  = new JTextArea(tprnt);
									boolean isprint = fpr.print();
														
						}
							
							
							conn.close();
						} catch (SQLException e) {
							JOptionPane.showMessageDialog(contentPanel, e);
						} catch (PrinterException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						}
						else
						{
							JOptionPane.showMessageDialog(contentPanel, msg);
						}
						}
					}
				});
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						String name = txtmemname.getText();
						String amount = amopaid.getText(); 
						String msg = ValidAll.validation1(amount, name);
						
						if(msg=="pass")
						{
						Connection conn = ConnectionClass.connmethod();
						
						try {
							
						if(fip == 1)
						{
							//full payment
						
							PreparedStatement pst = conn.prepareStatement("delete from fullpayment where membername=? and formno=?");
							pst.setString(1, mname);
							pst.setString(2, formnoofmem);
							pst.execute();
							
							pst = conn.prepareStatement("delete from session where name=?");
							pst.setString(1, mname);
							pst.execute();
		
							pst = conn.prepareStatement("insert into fullpayment values(?,?,?,?)");
							pst.setString(1, formnoofmem);
							pst.setString(2, name);
							pst.setString(3, txtadm.getText());
							pst.setString(4, (String) selpak.getSelectedItem());
							pst.execute();
							
							Calendar now = Calendar.getInstance();
							int year = now.get(Calendar.YEAR);
							int month = now.get(Calendar.MONTH)+1;
							int date = now.get(Calendar.DATE);
							String pass = date + "-" + month + "-" + year;
							
							//hererererererrerer
							pst = conn.prepareStatement("insert into session values(?,?,?,?,?)");
							pst.setString(1, name);
							pst.setString(2, pass);
							pst.setString(3, validity.getText());
							pst.setString(4, (String) selpak.getSelectedItem());
							Calendar checkmat = Calendar.getInstance();
							checkmat.add(checkmat.MONTH, 1);
							int checkmatdate = checkmat.get(Calendar.DATE);
							int checkmatmonth = checkmat.get(Calendar.MONTH);
							int checkmatyear = checkmat.get(Calendar.YEAR);
							String checkmatstring = checkmatdate+"-"+checkmatmonth+"-"+checkmatyear;
							pst.setString(5, checkmatstring);
							pst.execute();	
							//hererererererrerer

							pst = conn.prepareStatement("insert into packhis values(?,?,?,?)");
							pst.setString(1, name);
							pst.setString(2, (String) selpak.getSelectedItem());
							pst.setString(3, pass);
							pst.setString(4, amopaid.getText());
							pst.execute();

							pst = conn.prepareStatement("insert into profit values(?,?,?,?)");
							pst.setString(1, amopaid.getText());
							pst.setString(2, pass);
							pst.setInt(3, month);
							pst.setInt(4, year);
							pst.execute();
							
							String tprnt = 
							"        UNIVERSAL GYM\n"+
							"        Siddi Vianyak colony,\n"
							+ "        Saturna, Amravati  \n"+
							"\n      ===============================================\n"+
							"\n      Form No : "+formnoofmem+
							"\n      Name : "+name+
							"\n      Package : "+(String)selpak.getSelectedItem()+
							"\n      Amount : "+amopaid.getText()+
							"\n      Date : "+txtadm.getText()+
							"\n\n     Sign\n   _______________";
							
							JTextArea fpr  = new JTextArea(tprnt);
							try {
								boolean isprint = fpr.print();
							} catch (PrinterException e) {
								JOptionPane.showMessageDialog(null, e);
							}
													}
						else if(fip==2)
						{
							//half payment
							

							Calendar now = Calendar.getInstance();
							int year = now.get(Calendar.YEAR);
							int month = now.get(Calendar.MONTH)+1;
							int date = now.get(Calendar.DATE);
							String pass = date + "-" + month + "-" + year;

							
							PreparedStatement pst = conn.prepareStatement("delete from session where name=?");
							pst.setString(1, mname);
							pst.execute();
							
							pst = conn.prepareStatement("delete from fullpayment where membername=? and formno=?");
							pst.setString(1, mname);
							pst.setString(2, formnoofmem);
							pst.execute();
							
							pst = conn.prepareStatement("insert into halfpaidmember values(?,?,?,?,?)");
							pst.setString(1,name);
							pst.setString(2,(String) selpak.getSelectedItem());
							pst.setString(3,amopaid.getText());
							pst.setString(4,amorem.getText());
							pst.setString(5,txtadm.getText());
							pst.execute();
							
							//hererererererrerer
							
							
							
							pst = conn.prepareStatement("insert into session values(?,?,?,?,?)");
							pst.setString(1, name);
							pst.setString(2, pass);
							pst.setString(3, validity.getText());
							pst.setString(4, (String) selpak.getSelectedItem());
							
							Calendar checkmat = Calendar.getInstance();
							checkmat.add(checkmat.MONTH, 1);
							int checkmatdate = checkmat.get(Calendar.DATE);
							int checkmatmonth = checkmat.get(Calendar.MONTH);
							int checkmatyear = checkmat.get(Calendar.YEAR);
							String checkmatstring = checkmatdate+"-"+checkmatmonth+"-"+checkmatyear;
							pst.setString(5, checkmatstring);
							
							
							pst.execute();
							
							//hererererererrerer
								
								

								pst = conn.prepareStatement("insert into packhis values(?,?,?,?)");
								pst.setString(1, name);
								pst.setString(2, (String) selpak.getSelectedItem());
								pst.setString(3, pass);
								pst.setString(4, amopaid.getText());
								pst.execute();

								pst = conn.prepareStatement("insert into profit values(?,?,?,?)");
								pst.setString(1, amopaid.getText());
								pst.setString(2, pass);
								pst.setInt(3, month);
								pst.setInt(4, year);
								pst.execute();
							
							String tprnt = 
									"        UNIVERSAL GYM\n"+
									"        Siddi Vianyak colony,\n"
									+ "        Saturna, Amravati  \n"+
									"\n      ===============================================\n"+
									"\n      Name : "+name+
									"\n      Package : "+(String)selpak.getSelectedItem()+
									"\n      Amount Paid : "+amopaid.getText()+
									"\n      Amount Rem. : "+amorem.getText()+
									"\n      Date : "+pass+
									"\n\n       Sign\n    _______________";
									
									JTextArea fpr  = new JTextArea(tprnt);
									boolean isprint = fpr.print();
														
						}
							
							
							conn.close();
						} catch (SQLException e) {
							JOptionPane.showMessageDialog(contentPanel, e);
						} catch (PrinterException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						}
						else
						{
							JOptionPane.showMessageDialog(contentPanel, msg);
						}
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
		load();
	}
	private static void load()
	{
		Connection conn = ConnectionClass.connmethod();
		try {
			
			byte[] ph = null;
			
			PreparedStatement pst = conn.prepareStatement("select membername,address,phoneno,dateofadmission,photo,formno from gymmember where membername = ?");
			pst.setString(1, mname);
			ResultSet rs = pst.executeQuery();
			rs.next();
			ph = rs.getBytes("photo");
			
			txtmemname.setText(rs.getString("membername"));
			txtmemaddress.setText(rs.getString("address"));
			txtphon.setText(rs.getString("phoneno"));
			txtadm.setText(rs.getString("dateofadmission"));
			txtformno.setText("Form No :"+rs.getString("formno"));
			
			
			formnoofmem = rs.getString("formno");
			
			int w = txtphoto.getWidth();
			int h = txtphoto.getHeight();
			
			ByteArrayInputStream bis = new ByteArrayInputStream(ph);
    		BufferedImage img = ImageIO.read(bis);
    		Image tmp = img.getScaledInstance(w,h , Image.SCALE_SMOOTH);
    		BufferedImage dimg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    		Graphics2D g2d = dimg.createGraphics();
    		g2d.drawImage(tmp, 0, 0, null);
    		g2d.dispose();
    		ImageIcon im = new ImageIcon(dimg);
    		
    		txtphoto.setIcon(im);
    		
			
			
			pst=conn.prepareStatement("select * from package");
			rs=pst.executeQuery();
			selpak.addItem("Select Package");
			while(rs.next())
			{
				selpak.addItem(rs.getObject("name"));
			}
			comb = 1;
			


    		pst.close();
			rs.close();
			conn.close();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
}


