import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.text.Element;
import javax.swing.text.TableView.TableRow;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.imageio.ImageIO;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Session extends JFrame {

	private static JPanel contentPane;
	private static  JTable table;
	private static JScrollPane scrollPane;
	public static DefaultTableModel model = new DefaultTableModel();
	static int ppp = 0 ;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Session frame = new Session();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Session() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
			ppp=1;

			try {
				Connection conn=ConnectionClass.connmethod();
				String query = "select * from table"; 
				PreparedStatement pst = conn.prepareStatement(query); 
				ResultSet rs = pst.executeQuery(); 
				table.setModel(DbUtils.resultSetToTableModel(rs));
				conn.close();
			} 
			catch (Exception m) {

			}

			
			}
		});
		setTitle("Gym Management");
		setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
	    setBounds(0, 0, 1690, 764);
		Image imageforframe = new ImageIcon(this.getClass().getResource("/gym4.png")).getImage();		
		setIconImage(imageforframe);
	
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.RED, 4, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel logo = new JLabel("UNIVERSAL HEALTH CLUB");
		logo.setBounds(10, 11, 350, 28);
		logo.setForeground(Color.RED);
		logo.setFont(new Font("Khmer UI", Font.BOLD, 22));
		contentPane.add(logo);
		
		JLabel lblNewLabel = new JLabel("Siddi Vianyak colony, Saturna, Amravati");
		lblNewLabel.setBounds(10, 37, 373, 25);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 75, 1444, 2);
		separator.setBackground(Color.RED);
		contentPane.add(separator);
		
		JLabel lblSessionExpired = new JLabel("SESSION EXPIRED");
		lblSessionExpired.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSessionExpired.setBounds(598, 78, 174, 28);
		contentPane.add(lblSessionExpired);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.YELLOW, 2));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 108, 1350, 594);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 1330, 507);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.setModel(model);
		
		 table.setBackground(Color.CYAN);
		 
		 JButton btnLoadData = new JButton("Load Data!");
		 btnLoadData.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		

		 		if(ppp==0)
		 		{
		 		Connection conn = ConnectionClass.connmethod();
		 		try {
		 				
		 			 model.addColumn("#");
		 			 model.addColumn("Name");
		 			 model.addColumn("Start Date");
		 			 model.addColumn("Expiry Date");
		 		
		 			scrollPane.remove(table);
		 			scrollPane.setViewportView(table);
		 			String strdate = null;
		 			String expdate = null;
		 			String name = null;
		 			Date sdate = null;
		 			Date edate=null;
		 			
		 			Calendar now = Calendar.getInstance();
		 			int year = now.get(Calendar.YEAR);
		 			int month = now.get(Calendar.MONTH)+1;
		 			int date = now.get(Calendar.DATE);
		 			String pass = date + "-" + month + "-" + year;
		 			Date todayDate = new SimpleDateFormat("dd-MM-yyyy").parse(pass);
		 			
		 			PreparedStatement pst = conn.prepareStatement("select name,startdate,expiredate from session");
		 			ResultSet rs = pst.executeQuery();
		 			 
		 			int i=0;
		 			while (rs.next()) 
		 			{
		 				
		 				strdate = rs.getString("startdate");
		 				expdate = rs.getString("expiredate");
		 				name = rs.getString("name");
		 				sdate=new SimpleDateFormat("dd-MM-yyyy").parse(strdate);
		 				edate=new SimpleDateFormat("dd-MM-yyyy").parse(expdate);
		 			
		 				JButton renew = new JButton("Renew");
		 				
		 				if(!sdate.after(todayDate) && !edate.before(todayDate)) {
		 				    /* historyDate <= todayDate <= futureDate */ 
		 				}
		 				else
		 				{
		 					i++;
		 					model.addRow(new Object[] { Integer.toString(i),rs.getString("name"), rs.getString("startdate"), rs.getString("expiredate")});
		 				}
		 			}
		 			ppp=1;
		 			conn.close();
		 		} catch (SQLException e) {
		 			JOptionPane.showMessageDialog(null, e);
		 		} catch (ParseException e) {
		 			JOptionPane.showMessageDialog(null, e);
		 		}
		 		
		 		}
		 	}
		 });
		 btnLoadData.setFont(new Font("Tahoma", Font.BOLD, 13));
		 btnLoadData.setBounds(1199, 10, 141, 23);
		 panel.add(btnLoadData);
		 
		 JButton btnNewButton = new JButton("Renew Package");
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		
		 		int row = table.getSelectedRow();
		 		String selnamemem = (String) table.getModel().getValueAt(row, 1); 
		 		model.removeRow(row);
		 		
		 		new RenewDialog(selnamemem);
		 		
		 	}
		 });
		 btnNewButton.setBounds(510, 560, 329, 23);
		 panel.add(btnNewButton);
		 
		 JPanel panel_1 = new JPanel();
		 panel_1.setBounds(10, 11, 1350, 59);
		 contentPane.add(panel_1);
		 JTableHeader header = table.getTableHeader();
	      header.setBackground(Color.yellow);
	}
	
	

public static void actionperforme()
{
	
}
}


class ButtonRenderer extends JButton implements  TableCellRenderer
{

public ButtonRenderer() {
  setOpaque(true);
}
@Override
public Component getTableCellRendererComponent(JTable table, Object obj,
    boolean selected, boolean focused, int row, int col) {
    setText((obj==null) ? "":obj.toString());

  return this;
}
}

class ButtonEditor extends DefaultCellEditor
{
protected JButton btn;
 private String lbl;
 private Boolean clicked;

 public ButtonEditor(JTextField txt) {
  super(txt);

  btn=new JButton();
  btn.setOpaque(true);

  btn.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {

      fireEditingStopped();
    }
  });
}

 @Override
public Component getTableCellEditorComponent(JTable table, Object obj,
    boolean selected, int row, int col) {

   lbl=(obj==null) ? "":obj.toString();
   btn.setText(lbl);
   clicked=true;
  return btn;
}

 @Override
public Object getCellEditorValue() {

   if(clicked)
    {
	   Session.actionperforme();
    }
  clicked=false;
  return new String(lbl);
}
 @Override
public boolean stopCellEditing() {

    clicked=false;
  return super.stopCellEditing();
}
 @Override
protected void fireEditingStopped() {
  super.fireEditingStopped();
}
}






