package Api;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Blockuser {
	Properties prop=new Properties();
	
	  @BeforeTest
	  public void begin() throws IOException {
	  FileInputStream f=new FileInputStream("C:\\Users\\Online Test\\git\\APItesting\\Apitesting\\src\\data.properties");
	  prop.load(f);
	  }
	 
	  @Test
	  public void start()
	  {
		     String consumerKey = prop.getProperty("custermerKey");
		        String consumerSecret = prop.getProperty("cunsumerSecret");
		        String token = prop.getProperty("Token");
		        String tokenSecret = prop.getProperty("TokenSecret");
		
		RestAssured.baseURI=prop.getProperty("blockuseruri");
		Response res= given().auth().oauth(consumerKey,consumerSecret,token,tokenSecret).
	    queryParam("screen_name","Praveen19553459").
	 
		when().post(resource.postResource2()).then().extract().response();     
	     String response = res.asString();
	     System.out.println(response);
	     JsonPath js=new JsonPath(response);
		
	     String id=js.getString("id");
		 System.out.println(id);
		 String text=js.getString("screen_name");
		System.out.println(text);
				
				
	  }			
}

