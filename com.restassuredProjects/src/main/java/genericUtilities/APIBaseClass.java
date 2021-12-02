package genericUtilities;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;


public class APIBaseClass {
	public DataBaseUtility Dlib=new DataBaseUtility();
	
	@BeforeSuite
	public void configBeforeSuite()
	{
		baseURI="http://localhost:8084";
		Dlib.connectDB();
	}
	
	@AfterSuite
	public void configAfterSuite() throws SQLException
	{
		Dlib.closeDB();
	}
}
