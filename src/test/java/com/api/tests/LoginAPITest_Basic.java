package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class LoginAPITest_Basic {
	
	
	@Test (description = "Verify if Login API is working...")
	public void loginTest () {
		
		RestAssured.baseURI = "https://swift.techwithjatin.com";
		
		RequestSpecification x = RestAssured.given();
		RequestSpecification y = x.header("Content-Type", "application/json");
		RequestSpecification z = y.body("{\"username\": \"vamsikrishna.tanneru@gmail.com\",\"password\": \"Pass1234*\"}");

		Response response = z.post("/api/auth/login");
		
		System.out.println(response.asPrettyString());
				
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}

}
