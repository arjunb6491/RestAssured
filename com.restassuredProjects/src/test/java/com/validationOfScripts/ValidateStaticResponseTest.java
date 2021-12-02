package com.validationOfScripts;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class ValidateStaticResponseTest {
	@Test
	public void responseValidate()
	{
		String ExpProjectName="testyantra";
		Response responce=when()
				.get("http://localhost:8084/projects");
		String ActProjectName=responce.jsonPath().get("[0].projectName");
		
		System.out.println("Actual Value="+ActProjectName);
		System.out.println("Expected Value="+ExpProjectName);
		
		responce.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
		
		Assert.assertEquals(ExpProjectName, ActProjectName);
	}

}
