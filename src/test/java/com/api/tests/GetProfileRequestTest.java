package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetProfileRequestTest {
	
	
	@Test
	public void getProfileInfoTest() {
		
		
		AuthService authservice = new AuthService();
		
		Response response = authservice.login(new LoginRequest("vamsikrishna.tanneru@gmail.com","Pass1234*"));
		
		LoginResponse loginResponse = response.as(LoginResponse.class);
		
		System.out.println(loginResponse.getToken());
		
		UserProfileManagementService userProfileManagementService= new UserProfileManagementService();
		
		response = userProfileManagementService.getProfile(loginResponse.getToken());
		
		System.out.println(response.asPrettyString());
		
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		
		System.out.println(userProfileResponse.getUsername());
		
		
		
	}

}
