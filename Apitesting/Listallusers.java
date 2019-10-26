package Api;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

 

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

 

public class Listallusers {
	Properties prop= new Properties();
	
	@BeforeTest
	public void start() throws IOException 
	{
		FileInputStream fls= new FileInputStream("C:\\Users\\Online Test\\git\\APItesting\\Apitesting\\src\\data.properties");
        prop.load(fls);
	}
	
	@Test
    public void listusers() 
    { 
	        String consumerKey = prop.getProperty("custermerKey");
	        String consumerSecret = prop.getProperty("cunsumerSecret");
	        String token = prop.getProperty("Token");
	        String tokenSecret = prop.getProperty("TokenSecret");
    	
        RestAssured.baseURI=prop.getProperty("listbaseuri");
        Response res=given().auth().oauth( consumerKey, consumerSecret, token, tokenSecret).
                param("q","Qualitest").
        when().get(resource.retweetResource()).then().assertThat().statusCode(200).and().contentType(ContentType.JSON).extract().response();
        String response=res.asString();
        System.out.println(response);
        JsonPath js=new JsonPath(response);
        int count=js.get("statuses.size()");
        System.out.println(count);
        for(int i=0;i<count;i++)
        {
            String user=js.get("statuses["+i+"].user.screen_name");
            System.out.println("User name - "+user);
        }
    }
}


