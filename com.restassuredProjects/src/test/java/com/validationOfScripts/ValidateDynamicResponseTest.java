package com.validationOfScripts;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.util.List;

public class ValidateDynamicResponseTest {
	@Test
	public void validate()
	{
			String ExpProjectName="testyantra";
			String ActProjectName=null;
			
			Response responce=when()
					.get("http://localhost:8084/projects");
			List<String> list=responce.jsonPath().get("projectName");
			
			for(String listData:list)
			{
				if(ExpProjectName.equals(listData))
				{
					ActProjectName=listData;
				}
			}
			
			
			Assert.assertEquals(ExpProjectName, ActProjectName);
		
	}

}
