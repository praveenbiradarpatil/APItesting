package Api;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class Twitter {
	Properties prop= new Properties();
	
	@BeforeTest
	public void start() throws IOException 
	{
		FileInputStream fls= new FileInputStream("C:\\Users\\Online Test\\git\\APItesting\\Apitesting\\src\\data.properties");
        prop.load(fls);
	}
	
	
 @Test
 public void getTweet()  {
			  
		        String consumerKey = prop.getProperty("custermerKey");
		        String consumerSecret = prop.getProperty("cunsumerSecret");
		        String token = prop.getProperty("Token");
		        String tokenSecret = prop.getProperty("TokenSecret");
		        
		        
		RestAssured.baseURI= prop.getProperty("getbaseuri");
		Response res=given().auth().oauth(consumerKey, consumerSecret, token, tokenSecret).
		//queryParam("count","1").
		when().get(resource.getResource1()).then().extract().response();
		
		
		String responce=res.asString();//to convert into string
		System.out.println(responce);
		
		JsonPath js=new JsonPath(responce);
		String id=js.get("id").toString();
		System.out.println(id);
		
		String text=js.get("text").toString();
		System.out.println(text);
		
		
	}
	
	                  
	
}
