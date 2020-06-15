import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.proteanit.sql.DbUtils;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePhoto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	static byte phofreg[]; 
	static String Selected;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ChangePhoto dialog = new ChangePhoto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ChangePhoto() {
		setBounds(100, 100, 641, 362);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 175, 302);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int r = table.getSelectedRow();
				int c = table.getSelectedColumn();
				Selected = (String) table.getValueAt(r, c);
				
			}
		});
		scrollPane.setViewportView(table);
		table.setRowSelectionAllowed(false);
		table.setBackground(Color.WHITE);
	
		
		JButton btnNewButton = new JButton("Save Changes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			Connection conn = ConnectionClass.connmethod();
			
			
			try {
				
				PreparedStatement pst = conn.prepareStatement("update gymmember set photo = ? where membername = ?");
				pst.setBytes(1, phofreg);
				pst.setString(2,Selected);
				pst.execute();
				JOptionPane.showMessageDialog(null, "Saved....");
				
				btnNewButton.setEnabled(false);
				
				load();
				
				conn.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e);
			}
			
			}
		});
		btnNewButton.setBounds(340, 194, 135, 23);
		contentPanel.add(btnNewButton);
		btnNewButton.setEnabled(false);
		
		JLabel photo = new JLabel("");
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
					 phofreg= Files.readAllBytes(file.toPath());;
					 ByteArrayInputStream bis = new ByteArrayInputStream(data);
				     BufferedImage img = ImageIO.read(bis);
				     Image tmp = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
				     BufferedImage dimg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
				     Graphics2D g2d = dimg.createGraphics();
				     g2d.drawImage(tmp, 0, 0, null);
				     g2d.dispose();
				     ImageIcon im = new ImageIcon(dimg);
				     photo.setIcon(im);
				     btnNewButton.setEnabled(true); 

				     
				} catch (IOException e) {

				}
		        

			}
		});
		photo.setBounds(320, 11, 169, 172);
		contentPanel.add(photo);
		
		Image img = new ImageIcon(this.getClass().getResource("/id.png")).getImage();		
		Image newImg1 = img.getScaledInstance(photo.getWidth(),photo.getHeight(), Image.SCALE_SMOOTH);
		photo.setIcon(new ImageIcon(newImg1));
		
		
	load();
	}
	
	
	
public static void load()
{
	Connection conn = ConnectionClass.connmethod();
	
	try {
		
		DefaultTableModel model = new  DefaultTableModel();
		
		PreparedStatement pst = conn.prepareStatement("select membername from gymmember where photo is NULL");
		ResultSet rs = pst.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(rs));
		table.getColumnModel().getColumn(0).setHeaderValue("Member Name");
		
		
		conn.close();
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, e);
	}
	
	
}
}
