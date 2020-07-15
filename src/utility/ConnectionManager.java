package utility;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager
{
	public  static Connection getConnection() throws SQLException, ClassNotFoundException, IOException 
	 {
		Properties prop=loadPropertiesFile();
		
		String driver = prop.getProperty("driver");
		String  url= prop.getProperty("url");
		String user=prop.getProperty("username");
		String password=prop.getProperty("password");
		
		System.out.println(driver);
		System.out.println(url);
		System.out.println(user);
		System.out.println(password);
		
		 Class.forName(driver);
		 Connection con;
		 con=DriverManager.getConnection(url,user,password);
		 
		 return con;
	 }
	
	 public static   Properties  loadPropertiesFile() throws IOException 
	 {
		 Properties prop = new Properties();
		 InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		 prop.load(in);
		 in.close();
		 return prop;
		 
	 }
	
}



