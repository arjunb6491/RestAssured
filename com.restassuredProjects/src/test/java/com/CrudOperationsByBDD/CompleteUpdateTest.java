package com.CrudOperationsByBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CompleteUpdateTest {
	@Test
	public void update()
	{
		Random random=new Random();
		int randomNumber=random.nextInt(1000);
		
		JSONObject Jobj=new JSONObject();
		Jobj.put("createdBy", "Tyss");
		
		given()
			.contentType(ContentType.JSON).body(Jobj)
		.when()
			.put("http://localhost:8084/projects/TY_PROJ_1602")
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
	}

}
