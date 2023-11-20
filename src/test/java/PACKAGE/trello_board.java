package PACKAGE;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;

public class trello_board {
	String id;
@Test(enabled = true,priority = 0)
public void createBoard() {
	RestAssured.baseURI="https://trello.com/";
	Response rep = given().queryParam("name","jas")
	.queryParam("key","6483466b62b9c8afe4dfb6d048a08de9")
	.queryParam("token","ATTA08aa7441e6a12284322171158d5c57072c1c4b092d43f3600f3762f8037fca57E23C588F")
	.header("Content-Type","json/application")
	.when().post("/1/boards/").then().statusCode(200).contentType(ContentType.JSON).extract().response();
	JsonPath path=new JsonPath(rep.asString());
	System.out.println(path);
	id = path.get("id");
	System.out.println(id);
	
}

@Test(enabled = true,priority = 1)
public void deleteBoard() {
	RestAssured.baseURI="https://trello.com/";
	given().queryParam("name","jas")
	.queryParam("key","6483466b62b9c8afe4dfb6d048a08de9")
	.queryParam("token","ATTA08aa7441e6a12284322171158d5c57072c1c4b092d43f3600f3762f8037fca57E23C588F")
	.header("Content-Type","json/application")
	.when().delete("/1/boards/"+id).then().statusCode(200).contentType(ContentType.JSON).log().all();
	
}
}
