package crudProjects;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetAllProjectsTest {
	@Test
	public void listResource()
	{
		Response response = RestAssured.get("http://localhost:8084/projects");
		ValidatableResponse valresponse = response.then();
		valresponse.assertThat().statusCode(200);
		valresponse.contentType("application/json");
		valresponse.log().all();
	}

}
