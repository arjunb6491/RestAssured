package com.Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GithubTest {
	@Test
	public void github()
	{
		given()
			.pathParam("username", "arjunb6491")
			.queryParam("sort", "created")
		.when()
			.get("https://api.github.com/users/{username}/repos")
		.then()
			.log().all();
	}

}
