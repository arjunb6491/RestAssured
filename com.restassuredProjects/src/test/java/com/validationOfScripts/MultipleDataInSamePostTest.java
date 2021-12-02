package com.validationOfScripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ProjectUtils.PojoLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class MultipleDataInSamePostTest {
	@Test(dataProvider="provideData")
	public void multiple(String createdBy,String projectName,String status,int teamSize)
	{
		PojoLibrary pojo=new PojoLibrary(createdBy,projectName,status,teamSize);
		given()
			.contentType(ContentType.JSON)
			.body(pojo)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201).log().all();
	}
	@DataProvider
	public Object[][] provideData()
	{
		Object[][] obj=new Object[2][4];
		
		obj[0][0]="abc";
		obj[0][1]="Project1";
		obj[0][2]="created";
		obj[0][3]=4;
		
		obj[1][0]="abc1";
		obj[1][1]="Project2";
		obj[1][2]="completed";
		obj[1][3]=8;
		
		
		return obj;
		
	}

}
