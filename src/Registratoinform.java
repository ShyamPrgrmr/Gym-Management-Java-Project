import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.toedter.calendar.*;

import net.proteanit.sql.DbUtils;

import java.util.regex.*;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.html.Option;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dialog;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.nio.file.Files;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.border.LineBorder;
import java.awt.Frame;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JSpinner;
import java.awt.Toolkit;
import javax.swing.DefaultComboBoxModel;

public class Registratoinform extends JFrame {

	private JPanel contentPane;
	private JTextField rmembername;
	private JTextField rphone;
	private JTextField rheigth;
	private JTextField rweight;
	private JTextField roccupation;
	private JTextField dateofaddmission;
	private JTextField pakammount;
	private JTextField amountpaid;
	private JTextField amountremaining;
	private JComboBox rblood;
	private JTextField validity;
	private JTextField paymember;
	private JTextField payphone;
	private JTextField paydateofadm;
	private JTextField paypackage;
	private JTextField payremaining;
	private JTextField payamounttopay;
	private JComboBox packagesel; 
	private JTextArea payaddress;
	private JLabel photopay ;
	int amm=0;
	int pai=0;
	int foh=0;
	int formnoautoincre=0;
	String photopath;
	byte[] photoofreg =null;
	static int formcheck = 0; 
	String rmemname="";
	String packname="";
	String dbl="";
	private JTextField formno;
	private JTextField textField;
	private JTextField rempayamo;
	private JTextField dos;
	private JTextField doe;
	private JTextField txtage;
	private JDateChooser rdob ;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registratoinform frame = new Registratoinform();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Registratoinform() {
		
		
		setExtendedState(Frame.MAXIMIZED_BOTH);	
		setTitle("Gym Management");
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		Image imageforframe = new ImageIcon(this.getClass().getResource("/gym4.png")).getImage();		
		setIconImage(imageforframe);
	
		
		Image img = new ImageIcon(this.getClass().getResource("/id.png")).getImage();		
		Image img1 = new ImageIcon(this.getClass().getResource("/user.png")).getImage();

	
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1690, 764);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.RED, 4, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel logo = new JLabel("UNIVERSAL HEALTH CLUB");
		logo.setForeground(Color.RED);
		logo.setFont(new Font("Khmer UI", Font.BOLD, 22));
		logo.setBounds(10, 11, 276, 28);
		contentPane.add(logo);
		
