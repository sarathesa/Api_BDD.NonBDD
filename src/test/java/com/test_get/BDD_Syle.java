package com.test_get;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class BDD_Syle {
	//@Test
	private void getMethod() {
		RestAssured.given()
			.baseUri("https://petstore.swagger.io/")
		.when()
			.get("v2/store/inventory")//.getStatusLine();
			
			.asPrettyString();		
	}
	@Test
	public void postMethod() {
		File jsonFile=new File("C:\\Users\\sarath esa\\eclipse-workspace\\API_PRACTICE\\src\\test\\resources\\Testjson.json");
		RestAssured.given()
		.baseUri("https://petstore.swagger.io/v2/store/order")
		.header("content-type","application/json")
		.body(jsonFile)
		
		.when()
		.post()
		.prettyPrint();
	}
	

}
