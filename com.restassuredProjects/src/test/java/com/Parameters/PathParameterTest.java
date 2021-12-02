package com.Parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PathParameterTest {
	@Test
	public void path()
	{
		String ProID="TY_PROJ_811";
	given()
		.pathParam("projectId", ProID)
	.when()
		.get("http://localhost:8084/projects/{projectId}")
	.then().statusCode(200).contentType(ContentType.JSON).log().all();
	}

}
