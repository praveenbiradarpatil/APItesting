
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

 

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

 

public class Listallusers {
	String custermerKey="2Xtd4ILUtinfACHehAvCNcbjW";
	String consumerSecret="pIHDmJy9fgKlLVuAgG4AuP5rRkaOy6TtWqxLqjVeJ2MywdcGJp";
	String Token="839104214-h1Kaf8iJW2FAyXzNCZNicI1a4Xb8BMw7ZkFKGzmJ";
	String TokenSecret="PTvXawkmrK3EZWeLSSmqtD7hisogRC3nqG48FYzNcLfQy";
    
    
    @Test
    public void listusers() 
    {
        RestAssured.baseURI="https://api.twitter.com/1.1/search";
        Response res=given().auth().oauth( custermerKey, consumerSecret, Token, TokenSecret).
                param("q","Qualitest").
        when().get("/tweets.json").then().assertThat().statusCode(200).and().contentType(ContentType.JSON).extract().response();
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


