import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Tweeterserach {

	
	String custermerKey="2Xtd4ILUtinfACHehAvCNcbjW";
	String cunsumerSecret="pIHDmJy9fgKlLVuAgG4AuP5rRkaOy6TtWqxLqjVeJ2MywdcGJp";
	String Token="839104214-h1Kaf8iJW2FAyXzNCZNicI1a4Xb8BMw7ZkFKGzmJ";
	String TokenSecret="PTvXawkmrK3EZWeLSSmqtD7hisogRC3nqG48FYzNcLfQy";
	

	
	@Test
	public void searchtweet()
	{
		RestAssured.baseURI="https://api.twitter.com/1.1";
		Response res=given().auth().oauth(custermerKey, cunsumerSecret, Token, TokenSecret).
		queryParam("q","#Qualitest").
		when().get("search/tweets.json").then().extract().response();
		
		
		String responce=res.asString();//to convert into string
		System.out.println(responce);
		
		
	
		
	
}
}