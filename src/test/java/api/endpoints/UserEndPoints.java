package api.endpoints;
import static io.restassured.RestAssured.given;
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

public class UserEndPoints {
	
	public static Response createUser(User payload){
		
		RequestSpecification httpRequest = given();
		
		Response response =httpRequest
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.post_url);
		
		return response;
		
	}
	public static Response readUser(String username){
		RequestSpecification httpRequest = given();
		Response response =httpRequest
				.pathParam("username",username)
		.when()
			.get(Routes.get_url);
		
		return response;
		
	}
	
	  public static Response updateUser(String userName, User payload){
	  RequestSpecification httpRequest = given(); 
	  Response response =httpRequest
	  .contentType(ContentType.JSON) .accept(ContentType.JSON)
	  .pathParam("username",userName) .body(payload) .when()
	  .put(Routes.update_url);
	  
	  return response;
	  
	  } 
	  
	  public static Response deleteUser(String userName)
	  { 
	RequestSpecification httpRequest = given(); 
	Response response =httpRequest
	  .pathParam("username",userName) .when() .delete(Routes.delete_url);
	  
	  return response;
	  
	  }
	  	 

}
