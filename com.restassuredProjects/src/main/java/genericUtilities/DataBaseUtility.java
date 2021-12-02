package genericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	static Driver driver;
	static Connection connection;
	static ResultSet result;
	
	/**
	 * This method will perform the mysql database connection
	 */
	public void connectDB()
	{
		try
		{
			driver =new Driver();
			DriverManager.registerDriver(driver);
			connection=DriverManager.getConnection(IConstants.dbURL,IConstants.username , IConstants.password);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * This method will close the mysql database connection
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException
	{
		connection.close();
	}
	/**this method will execute querry 
	 * This method will execute the query
	 * @param query
	 * @return
	 */
	public ResultSet executeQuery(String query)
	{
	try
	{
		result=connection.createStatement().executeQuery(query);
		return result;
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
		return result;
	}
	/**
	 * this method will execute querry based on querry and it will verify the data
	 * @param Qerry
	 * @param columnName
	 * @param expecteddata
	 * @return
	 * @throws SQLException
	 */
	public String executeQueryAndVerifyAndGetData(String Qerry,int columnName,String expecteddata) throws SQLException
	{
		boolean flag=false;
		result=connection.createStatement().executeQuery(Qerry);
		while(result.next())
		{
			if(result.getString(columnName).equals(expecteddata))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println(expecteddata+"====Data is Verified in Data Table====");
			return expecteddata;
		}
		else
		{
			System.out.println(expecteddata+"====Data is not Verified in Data Table====");
			return expecteddata;
		}
	}

}
