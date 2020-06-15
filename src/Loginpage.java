/*
******************The software is developed by************** 
**********************you think we build******************** 
**********************Software Developers*******************
**Progaram written by shyam g. pradhan and vedant jawanjal**
*/
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.table.JTableHeader;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Loginpage {

	private JFrame frmGymManagement;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginpage window = new Loginpage();
					window.frmGymManagement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Loginpage() {
		initialize();
	}

	private void initialize() {
		
		
		Image img = new ImageIcon(this.getClass().getResource("/login.jpg")).getImage();
		
		frmGymManagement = new JFrame();
		frmGymManagement.setTitle("GYM MANAGEMENT");
		frmGymManagement.setResizable(false);
		frmGymManagement.getContentPane().setBackground(Color.WHITE);
		frmGymManagement.getContentPane().setLayout(null);
		
		JLabel loginimage = new JLabel("");
		loginimage.setBackground(Color.RED);
		loginimage.setBounds(0, 11, 200, 226);
		Image newImg1 = img.getScaledInstance(loginimage.getWidth(),loginimage.getHeight(), Image.SCALE_SMOOTH);
		loginimage.setIcon(new ImageIcon(newImg1));
		frmGymManagement.getContentPane().add(loginimage);
		
		JLabel lblNewLabel_1 = new JLabel("Login in account");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(223, 11, 181, 35);
		
		frmGymManagement.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Username : ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(208, 60, 72, 26);
		frmGymManagement.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPassword.setBounds(210, 97, 69, 26);
		frmGymManagement.getContentPane().add(lblPassword);
		
		username = new JTextField();
		username.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		username.setBounds(289, 64, 160, 20);
		frmGymManagement.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(289, 101, 160, 20);
		frmGymManagement.getContentPane().add(password);
		
		//startup
		
		try {
			Connection conn=ConnectionClass.connmethod();
			
			
			Date edate=null;
			String name= new String();
			String end = new String();
			Calendar now = Calendar.getInstance();
			int year = now.get(Calendar.YEAR);
			int month = now.get(Calendar.MONTH)+1;
			int date = now.get(Calendar.DATE);
			String pass = date + "-" + month + "-" + year;
			Date todayDate = new SimpleDateFormat("dd-MM-yyyy").parse(pass);
			PreparedStatement p;
			ResultSet r;
			PreparedStatement p1;
			ResultSet r1;		
			PreparedStatement p1911;
			Date exend1,exend2,ch;
			String exend=null;
	
			
			
			PreparedStatement pstfordelete = conn.prepareStatement("select formno,membername from gymmember where formno != 'Not Specified'");
			ResultSet rsfordelete = pstfordelete.executeQuery();
			while(rsfordelete.next())
			{
			
					String query = "select membername from halfpaidmember where membername = ?";
					PreparedStatement pst = conn.prepareStatement(query); 
					pst.setString(1, rsfordelete.getString("membername"));
					
					ResultSet rs = pst.executeQuery(); 
					while (rs.next())
					{
					p = conn.prepareStatement("select expiredate from session where name = ?");
					p.setString(1, rs.getString("membername"));
					r = p.executeQuery(); 
					while(r.next())
					{
						name = rs.getString("membername");
						end = r.getString("expiredate");
						
						edate=new SimpleDateFormat("dd-MM-yyyy").parse(end);
						
						if(edate.before(todayDate))
						{
							p1= conn.prepareStatement("delete from halfpaidmember where membername=?");
							p1.setString(1, name);
							p1.execute();
						}
						
					}
					}	
			}
			
			
			
			
			rsfordelete = conn.prepareStatement("select formno,membername from gymmember where formno = 'Not Specified'").executeQuery();
			while(rsfordelete.next())
			{
					String query = "select membername from halfpaidmember where membername = ?";
					PreparedStatement pst = conn.prepareStatement(query); 
					pst.setString(1, rsfordelete.getString("membername"));
					
					ResultSet rs = pst.executeQuery(); 
					while (rs.next())
					{
					p = conn.prepareStatement("select expiredate from session where name = ?");
					p.setString(1, rs.getString("membername"));
					r = p.executeQuery(); 
					while(r.next())
					{
						name = rs.getString("membername");
						end = r.getString("expiredate");
						
						edate=new SimpleDateFormat("dd-MM-yyyy").parse(end);
						
						if(edate.before(todayDate))
						{
							p1= conn.prepareStatement("delete from halfpaidmember where membername=?");
							p1.setString(1, name);
							p1.execute();
							
							p1= conn.prepareStatement("delete from session where name=?");
							p1.setString(1, name);
							p1.execute();
							
							p1= conn.prepareStatement("delete from gymmember where membername=?");
							p1.setString(1, name);
							p1.execute();
						
						}
						
					}
					}	
			}
			
			
			
			
			
				
		
			exend2=new SimpleDateFormat("dd-MM-yyyy").parse(pass);               //todays date
			
			PreparedStatement pst1 = conn.prepareStatement("select expiredate,name from session");
			ResultSet rs1 = pst1.executeQuery();				
			
			long dur;
			while(rs1.next())
			{
				exend = rs1.getString("expiredate");   						
				exend1=new SimpleDateFormat("dd-MM-yyyy").parse(exend);	        //Expiry date
				
				dur =    exend2.getTime() - exend1.getTime() ;
				
				//JOptionPane.showMessageDialog(null,TimeUnit.MILLISECONDS.toHours(dur));
				
				if(TimeUnit.MILLISECONDS.toHours(dur) > 720)    //diffrance between todays date and expiry_date+30 is 720 hours if greater then true
				{
					p1911 = conn.prepareStatement("delete from session where name = ?");
					p1911.setString(1, rs1.getString("name"));
					p1911.execute();
				}

				
			}
			
		
			
			
			conn.close();

		} 
		catch (Exception m) {
				JOptionPane.showMessageDialog(null, m);
		}

		
		
		try {
			Connection conn=ConnectionClass.connmethod();
			PreparedStatement pst,pst1,pst2,pst3,pst4;
			ResultSet rs,rs1,rs2,rs3,rs4;
			
			int hc=0,fc=0,sc=0;
			
			pst = conn.prepareStatement("select membername from gymmember");
			rs=pst.executeQuery();
			
			
			Date oyc,oy;
			long dury;
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
					pst4 = conn .prepareStatement("select dateofadmission from gymmember where membername=?");
					pst4.setString(1,  rs.getString("membername"));
					rs4 = pst4.executeQuery();
					oyc = new SimpleDateFormat("dd-MM-yyyy").parse(rs4.getString("dateofadmission"));
					Calendar c1 = Calendar.getInstance();
					
					int c1d = c1.get(Calendar.DATE);
					int c1m = c1.get(Calendar.MONTH);
					int c1y = c1.get(Calendar.YEAR);
					
					String y = c1d+"-"+c1m+"-"+c1y;
					oy = new SimpleDateFormat("dd-MM-yyyy").parse(y);
					
					dury = oy.getTime() - oyc.getTime();
					
					if(dury < 0)
					{
						dury = dury * (-1);
					}
					
					if(TimeUnit.MILLISECONDS.toHours(dury) >= 8760)
					{
						pst4 = conn .prepareStatement("delete  from gymmember where membername=?");
						pst4.setString(1,  rs.getString("membername"));
						pst4.executeQuery();
					}
					
				}
				
				
			}
			
			conn.close();

		} 
		catch (Exception m) {

		}


		
		
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
			if(arg0.getKeyCode()==10)
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
						Registratoinform exp = new Registratoinform();
						exp.setVisible(true);	
						frmGymManagement.dispose();
					} else 
					{
						JOptionPane.showMessageDialog(frmGymManagement,"Please give correct login credential...");
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
						Registratoinform exp = new Registratoinform();
						exp.setVisible(true);	
						frmGymManagement.dispose();
					} else 
					{
						JOptionPane.showMessageDialog(frmGymManagement,"Please give correct login credential...");
					}
					
					conn.close();

				} 
				catch (Exception m) {

				}

	
				
				
			}
		});
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(210, 150, 239, 35);
		frmGymManagement.getContentPane().add(btnNewButton);
		frmGymManagement.setBounds(100, 100, 475, 279);
		frmGymManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
