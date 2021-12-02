package com.PostByDiffMethods;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Random;

public class ByHashmapTest {
	@Test
	public void create()
	{
		Random random=new Random();
		int randomNumber=random.nextInt(1000);
		
		HashMap map=new HashMap();
		map.put("createdBy", "Tysssdet");
		map.put("projectName", "RMGY"+randomNumber);
		map.put("status", "created");
		map.put("teamSize", 15);
		
		given()
			.contentType(ContentType.JSON)
			.body(map)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201).log().all();
	}

}
