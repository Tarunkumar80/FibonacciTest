package academy.dd.fibonacci.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class FibonacciTest  {

	
	private Response response;
	private ValidatableResponse jsonresponse;
	private RequestSpecification request;

	@Before
    public void startService() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 7003;
	}
	
	@Test
	public void FindTheStopPointOnReturningFibonacciNumbersSequence(){
		int statusCode = 200;
		request = given();
		response = request.when()
					.contentType(ContentType.JSON)
						.get("/fib");
		
		System.out.println("Response is : "+response.getStatusCode());
		Assert.assertEquals(200, response.getStatusCode());		
		jsonresponse = response.then().statusCode(statusCode).log().all();
		System.out.println("Validatable Json Response is : "+jsonresponse);
		
		
		String data = response.asString();
		System.out.println("DATA is :"+data);
		
		 String[] strArray = new String[]{data};
		 for (String FiboSeries : strArray) {
			System.out.println(" Application STOPs returning Fibonacci numbers in their correct sequence is at : "+ (FiboSeries.length()));
		}
		 
	}
}
