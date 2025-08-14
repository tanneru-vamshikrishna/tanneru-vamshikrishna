package com.api.base;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.api.filters.LoggingFilter;

public class BaseService { //wrapper for rest assured

	// base uri
	//creating the request
	//handling the response
	
	
	private final static String BASE_URI = "https://swift.techwithjatin.com";
	private RequestSpecification requestSpecification;
	
	
	static {
		RestAssured.filters(new LoggingFilter());
	}

	public BaseService() {
		requestSpecification = given().baseUri(BASE_URI);
	}
	
	protected void setAuthToken(String token) {
		requestSpecification.header("Authorization", "Bearer " + token);
		
	}
	
	
	protected Response postRequest (Object payload, String endpoint) {		
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}
	
	protected Response getRequest (String endpoint) {
		return requestSpecification.get(endpoint);
	}
	
	protected Response putRequest (Object payload, String endpoint) {		
		return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);
	}


}
