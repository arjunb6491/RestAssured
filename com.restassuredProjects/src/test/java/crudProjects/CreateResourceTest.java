package crudProjects;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateResourceTest {
@Test
public void create()
{
	JSONObject jobj = new JSONObject();
	jobj.put("createdBy", "Tysssdet");
	jobj.put("projectName", "dfdgvgggfg");
	jobj.put("status", "created");
	jobj.put("teamSize", 15);
	
	RequestSpecification ReqSpec = RestAssured.given();
	ReqSpec.contentType(ContentType.JSON);
	ReqSpec.body(jobj);
	
	Response response = ReqSpec.post("http://localhost:8084/addProject");
	ValidatableResponse valresp = response.then();
	valresp.assertThat().statusCode(201);
	valresp.assertThat().contentType(ContentType.JSON);
	valresp.log().all();
}
}
