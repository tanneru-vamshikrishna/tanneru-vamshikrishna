package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class forgotPassword {
	
	@Test
	public void forgotpass() {
		
		AuthService authservice = new AuthService();
		
		Response response = authservice.forgotPassword("vk.tanneru@gmail.com");
		
		System.out.println(response.asPrettyString());
	}

}
