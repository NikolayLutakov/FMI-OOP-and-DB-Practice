import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext 
{
	static Connection connection = null;
	
	static Connection getConnection() 
	{
		
		//
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=BookShop;instance=MSSQLSERVER;user=nlyutakov;password=A123456a";
			
			
			connection = DriverManager.getConnection(dbURL);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
		return connection;
	}
}
