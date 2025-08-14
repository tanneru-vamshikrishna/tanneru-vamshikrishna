package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {
	
	@Test
	public void updateProfileTest() {
		
						
		AuthService authservice = new AuthService();
		Response response = authservice.login(new LoginRequest("vamsikrishna.tanneru@gmail.com", "Pass1234*"));
		
		LoginResponse loginResponse = response.as(LoginResponse.class);
		
		System.out.println(loginResponse.getToken());
		
		System.out.println("_____________________________________________________________");
		
		
		UserProfileManagementService userProfileManagementService= new UserProfileManagementService();
		
		response = userProfileManagementService.getProfile(loginResponse.getToken());
		
		System.out.println(response.asPrettyString());
		
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		
		Assert.assertEquals(userProfileResponse.getFirstName(), "Tanneeru");
		
		System.out.println("_____________________________________________________________");
		
		
		ProfileRequest profileRequest = new ProfileRequest.Builder()
				.firstName("Tanneru")
				.lastName("Vamshi Krishna")
				.email("vamsikrishna.tanneru@gmail.com")
				.mobileNumber("9652571660")
				.build();
		
		response = userProfileManagementService.updateProfile(loginResponse.getToken(), profileRequest);
		
		System.out.println(response.asPrettyString());
		
	}

}
