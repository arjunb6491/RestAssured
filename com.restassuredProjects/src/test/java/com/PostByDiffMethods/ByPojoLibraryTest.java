package com.PostByDiffMethods;

import org.testng.annotations.Test;

import ProjectUtils.PojoLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class ByPojoLibraryTest {
	@Test
	public void create()
	{
		PojoLibrary pojo=new PojoLibrary("RMGYantra","RMG","completed",20);
		
	given()
		.contentType(ContentType.JSON)
		.body(pojo)
	.when()
		.post("http://localhost:8084/addProject")
	.then()
		.assertThat().statusCode(201).log().all();
	}

}