		JLabel lblNewLabel = new JLabel("Siddi Vianyak colony, Saturna, Amravati");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 37, 373, 25);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.RED);
		separator.setBounds(0, 75, 1370, 2);
		contentPane.add(separator);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.YELLOW, 2, true));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 88, 657, 604);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAddress.setBackground(Color.GRAY);
		lblAddress.setBounds(10, 88, 122, 25);
		panel.add(lblAddress);
		
		
		
		JLabel lblPhoneNo = new JLabel("Phone No:");
		lblPhoneNo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPhoneNo.setBackground(Color.GRAY);
		lblPhoneNo.setBounds(10, 149, 122, 25);
		panel.add(lblPhoneNo);
		
		JLabel lblDob = new JLabel("DOB:");
		lblDob.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDob.setBackground(Color.GRAY);
		lblDob.setBounds(10, 182, 37, 25);
		panel.add(lblDob);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAge.setBackground(Color.GRAY);
		lblAge.setBounds(10, 210, 37, 25);
		panel.add(lblAge);
		
		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHeight.setBackground(Color.GRAY);
		lblHeight.setBounds(10, 244, 53, 25);
		panel.add(lblHeight);
		
		JLabel lblWeight = new JLabel("Weight:");
		lblWeight.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblWeight.setBackground(Color.GRAY);
		lblWeight.setBounds(238, 244, 53, 25);
		panel.add(lblWeight);
		
		JLabel labgend = new JLabel("Gender:");
		labgend.setFont(new Font("Tahoma", Font.BOLD, 13));
		labgend.setBackground(Color.GRAY);
		labgend.setBounds(238, 210, 68, 25);
		panel.add(labgend);
		
		JLabel lblOccupation = new JLabel("Occupation:");
		lblOccupation.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOccupation.setBackground(Color.GRAY);
		lblOccupation.setBounds(10, 286, 122, 25);
		panel.add(lblOccupation);
		
		JLabel lblDoYouLike = new JLabel("Would you like to donate your blood ?:");
		lblDoYouLike.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDoYouLike.setBackground(Color.GRAY);
		lblDoYouLike.setBounds(10, 316, 250, 25);
		panel.add(lblDoYouLike);
		
		JLabel lblDateOfJoining = new JLabel("Date of Admission:");
		lblDateOfJoining.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDateOfJoining.setBackground(Color.GRAY);
		lblDateOfJoining.setBounds(10, 440, 122, 25);
		panel.add(lblDateOfJoining);
		
		JLabel lblSelectPackage = new JLabel("Select Package:");
		lblSelectPackage.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSelectPackage.setBackground(Color.GRAY);
		lblSelectPackage.setBounds(10, 401, 122, 25);
		panel.add(lblSelectPackage);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAmount.setBackground(Color.GRAY);
		lblAmount.setBounds(228, 401, 63, 25);
		panel.add(lblAmount);
		
		ButtonGroup bg=new ButtonGroup();
		
		
		
	
		
		JLabel lblNewLabel_1 = new JLabel("Registration Form");
		lblNewLabel_1.setBounds(249, 11, 159, 28);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblNewLabel_2 = new JLabel("Member Name:");
		lblNewLabel_2.setBounds(10, 58, 122, 25);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setBackground(Color.GRAY);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		rmembername = new JTextField(100);
		rmembername.setToolTipText("Enter New Member Name eg. amit N Deshmukh");
		rmembername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				String v = rmembername.getText();
				boolean b = ValidationClass.charactercheck(v);
				if(b)
				{
					
				}
				else
				{
					String sub  = rmembername.getText();
					int l = sub.length();
					rmembername.setText(sub.substring(0, l-1));
				}
			}
		});
		rmembername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				String v = rmembername.getText();
				boolean b = ValidationClass.charactercheck(v);
				if(b)
				{
					
				}
				else
				{
					String sub  = rmembername.getText();
					int l = sub.length();
					rmembername.setText(sub.substring(0, l-1));
				}
			}
		});
		rmembername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rmembername.setBounds(115, 61, 326, 20);
		panel.add(rmembername);
		rmembername.setColumns(10);
		
		rphone = new JTextField();
		rphone.setToolTipText("Enter Phone no");
		rphone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				String v = rphone.getText();
				boolean b = ValidationClass.numcheck(v);
				if(b)
				{
					
				}
				else
				{
					String sub  = rphone.getText();
					int l = sub.length();
					rphone.setText(sub.substring(0, l-1));
				}
			}
		});
		rphone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String v = rphone.getText();
				boolean b = ValidationClass.numcheck(v);
				if(b)
				{
					
				}
				else
				{
					String sub  = rphone.getText();
					int l = sub.length();
					rphone.setText(sub.substring(0, l-1));
				}
				
			}
		});
		rphone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rphone.setColumns(10);
		rphone.setBounds(115, 151, 164, 20);
		panel.add(rphone);
		
		JLabel photo = new JLabel("");
		photo.setBounds(466, 58, 159, 171);
		Image newImg1 = img.getScaledInstance(photo.getWidth(),photo.getHeight(), Image.SCALE_SMOOTH);
		photo.setIcon(new ImageIcon(newImg1));
		
		photo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			

				JFileChooser chooser = new JFileChooser();
		        chooser.showOpenDialog(null);
		        File file = chooser.getSelectedFile();
		        
		       
		        try {
		        	
		        		int h= photo.getHeight();
		        		int w= photo.getWidth();
		        		
					 byte[] data = Files.readAllBytes(file.toPath());
					 photoofreg= Files.readAllBytes(file.toPath());;
					 ByteArrayInputStream bis = new ByteArrayInputStream(data);
				     BufferedImage img = ImageIO.read(bis);
				     
				     Image tmp = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
				     BufferedImage dimg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

				     Graphics2D g2d = dimg.createGraphics();
				     g2d.drawImage(tmp, 0, 0, null);
				     g2d.dispose();
				     
				     ImageIcon im = new ImageIcon(dimg);
				     
				     photo.setIcon(im);
				     
				 //    savebtn.setEnabled();

				     
				} catch (IOException e) {

				}
		        
		       
		        
		        
			
			}
		});
		
		
		panel.add(photo);
		
		JComboBox rgender = new JComboBox();
		rgender.setToolTipText("Enter Gender");
		rgender.setBounds(327, 213, 86, 20);
		panel.add(rgender);
		rgender.addItem("Male");
		rgender.addItem("Female");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(115, 89, 326, 49);
		panel.add(scrollPane);
		
		JTextArea raddress = new JTextArea();
		raddress.setToolTipText("Enter Address");
		raddress.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				String v = raddress.getText();
				boolean b = ValidationClass.charactercheckadd(v);
				if(b)
				{
					
				}
				else
				{
					String sub  = raddress.getText();
					int l = sub.length();
					raddress.setText(sub.substring(0, l-1));
				}
				
			}
		});
		raddress.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String v = raddress.getText();
				boolean b = ValidationClass.charactercheckadd(v);
				if(b)
				{
					
				}
				else
				{
					String sub  = raddress.getText();
					int l = sub.length();
					raddress.setText(sub.substring(0, l-1));
				}
				
			}
		});
		raddress.setColumns(10);
		scrollPane.setViewportView(raddress);
		
	    rdob = new JDateChooser();
	    rdob.setToolTipText("Enter Date OF BIrth");
		rdob.setDateFormatString("dd-MM-yyyy");
		rdob.setBounds(115, 184, 109, 20);
		panel.add(rdob);
		
		rheigth = new JTextField();
		rheigth.setToolTipText("Enter Height");
		rheigth.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
				String v = rheigth.getText();
				boolean b = ValidationClass.decimalnumcheck(v);
				if(b)
				{
					
				}
				else
				{
					String sub  = rheigth.getText();
					int l = sub.length();
					rheigth.setText(sub.substring(0, l-1));
				}
				
			}
		});
		rheigth.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				String v = rheigth.getText();
				boolean b = ValidationClass.decimalnumcheck(v);
				if(b)
				{
					
				}
				else
				{
					String sub  = rheigth.getText();
					int l = sub.length();
					rheigth.setText(sub.substring(0, l-1));
				}
				
			}
		});
		rheigth.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rheigth.setColumns(10);
		rheigth.setBounds(115, 246, 68, 20);
		panel.add(rheigth);
		
		rweight = new JTextField();
		rweight.setToolTipText("Enter Weight");
		rweight.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				String v = rweight.getText();
				boolean b = ValidationClass.decimalnumcheck(v);
				if(b)
				{
					
				}
				else
				{
					String sub  = rweight.getText();
					int l = sub.length();
					rweight.setText(sub.substring(0, l-1));
				}
			}
		});
		rweight.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				String v = rweight.getText();
				boolean b = ValidationClass.decimalnumcheck(v);
				if(b)
				{
					
				}
				else
				{
					String sub  = rweight.getText();
					int l = sub.length();
					rweight.setText(sub.substring(0, l-1));
				}
			}
		});
		rweight.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rweight.setColumns(10);
		rweight.setBounds(327, 246, 63, 20);
		panel.add(rweight);
		
		roccupation = new JTextField();
		roccupation.setToolTipText("Enter occupation");
		roccupation.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {

				String v = roccupation.getText();
				boolean b = ValidationClass.charactercheck(v);
				if(b)
				{
					
				}
				else
				{
					String sub  = roccupation.getText();
					int l = sub.length();
					roccupation.setText(sub.substring(0, l-1));
				}
			}
		});
		roccupation.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				String v = roccupation.getText();
				boolean b = ValidationClass.charactercheck(v);
				if(b)
				{
					
				}
				else
				{
					String sub  = roccupation.getText();
					int l = sub.length();
					roccupation.setText(sub.substring(0, l-1));
				}
				
			}
		});
		roccupation.setFont(new Font("Tahoma", Font.PLAIN, 13));
		roccupation.setColumns(10);
		roccupation.setBounds(115, 288, 326, 20);
		panel.add(roccupation);
		
		ButtonGroup yn =new ButtonGroup();
		
		JRadioButton rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbl="yes";
				
			}
		});
		rdbtnYes.setBackground(Color.WHITE);
		rdbtnYes.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnYes.setBounds(263, 317, 49, 23);
		panel.add(rdbtnYes);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dbl="no";
			
			}
		});
		rdbtnNo.setBackground(Color.WHITE);
		rdbtnNo.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnNo.setBounds(314, 317, 41, 23);
		panel.add(rdbtnNo);
		yn.add(rdbtnYes);
		yn.add(rdbtnNo);
		
		dateofaddmission = new JTextField();
		dateofaddmission.setFont(new Font("Tahoma", Font.PLAIN, 13));
		dateofaddmission.setColumns(10);
		dateofaddmission.setBounds(142, 442, 109, 20);
		panel.add(dateofaddmission);
		
		pakammount = new JTextField();
		pakammount.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pakammount.setEditable(false);
		pakammount.setColumns(10);
		pakammount.setBounds(299, 403, 109, 20);
		panel.add(pakammount);
		
		packagesel = new JComboBox();
		packagesel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		packagesel.setBounds(115, 403, 103, 22);
		panel.add(packagesel);
		
		JLabel lblAmountRemaining = new JLabel("Amount Paid");
		lblAmountRemaining.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAmountRemaining.setBackground(Color.GRAY);
		lblAmountRemaining.setBounds(10, 476, 122, 25);
		panel.add(lblAmountRemaining);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 374, 657, 2);
		panel.add(separator_2);
		
		amountpaid = new JTextField();
		amountpaid.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
				
				String v = amountpaid.getText();
				boolean b = ValidationClass.numcheck(v);
				if(b)
				{
					
				}
				else
				{
					String sub  = amountpaid.getText();
					int l = sub.length();
					amountpaid.setText(sub.substring(0, l-1));
				}
				
				int packageammount = Integer.parseInt(pakammount.getText());
				int ammount=Integer.parseInt(amountpaid.getText());
				int remaining=packageammount-ammount;
				
				amountremaining.setText(Integer.toString(remaining));
				
			}
		});
		amountpaid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				String v = amountpaid.getText();
				boolean b = ValidationClass.numcheck(v);
				if(b)
				{
					
				}
				else
				{
					String sub  = amountpaid.getText();
					int l = sub.length();
					amountpaid.setText(sub.substring(0, l-1));
				}
				
			}
		});
		
		amountpaid.setEditable(false);
		amountpaid.setEnabled(false);
		amountpaid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		amountpaid.setColumns(10);
		amountpaid.setBounds(142, 478, 109, 20);
		panel.add(amountpaid);
		
		JLabel lblFormNo = new JLabel("Amount Remaining:");
		lblFormNo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFormNo.setBackground(Color.GRAY);
		lblFormNo.setBounds(271, 476, 137, 25);
		panel.add(lblFormNo);
		
		amountremaining = new JTextField();
		amountremaining.setFont(new Font("Tahoma", Font.PLAIN, 13));
		amountremaining.setEditable(false);
		amountremaining.setColumns(10);
		amountremaining.setBounds(418, 478, 137, 20);
		panel.add(amountremaining);
		
		JLabel lblNewLabel_4 = new JLabel("*Note that form no will be given in full payment.");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBackground(Color.RED);
		lblNewLabel_4.setBounds(263, 517, 227, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblBloodGroup = new JLabel("Blood Group:");
		lblBloodGroup.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBloodGroup.setBackground(Color.GRAY);
		lblBloodGroup.setBounds(238, 182, 97, 25);
		panel.add(lblBloodGroup);
		
		
		
		
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(0, 542, 657, 2);
		panel.add(separator_3);
		
		JLabel lblDateOfExpiry = new JLabel("Valid Till:");
		lblDateOfExpiry.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDateOfExpiry.setBackground(Color.GRAY);
		lblDateOfExpiry.setBounds(271, 440, 122, 25);
		panel.add(lblDateOfExpiry);
		
		validity = new JTextField();
		validity.setFont(new Font("Tahoma", Font.PLAIN, 13));
		validity.setEditable(false);
		validity.setColumns(10);
		validity.setBounds(418, 442, 137, 20);
		panel.add(validity);
		
		formno = new JTextField();
		formno.setToolTipText("Form no will generate if full payment is done");
		formno.setFont(new Font("Tahoma", Font.PLAIN, 13));
		formno.setEditable(false);
		formno.setColumns(10);
		formno.setBounds(142, 512, 109, 20);
		panel.add(formno);
		
		JButton btnNewButton = new JButton(" Log out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				Loginpage exp = new Loginpage();
				exp.main(null);
				
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(1212, 11, 148, 23);
		contentPane.add(btnNewButton);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChangePassword exp = new ChangePassword();
				exp.setVisible(true);
			}
		});
		btnChangePassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnChangePassword.setBounds(1212, 39, 148, 23);
		contentPane.add(btnChangePassword);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new LineBorder(Color.YELLOW, 2));
		panel_2.setBounds(677, 88, 683, 116);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Expenses");
		btnNewButton_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				Expenses exp = new Expenses();
				exp.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(29, 11, 148, 25);
		panel_2.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Expenses exp = new Expenses();
				exp.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JButton btnSessionExpired = new JButton("Membership Expired");
		btnSessionExpired.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				Expenses exp = new Expenses();
				exp.setVisible(true);
			}
		});
		btnSessionExpired.setBounds(187, 11, 148, 25);
		panel_2.add(btnSessionExpired);
		btnSessionExpired.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Session exp = new Session();
				exp.setVisible(true);
			}
		});
		btnSessionExpired.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		JButton btnAccount = new JButton("Member Details");
		btnAccount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				MemberDetails exp = new MemberDetails();
				exp.setVisible(true);
			}
		});
		btnAccount.setBounds(345, 11, 148, 25);
		panel_2.add(btnAccount);
		btnAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberDetails exp = new MemberDetails();
				exp.setVisible(true);
			}
		});
		btnAccount.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JButton btnProfit = new JButton("Profit");
		btnProfit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				new ProfitPass().setVisible(true);	
			}
		});
		btnProfit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			new ProfitPass().setVisible(true);
			}
		});
		btnProfit.setBounds(503, 11, 148, 25);
		panel_2.add(btnProfit);
		btnProfit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JButton btnHalfPaidMember = new JButton("Half Paid Members");
		btnHalfPaidMember.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				Halfpaid exp = new Halfpaid();
				exp.setVisible(true);
			}
		});
		btnHalfPaidMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Halfpaid exp = new Halfpaid();
				exp.setVisible(true);
			}
		});
		btnHalfPaidMember.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnHalfPaidMember.setBounds(29, 47, 148, 25);
		panel_2.add(btnHalfPaidMember);
		
		JButton btnMemberHistory = new JButton("Member Payments History");
		btnMemberHistory.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				MemberHis exp = new MemberHis();
				exp.setVisible(true);
			}
		});
		btnMemberHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MemberHis exp = new MemberHis();
				exp.setVisible(true);
			}
		});
		btnMemberHistory.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnMemberHistory.setBounds(187, 47, 306, 25);
		panel_2.add(btnMemberHistory);
		
		JButton btnTodaysActivities = new JButton("Todays Activities");
		btnTodaysActivities.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				TodayWork exp = new TodayWork();
				exp.setVisible(true);
			}
		});
		btnTodaysActivities.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TodayWork exp = new TodayWork();
				exp.setVisible(true);
			}
		});
		btnTodaysActivities.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnTodaysActivities.setBounds(503, 47, 148, 25);
		panel_2.add(btnTodaysActivities);
		
		JButton btnRenewMemberShip = new JButton("Renew Member ship for already registered members");
		btnRenewMemberShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new RenewReg().setVisible(true);
			}
		});
		btnRenewMemberShip.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnRenewMemberShip.setBounds(173, 83, 336, 25);
		panel_2.add(btnRenewMemberShip);
		
		JButton btnPaymentReminders = new JButton("Payment Reminders");
		btnPaymentReminders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Remainder().setVisible(true);				
			}
		});
		btnPaymentReminders.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnPaymentReminders.setBounds(29, 83, 134, 25);
		panel_2.add(btnPaymentReminders);
		
		JButton btnDevelopersInfo = new JButton("Developers info");
		btnDevelopersInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Developers().setVisible(true);
			}
		});
		btnDevelopersInfo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnDevelopersInfo.setBounds(517, 83, 134, 25);
		panel_2.add(btnDevelopersInfo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.YELLOW, 2, true));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(677, 207, 683, 485);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPayAmount = new JLabel("Pay Amount");
		lblPayAmount.setBounds(290, 18, 103, 24);
		lblPayAmount.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_1.add(lblPayAmount);
		
		JLabel lblNewLabel_3 = new JLabel("Select Name :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 50, 96, 24);
		panel_1.add(lblNewLabel_3);
		
		JComboBox payname = new JComboBox();
		payname.setBounds(100, 76, 340, 20);
		panel_1.add(payname);
		
		JLabel lblMemberName = new JLabel("Member Name :");
		lblMemberName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMemberName.setBounds(10, 139, 109, 24);
		panel_1.add(lblMemberName);
		
		JLabel lblAddress_1 = new JLabel("Address :");
		lblAddress_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAddress_1.setBounds(10, 174, 109, 24);
		panel_1.add(lblAddress_1);
		
		JLabel lblPhoneNo_1 = new JLabel("Phone No:");
		lblPhoneNo_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPhoneNo_1.setBounds(10, 229, 109, 24);
		panel_1.add(lblPhoneNo_1);
		
		JLabel lblDateOfRegistration = new JLabel("Date of Admission:");
		lblDateOfRegistration.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDateOfRegistration.setBounds(10, 264, 137, 24);
		panel_1.add(lblDateOfRegistration);
		
		JLabel lblRemainingAmount = new JLabel("Remaining Amount:");
		lblRemainingAmount.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRemainingAmount.setBounds(10, 370, 137, 24);
		panel_1.add(lblRemainingAmount);
		
		JLabel lblPackageSelected = new JLabel("Package Selected:");
		lblPackageSelected.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPackageSelected.setBounds(10, 299, 137, 24);
		panel_1.add(lblPackageSelected);
		
		JLabel lblAmountToPay = new JLabel("Amount to Pay:");
		lblAmountToPay.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAmountToPay.setBounds(10, 405, 109, 24);
		panel_1.add(lblAmountToPay);
		
		JButton btnGo = new JButton("GO!");
		btnGo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
			if(arg0.getKeyCode() == 10)
			{
				Connection conn = ConnectionClass.connmethod();
				try {
					String memname = null;
					String memaddress = null;
					String memphone = null; 
					String datead = null;
					byte[] payphoto = null;
					String packsel = null;
					String remamo = null;
					
					
					
					
					String name = (String) payname.getSelectedItem();
					PreparedStatement preparedStatement = conn.prepareStatement("select * from gymmember where membername = ?");
					preparedStatement.setString(1, name);
					
					ResultSet rs = preparedStatement.executeQuery();
					while(rs.next())
					{
						memname = rs.getString("membername");
						memaddress = rs.getString("address");
						payphoto = rs.getBytes("photo");
						datead = rs.getString("dateofadmission");
						memphone = rs.getString("phoneno");
						
					}
					
					preparedStatement = conn.prepareStatement("select * from halfpaidmember where membername = ?");
					preparedStatement.setString(1, name);
					rs = preparedStatement.executeQuery();
					while(rs.next())
					{
						packsel = rs.getString("package");
						remamo = rs.getString("amountremaining");
					}
					
					paymember.setText(memname);
					payaddress.setText(memaddress);
					paydateofadm.setText(datead);
					payphone.setText(memphone);
					paypackage.setText(packsel);
					payremaining.setText(remamo);
					
					if(payphoto != null)
					{
	        		
					int h= photopay.getHeight();
	        		int w= photopay.getWidth();
	        		ByteArrayInputStream bis = new ByteArrayInputStream(payphoto);
	        		BufferedImage img = ImageIO.read(bis);
	        		Image tmp = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
	        		BufferedImage dimg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

	        		Graphics2D g2d = dimg.createGraphics();
	        		g2d.drawImage(tmp, 0, 0, null);
	        		g2d.dispose();
	        		ImageIcon im = new ImageIcon(dimg);
	        		photopay.setIcon(im);
					}
					
					
	        		preparedStatement=conn.prepareStatement("select startdate,expiredate from session where name = ?");
	        		preparedStatement.setString(1, name);
					rs = preparedStatement.executeQuery();
	        		rs.next();
	        		
	        		dos.setText(rs.getString("startdate"));
	        		doe.setText(rs.getString("expiredate"));
					
					conn.close();
				} catch (SQLException | IOException e) {
					JOptionPane.showMessageDialog(null, e);
				}

			}
			}
		});
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn = ConnectionClass.connmethod();
				try {
					String memname = null;
					String memaddress = null;
					String memphone = null; 
					String datead = null;
					byte[] payphoto = null;
					String packsel = null;
					String remamo = null;
					
					
					
					
					String name = (String) payname.getSelectedItem();
					PreparedStatement preparedStatement = conn.prepareStatement("select * from gymmember where membername = ?");
					preparedStatement.setString(1, name);
					
					
					ResultSet rs = preparedStatement.executeQuery();
					while(rs.next())
					{
						memname = rs.getString("membername");
						memaddress = rs.getString("address");
						payphoto = rs.getBytes("photo");
						//payphoto = rs.getString("photo");
						datead = rs.getString("dateofadmission");
						memphone = rs.getString("phoneno");
						
					}
					
					preparedStatement = conn.prepareStatement("select * from halfpaidmember where membername = ?");
					preparedStatement.setString(1, name);
					rs = preparedStatement.executeQuery();
					while(rs.next())
					{
						packsel = rs.getString("package");
						remamo = rs.getString("amountremaining");
					}
					
					paymember.setText(memname);
					payaddress.setText(memaddress);
					paydateofadm.setText(datead);
					payphone.setText(memphone);
					paypackage.setText(packsel);
					payremaining.setText(remamo);
					
	        		int h= photopay.getHeight();
	        		int w= photopay.getWidth();
	        		
	        	
	        	//.	JOptionPane.showMessageDialog(payphoto);
	        		
	        		if(payphoto != null)
	        		{
	        		
	        		ByteArrayInputStream bis = new ByteArrayInputStream(payphoto);
	        		BufferedImage img = ImageIO.read(bis);
	        		Image tmp = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
	        		BufferedImage dimg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

	        		Graphics2D g2d = dimg.createGraphics();
	        		g2d.drawImage(tmp, 0, 0, null);
	        		g2d.dispose();
			     
	        		ImageIcon im = new ImageIcon(dimg);
			     
	        		photopay.setIcon(im);
	        		
	        		}
					
	        		preparedStatement=conn.prepareStatement("select startdate,expiredate from session where name = ?");
	        		preparedStatement.setString(1, name);
					rs = preparedStatement.executeQuery();
	        		rs.next();
	        		
	        		dos.setText(rs.getString("startdate"));
	        		doe.setText(rs.getString("expiredate"));
					
					conn.close();
				} catch (SQLException | IOException e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnGo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnGo.setBounds(451, 60, 71, 25);
		panel_1.add(btnGo);
		
		
		JButton generateformno = new JButton("Genrate form no.");
		generateformno.setFont(new Font("Tahoma", Font.PLAIN, 10));
		JButton savebtn = new JButton("Save");
		
		JRadioButton halfpayment = new JRadioButton("Part Payment");
		halfpayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amountpaid.setEnabled(true);
				amountpaid.setEditable(true);
				formno.setText("");
				foh=1;
				formcheck=0;
				savebtn.setEnabled(true);
				generateformno.setEnabled(false);
			}
		});
		halfpayment.setBackground(Color.WHITE);
		halfpayment.setFont(new Font("Tahoma", Font.BOLD, 13));
		halfpayment.setBounds(526, 402, 121, 23);
		panel.add(halfpayment);
		
		JRadioButton fullpayment = new JRadioButton("Full Payment");
		fullpayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amountpaid.setEnabled(false);
				amountpaid.setEditable(false);
				amountremaining.setText("");
				amountpaid.isEnabled();
				amountpaid.setText(pakammount.getText());
				generateformno.setEnabled(true);
				savebtn.setEnabled(false);
						
				foh=2;
			}
		});
		fullpayment.setBackground(Color.WHITE);
		fullpayment.setFont(new Font("Tahoma", Font.BOLD, 13));
		fullpayment.setBounds(411, 402, 109, 23);
		panel.add(fullpayment);
		
		bg.add(halfpayment);
		bg.add(fullpayment);
		
		
		paymember = new JTextField();
		paymember.setEditable(false);
		paymember.setFont(new Font("Tahoma", Font.PLAIN, 13));
		paymember.setColumns(10);
		paymember.setBounds(114, 142, 326, 20);
		panel_1.add(paymember);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(116, 175, 324, 47);
		panel_1.add(scrollPane_1);
		
		payaddress = new JTextArea();
		payaddress.setEditable(false);
		scrollPane_1.setViewportView(payaddress);
		
		payphone = new JTextField();
		payphone.setEditable(false);
		payphone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		payphone.setColumns(10);
		payphone.setBounds(142, 232, 137, 20);
		panel_1.add(payphone);
		
		paydateofadm = new JTextField();
		paydateofadm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		paydateofadm.setEditable(false);
		paydateofadm.setColumns(10);
		paydateofadm.setBounds(142, 266, 137, 20);
		panel_1.add(paydateofadm);
		
		paypackage = new JTextField();
		paypackage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		paypackage.setEditable(false);
		paypackage.setColumns(10);
		paypackage.setBounds(142, 299, 137, 20);
		panel_1.add(paypackage);
		
		payremaining = new JTextField();
		payremaining.setFont(new Font("Tahoma", Font.PLAIN, 13));
		payremaining.setEditable(false);
		payremaining.setColumns(10);
		payremaining.setBounds(142, 376, 137, 20);
		panel_1.add(payremaining);
		
		payamounttopay = new JTextField();
		payamounttopay.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
				String v = payamounttopay.getText();
				boolean b = ValidationClass.numcheck(v);
				if(b)
				{
					
				}
				else
				{
					String sub  = payamounttopay.getText();
					int l = sub.length();
					payamounttopay.setText(sub.substring(0, l-1));
				}
		
					int rem =	Integer.parseInt(payremaining.getText());
					int ampa =	Integer.parseInt(payamounttopay.getText());
					rempayamo.setText(Integer.toString(rem-ampa));
				
			}
		});
		payamounttopay.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				String v = payamounttopay.getText();
				boolean b = ValidationClass.numcheck(v);
				if(b)
				{
					
				}
				else
				{
					String sub  = payamounttopay.getText();
					int l = sub.length();
					payamounttopay.setText(sub.substring(0, l-1));
				}
			}
		});
		payamounttopay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				
			int rem =	Integer.parseInt(payremaining.getText());
			int ampa =	Integer.parseInt(payamounttopay.getText());
			rempayamo.setText(Integer.toString(rem-ampa));
			
			}
		});
		payamounttopay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		payamounttopay.setColumns(10);
		payamounttopay.setBounds(142, 407, 137, 20);
		panel_1.add(payamounttopay);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(0, 440, 683, 2);
		panel_1.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(0, 107, 683, 2);
		panel_1.add(separator_5);
		
		JButton paysavebtn = new JButton("Save");
		paysavebtn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == 10)
				{
					
					String shyam = (String)payname.getSelectedItem();
					String vali = ValidAll.validation1(payamounttopay.getText(),shyam);
					
					if(vali.equals("pass"))
					{
					String ret = rempayamo.getText();
					
					if (ret.equals("0"))
					{
						try {
							
							
							
							String name = (String )payname.getSelectedItem();
							Connection conn = ConnectionClass.connmethod();

							PreparedStatement pst;
							ResultSet rs;
							
							
							pst = conn.prepareStatement("select formno from gymmember where membername = ?");
							pst.setString(1, name);
							rs = pst.executeQuery();
							rs.next();
							
							if(rs.getString("formno").equals("Not Specified"))
							{
								pst = conn.prepareStatement("insert into frmauto values('inserted')");
								pst.execute();
								int formno1 = 0;
								pst = conn.prepareStatement("SELECT * FROM `gymmember` where formno != 'Not Specified'");
								rs = pst.executeQuery();
								while(rs.next())
								{
									formno1++;
								}
							
								String frmno=Integer.toString(formno1+1);
								
								pst = conn.prepareStatement("update gymmember set formno=? where membername=?");
								pst.setString(1, frmno);
								pst.setString(2, name);
								pst.execute();
								JOptionPane.showMessageDialog(null, "Member Form No : "+frmno);
								
								pst = conn.prepareStatement("delete from halfpaidmember where membername = ?");
								pst.setString(1, name);
								pst.execute();
								
								pst = conn.prepareStatement("insert into fullpayment values(?,?,?,?)"); 
								pst.setString(1, frmno);
								pst.setString(2, name);
								pst.setString(3, paydateofadm.getText());
								pst.setString(4,paypackage.getText() );
								pst.execute();
								
								
								Calendar now = Calendar.getInstance();
								int year = now.get(Calendar.YEAR);
								int month = now.get(Calendar.MONTH)+1;
								int date = now.get(Calendar.DATE);
								String pass = date + "-" + month + "-" + year;
								
								pst = conn.prepareStatement("insert into packhis values(?,?,?,?)");
								pst.setString(1, name);
								pst.setString(2, paypackage.getText());
								pst.setString(3, pass);
								pst.setString(4, payamounttopay.getText());
								pst.execute();
								
								
								DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
								LocalDateTime time = LocalDateTime.now();
								pst = conn.prepareStatement("insert into towork values('Remaining fees paid',?,?,?)");
								pst.setString(1, pass);
								pst.setString(2, dtf.format(time));
								pst.setString(3, name);
								pst.execute();
								
								
								pst = conn.prepareStatement("insert into profit values(?,?,?,?)");
								pst.setString(1, payamounttopay.getText());
								pst.setString(2, pass);
								pst.setInt(3, month);
								pst.setInt(4, year);
								pst.execute();
							}
							else
							{

								String frmno = rs.getString("formno");
								pst = conn.prepareStatement("delete from halfpaidmember where membername = ?");
								pst.setString(1, name);
								pst.execute();
								
								pst = conn.prepareStatement("insert into fullpayment values(?,?,?,?)"); 
								pst.setString(1, frmno);
								pst.setString(2, name);
								pst.setString(3, paydateofadm.getText());
								pst.setString(4,paypackage.getText() );
								pst.execute();	
							
								Calendar now = Calendar.getInstance();
								int year = now.get(Calendar.YEAR);
								int month = now.get(Calendar.MONTH)+1;
								int date = now.get(Calendar.DATE);
								String pass = date + "-" + month + "-" + year;
								
								pst = conn.prepareStatement("insert into packhis values(?,?,?,?)");
								pst.setString(1, name);
								pst.setString(2, paypackage.getText());
								pst.setString(3, pass);
								pst.setString(4, payamounttopay.getText());
								pst.execute();
								
								DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
								LocalDateTime time = LocalDateTime.now();
								pst = conn.prepareStatement("insert into towork values('Remaining fees paid',?,?,?)");
								pst.setString(1, pass);
								pst.setString(2, dtf.format(time));
								pst.setString(3, name);
								pst.execute();
								
								
								pst = conn.prepareStatement("insert into profit values(?,?,?,?)");
								pst.setString(1, payamounttopay.getText());
								pst.setString(2, pass);
								pst.setInt(3, month);
								pst.setInt(4, year);
								pst.execute();
							
							}
							//Need to update
							conn.close();
							//payamounttopay
							String amopaidpay = payamounttopay.getText();
							Calendar now = Calendar.getInstance();
							int year = now.get(Calendar.YEAR);
							int month = now.get(Calendar.MONTH)+1;
							int date = now.get(Calendar.DATE);
							String pass = date + "-" + month + "-" + year;
							
							String tprnt = 
									"        UNIVERSAL GYM\n"+
									"        Siddi Vianyak colony,\n"
									+ "        Saturna, Amravati  \n"+
									"\n      ===============================================\n"+
									"\n      Form No : "+formno.getText()+
									"\n      Name : "+name+
									"\n      Package : "+paypackage.getText()+
									"\n      Amount : "+payamounttopay.getText()+
									"\n      Date : "+pass+
									"\n\n     Sign\n   _______________";
									
									JTextArea fpr  = new JTextArea(tprnt);
									boolean isprint = fpr.print();
							
						
						
						}
							catch(Exception e1)
							{
								JOptionPane.showMessageDialog(null, e1);
							}
					}
					else
					{
						try {
							String amopaidpay = payamounttopay.getText();
							Calendar now = Calendar.getInstance();
							int year = now.get(Calendar.YEAR);
							int month = now.get(Calendar.MONTH)+1;
							int date = now.get(Calendar.DATE);
							String pass = date + "-" + month + "-" + year;
							
							String name = (String )payname.getSelectedItem();
							Connection conn = ConnectionClass.connmethod();
							PreparedStatement pst = conn.prepareStatement("update halfpaidmember set amountpaid = ? , amountremaining = ? , lastpaiddate = ? where membername = ?");
							
							pst.setString(1, amopaidpay);
							pst.setString(2, ret);
							pst.setString(3, pass);
							pst.setString(4, name);
							pst.execute();
							
							DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
							LocalDateTime time = LocalDateTime.now();
							pst = conn.prepareStatement("insert into towork values('installment fees paid',?,?,?)");
							pst.setString(1, pass);
							pst.setString(2, dtf.format(time));
							pst.setString(3, name);
							pst.execute();
							
							pst = conn.prepareStatement("insert into packhis values(?,?,?,?)");
							pst.setString(1, name);
							pst.setString(2, paypackage.getText());
							pst.setString(3, pass);
							pst.setString(4, payamounttopay.getText());
							pst.execute();
							
							pst = conn.prepareStatement("insert into profit values(?,?,?,?)");
							pst.setString(1, payamounttopay.getText());
							pst.setString(2, pass);
							pst.setInt(3, month);
							pst.setInt(4, year);
							pst.execute();
							
							conn.close();
							
							String tprnt = 
									"        UNIVERSAL GYM\n"+
									"        Siddi Vianyak colony,\n"
									+ "        Saturna, Amravati  \n"+
									"\n      ===============================================\n"+
									"\n      Name : "+name+
									"\n      Package : "+paypackage.getText()+
									"\n      Amount Paid : "+amopaidpay+
									"\n      Amount Rem. : "+ret+
									"\n      Date : "+pass+
									"\n\n       Sign\n    _______________";
									
									JTextArea fpr  = new JTextArea(tprnt);
									boolean isprint = fpr.print();
							
								
							
							}
							catch(Exception e1)
							{
								JOptionPane.showMessageDialog(null, e1);
							}
					}
				}
				else
				{
					JOptionPane.showMessageDialog(panel_1, vali);
				}
				}
				
			}
		});
		paysavebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String shyam = (String)payname.getSelectedItem();
				
				String vali = ValidAll.validation1(payamounttopay.getText(),shyam);
				
				if(vali.equals("pass"))
				{
				String ret = rempayamo.getText();
				
				if (ret.equals("0"))
				{
					try {
						
						
						
						String name = (String )payname.getSelectedItem();
						Connection conn = ConnectionClass.connmethod();

						PreparedStatement pst;
						ResultSet rs;
						
						
						pst = conn.prepareStatement("select formno from gymmember where membername = ?");
						pst.setString(1, name);
						rs = pst.executeQuery();
						rs.next();
						
						if(rs.getString("formno").equals("Not Specified"))
						{
							pst = conn.prepareStatement("insert into frmauto values('inserted')");
							pst.execute();
							int formno1 = 0;
							pst = conn.prepareStatement("SELECT * FROM `gymmember` where formno != 'Not Specified'");
							rs = pst.executeQuery();
							while(rs.next())
							{
								formno1++;
							}
						
							String frmno=Integer.toString(formno1+1);
							
							pst = conn.prepareStatement("update gymmember set formno=? where membername=?");
							pst.setString(1, frmno);
							pst.setString(2, name);
							pst.execute();
							JOptionPane.showMessageDialog(null, "Member Form No : "+frmno);
							
							pst = conn.prepareStatement("delete from halfpaidmember where membername = ?");
							pst.setString(1, name);
							pst.execute();
							
							pst = conn.prepareStatement("insert into fullpayment values(?,?,?,?)"); 
							pst.setString(1, frmno);
							pst.setString(2, name);
							pst.setString(3, paydateofadm.getText());
							pst.setString(4,paypackage.getText() );
							pst.execute();
							
							
							Calendar now = Calendar.getInstance();
							int year = now.get(Calendar.YEAR);
							int month = now.get(Calendar.MONTH)+1;
							int date = now.get(Calendar.DATE);
							String pass = date + "-" + month + "-" + year;
							
							pst = conn.prepareStatement("insert into packhis values(?,?,?,?)");
							pst.setString(1, name);
							pst.setString(2, paypackage.getText());
							pst.setString(3, pass);
							pst.setString(4, payamounttopay.getText());
							pst.execute();
							
							
							DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
							LocalDateTime time = LocalDateTime.now();
							pst = conn.prepareStatement("insert into towork values('Remaining fees paid',?,?,?)");
							pst.setString(1, pass);
							pst.setString(2, dtf.format(time));
							pst.setString(3, name);
							pst.execute();
							
							
							pst = conn.prepareStatement("insert into profit values(?,?,?,?)");
							pst.setString(1, payamounttopay.getText());
							pst.setString(2, pass);
							pst.setInt(3, month);
							pst.setInt(4, year);
							pst.execute();
						}
						else
						{

							String frmno = rs.getString("formno");
							pst = conn.prepareStatement("delete from halfpaidmember where membername = ?");
							pst.setString(1, name);
							pst.execute();
							
							pst = conn.prepareStatement("insert into fullpayment values(?,?,?,?)"); 
							pst.setString(1, frmno);
							pst.setString(2, name);
							pst.setString(3, paydateofadm.getText());
							pst.setString(4,paypackage.getText() );
							pst.execute();	
						
							Calendar now = Calendar.getInstance();
							int year = now.get(Calendar.YEAR);
							int month = now.get(Calendar.MONTH)+1;
							int date = now.get(Calendar.DATE);
							String pass = date + "-" + month + "-" + year;
							
							pst = conn.prepareStatement("insert into packhis values(?,?,?,?)");
							pst.setString(1, name);
							pst.setString(2, paypackage.getText());
							pst.setString(3, pass);
							pst.setString(4, payamounttopay.getText());
							pst.execute();
							
							DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
							LocalDateTime time = LocalDateTime.now();
							pst = conn.prepareStatement("insert into towork values('Remaining fees paid',?,?,?)");
							pst.setString(1, pass);
							pst.setString(2, dtf.format(time));
							pst.setString(3, name);
							pst.execute();
							
							
							pst = conn.prepareStatement("insert into profit values(?,?,?,?)");
							pst.setString(1, payamounttopay.getText());
							pst.setString(2, pass);
							pst.setInt(3, month);
							pst.setInt(4, year);
							pst.execute();
						
						}
						//Need to update
						conn.close();
						//payamounttopay
						String amopaidpay = payamounttopay.getText();
						Calendar now = Calendar.getInstance();
						int year = now.get(Calendar.YEAR);
						int month = now.get(Calendar.MONTH)+1;
						int date = now.get(Calendar.DATE);
						String pass = date + "-" + month + "-" + year;
						
						String tprnt = 
								"        UNIVERSAL GYM\n"+
								"        Siddi Vianyak colony,\n"
								+ "        Saturna, Amravati  \n"+
								"\n      ===============================================\n"+
								"\n      Form No : "+formno.getText()+
								"\n      Name : "+name+
								"\n      Package : "+paypackage.getText()+
								"\n      Amount : "+payamounttopay.getText()+
								"\n      Date : "+pass+
								"\n\n     Sign\n   _______________";
								
								JTextArea fpr  = new JTextArea(tprnt);
								boolean isprint = fpr.print();
					}
						catch(Exception e1)
						{
							JOptionPane.showMessageDialog(null, e1);
						}
				}
				else
				{
					try {
						String amopaidpay = payamounttopay.getText();
						Calendar now = Calendar.getInstance();
						int year = now.get(Calendar.YEAR);
						int month = now.get(Calendar.MONTH)+1;
						int date = now.get(Calendar.DATE);
						String pass = date + "-" + month + "-" + year;
						
						String name = (String )payname.getSelectedItem();
						Connection conn = ConnectionClass.connmethod();
						PreparedStatement pst = conn.prepareStatement("update halfpaidmember set amountpaid = ? , amountremaining = ? , lastpaiddate = ? where membername = ?");
						
						pst.setString(1, amopaidpay);
						pst.setString(2, ret);
						pst.setString(3, pass);
						pst.setString(4, name);
						pst.execute();
						
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
						LocalDateTime time = LocalDateTime.now();
						pst = conn.prepareStatement("insert into towork values('installment fees paid',?,?,?)");
						pst.setString(1, pass);
						pst.setString(2, dtf.format(time));
						pst.setString(3, name);
						pst.execute();
						
						pst = conn.prepareStatement("insert into packhis values(?,?,?,?)");
						pst.setString(1, name);
						pst.setString(2, paypackage.getText());
						pst.setString(3, pass);
						pst.setString(4, payamounttopay.getText());
						pst.execute();
						
						pst = conn.prepareStatement("insert into profit values(?,?,?,?)");
						pst.setString(1, payamounttopay.getText());
						pst.setString(2, pass);
						pst.setInt(3, month);
						pst.setInt(4, year);
						pst.execute();
						
						conn.close();
						
						String tprnt = 
								"        UNIVERSAL GYM\n"+
								"        Siddi Vianyak colony,\n"
								+ "        Saturna, Amravati  \n"+
								"\n      ===============================================\n"+
								"\n      Name : "+name+
								"\n      Package : "+paypackage.getText()+
								"\n      Amount Paid : "+amopaidpay+
								"\n      Amount Rem. : "+ret+
								"\n      Date : "+pass+
								"\n\n       Sign\n    _______________";
								
								JTextArea fpr  = new JTextArea(tprnt);
								boolean isprint = fpr.print();
						
							
						
						}
						catch(Exception e1)
						{
							JOptionPane.showMessageDialog(null, e1);
						}
				}
			}
			else
			{
				JOptionPane.showMessageDialog(panel_1, vali);
			}
			}
		});
		paysavebtn.setFont(new Font("Times New Roman", Font.BOLD, 15));
		paysavebtn.setBounds(214, 453, 122, 25);
		panel_1.add(paysavebtn);
		
		
		photopay = new JLabel("");
		photopay.setBounds(488, 120, 159, 171);
		newImg1 = img1.getScaledInstance(photopay.getWidth(),photopay.getHeight(), Image.SCALE_SMOOTH);
		photopay.setIcon(new ImageIcon(newImg1));
		panel_1.add(photopay);
		

		JButton payrfrbtn = new JButton("Clear");
		payrfrbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				paymember.setText("");
				payaddress.setText("");
				payphone.setText("");
				paydateofadm.setText("");
				paypackage.setText("");
				dos.setText("");
				doe.setText("");
				payremaining.setText("");
				payamounttopay.setText("");
				Image newImg1 = img1.getScaledInstance(photopay.getWidth(),photopay.getHeight(), Image.SCALE_SMOOTH);
				photopay.setIcon(new ImageIcon(newImg1));
			}
		});
		payrfrbtn.setFont(new Font("Times New Roman", Font.BOLD, 15));
		payrfrbtn.setBounds(346, 453, 122, 25);
		panel_1.add(payrfrbtn);
		
		textField = new JTextField();
		textField.setToolTipText("Select name of half paid member");
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				Connection conn = ConnectionClass.connmethod();
				try {
					
					PreparedStatement pst = conn.prepareStatement("select membername from halfpaidmember where membername like '"+textField.getText()+"%'");
					ResultSet rs = pst.executeQuery();
					payname.removeAllItems();
					while(rs.next())
					{
						payname.addItem(rs.getString("membername"));
					}
					conn.close();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e);
				}
				
			}
		});
		textField.setBounds(100, 53, 340, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblRemain = new JLabel("Remain : ");
		lblRemain.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRemain.setBounds(290, 405, 60, 24);
		panel_1.add(lblRemain);
		
		rempayamo = new JTextField();
		rempayamo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rempayamo.setEditable(false);
		rempayamo.setColumns(10);
		rempayamo.setBounds(385, 407, 137, 20);
		panel_1.add(rempayamo);
		
		JLabel lblDateOfStart = new JLabel("Date of Start:");
		lblDateOfStart.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDateOfStart.setBounds(10, 334, 109, 24);
		panel_1.add(lblDateOfStart);
		
		dos = new JTextField();
		dos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		dos.setEditable(false);
		dos.setColumns(10);
		dos.setBounds(142, 339, 137, 20);
		panel_1.add(dos);
		
		JLabel lblDateOfExpiry_1 = new JLabel("Date of Expiry:");
		lblDateOfExpiry_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDateOfExpiry_1.setBounds(290, 334, 109, 24);
		panel_1.add(lblDateOfExpiry_1);
		

		
		JButton refresh = new JButton("Clear");
		refresh.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyChar()==10)
				{
					
					photoofreg = null;
					rmembername.setText("");
					raddress.setText("");
					rphone.setText("");
					txtage.setText(""); 
					rheigth.setText("");
					rweight.setText("");
					roccupation.setText("");
					packagesel.setSelectedItem("Select Package");
					pakammount.setText("");
					validity.setText("");
					amountpaid.setText("");
					amountremaining.setText("");
					formno.setText("");
					rdbtnYes.setSelected(false);
					rdbtnNo.setSelected(false);
					halfpayment.setSelected(false);
					fullpayment.setSelected(false);
					amountpaid.setEnabled(false);
					Image newImg1 = img.getScaledInstance(photo.getWidth(),photo.getHeight(), Image.SCALE_SMOOTH);
					photo.setIcon(new ImageIcon(newImg1));
				}
			}
		});
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rmembername.setText("");
				photoofreg = null;
				raddress.setText("");
				rphone.setText("");
				txtage.setText(""); 
				rheigth.setText("");
				rweight.setText("");
				roccupation.setText("");
				packagesel.setSelectedItem("Select Package");
				pakammount.setText("");
				validity.setText("");
				amountpaid.setText("");
				amountremaining.setText("");
				formno.setText("");
				rdbtnYes.setSelected(false);
				rdbtnNo.setSelected(false);
				halfpayment.setSelected(false);
				fullpayment.setSelected(false);
				amountpaid.setEnabled(false);
				Image newImg1 = img.getScaledInstance(photo.getWidth(),photo.getHeight(), Image.SCALE_SMOOTH);
				photo.setIcon(new ImageIcon(newImg1));
			}
		});
		refresh.setFont(new Font("Times New Roman", Font.BOLD, 15));
		refresh.setBounds(357, 555, 122, 25);
		panel.add(refresh);
		
		doe = new JTextField();
		doe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		doe.setEditable(false);
		doe.setColumns(10);
		doe.setBounds(385, 336, 137, 20);
		panel_1.add(doe);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.ORANGE);
		separator_1.setBounds(1202, 0, 0, 77);
		contentPane.add(separator_1);
		
		
		
		savebtn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				
				//Start
				if(arg0.getKeyCode() == 10)
				{
					Date m=rdob.getDateEditor().getDate();
					SimpleDateFormat form = new SimpleDateFormat("yyyy-M-d");
					String name=rmembername.getText();
					String address=raddress.getText();
					String phone=rphone.getText();
					String dob = form.format(m); 
					String blood = (String)rblood.getSelectedItem();
					String age=(String) txtage.getText();; 
					String gender=(String) rgender.getSelectedItem();
					String height=rheigth.getText();
					String weight=rweight.getText();
					String occupation=roccupation.getText();
					String donate=dbl;
					String selpak= (String)packagesel.getSelectedItem();
					String payment=null;
					String dateofadm = dateofaddmission.getText();
					String dateofexp = validity.getText();
					String amountp = amountpaid.getText();
					String amountr = amountremaining.getText();
					String formn = formno.getText();
					byte[] sendphoto = photoofreg;
					
					String message = ValidAll.validation(name,address,phone,blood,age,gender,height,weight,occupation,donate,selpak,amountp);
					
					if(message == "pass")
					{
					
					
						if(foh==2)
						{
						payment="full paid";

						try {
							Connection conn = ConnectionClass.connmethod();	
							PreparedStatement pst = conn.prepareStatement("insert into gymmember(formno,membername,address,phoneno,dob,blood,age,gender,height,weight,occupation,"+
																			"donate,dateofadmission,photo)"+
																			"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
							pst.setString(1,formn);
							pst.setString(2, name);
							pst.setString(3, address);
							pst.setString(4, phone);
							pst.setString(5, dob);
							pst.setString(6, blood);
							pst.setString(7, age);
							pst.setString(8, gender);
							pst.setString(9, height);
							pst.setString(10,weight);
							pst.setString(11, occupation);
							pst.setString(12, donate);
							pst.setString(13, dateofadm);
							pst.setBytes(14, sendphoto);
							pst.execute();
							
							pst = conn.prepareStatement("insert into fullpayment values(?,?,?,?)");
							pst.setString(1, formn);
							pst.setString(2, name);
							pst.setString(3, dateofadm);
							pst.setString(4, selpak);
							pst.execute();
							
							
							//hererererererrerer
							
							pst = conn.prepareStatement("insert into session values(?,?,?,?,?)");
							pst.setString(1, name);
							pst.setString(2, dateofadm);
							pst.setString(3, dateofexp);
							pst.setString(4, selpak);
							Calendar checkmat = Calendar.getInstance();
							checkmat.add(checkmat.MONTH, 1);
							int checkmatdate = checkmat.get(Calendar.DATE);
							int checkmatmonth = checkmat.get(Calendar.MONTH);
							int checkmatyear = checkmat.get(Calendar.YEAR);
							String checkmatstring = checkmatdate+"-"+checkmatmonth+"-"+checkmatyear;
							pst.setString(5, checkmatstring);
							pst.execute();	
							//hererererererrerer
							
							String tprnt = 
							"        UNIVERSAL GYM\n"+
							"        Siddi Vianyak colony,\n"
							+ "        Saturna, Amravati  \n"+
							"\n      ===============================================\n"+
							"\n      Form No : "+formn+
							"\n      Name : "+name+
							"\n      Package : "+selpak+
							"\n      Amount : "+amountp+
							"\n      Date : "+dateofadm+
							"\n\n     Sign\n   _______________";
							
							JTextArea fpr  = new JTextArea(tprnt);
							boolean isprint = fpr.print();
							
							
							Calendar now = Calendar.getInstance();
							int year = now.get(Calendar.YEAR);
							int month = now.get(Calendar.MONTH)+1;
							int date = now.get(Calendar.DATE);
							String pass = date + "-" + month + "-" + year;
							
							pst = conn.prepareStatement("insert into packhis values(?,?,?,?)");
							pst.setString(1, name);
							pst.setString(2, selpak);
							pst.setString(3, pass);
							pst.setString(4, amountp);
							pst.execute();
							
							DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
							LocalDateTime time = LocalDateTime.now();
							pst = conn.prepareStatement("insert into towork values('FUll fees paid',?,?,?)");
							pst.setString(1, pass);
							pst.setString(2, dtf.format(time));
							pst.setString(3, name);
							pst.execute();
						
							
							pst = conn.prepareStatement("insert into profit values(?,?,?,?)");
							pst.setString(1, amountpaid.getText());
							pst.setString(2, pass);
							pst.setInt(3, month);
							pst.setInt(4, year);
							pst.execute();
							
						
							conn.close();
							} 
						catch (SQLException e1) 
							{
							
							if(sendphoto == null)
							{
								JOptionPane.showMessageDialog(panel, "Please attach photo" +"\n"+e1);	
							}
							
							else 
							{
								JOptionPane.showMessageDialog(panel, "Member with this name already exist please select another name" +"\n"+e1);
							}
							
							} catch (PrinterException e) {
							e.printStackTrace();
						}
					}
					if(foh==1)
					{
						payment="half payment";
						
						try {
							Connection conn = ConnectionClass.connmethod();
							PreparedStatement pst = conn.prepareStatement("insert into gymmember(formno,membername,address,phoneno,dob,blood,age,gender,height,weight,occupation,"+
																			"donate,dateofadmission,photo)"+
																			"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
							pst.setString(1,"Not Specified");
							pst.setString(2, name);
							pst.setString(3, address);
							pst.setString(4, phone);
							pst.setString(5, dob);
							pst.setString(6, blood);
							pst.setString(7, age);
							pst.setString(8, gender);
							pst.setString(9, height);
							pst.setString(10,weight);
							pst.setString(11, occupation);
							pst.setString(12, donate);
							pst.setString(13, dateofadm);
							pst.setBytes(14, sendphoto);
							pst.execute();
							
							pst = conn.prepareStatement("insert into halfpaidmember values(?,?,?,?,?)");
							pst.setString(1,name);
							pst.setString(2,selpak);
							pst.setString(3,amountp);
							pst.setString(4,amountr);
							pst.setString(5,dateofadm);
							pst.execute();
							
							//hererererererrerer
							 pst = conn.prepareStatement("insert into session values(?,?,?,?,?)");
								pst.setString(1, name);
								pst.setString(2, dateofadm);
								pst.setString(3, dateofexp);
								pst.setString(4, selpak);
								Calendar checkmat = Calendar.getInstance();
								checkmat.add(checkmat.MONTH, 1);
								int checkmatdate = checkmat.get(Calendar.DATE);
								int checkmatmonth = checkmat.get(Calendar.MONTH);
								int checkmatyear = checkmat.get(Calendar.YEAR);
								String checkmatstring = checkmatdate+"-"+checkmatmonth+"-"+checkmatyear;
								pst.setString(5, checkmatstring);
								pst.execute();
								//hererererererrerer
							
							String tprnt = 
									"        UNIVERSAL GYM\n"+
									"        Siddi Vianyak colony,\n"
									+ "        Saturna, Amravati  \n"+
									"\n      ===============================================\n"+
									"\n      Name : "+name+
									"\n      Package : "+selpak+
									"\n      Amount Paid : "+amountp+
									"\n      Amount Rem. : "+amountr+
									"\n      Date : "+dateofadm+
									"\n\n       Sign\n    _______________";
									
									JTextArea fpr  = new JTextArea(tprnt);
									boolean isprint = fpr.print();
							
							Calendar now = Calendar.getInstance();
							int year = now.get(Calendar.YEAR);
							int month = now.get(Calendar.MONTH)+1;
							int date = now.get(Calendar.DATE);
							String pass = date + "-" + month + "-" + year;
							
							pst = conn.prepareStatement("insert into packhis values(?,?,?,?)");
							pst.setString(1, name);
							pst.setString(2, selpak);
							pst.setString(3, pass);
							pst.setString(4, amountp);
							pst.execute();
							
							DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
							LocalDateTime time = LocalDateTime.now();
							pst = conn.prepareStatement("insert into towork values('HALF fees paid',?,?,?)");
							pst.setString(1, pass);
							pst.setString(2, dtf.format(time));
							pst.setString(3, name);
							pst.execute();
							
							pst = conn.prepareStatement("insert into profit values(?,?,?,?)");
							pst.setString(1, amountpaid.getText());
							pst.setString(2, pass);
							pst.setInt(3, month);
							pst.setInt(4, year);
							pst.execute();
							
							conn.close();
						} catch (SQLException e1) {

							if(sendphoto == null)
							{
								JOptionPane.showMessageDialog(panel, "Please attach photo" +"\n"+e1);	
							}
							
							else 
							{
								JOptionPane.showMessageDialog(panel, "Member with this name already exist please select another name" +"\n"+e1);
							}
							
							
						} catch (PrinterException e) {
							JOptionPane.showMessageDialog(panel, e);
						}
					}
					
					
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(panel, message);
				}

				}
				
				
				formcheck=0;
				//end	

				
			}
			
			
			
			
			
		});
		savebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Start
				
				
				Date m=rdob.getDateEditor().getDate();
				SimpleDateFormat form = new SimpleDateFormat("yyyy-M-d");
				
				
				
				String name=rmembername.getText();
				String address=raddress.getText();
				String phone=rphone.getText();
				String dob = form.format(m); 
				String blood = (String)rblood.getSelectedItem();
				String age=(String) txtage.getText();; 
				String gender=(String) rgender.getSelectedItem();
				String height=rheigth.getText();
				String weight=rweight.getText();
				String occupation=roccupation.getText();
				String donate=dbl;
				String selpak= (String)packagesel.getSelectedItem();
				String payment=null;
				String dateofadm = dateofaddmission.getText();
				String dateofexp = validity.getText();
				String amountp = amountpaid.getText();
				String amountr = amountremaining.getText();
				String formn = formno.getText();
				byte[] sendphoto = photoofreg;
				
				
				
				String message = ValidAll.validation(name,address,phone,blood,age,gender,height,weight,occupation,donate,selpak,amountp);
				
				if(message == "pass")
				{
				
				
					if(foh==2)
					{
					payment="full paid";

					try {
						Connection conn = ConnectionClass.connmethod();						
						
											
						
						
						
						PreparedStatement pst = conn.prepareStatement("insert into gymmember(formno,membername,address,phoneno,dob,blood,age,gender,height,weight,occupation,"+
																		"donate,dateofadmission,photo)"+
																		"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
						pst.setString(1,formn);
						pst.setString(2, name);
						pst.setString(3, address);
						pst.setString(4, phone);
						pst.setString(5, dob);
						pst.setString(6, blood);
						pst.setString(7, age);
						pst.setString(8, gender);
						pst.setString(9, height);
						pst.setString(10,weight);
						pst.setString(11, occupation);
						pst.setString(12, donate);
						pst.setString(13, dateofadm);
						pst.setBytes(14, sendphoto);
						pst.execute();
						
						pst = conn.prepareStatement("insert into fullpayment values(?,?,?,?)");
						pst.setString(1, formn);
						pst.setString(2, name);
						pst.setString(3, dateofadm);
						pst.setString(4, selpak);
						pst.execute();
						
						//hererererererrerer
						 pst = conn.prepareStatement("insert into session values(?,?,?,?,?)");
						pst.setString(1, name);
						pst.setString(2, dateofadm);
						pst.setString(3, dateofexp);
						pst.setString(4, selpak);
						Calendar checkmat = Calendar.getInstance();
						checkmat.add(checkmat.MONTH, 1);
						int checkmatdate = checkmat.get(Calendar.DATE);
						int checkmatmonth = checkmat.get(Calendar.MONTH);
						int checkmatyear = checkmat.get(Calendar.YEAR);
						String checkmatstring = checkmatdate+"-"+checkmatmonth+"-"+checkmatyear;
						pst.setString(5, checkmatstring);
						pst.execute();	
						//hererererererrerer
						
						String tprnt = 
						"        UNIVERSAL GYM\n"+
						"        Siddi Vianyak colony,\n"
						+ "        Saturna, Amravati  \n"+
						"\n      ===============================================\n"+
						"\n      Form No : "+formn+
						"\n      Name : "+name+
						"\n      Package : "+selpak+
						"\n      Amount : "+amountp+
						"\n      Date : "+dateofadm+
						"\n\n     Sign\n   _______________";
						
						JTextArea fpr  = new JTextArea(tprnt);
						boolean isprint = fpr.print();
						
						
						Calendar now = Calendar.getInstance();
						int year = now.get(Calendar.YEAR);
						int month = now.get(Calendar.MONTH)+1;
						int date = now.get(Calendar.DATE);
						String pass = date + "-" + month + "-" + year;
						
						pst = conn.prepareStatement("insert into packhis values(?,?,?,?)");
						pst.setString(1, name);
						pst.setString(2, selpak);
						pst.setString(3, pass);
						pst.setString(4, amountp);
						pst.execute();
						
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
						LocalDateTime time = LocalDateTime.now();
						pst = conn.prepareStatement("insert into towork values('FUll fees paid',?,?,?)");
						pst.setString(1, pass);
						pst.setString(2, dtf.format(time));
						pst.setString(3, name);
						pst.execute();
					
						
						pst = conn.prepareStatement("insert into profit values(?,?,?,?)");
						pst.setString(1, amountpaid.getText());
						pst.setString(2, pass);
						pst.setInt(3, month);
						pst.setInt(4, year);
						pst.execute();
						
						
						conn.close();
						} 
					catch (SQLException e1) 
						{
						
						if(sendphoto == null)
						{
							JOptionPane.showMessageDialog(panel, "Please attach photo" +"\n"+e1);	
						}
						
						else 
						{
							JOptionPane.showMessageDialog(panel, "Member with this name already exist please select another name" +"\n"+e1);
						}
						
						
						} catch (PrinterException e) {
						e.printStackTrace();
					}
				}
				
				
				
				if(foh==1)
				{
					payment="half payment";
					
					try {
						
						Connection conn = ConnectionClass.connmethod();
						
						
						
						PreparedStatement pst = conn.prepareStatement("insert into gymmember(formno,membername,address,phoneno,dob,blood,age,gender,height,weight,occupation,"+
																		"donate,dateofadmission,photo)"+
																		"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
						pst.setString(1,"Not Specified");
						pst.setString(2, name);
						pst.setString(3, address);
						pst.setString(4, phone);
						pst.setString(5, dob);
						pst.setString(6, blood);
						pst.setString(7, age);
						pst.setString(8, gender);
						pst.setString(9, height);
						pst.setString(10,weight);
						pst.setString(11, occupation);
						pst.setString(12, donate);
						pst.setString(13, dateofadm);
						pst.setBytes(14, sendphoto);
						pst.execute();
						
						pst = conn.prepareStatement("insert into halfpaidmember values(?,?,?,?,?)");
						pst.setString(1,name);
						pst.setString(2,selpak);
						pst.setString(3,amountp);
						pst.setString(4,amountr);
						pst.setString(5,dateofadm);
						pst.execute();
						
						//hererererererrerer
						 pst = conn.prepareStatement("insert into session values(?,?,?,?,?)");
							pst.setString(1, name);
							pst.setString(2, dateofadm);
							pst.setString(3, dateofexp);
							pst.setString(4, selpak);
							Calendar checkmat = Calendar.getInstance();
							checkmat.add(checkmat.DATE, 1);
							int checkmatdate = checkmat.get(Calendar.DATE);
							int checkmatmonth = checkmat.get(Calendar.MONTH);
							int checkmatyear = checkmat.get(Calendar.YEAR);
							String checkmatstring = checkmatdate+"-"+checkmatmonth+"-"+checkmatyear;
							pst.setString(5, checkmatstring);
							pst.execute();
							//hererererererrerer
						
						String tprnt = 
								"        UNIVERSAL GYM\n"+
								"        Siddi Vianyak colony,\n"
								+ "        Saturna, Amravati  \n"+
								"\n      ===============================================\n"+
								"\n      Name : "+name+
								"\n      Package : "+selpak+
								"\n      Amount Paid : "+amountp+
								"\n      Amount Rem. : "+amountr+
								"\n      Date : "+dateofadm+
								"\n\n       Sign\n    _______________";
								
								JTextArea fpr  = new JTextArea(tprnt);
								boolean isprint = fpr.print();
						
						Calendar now = Calendar.getInstance();
						int year = now.get(Calendar.YEAR);
						int month = now.get(Calendar.MONTH)+1;
						int date = now.get(Calendar.DATE);
						String pass = date + "-" + month + "-" + year;
						
						pst = conn.prepareStatement("insert into packhis values(?,?,?,?)");
						pst.setString(1, name);
						pst.setString(2, selpak);
						pst.setString(3, pass);
						pst.setString(4, amountp);
						pst.execute();
						
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
						LocalDateTime time = LocalDateTime.now();
						pst = conn.prepareStatement("insert into towork values('HALF fees paid',?,?,?)");
						pst.setString(1, pass);
						pst.setString(2, dtf.format(time));
						pst.setString(3, name);
						pst.execute();
						
						
						pst = conn.prepareStatement("insert into profit values(?,?,?,?)");
						pst.setString(1, amountpaid.getText());
						pst.setString(2, pass);
						pst.setInt(3, month);
						pst.setInt(4, year);
						pst.execute();
						
						conn.close();
					} catch (SQLException e1) {

						if(sendphoto == null)
						{
							JOptionPane.showMessageDialog(panel, "Please attach photo" +"\n"+e1);	
						}
						
						else 
						{
							JOptionPane.showMessageDialog(panel, "Member with this name already exist please select another name" +"\n"+e1);
						}
						
						
					} catch (PrinterException e) {
						JOptionPane.showMessageDialog(panel, e);
					}
				}
				
				
			}
			else
			{
				JOptionPane.showMessageDialog(panel, message);
			}
				
			
				formcheck=0;
			
			//end	
			}
		});
		savebtn.setFont(new Font("Times New Roman", Font.BOLD, 15));
		savebtn.setBounds(213, 555, 122, 25);
		panel.add(savebtn);
		
		rblood = new JComboBox();
		rblood.setToolTipText("Enter BloodGroup");
		rblood.setBounds(327, 185, 86, 20);
		panel.add(rblood);
		rblood.addItem("A+");
		rblood.addItem("A-");
		rblood.addItem("B+");
		rblood.addItem("B-");
		rblood.addItem("AB+");
		rblood.addItem("AB-");
		rblood.addItem("O+");
		rblood.addItem("O-");
		
		JLabel lblNewLabel_5 = new JLabel("Year");
		lblNewLabel_5.setBounds(174, 216, 37, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblFt = new JLabel("ft");
		lblFt.setBounds(193, 250, 37, 14);
		panel.add(lblFt);
		
		JLabel lblKg = new JLabel("Kg");
		lblKg.setBounds(400, 250, 37, 14);
		panel.add(lblKg);
		
		JLabel blooderror = new JLabel("");
		blooderror.setBounds(344, 322, 303, 14);
		panel.add(blooderror);
		
		txtage = new JTextField();
		txtage.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
				Calendar now = Calendar.getInstance();
				int year = now.get(Calendar.YEAR);
	    		Date m=rdob.getDateEditor().getDate();
				SimpleDateFormat form = new SimpleDateFormat("yyyy-M-d");
				String dob = form.format(m); 
				String exdate = dob.substring(0,4);
				int d = Integer.parseInt(exdate);				
				txtage.setText(Integer.toString(year - d));
	    		
			}
		});
		txtage.setBounds(115, 213, 50, 20);
		panel.add(txtage);
		txtage.setColumns(10);
		
		
		generateformno.setEnabled(false);
		generateformno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				try {
					Connection conn = ConnectionClass.connmethod();
					
					PreparedStatement pst = conn.prepareStatement("insert into frmauto values('inserted')");
					pst.execute();
					int formno1 = 0;
					pst = conn.prepareStatement("SELECT * FROM `gymmember` where formno != 'Not Specified'");
					ResultSet rs = pst.executeQuery();
					while(rs.next())
					{
						formno1++;
					}
					
					formno.setText(Integer.toString(formno1+1));
					
					conn.close();
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, e1);
					}
				
				
				savebtn.setEnabled(true);
				generateformno.setEnabled(false);
				
			}
		});
		generateformno.setBounds(10, 512, 122, 19);
		panel.add(generateformno);
		

		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(Color.CYAN));
		panel_3.setBounds(10, 11, 1350, 59);
		contentPane.add(panel_3);
		
		JLabel lblNewLabel_6 = new JLabel("Copy Rights All Right reserved to YOU THINK WE BUILD - SOFTWARE DEVELOPERS");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_6.setBounds(10, 690, 397, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblClickHere = new JLabel("Click Here!");
		lblClickHere.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new Developers().setVisible(true);
			}
		});
		lblClickHere.setForeground(Color.RED);
		lblClickHere.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblClickHere.setBounds(401, 690, 48, 14);
		contentPane.add(lblClickHere);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{panel_1, logo, lblNewLabel, separator, panel, lblAddress, lblPhoneNo, lblDob, lblAge, lblHeight, lblWeight, labgend, lblOccupation, lblDoYouLike, lblDateOfJoining, lblSelectPackage, lblAmount, lblNewLabel_1, lblNewLabel_2, rmembername, rphone, photo, rgender, scrollPane, raddress, rdob, rdob.getCalendarButton(), rheigth, rweight, roccupation, rdbtnYes, rdbtnNo, dateofaddmission, pakammount, packagesel, lblAmountRemaining, separator_2, amountpaid, lblFormNo, amountremaining, lblNewLabel_4, lblBloodGroup, refresh, separator_3, lblDateOfExpiry, validity, formno, halfpayment, fullpayment, savebtn, rblood, lblNewLabel_5, lblFt, lblKg, blooderror, btnNewButton, btnChangePassword, panel_2, btnNewButton_1, btnSessionExpired, btnAccount, btnProfit, btnHalfPaidMember, btnMemberHistory, lblPayAmount, lblNewLabel_3, payname, lblMemberName, lblAddress_1, lblPhoneNo_1, lblDateOfRegistration, lblRemainingAmount, lblPackageSelected, lblAmountToPay, btnGo, paymember, scrollPane_1, payaddress, payphone, paydateofadm, paypackage, payremaining, payamounttopay, separator_4, separator_5, paysavebtn, payrfrbtn, photopay, textField, lblRemain, rempayamo, lblDateOfStart, dos, lblDateOfExpiry_1, doe, separator_1}));
	packagesel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String selected= (String)packagesel.getSelectedItem();
				if(amm==1)
				{
					
					try {
						
						Connection conn= ConnectionClass.connmethod();
						
						PreparedStatement pst=conn.prepareStatement("select rs from package where name=?");
						pst.setString(1, selected);
						
						ResultSet rs=pst.executeQuery();
						while(rs.next())
						{
								
							pai=rs.getInt("rs")+100;
							pakammount.setText(Integer.toString(pai));
						}
						
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
						} catch (MySQLIntegrityConstraintViolationException ex) {
						JOptionPane.showMessageDialog(panel,"Please Attach a photo");
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(panel,"Please Attach a photo");
						}	
				}
			}

	});	
amountpaid.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			int packageammount = Integer.parseInt(pakammount.getText());
			int ammount=Integer.parseInt(amountpaid.getText());
			int remaining=packageammount-ammount;
			
			amountremaining.setText(Integer.toString(remaining));
			
		}
	});

	
load();	
}
private void load()
{

	try {
		
		Connection conn= ConnectionClass.connmethod();
		PreparedStatement pst=conn.prepareStatement("select * from package");
		ResultSet rs=pst.executeQuery();
		packagesel.addItem("Select Package");
		while(rs.next())
		{
			packagesel.addItem(rs.getObject("name"));
		}
		
		

		amm=1;
		conn.close();
		} catch (SQLException e) {
		JOptionPane.showMessageDialog(null,e);
	}
	
	Calendar now = Calendar.getInstance();
	int year = now.get(Calendar.YEAR);
	int month = now.get(Calendar.MONTH)+1;
	int date = now.get(Calendar.DATE);
	String pass = date + "-" + month + "-" + year;
	
	dateofaddmission.setText(pass);
}
}