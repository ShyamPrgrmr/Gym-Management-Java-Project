import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Font;

public class Developers extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Developers dialog = new Developers();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Developers() {
		setResizable(false);
		setTitle("Gym Management");
		setBounds(100, 100, 450, 347);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.control);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextArea txtrGymManagement = new JTextArea();
			txtrGymManagement.setEditable(false);
			txtrGymManagement.setFont(new Font("Monospaced", Font.BOLD, 13));
			txtrGymManagement.setText("                   GYM MANAGEMENT\r\n\r\nSoftware is Developed and Deployed by,\r\nYou think we Build- Software Developers\r\n\r\nTeam Members\r\nShyam G. Pradhan\r\nVedant N. Jawanjal\r\n    \r\nConteact us :\r\nMob. Number : 8793127023, 9021026149\r\nEmail : www.shyam.pradhan@gmail.com, \r\n        vedantjawanjal99@gmail.com \r\n\r\nCopy Rights\r\nAll rights reserved to YOU THINK WE BUILD- \r\nSOFTWARE DEVELOPERS");
			txtrGymManagement.setBackground(SystemColor.control);
			txtrGymManagement.setBounds(0, 11, 444, 308);
			contentPanel.add(txtrGymManagement);
		}
	}

}
