import java.sql.*;

import javax.swing.JOptionPane;

public class ConnectionClass {

	public static Connection connmethod()
	{
		try 
		{
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/gymmanagement","root", "");
		return con;
		}
		catch (Exception e) 
		{
		JOptionPane.showMessageDialog(null,e);
		return null;
		}
	}
}
