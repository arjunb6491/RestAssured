package crudProjects;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteResponseTest {
@Test
public void delete()
{
	Response response = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1403");
	ValidatableResponse ValResponse = response.then();
	ValResponse.statusCode(204);
	ValResponse.contentType(ContentType.JSON);
	ValResponse.log().all();
}
}
