package crudProjects;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CompleteUpdateTest {
@Test
public void update()
{
	JSONObject jobj = new JSONObject();
	jobj.put("projectName", "Arjun");
	
	
	RequestSpecification ReqSpec = RestAssured.given();
	ReqSpec.contentType(ContentType.JSON);
	ReqSpec.body(jobj);
	
	Response response = ReqSpec.put("http://localhost:8084/projects/TY_PROJ_1403");
	ValidatableResponse valresp = response.then();
	valresp.assertThat().statusCode(200);
	valresp.assertThat().contentType(ContentType.JSON);
	valresp.log().all();
}
}
