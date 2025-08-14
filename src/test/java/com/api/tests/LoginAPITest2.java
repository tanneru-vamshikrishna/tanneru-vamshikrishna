package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;


public class LoginAPITest2 {
	
	@Test (description = "Verify if Login API is working...")
	public void loginTest () {
		
		Response response = given().baseUri("https://swift.techwithjatin.com")
				.header("Content-Type", "application/json")
				.body("{\"username\": \"vamsikrishna.tanneru@gmail.com\",\"password\": \"Pass1234*\"}")
				.post("/api/auth/login");
		
		System.out.println(response.asPrettyString());
				
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}

}
