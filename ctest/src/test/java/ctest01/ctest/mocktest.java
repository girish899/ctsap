package ctest01.ctest;

import java.net.URI;
import java.net.URISyntaxException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadExecutionException;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

import io.restassured.RestAssured;

public class mocktest {
	
	private static final int port=8091;
	private static final String host="localhost";
	
	
	private static WireMockServer server=new WireMockServer(port);
	
	static ResponseDefinitionBuilder mockresponse=new ResponseDefinitionBuilder();
	
	
	@BeforeTest
	public void beforeset()
	{
		String apiop=System.getProperty("apiop");
		
		switch(apiop)
		{
		case "createemployee":
			mockresponse.withStatus(200);
			mockresponse.withBody("employee added successfully");
			WireMock.configureFor(host,port);
			WireMock.stubFor ( 
					WireMock.get("/rabo/createemp")
					.willReturn(mockresponse)
					);
			
		case "createlistemployee":
			mockresponse.withStatus(200);
			mockresponse.withBody("employee list added successfully");
			WireMock.configureFor(host,port);
			WireMock.stubFor ( 
					WireMock.get("/rabo/createemplist")
					.willReturn(mockresponse)
					);
			
		case "createarrayemployee":
			mockresponse.withStatus(200);
			mockresponse.withBody("employee array added successfully");
			WireMock.configureFor(host,port);
			WireMock.stubFor ( 
					WireMock.get("/rabo/createemparr")
					.willReturn(mockresponse)
					);
			
		case "login":
			mockresponse.withStatus(200);
			mockresponse.withBody("login successfully");
			WireMock.configureFor(host,port);
			WireMock.stubFor ( 
					WireMock.get("/rabo/login")
					.willReturn(mockresponse)
					);
		
		case "logout":
			mockresponse.withStatus(200);
			mockresponse.withBody("logout successfully");
			WireMock.configureFor(host,port);
			WireMock.stubFor ( 
					WireMock.get("/rabo/logout")
					.willReturn(mockresponse)
					);
			
		case "getemployee":
			mockresponse.withStatus(200);
			mockresponse.withBody("employee details retrieved ");
			WireMock.configureFor(host,port);
			WireMock.stubFor ( 
					WireMock.get("/rabo/getemp")
					.willReturn(mockresponse)
					);
			
			
		
		}

	server.start();
	

}
	
	@Test
	public void test() throws URISyntaxException
	{
		RestAssured.given()
		.when()
		.get(new URI("http://localhost:8089/bag/web/all"))
		.then()
		.assertThat()
		.statusCode(200);
	}
	
	
}
