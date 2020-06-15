import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ChangePassword extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	
	public ChangePassword() {
		setTitle("Gym Managemen");
		setBounds(100, 100, 450, 129);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblChangeYourPassword = new JLabel("CHANGE YOUR PASSWORD");
			lblChangeYourPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblChangeYourPassword.setBounds(122, 11, 190, 14);
			contentPanel.add(lblChangeYourPassword);
		}
		{
			JLabel lblNewLabel = new JLabel("New Password : ");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel.setBounds(10, 33, 97, 14);
			contentPanel.add(lblNewLabel);
		}
		
		textField = new JTextField();
		textField.setBounds(104, 31, 320, 20);
		contentPanel.add(textField);
		JLabel lblNewLabel_1 = new JLabel("") ;
		textField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save!");
				okButton.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent arg0) {
						if(arg0.getKeyCode()==10)
						{
							try {
								Connection conn = ConnectionClass.connmethod();
								PreparedStatement pst = conn .prepareStatement("update login set password = ?");
								pst.setString(1, textField.getText());
								pst.execute();
								lblNewLabel_1.setText("Password Change Successfully...");
								conn.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				});
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Connection conn = ConnectionClass.connmethod();
						try {
							PreparedStatement pst = conn .prepareStatement("update login set password = ?");
							pst.setString(1, textField.getText());
							pst.execute();
							lblNewLabel_1.setText("Password Change Successfully...");
							conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				{
					
					buttonPane.add(lblNewLabel_1);
				}
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
