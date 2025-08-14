package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class LoginAPITest3 {
	
	@Test (description = "Verify if Login API is working...")
	public void loginTest () {
		
		LoginRequest loginRequest = new LoginRequest("vamsikrishna.tanneru@gmail.com", "Pass1234*");
		
		AuthService authService = new AuthService();
		
		Response response = authService.login(loginRequest);
		
		System.out.println(response.asPrettyString());
		
		Assert.assertEquals(response.getStatusCode(), 200);

		
		LoginResponse loginResponse =response.as(LoginResponse.class);
		
		System.out.println(loginResponse.getToken());
		
		System.out.println(loginResponse.getRoles());
		
		
		Assert.assertTrue(loginResponse.getToken() != null);
		Assert.assertEquals(loginResponse.getEmail(), "vamsikrishna.tanneru@gmail.com");
		Assert.assertEquals(loginResponse.getId(), 2350);
		
			
	}

}
