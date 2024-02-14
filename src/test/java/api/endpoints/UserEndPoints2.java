package api.endpoints;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.*;
import api.payloads.*;
/*
 * UserEndPoints.java
 * created to perform create , retrieve, update and delete user records through the users module enpoints
 */

public class UserEndPoints2 {
	
	static ResourceBundle getURL(){
		ResourceBundle routes=ResourceBundle.getBundle("routes");// Load the properties file
		return routes;
	}
	
	
	public static Response createUser(User payload){
		
		String post_url = getURL().getString("post_url");
		
		RequestSpecification httpRequest = given();
		
		Response response =httpRequest
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(post_url);
		
		return response;
		
	}
	public static Response readUser(String username){
		String get_url = getURL().getString("get_url");
		RequestSpecification httpRequest = given();
		Response response =httpRequest
				.pathParam("username",username)
		.when()
			.get(get_url);
		
		return response;
		
	}
	
	  public static Response updateUser(String userName, User payload){
		  String update_url = getURL().getString("update_url");
	  RequestSpecification httpRequest = given(); 
	  Response response =httpRequest
	  .contentType(ContentType.JSON) .accept(ContentType.JSON)
	  .pathParam("username",userName) .body(payload) .when()
	  .put(update_url);
	  
	  return response;
	  
	  } 
	  
	  public static Response deleteUser(String userName)
	  { 
		  String delete_url = getURL().getString("delete_url");
	RequestSpecification httpRequest = given(); 
	Response response =httpRequest
	  .pathParam("username",userName) .when() .delete(Routes.delete_url);
	  
	  return response;
	  
	  }
	  	 

}
