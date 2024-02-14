package api.endpoints;

/*
 * swagger URI --> https://petstore-swagger.io
 * 
 * create users(Post) : https://petstore.swagger.io/v2/user
 * Get user(Get): https://petstore.swagger.io/v2/user/{username}
 * Update user (Put): https://petstore.swagger.io/v2/user/{username}
 * Delete user (Delete) : https://petstore.swagger.io/v2/user/{username}
 */

public class Routes {
	
	public static final String base_url = "https://petstore.swagger.io";
	
	
	//User model endpoints
	
	public static String post_url = base_url+"/v2/user";
	public static String get_url = base_url+"/v2/user/{username}";
	public static String update_url = base_url+"/v2/user/{username}";
	public static String delete_url = base_url+"/v2/user/{username}";
	
	//Store module endpoints
	
	
	//Pet module endpoints
}
