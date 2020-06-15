import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class Remainder extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private  static JTextArea textArea;
	
	public static void main(String[] args) {
		try {
			Remainder dialog = new Remainder();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Remainder() {
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Gym Management");
		setBounds(100, 100, 523, 344);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 32, 487, 230);
		contentPanel.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setForeground(Color.RED);
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel = new JLabel("Reminaders");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(206, 11, 95, 14);
		contentPanel.add(lblNewLabel);
		
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	
		
		load();
	
	}



	public static void load()
	{
		
		Connection conn = ConnectionClass.connmethod();
		try {
			
			String msg="";
			Date strdate,expdate;
			String str,exp;
			PreparedStatement pst = conn.prepareStatement("select name,startdate,expiredate,package from session");
			ResultSet rs = pst.executeQuery();
			long dur,day;
			int count=0;
			while(rs.next())
			{
				str = rs.getString("startdate");
				exp = rs.getString("expiredate");
				strdate = new SimpleDateFormat("dd-MM-yyyy").parse(str);
				expdate = new SimpleDateFormat("dd-MM-yyyy").parse(exp);
				dur = expdate.getTime() - strdate.getTime();
				
				if(TimeUnit.MILLISECONDS.toHours(dur)<=120)
				{
					count ++;
					msg = msg +count+". Member "+rs.getString("name")+" left only "+((int)TimeUnit.MILLISECONDS.toHours(dur)/24)+" days in there current session \nof package "+rs.getString("package")+" Expiry date "+ rs.getString("expiredate") + "\n";		
					textArea.setText(msg);
				
				}
				
			}
			conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null,e);
		}
		

	}
}
	
	
