package com.RMGYantraProject;

import org.testng.Assert;
import org.testng.annotations.Test;

import ProjectUtils.PojoLibrary;
import genericUtilities.APIBaseClass;
import genericUtilities.IENDPOINTS;
import genericUtilities.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

public class CreateProjectWithCreatedStatus extends APIBaseClass {
	@Test
	public void CreateProjectWithCreatedStatusTest() throws Throwable
	{
		String status="created";
		String projectName="SDET_22_"+JavaUtility.getRandomData();
		PojoLibrary pojo=new PojoLibrary("RMGYantra",projectName,status,20);
		
		Response resp = given()
			.contentType(ContentType.JSON)
			.body(pojo)
		.when()
			.post(IENDPOINTS.CREATE_PROJECT_ENDPOINT);
		resp.then()
			.assertThat().statusCode(201)
			.log().all();
		String apiResponseProjectName=resp.jsonPath().get("projectName");
		System.out.println(apiResponseProjectName);
		
	String dbpro=Dlib.executeQueryAndVerifyAndGetData("select * from project", 4, apiResponseProjectName);
	String dbStatus=Dlib.executeQueryAndVerifyAndGetData("select * from project", 5, status);
	Assert.assertEquals(dbpro,apiResponseProjectName);
	}

}
