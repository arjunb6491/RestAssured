package com.Chaining;

import static org.testng.annotations.Test.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ChainingTest {
	@Test
	public void request()
	{
		Response response = when().get("http://localhost:8084/projects");
		String proID=response.jsonPath().get("[1].projectId");
		given().pathParam("projectId", proID)
		.when()
		.delete("http://localhost:8084/projects/{projectId}")
		.then().log().all();
	}

}
