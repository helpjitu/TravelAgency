package com.travel;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import org.hamcrest.Matcher.*;

public class RestApiAutomationTest {
	
	@Test
	public void restAutomation()
	{
		given().
		when().
			get("http://demoqa.com/utilities/weather/city/Hyderabad").
		then().
		assertThat().statusCode(200).log().all();
	}

}
