package com.CrudOperationsByBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateProjectTest {
	@Test
	public void create()
	{
		Random random=new Random();
		int randomNumber=random.nextInt(1000);
		
		JSONObject Jobj=new JSONObject();
		Jobj.put("createdBy", "Tysssdet");
		Jobj.put("projectName", "RMGY"+randomNumber);
		Jobj.put("status", "created");
		Jobj.put("teamSize", 15);
		
		given()
			.contentType(ContentType.JSON)
			.body(Jobj)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
	}

}
