package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {
	
	@Test
	public void createAccountTest() {
		
		SignUpRequest signUpRequest = new SignUpRequest.Builder()
				.userName("vams")
				.email("vk.t@gmail.com")
				.firstName("Tanneru")
				.lastName("Vamshi Krishna")
				.password("Pass1234*")
				.mobileNumber("9652571660")
				.build();
		
		AuthService authService = new AuthService();
		Response response = authService.signUp(signUpRequest);
		
		System.out.println(response.asPrettyString());
		
		Assert.assertEquals(response.asPrettyString(),"User registered successfully!");
		
		Assert.assertEquals(response.statusCode(), 200);
		
	}

}
