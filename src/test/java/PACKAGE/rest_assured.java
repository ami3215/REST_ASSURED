package PACKAGE;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;

public class rest_assured {
	@Test(enabled = false)
	public void getListUsers() {
		/*Response a = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(a.getBody());
		int act=a.getStatusCode();
		Assert.assertEquals(act, 200);
		System.out.println(a.getTime());
		System.out.println(a.asString());*/
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).log().all();
	}
	
	@Test(enabled = false)
	public void tc1() {
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[0]",equalTo(7)); 
		System.out.println(given().get("https://reqres.in/api/users?page=2").then().statusCode(200).log().all());
	}
	
	@Test(enabled = false)
	public void getSingleUser(){
		given().get("https://reqres.in/api/users/10").then().statusCode(200).log().all();
	}
	
	@Test(enabled = false)
	public void singleUserNotFound() {
		given().get("https://reqres.in/api/users/23").then().statusCode(404).log().all();
	}
	
	@Test(enabled = false)
	public void list_resource(){
		given().get("https://reqres.in/api/unknown").then().statusCode(200).log().all();
	}
	
	@Test(enabled = false)
	public void single_resource() {
		given().get("https://reqres.in/api/unknown/10").then().statusCode(200).log().all();
	}
	
	@Test(enabled = false)
	public void single_resource_not_found() {
		given().get("https://reqres.in/api/unknown/22").then().statusCode(404).log().all();
	}
	
	@Test(enabled = false)
	public void create() {
	  JSONObject js=new JSONObject();
	  js.put("name","Amisha Jha");
	  js.put("job","tester");
	  System.out.println(js.toJSONString());
	  given().body(js.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201).log().all();
	}
	
	@Test(enabled = false)
	public void update() {
		  JSONObject js=new JSONObject();
		  js.put("name","Amisha");
		  js.put("job","developer");
		  System.out.println(js.toJSONString());
		  given().body(js.toJSONString()).when().put("https://reqres.in/api/users/10").then().statusCode(200).log().all();
	}
	
	@Test(enabled = false)
	public void update_1() {
		  JSONObject js=new JSONObject();
		  js.put("name","Ami");
		  js.put("job","developer");
		  System.out.println(js.toJSONString());
		  given().body(js.toJSONString()).when().patch("https://reqres.in/api/users/10").then().statusCode(200).log().all();
	}
	
	@Test(enabled = false)
	public void delete() {
		given().delete("https://reqres.in/api/users/10").then().statusCode(204).log().all();
	}
	
	@Test(enabled = true)
	public void register_successful() {
	  JSONObject js=new JSONObject();
	  js.put("email","eve.holt@reqres.in");
	  js.put("password","pistol");
	  System.out.println(js.toJSONString());
	  given().body(js.toJSONString()).when().post("https://reqres.in/api/register").then().statusCode(200).log().all();
	}
	
	
	

}
