package com.test_get;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class NewClassGet {

	
		@Test(enabled = false)
		private void getMethod() {
			RequestSpecification reqres = RestAssured.given();
			RequestSpecification baseUri = reqres.baseUri("https://petstore.swagger.io/");

		 	Response response = baseUri.get("v2/store/inventory");
			System.out.println(response.statusCode());
			System.out.println(response.asPrettyString());
			System.out.println(response.statusLine());

			JsonPath jsonPath = response.jsonPath();
			Object object = jsonPath.get("status");
			Assert.assertEquals(object, 9);
			System.out.println(object);
		}

}
