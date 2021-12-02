package com.PostByDiffMethods;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class ByJsonFileTest {
	@Test
	public void JsonFile()
	{
		File file=new File("./src/test/resources/Json.json");
		
		given()
			.contentType(ContentType.JSON)
			.body(file)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201).log().all();
	}

}
