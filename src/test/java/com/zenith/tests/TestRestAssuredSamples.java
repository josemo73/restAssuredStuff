package com.zenith.tests;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestRestAssuredSamples {
	@Test
	public void requestUsZipCode90210_logRequestAndResponseDetails() {
	    given().
	    	log().all().
	    when().
	        get("https://zippopotam.us/us/90210").
	    then().
	        log().body();
	}
	
	@Test
	public void requestUsZipCode90210_checkContentType_expectJSON() {
	    given().
	    when().
	        get("https://zippopotam.us/us/90210").
	    then().
	        assertThat().
	        contentType(ContentType.JSON);
	}
	
	@Test
	public void requestUsZipCode90210_checkStatusCode_expectHTTP200() {
	    given().
	    when().
	        get("https://zippopotam.us/us/90210").
	    then().
	        assertThat().
	        statusCode(200);

	}
	
	@Test
	public void requestUsZipCode90210_checkPlaceNameInResponseBody_expectBeverlyHills() {
	    given().
	    when().
	        get("https://zippopotam.us/us/90210").
	    then().
	        assertThat().
	        body("places[0].'place name'",  equalTo("Beverly Hills"));

	}
}
