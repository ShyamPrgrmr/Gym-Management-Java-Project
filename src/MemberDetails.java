import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;
import net.proteanit.sql.DbUtils;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.UIManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;import java.util.concurrent.TimeUnit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class MemberDetails extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private JTextField namef;
	private JTextField agef;
	private JTextField heightf;
	private JTextField weightf;
	private JTextField phonef;
	private JTextField datef;
	private JTextField packagef;
	private JTextField textField_7;
	private JComboBox payname;
	private JTextField expin;
	private static byte[] photofreg;
	private static JLabel totalnumber;
	static byte[]  photoofreg1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberDetails frame = new MemberDetails();
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
	public MemberDetails() {
		
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Gym Management");
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setBounds(0, 0, 1690, 764);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
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
		
		Image imageforframe = new ImageIcon(this.getClass().getResource("/gym4.png")).getImage();		
		setIconImage(imageforframe);
	
		
		Image img1 = new ImageIcon(this.getClass().getResource("/user.png")).getImage();
		
		JLabel logo = new JLabel("UNIVERSAL HEALTH CLUB");
		logo.setForeground(Color.RED);
		logo.setFont(new Font("Khmer UI", Font.BOLD, 22));
		logo.setBounds(10, 11, 350, 28);
		contentPane.add(logo);
		
		JLabel lblNewLabel = new JLabel("Siddi Vianyak colony, Saturna, Amravati");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 37, 373, 25);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.RED);
		separator.setBackground(Color.RED);
		separator.setBounds(0, 75, 1370, 2);
		contentPane.add(separator);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.YELLOW, 2));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 88, 739, 612);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("All Gym Members");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(283, 11, 173, 24);
		panel.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 630, 550);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(UIManager.getColor("Button.background"));
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.YELLOW, 2));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(769, 88, 591, 612);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel photo = new JLabel("");
		photo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			

				
		       
			
			
			}
		});
		photo.setBounds(216, 86, 159, 171);
		Image newImg1 = img1.getScaledInstance(photo.getWidth(),photo.getHeight(), Image.SCALE_SMOOTH);
		photo.setIcon(new ImageIcon(newImg1));
		panel_1.add(photo);
		
		JLabel lblNewLabel_2 = new JLabel("Member Name:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 265, 104, 24);
		panel_1.add(lblNewLabel_2);
		
		namef = new JTextField();
		namef.setEditable(false);
		namef.setBounds(124, 268, 208, 20);
		panel_1.add(namef);
		namef.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAddress.setBounds(10, 300, 104, 24);
		panel_1.add(lblAddress);
		
		JLabel lblPhoneNo = new JLabel("Phone No.:");
		lblPhoneNo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPhoneNo.setBounds(10, 366, 104, 24);
		panel_1.add(lblPhoneNo);
		
		JLabel lblDateOfAdmission = new JLabel("Date of admission:");
		lblDateOfAdmission.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDateOfAdmission.setBounds(10, 401, 128, 24);
		panel_1.add(lblDateOfAdmission);
		
		JLabel label = new JLabel("Member Name :");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(677, 401, 109, 24);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Age:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBackground(Color.GRAY);
		label_1.setBounds(10, 430, 37, 25);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Height:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBackground(Color.GRAY);
		label_2.setBounds(10, 466, 53, 25);
		panel_1.add(label_2);
		
		agef = new JTextField();
		agef.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String v = agef.getText();
				boolean b = ValidationClass.decimalnumcheck(v);
				if(b)
				{
					
				}
				else
				{
					String sub  = agef.getText();
					int l = sub.length();
					agef.setText(sub.substring(0, l-1));
				}
			}
		});
		agef.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String v = agef.getText();
				boolean b = ValidationClass.decimalnumcheck(v);
				if(b)
				{
					
				}
				else
				{
					String sub  = agef.getText();
					int l = sub.length();
					agef.setText(sub.substring(0, l-1));
				}
			}
		});
		agef.setFont(new Font("Tahoma", Font.PLAIN, 13));
		agef.setColumns(10);
		agef.setBounds(72, 432, 53, 20);
		panel_1.add(agef);
		
		heightf = new JTextField();
		heightf.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String v = heightf.getText();
				boolean b = ValidationClass.decimalnumcheck(v);
				if(b)
				{
					
				}
				else
				{
					String sub  = heightf.getText();
					int l = sub.length();
					heightf.setText(sub.substring(0, l-1));
				}
				
			}
		});
		heightf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String v = heightf.getText();
				boolean b = ValidationClass.decimalnumcheck(v);
				if(b)
				{
					
				}
				else
				{
					String sub  = heightf.getText();
					int l = sub.length();
					heightf.setText(sub.substring(0, l-1));
				}
				
			}
		});
		heightf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		heightf.setColumns(10);
		heightf.setBounds(73, 468, 52, 20);
		panel_1.add(heightf);
		
		JLabel label_3 = new JLabel("Gender:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBackground(Color.GRAY);
		label_3.setBounds(135, 466, 68, 25);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("Weight:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_4.setBackground(Color.GRAY);
		label_4.setBounds(10, 502, 53, 25);
		panel_1.add(label_4);
		
		expin = new JTextField();
		expin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		expin.setEditable(false);
		expin.setColumns(10);
		expin.setBounds(404, 505, 65, 20);
		panel_1.add(expin);
		
		JComboBox genderf = new JComboBox();
		genderf.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		genderf.setBounds(238, 469, 86, 20);
		panel_1.add(genderf);
		
		weightf = new JTextField();
		weightf.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String v = weightf.getText();
				boolean b = ValidationClass.decimalnumcheck(v);
				if(b)
				{
					
				}
				else
				{
					String sub  = weightf.getText();
					int l = sub.length();
					weightf.setText(sub.substring(0, l-1));
				}
				
			}
		});
		weightf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String v = weightf.getText();
				boolean b = ValidationClass.decimalnumcheck(v);
				if(b)
				{
					
				}
				else
				{
					String sub  = weightf.getText();
					int l = sub.length();
					weightf.setText(sub.substring(0, l-1));
				}
			}
		});
		weightf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		weightf.setColumns(10);
		weightf.setBounds(72, 504, 53, 20);
		panel_1.add(weightf);
		
		JLabel label_5 = new JLabel("Blood Group:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_5.setBackground(Color.GRAY);
		label_5.setBounds(131, 430, 97, 25);
		panel_1.add(label_5);
		
		JComboBox bloodf = new JComboBox();
		bloodf.setModel(new DefaultComboBoxModel(new String[] {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"}));
		bloodf.setBounds(238, 433, 86, 20);
		panel_1.add(bloodf);
		
		JLabel formf = new JLabel("Form No. : ");
		formf.setFont(new Font("Tahoma", Font.BOLD, 13));
		formf.setBounds(10, 97, 142, 31);
		panel_1.add(formf);
		
		phonef = new JTextField();
		phonef.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String v = phonef.getText();
				boolean b = ValidationClass.numcheck(v);
				if(b)
				{
					
				}
				else
				{
					String sub  = phonef.getText();
					int l = sub.length();
					phonef.setText(sub.substring(0, l-1));
				}
			}
		});
		phonef.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String v = phonef.getText();
				boolean b = ValidationClass.numcheck(v);
				if(b)
				{
					
				}
				else
				{
					String sub  = phonef.getText();
					int l = sub.length();
					phonef.setText(sub.substring(0, l-1));
				}
			}
		});
		phonef.setBounds(124, 369, 200, 20);
		panel_1.add(phonef);
		phonef.setColumns(10);
		
		datef = new JTextField();
		datef.setEditable(false);
		datef.setColumns(10);
		datef.setBounds(124, 404, 86, 20);
		panel_1.add(datef);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 538, 611, 2);
		panel_1.add(separator_1);
				
		JLabel lblCurrentlySelectedPackage = new JLabel("Selected Package:");
		lblCurrentlySelectedPackage.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCurrentlySelectedPackage.setBackground(Color.GRAY);
		lblCurrentlySelectedPackage.setBounds(135, 502, 122, 25);
		panel_1.add(lblCurrentlySelectedPackage);
		
		packagef = new JTextField();
		packagef.setEditable(false);
		packagef.setFont(new Font("Tahoma", Font.PLAIN, 13));
		packagef.setColumns(10);
		packagef.setBounds(259, 505, 65, 20);
		panel_1.add(packagef);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(124, 301, 306, 57);
		panel_1.add(scrollPane_1);
		
		JTextArea addressf = new JTextArea();
		addressf.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
				String v = addressf.getText();
				boolean b = ValidationClass.charactercheckadd(v);
				if(b)
				{
					
				}
				else
				{
					String sub  = addressf.getText();
					int l = sub.length();
					addressf.setText(sub.substring(0, l-1));
				}
			}
		});
		addressf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				String v = addressf.getText();
				boolean b = ValidationClass.charactercheckadd(v);
				if(b)
				{
					
				}
				else
				{
					String sub  = addressf.getText();
					int l = sub.length();
					addressf.setText(sub.substring(0, l-1));
				}
			}
		});
		scrollPane_1.setViewportView(addressf);
		
		JLabel label_6 = new JLabel("Select Name :");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_6.setBounds(10, 11, 96, 24);
		panel_1.add(label_6);
		
		textField_7 = new JTextField();
		textField_7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
					try {
					Connection conn = ConnectionClass.connmethod();
					PreparedStatement pst = conn.prepareStatement("select membername from gymmember where membername like '"+textField_7.getText()+"%'");
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
		textField_7.setColumns(10);
		textField_7.setBounds(100, 14, 340, 20);
		panel_1.add(textField_7);
		
		payname = new JComboBox();
		payname.setBounds(100, 37, 340, 20);
		panel_1.add(payname);
		
		JButton button = new JButton("GO!");
		button.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
			if(arg0.getKeyCode()==10)
			{

				String formno = null;
				String memname = null;
				String maddress = null;
				String memphone = null; 
				String datead = null;
				byte[] payphoto = null;
				String packsel = null;
				String height = null;
				String weight = null;
				String gender = null;
				String blood = null;
				String age = null;
				String exp = null;
				
				String selnaame = (String) payname.getSelectedItem();
				try {
					Connection conn = ConnectionClass.connmethod();
					PreparedStatement pst = conn.prepareStatement("select * from gymmember where membername = ?");
					PreparedStatement pst1 = conn.prepareStatement("select * from session where name = ?");
					pst1.setString(1, selnaame);
					pst.setString(1,selnaame);
					ResultSet rs = pst.executeQuery();
					ResultSet rs1 = pst1.executeQuery();
					while (rs.next())
					{
						formno  = rs.getString("formno");
						memname	= rs.getString("membername");
						maddress= rs.getString("address");
						memphone= rs.getString("phoneno");
						datead	= rs.getString("dateofadmission");
						payphoto= rs.getBytes("photo");
						height	= rs.getString("height");
						weight	= rs.getString("weight");
						gender	= rs.getString("gender");
						blood	= rs.getString("blood");
						photofreg = payphoto;
						age		= rs.getString("age");
						
					}
					
					Date strdate,expdate;
					long dur=0;
					Calendar todaycheck = Calendar.getInstance();
					int year = todaycheck.get(Calendar.YEAR);
					int month = todaycheck.get(Calendar.MONTH)+1;
					int date = todaycheck.get(Calendar.DATE);
					String passtoday = date + "-" + month + "-" + year;
					
					while(rs1.next())
					{
						packsel = rs1.getString("package");
						strdate = new SimpleDateFormat("dd-MM-yyyy").parse(passtoday);
						expdate = new SimpleDateFormat("dd-MM-yyyy").parse(rs1.getString("expiredate"));
						dur =   expdate.getTime()-strdate.getTime();
					}
					expin.setText((TimeUnit.MILLISECONDS.toHours(dur)/24+". days"));

					formf.setText("Form No. : "+formno);
					namef.setText(memname);
					addressf.setText(maddress);
					phonef.setText(memphone);
					datef.setText(datead);
					heightf.setText(height);
					weightf.setText(weight);
					genderf.setSelectedItem(gender);
					bloodf.setSelectedItem(blood);
					agef.setText(age);
					packagef.setText(packsel);					

	        		int h= photo.getHeight();
	        		int w= photo.getWidth();
	        		
	        		try
	        		{
	        		ByteArrayInputStream bis = new ByteArrayInputStream(payphoto);
	        		BufferedImage img = ImageIO.read(bis);
	        		Image tmp = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
	        		BufferedImage dimg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	        		Graphics2D g2d = dimg.createGraphics();
	        		g2d.drawImage(tmp, 0, 0, null);
	        		g2d.dispose();
	        		ImageIcon im = new ImageIcon(dimg);
					photo.setIcon(im);		
	        		}
	        		catch(NullPointerException npe)
	        		{
	        			
	        		}
					
					conn.close();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, e);
					} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String formno = null;
				String memname = null;
				String maddress = null;
				String memphone = null; 
				String datead = null;
				byte[] payphoto = null;
				String packsel = null;
				String height = null;
				String weight = null;
				String gender = null;
				String blood = null;
				String age = null;
				
				String selnaame = (String) payname.getSelectedItem();
				try {
					Connection conn = ConnectionClass.connmethod();
					PreparedStatement pst = conn.prepareStatement("select * from gymmember where membername = ?");
					PreparedStatement pst1 = conn.prepareStatement("select * from session where name = ?");
					pst1.setString(1, selnaame);
					pst.setString(1,selnaame);
					ResultSet rs = pst.executeQuery();
					ResultSet rs1 = pst1.executeQuery();
					while (rs.next())
					{
						formno  = rs.getString("formno");
						memname	= rs.getString("membername");
						maddress= rs.getString("address");
						memphone= rs.getString("phoneno");
						datead	= rs.getString("dateofadmission");
						payphoto= rs.getBytes("photo");
						height	= rs.getString("height");
						weight	= rs.getString("weight");
						gender	= rs.getString("gender");
						blood	= rs.getString("blood");
						age		= rs.getString("age");
						photofreg = payphoto;
					}
					
					Date strdate,expdate;
					long dur=0;
					Calendar todaycheck = Calendar.getInstance();
					int year = todaycheck.get(Calendar.YEAR);
					int month = todaycheck.get(Calendar.MONTH)+1;
					int date = todaycheck.get(Calendar.DATE);
					String passtoday = date + "-" + month + "-" + year;
					
					while(rs1.next())
					{
						packsel = rs1.getString("package");
						strdate = new SimpleDateFormat("dd-MM-yyyy").parse(passtoday);
						expdate = new SimpleDateFormat("dd-MM-yyyy").parse(rs1.getString("expiredate"));
						dur =   expdate.getTime()-strdate.getTime();
					}
					expin.setText((TimeUnit.MILLISECONDS.toHours(dur)/24+". days"));

					
					
					
					formf.setText("Form No. : "+formno);
					namef.setText(memname);
					addressf.setText(maddress);
					phonef.setText(memphone);
					datef.setText(datead);
					heightf.setText(height);
					weightf.setText(weight);
					genderf.setSelectedItem(gender);
					bloodf.setSelectedItem(blood);
					agef.setText(age);
					packagef.setText(packsel);
										

					
					
	        		int h= photo.getHeight();
	        		int w= photo.getWidth();
	        		
	        		try
	        		{
	        		ByteArrayInputStream bis = new ByteArrayInputStream(payphoto);
	        		BufferedImage img = ImageIO.read(bis);
	        		Image tmp = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
	        		BufferedImage dimg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	        		Graphics2D g2d = dimg.createGraphics();
	        		g2d.drawImage(tmp, 0, 0, null);
	        		g2d.dispose();
	        		ImageIcon im = new ImageIcon(dimg);
					photo.setIcon(im);		
	        		}
	        		catch(NullPointerException npe)
	        		{
	        			
	        		}
					
					conn.close();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, e);
					} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button.setFont(new Font("Times New Roman", Font.BOLD, 15));
		button.setBounds(450, 11, 71, 20);
		panel_1.add(button);
		
		JButton btnNewButton = new JButton("Edit");
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if(arg0.getKeyCode() == 10)
				{
					int col = table.getSelectedColumn();
					int row = table.getSelectedRow();
					

					String formno = null;
					String memname = null;
					String maddress = null;
					String memphone = null; 
					String datead = null;
					byte[] payphoto = null;
					String packsel = null;
					String height = null;
					String weight = null;
					String gender = null;
					String blood = null;
					String age = null;
					
					String selnaame =  (String) table.getModel().getValueAt(row, 1);
					
					try {
						Connection conn = ConnectionClass.connmethod();
						PreparedStatement pst = conn.prepareStatement("select * from gymmember where membername = ?");
						PreparedStatement pst1 = conn.prepareStatement("select * from session where name = ?");
						pst1.setString(1, selnaame);
						pst.setString(1,selnaame);
						ResultSet rs = pst.executeQuery();
						ResultSet rs1 = pst1.executeQuery();
						while (rs.next())
						{
							formno  = rs.getString("formno");
							memname	= rs.getString("membername");
							maddress= rs.getString("address");
							memphone= rs.getString("phoneno");
							datead	= rs.getString("dateofadmission");
							payphoto= rs.getBytes("photo");
							photofreg = payphoto;
							height	= rs.getString("height");
							weight	= rs.getString("weight");
							gender	= rs.getString("gender");
							blood	= rs.getString("blood");
							age		= rs.getString("age");
							
						}
						
						Date strdate,expdate;
						long dur=0;
						Calendar todaycheck = Calendar.getInstance();
						int year = todaycheck.get(Calendar.YEAR);
						int month = todaycheck.get(Calendar.MONTH)+1;
						int date = todaycheck.get(Calendar.DATE);
						String passtoday = date + "-" + month + "-" + year;
						
						while(rs1.next())
						{
							packsel = rs1.getString("package");
							strdate = new SimpleDateFormat("dd-MM-yyyy").parse(passtoday);
							expdate = new SimpleDateFormat("dd-MM-yyyy").parse(rs1.getString("expiredate"));
							dur =   expdate.getTime()-strdate.getTime();
						}
						expin.setText((TimeUnit.MILLISECONDS.toHours(dur)/24+". days"));
	
						formf.setText("Form No. : "+formno);
						namef.setText(memname);
						addressf.setText(maddress);
						phonef.setText(memphone);
						datef.setText(datead);
						heightf.setText(height);
						weightf.setText(weight);
						genderf.setSelectedItem(gender);
						bloodf.setSelectedItem(blood);
						agef.setText(age);
						packagef.setText(packsel);
						

		        		int h= photo.getHeight();
		        		int w= photo.getWidth();
		        		try
		        		{
		        		ByteArrayInputStream bis = new ByteArrayInputStream(payphoto);
		        		BufferedImage img = ImageIO.read(bis);
		        		Image tmp = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		        		BufferedImage dimg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		        		Graphics2D g2d = dimg.createGraphics();
		        		g2d.drawImage(tmp, 0, 0, null);
		        		g2d.dispose();
		        		ImageIcon im = new ImageIcon(dimg);
						photo.setIcon(im);		
		        		}
		        		catch(NullPointerException npe)
		        		{
		        			
		        		}
						
						conn.close();
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, e);
					} catch (IOException e) {
						JOptionPane.showMessageDialog(null, e);
						} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int col = table.getSelectedColumn();
				int row = table.getSelectedRow();
				

				String formno = null;
				String memname = null;
				String maddress = null;
				String memphone = null; 
				String datead = null;
				byte[] payphoto = null;
				String packsel = null;
				String height = null;
				String weight = null;
				String gender = null;
				String blood = null;
				String age = null;
				
				String selnaame =  (String) table.getModel().getValueAt(row, 1);
				
				try {
					Connection conn = ConnectionClass.connmethod();
					PreparedStatement pst = conn.prepareStatement("select * from gymmember where membername = ?");
					PreparedStatement pst1 = conn.prepareStatement("select * from session where name = ?");
					pst1.setString(1, selnaame);
					pst.setString(1,selnaame);
					ResultSet rs = pst.executeQuery();
					ResultSet rs1 = pst1.executeQuery();
					while (rs.next())
					{
						formno  = rs.getString("formno");
						memname	= rs.getString("membername");
						maddress= rs.getString("address");
						memphone= rs.getString("phoneno");
						datead	= rs.getString("dateofadmission");
						payphoto= rs.getBytes("photo");
						photofreg = payphoto;
						height	= rs.getString("height");
						weight	= rs.getString("weight");
						gender	= rs.getString("gender");
						blood	= rs.getString("blood");
						age		= rs.getString("age");
						
					}
					
					Date strdate,expdate;
					long dur=0;
					Calendar todaycheck = Calendar.getInstance();
					int year = todaycheck.get(Calendar.YEAR);
					int month = todaycheck.get(Calendar.MONTH)+1;
					int date = todaycheck.get(Calendar.DATE);
					String passtoday = date + "-" + month + "-" + year;
					
					while(rs1.next())
					{
						packsel = rs1.getString("package");
						strdate = new SimpleDateFormat("dd-MM-yyyy").parse(passtoday);
						expdate = new SimpleDateFormat("dd-MM-yyyy").parse(rs1.getString("expiredate"));
						dur =   expdate.getTime()-strdate.getTime();
					}
					expin.setText((TimeUnit.MILLISECONDS.toHours(dur)/24+". days"));

					
					formf.setText("Form No. : "+formno);
					namef.setText(memname);
					addressf.setText(maddress);
					phonef.setText(memphone);
					datef.setText(datead);
					heightf.setText(height);
					weightf.setText(weight);
					genderf.setSelectedItem(gender);
					bloodf.setSelectedItem(blood);
					agef.setText(age);
					packagef.setText(packsel);
					

	        		int h= photo.getHeight();
	        		int w= photo.getWidth();
	        		
	        		/*try
	        		{*/
	        			
	        				ByteArrayInputStream bis = new ByteArrayInputStream(payphoto);
	        				BufferedImage img = ImageIO.read(bis);
	        				Image tmp = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
	        				BufferedImage dimg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	        				
	        				Graphics2D g2d = dimg.createGraphics();
	        				g2d.drawImage(tmp, 0, 0, null);
	        				g2d.dispose();
	        				
	        				ImageIcon im = new ImageIcon(dimg);
	        				photo.setIcon(im);		
	        			
	        				conn.close();
	        		/*}
	        		catch(Exception e1)
	        		{
	        			JOptionPane.showMessageDialog(null, e1);
	        		}
					*/
					
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, e);
					} catch (ParseException e) {
						JOptionPane.showMessageDialog(null, e);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(650, 294, 79, 23);
		panel.add(btnNewButton);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 73, 611, 2);
		panel_1.add(separator_2);
		

		JButton button_1 = new JButton("Save");
		button_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==10)
				{

					String memname 		= 	namef.getText();
					String maddress 	= 	addressf.getText();
					String memphone		=	phonef.getText(); 
					String height 		= 	heightf.getText();
					String weight 		= 	weightf.getText();
					String gender 		= 	(String)genderf.getSelectedItem();
					String blood 		= 	(String)bloodf.getSelectedItem();
					String age 			= 	agef.getText();
					
					
					
					Connection conn = ConnectionClass.connmethod();
					try {
						PreparedStatement pst = conn.prepareStatement("update gymmember set membername = ?,address = ?,phoneno = ?,height = ?,weight = ?, gender = ?, blood = ?,age = ? where membername=?");
						
						pst.setString(1, memname);
						pst.setString(2, maddress);
						pst.setString(3, memphone);
						pst.setString(4, height);
						pst.setString(5, weight);
						pst.setString(6, gender);
						pst.setString(7, blood);
						pst.setString(8, age);
						pst.setString(9, memname);
						
						
						
						pst.executeUpdate();
						load();
						conn.close();
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(panel_1, e);
					}
				}
			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String memname 		= 	namef.getText();
				String maddress 	= 	addressf.getText();
				String memphone		=	phonef.getText(); 
				String height 		= 	heightf.getText();
				String weight 		= 	weightf.getText();
				String gender 		= 	(String)genderf.getSelectedItem();
				String blood 		= 	(String)bloodf.getSelectedItem();
				String age 			= 	agef.getText();
				
				
				
				Connection conn = ConnectionClass.connmethod();
				try {
					PreparedStatement pst = conn.prepareStatement("update gymmember set membername = ?,address = ?,phoneno = ?,height = ?,weight = ?, gender = ?, blood = ?,age = ? where membername=?");
					
					pst.setString(1, memname);
					pst.setString(2, maddress);
					pst.setString(3, memphone);
					pst.setString(4, height);
					pst.setString(5, weight);
					pst.setString(6, gender);
					pst.setString(7, blood);
					pst.setString(8, age);
					pst.setString(9, memname);
				
					
					
					pst.executeUpdate();
					load();
					conn.close();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(panel_1, e);
				}
				
			}
		});
		button_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		button_1.setBounds(238, 551, 122, 25);
		panel_1.add(button_1);
		
		JLabel lblExpireIn = new JLabel("Expire In. :");
		lblExpireIn.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblExpireIn.setBackground(Color.GRAY);
		lblExpireIn.setBounds(330, 502, 79, 25);
		panel_1.add(lblExpireIn);
		
		totalnumber = new JLabel("");
		totalnumber.setBounds(450, 40, 122, 14);
		panel_1.add(totalnumber);
		
		JButton btnNewButton_1 = new JButton("Change Photo for Members");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ChangePhoto().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_1.setBounds(112, 587, 357, 14);
		panel_1.add(btnNewButton_1);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 1350, 59);
		contentPane.add(panel_2);

		
		load();
		
		
	}

public static void load()
{
	Connection conn = ConnectionClass.connmethod();
	try {
		
		PreparedStatement pst = conn .prepareStatement("select formno,membername,phoneno,age,gender,blood,dateofadmission from gymmember order by formno");
		ResultSet rs = pst.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(rs));
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
	     int data=0;
	     PreparedStatement pst1 = conn .prepareStatement("select formno,membername,phoneno,age,gender,blood,dateofadmission from gymmember order by formno");
		 ResultSet rs1 = pst.executeQuery();
		
		 while(rs1.next())
		 {
			 data++;
		 }
	     
	     totalnumber.setText("Total Members : "+data);
		 
		conn.close();
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, e);
	}
	
}
}
