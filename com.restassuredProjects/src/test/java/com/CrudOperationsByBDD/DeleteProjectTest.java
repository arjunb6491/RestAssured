package com.CrudOperationsByBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DeleteProjectTest {
	@Test
	public void delete()
	{
		when()
			.delete("http://localhost:8084/projects/TY_PROJ_1602")
		.then()
			.assertThat().statusCode(204).contentType(ContentType.JSON).log().all();
	}

}
