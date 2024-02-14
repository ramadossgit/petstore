package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import io.restassured.response.Response;

import api.utilities.DataProviders;

public class DDTests {
	
	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testPostUser(String userID, String userName, String fname, String lname, String useremail, String pwd, String ph)
	{
		
		User userPayload = new User();
		
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUserName(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		
		Response response=UserEndPoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
			
	}
	
	
	  @Test(priority=2,dataProvider="UserNames",
	  dataProviderClass=DataProviders.class ) public void
	  testDeleteUserByName(String userName) {
	  
	  Response response = UserEndPoints.deleteUser(userName);
	  System.out.println(response.getBody().asString());
	  Assert.assertEquals(response.getStatusCode(), 200);
	  
	  
	  //Assert.assertEquals(this.userpayload.getUserName(),response.body().jsonPath().); 
	  }
	 

}
