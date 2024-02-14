package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import io.restassured.response.Response;

public class UserTest {
	Faker faker;
	User userpayload;
	
	public Logger logger;
	
	@BeforeClass
	public void setup() 
	{
		faker = new Faker();
		userpayload = new User();
		
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUserName(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password());
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs 
		
		logger=LogManager.getLogger(this.getClass());
		
		
		
	}
	
	@Test(priority=1)
	public void testPostUser()
	{
		logger.info("---------------Creating User----------------");
		Response response = UserEndPoints.createUser(userpayload);
		response.then().log().all();
		logger.info("---------------User Created----------------");
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("---------------Status code valdiated----------------");
			
	}
	
	@Test(priority=2)
	public void testGetUser()
	{
		logger.info("---------------Reading User Info----------------");
		Response response = UserEndPoints.readUser(this.userpayload.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		//Assert.assertEquals(this.userpayload.getUserName(),response.body().jsonPath().);
		logger.info("---------------Reading User Info Completed----------------");
	}
	
	
	@Test(priority=3)
	public void testUpdateUser() 
	{
		logger.info("---------------Update User----------------");
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		
		
		Response response = UserEndPoints.updateUser(this.userpayload.getUsername(), userpayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("---------------Update UserCompleted----------------");
		
		//check the data
		logger.info("---------------Read the Updated User---------------");
		
		Response responseAfterUpdate = UserEndPoints.readUser(this.userpayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("---------------Read Updated User Completed----------------");
		
	}
	
	
	  @Test(priority=4) public void testDeleteUser() 
	  { 
		  logger.info("---------------Deleted User ----------------");
	  Response response =
	  UserEndPoints.deleteUser(this.userpayload.getUsername());
	  response.then().log().all();
	  
	  Assert.assertEquals(response.getStatusCode(), 200); 
	  
	  logger.info("---------------Delete User Completed----------------");
	  }
	  
	  
	  
	 

}
