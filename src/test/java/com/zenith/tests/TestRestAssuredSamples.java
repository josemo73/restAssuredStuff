package com.zenith.tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestRestAssuredSamples {
	
	@Test
	public void test_NumberOfCircuitsFor2017Season_ShouldBe20() {
	        
	    given().
	    when().
	        get("http://ergast.com/api/f1/2017/circuits.json").
	    then().
	        assertThat().
	        body("MRData.CircuitTable.Circuits.circuitId",hasSize(20));
	}
	
	@Test
	public void requestUsZipCode90210_CheckPlaceNameInResponseBody_expectBeverlyHills() {
	    given().
	    when().
	        get("https://zippopotam.us/us/90210").
	    then().
	        assertThat().
	        body("places[0].'place name'", equalTo("Beverly Hills"));
	    	
	}
}
