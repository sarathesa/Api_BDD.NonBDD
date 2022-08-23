package com.test_get;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import javax.swing.text.AbstractDocument.Content;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Non_BDD_Style {

	// @Test
	public void method1() {
		RestAssured.given().baseUri("https://reqres.in/").header("content-Type", "application/json")
				.body("{\r\n" + "    \"email\": \"eve.holt@reqres.in\",\r\n" + "    \"password\": \"pistol\"\r\n" + "}")

				.when().post("/api/register").prettyPrint();

	}

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

	@Test(enabled = false)
	private void postMethod() {
		RequestSpecification reqres = RestAssured.given().baseUri("https://petstore.swagger.io/")
				.header("Content-type", "application/json")
				.body("{\r\n" + "  \"id\": 9999,\r\n" + "  \"category\": {\r\n" + "    \"id\": 0,\r\n"
						+ "    \"name\": \"string\"\r\n" + "  },\r\n" + "  \"name\": \"doggi\",\r\n"
						+ "  \"photoUrls\": [\r\n" + "    \"string\"\r\n" + "  ],\r\n" + "  \"tags\": [\r\n"
						+ "    {\r\n" + "      \"id\": 0,\r\n" + "      \"name\": \"string\"\r\n" + "    }\r\n"
						+ "  ],\r\n" + "  \"status\": \"available\"\r\n" + "}");
		Response post = reqres.post("v2/pet");
		System.out.println(post.getStatusLine());
		System.out.println(post.asPrettyString());
		Object object = post.jsonPath().get("status");
		System.out.println(object);
	}

	@Test(enabled=false)
	private void putMethod() {
		RequestSpecification reqres = RestAssured.given().baseUri("https://petstore.swagger.io/")
				.header("content-Type", "application/json")
				.body("{\r\n" + "  \"id\": 0,\r\n" + "  \"category\": {\r\n" + "    \"id\": 0,\r\n"
						+ "    \"name\": \"string\"\r\n" + "  },\r\n" + "  \"name\": \"doggi\",\r\n"
						+ "  \"photoUrls\": [\r\n" + "    \"string\"\r\n" + "  ],\r\n" + "  \"tags\": [\r\n"
						+ "    {\r\n" + "      \"id\": 0,\r\n" + "      \"name\": \"string\"\r\n" + "    }\r\n"
						+ "  ],\r\n" + "  \"status\": \"available\"\r\n" + "}");
		Response put = reqres.put("v2/pet");
		System.out.println(put.asPrettyString());
		System.out.println(put.statusCode());
		System.out.println(put.statusLine());
		System.out.println(put.jsonPath().get("id"));
	}

	@Test
	private void deleteMethod() {
		RequestSpecification req = RestAssured.given().baseUri("https://petstore.swagger.io/").header("contenet-Type",
				"application/json");
		Response delete = req.delete("v2/pet/9999");
		System.out.println(delete.getStatusLine());
		System.out.println(delete.asPrettyString());

	}

}
