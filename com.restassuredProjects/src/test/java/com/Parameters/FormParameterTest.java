package com.Parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class FormParameterTest {
	@Test
	public void form()
	{
		given()
			.contentType(ContentType.JSON)
			.formParam("createdBy", "Who Knows")
			.formParam("projectName", "goods")
			.formParam("status", "completed")
			.formParam("teamSize", 100)
		.when()
			.post("http://localhost:8084/addProject")
			.then().log().all();
	}

}
