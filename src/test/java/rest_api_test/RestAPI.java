package rest_api_test;

import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
public class RestAPI {

	@Test
	public void test_1() {
		
		Response res = 
		RestAssured.get("https://reqres.in/api/users?page=2");
	
		int StatusCode = res.getStatusCode();
		
		Assert.assertEquals(StatusCode, 200);
		
		get("https://reqres.in/api/users?page=2")
		.then()
		.body("data[0].id", equalTo(7));
		//     JSON path    //matcher
	}
	
	@Test
	public void test_2() {
		get("https://api.zippopotam.us/us/19030")
		.then()
		.body("places[0].'place name'", equalTo("Fairless Hills"));
		//	.body("places[0][\"place name\"]", equalTo("Fairless Hills"));
		//    JSON path
	}
	
	@Test
	public void test_3() {
		get("https://api.zippopotam.us/us/19030")
		.then()
		.body("places[0].'state abbreviation'", equalTo("PA"));
		//    JSON path
	}
	
	
	@Test
	public void test_4() {
		get("https://api.zippopotam.us/us/19030")
		.then()
		.body("places[0].state", equalTo("Pennsylvania"));
		//    JSON path
	}
	
	@Test
	public void test_5() {
		get("https://api.zippopotam.us/us/19030")
		.then()
		.body("places[0].'state abbreviation'", equalTo("PA"));
		//    JSON path
	}
	
	@Test
	public void test_6() {
		get("https://api.zippopotam.us/us/19030")
		.then()
		.body("'post code'", equalTo("19030"));
		//    JSON path
	}
	
	
	
}
