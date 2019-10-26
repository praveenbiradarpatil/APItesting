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
public class Twittertrends {
	
	 int[] k = {1,2295383,28218,23424977,23424852};

	 Properties prop= new Properties();
	
	 
		@BeforeTest
		public void start() throws IOException 
		{
			FileInputStream fls= new FileInputStream("C:\\Users\\Online Test\\git\\APItesting\\Apitesting\\src\\data.properties");
	        prop.load(fls);
		}
		
	 @Test
	public void updatetweets() 
	
	{  
        String consumerKey = prop.getProperty("custermerKey");
        String consumerSecret = prop.getProperty("cunsumerSecret");
        String token = prop.getProperty("Token");
        String tokenSecret = prop.getProperty("TokenSecret");
		
		
		
		for(int i=0;i<k.length;i++)
		{
		RestAssured.baseURI=prop.getProperty("trendsuri");
		Response res=given().auth().oauth(consumerKey, consumerSecret, token, tokenSecret).
		queryParam("id",k[i]).
		when().get(resource.getResource2()).then().extract().response();
		
		
		String responce=res.asString();//to convert into string
		System.out.println(responce);
		
		JsonPath js=new JsonPath(responce);
		String id=js.get("name").toString();
		System.out.println(id);
	}
}
}
