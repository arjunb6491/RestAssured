package com.RMGYantraProject;

import org.testng.annotations.Test;

import ProjectUtils.PojoLibrary;
import ProjectUtils.pojoLibraryEmployee;
import genericUtilities.IENDPOINTS;
import genericUtilities.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class E2EScenario {
	@Test
	public void E2EScenarioTest()
	{
		String status="completed";
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
		
		//create user for above project
		
		pojoLibraryEmployee EmpProObj=new pojoLibraryEmployee("sdet", "12/12/1990", "arjun@gmail.com", "arjunb", 5, "9972148024", apiResponseProjectName, "ROLE_EMPLOYEE", "Arjun");
		given()
			.contentType(ContentType.JSON)
			.body(EmpProObj)
	.when()
		.post(IENDPOINTS.CREATE_EMPLOYEE_ENDPOINT)
	.then()
		.assertThat().statusCode(201)
		.log().all();
	}
}
