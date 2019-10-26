package Api;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Tweeterserach {
	Properties prop= new Properties();

	@BeforeTest
	public void start() throws IOException 
	{
		FileInputStream fls= new FileInputStream("C:\\Users\\Online Test\\git\\APItesting\\Apitesting\\src\\data.properties");
        prop.load(fls);
	}
	
	
	@Test
	public void searchtweet() 
	{  
	        String consumerKey = prop.getProperty("custermerKey");
	        String consumerSecret = prop.getProperty("cunsumerSecret");
	        String token = prop.getProperty("Token");
	        String tokenSecret = prop.getProperty("TokenSecret");
		
		
		RestAssured.baseURI=prop.getProperty("twittersearch");
		Response res=given().auth().oauth(consumerKey, consumerSecret, token, tokenSecret).
		queryParam("q","#Qualitest").
		when().get(resource.retweetResource()).then().extract().response();
		
		
		String responce=res.asString();//to convert into string
		System.out.println(responce);
		
		
	
		
	
}
}