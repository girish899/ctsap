package ctest01.ctest;

import java.net.URI;
import java.net.URISyntaxException;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class basehelper {
	
	 protected ClientHelper clientHelper = new ClientHelper();
	private Response actualResponse;
	
	
	
	
/*	public void get(String uri) throws URISyntaxException
	{
		RestAssured.given()
		.when()
		.get(new URI(uri))
		.then()
		.assertThat()
		.statusCode(200);
	}
	
	
	public void post(String uri) throws URISyntaxException
	{
		RestAssured.given()
		.when()
		.post(new URI(uri))
		.then()
		.assertThat()
		.statusCode(200);
	}
	
	
	public void put(String uri) throws URISyntaxException
	{
		RestAssured.given()
		.when()
		.put(new URI(uri))
		.then()
		.assertThat()
		.statusCode(200);
	}
	
	
	public void delete(String uri) throws URISyntaxException
	{
		RestAssured.given()
		.when()
		.delete(new URI(uri))
		.then()
		.assertThat()
		.statusCode(200);
	}*/


	public ClientHelper post(ClientHelper clientHelper)  {

		//test.log(LogStatus.PASS, "Desc");
		RestAssured.baseURI = clientHelper.getBaseUri();
		RestAssured.useRelaxedHTTPSValidation();
		actualResponse = RestAssured
				.given().headers(clientHelper.getHeader())
				.and().body(clientHelper.getRequestBody())
				.and().log().all()
				.when().post(clientHelper.getPath())
				.then().log().all()
				//.body(matchesJsonSchemaInClasspath(""))
				.and().extract().response();
		clientHelper.setResponse(actualResponse);

		return clientHelper;
	}

	
	
	public ClientHelper getAndVerifySchema(ClientHelper clientHelper) {

		RestAssured.baseURI = clientHelper.getBaseUri();
		RestAssured.useRelaxedHTTPSValidation();
		actualResponse = RestAssured
				.given().headers(clientHelper.getHeader())
				.and().log().all()
				//.queryParam(clientHelper.getQueryParams())
				.when().get(clientHelper.getPath())
				.then().log().all()
				//.body(matchesJsonSchemaInClasspath("getBagSchema.json"))
				.and().extract().response();
		clientHelper.setResponse(actualResponse);

		return clientHelper;
	}
	public ClientHelper get(ClientHelper clientHelper) {

		RestAssured.baseURI = clientHelper.getBaseUri();
		RestAssured.useRelaxedHTTPSValidation();
		Response actualResponse = RestAssured
				.given().headers(clientHelper.getHeader())
				.and().log().all()
				//.queryParam(clientHelper.getQueryParams())
				.when().get(clientHelper.getPath())
				.then().log().all()
				//.body(matchesJsonSchemaInClasspath("getBagSchema.json"))
				.and().extract().response();
		clientHelper.setResponse(actualResponse);

		return clientHelper;
	}

	public ClientHelper put(ClientHelper clientHelper) {
		clientHelper.getHeader();
		//log.info("PUT Service Call for :: " + clientHelper.getServiceName());
		RestAssured.baseURI = clientHelper.getBaseUri();
		RestAssured.useRelaxedHTTPSValidation();
		Response actualResponse = RestAssured
				.given().headers(clientHelper.getHeader())
				.and().body(clientHelper.getRequestBody())
				.and().log().all()
				.when().put(clientHelper.getPath())
				.then().log().all()
				//.and().assertThat().statusCode(statusCode)
				.and().extract().response();
		clientHelper.setResponse(actualResponse);
	
		return clientHelper;
	}

	public ClientHelper delete(ClientHelper clientHelper) {
		clientHelper.getHeader();
		RestAssured.baseURI = clientHelper.getBaseUri();
		RestAssured.useRelaxedHTTPSValidation();
		Response actualResponse = RestAssured
				.given().headers(clientHelper.getHeader())
				//.and().body(clientHelper.getRequestBody())
				//.and().log().all()
				.when().delete(clientHelper.getPath())
				.then().log().all()
				//.and().assertThat().statusCode(statusCode)
				.and().extract().response();
		clientHelper.setResponse(actualResponse);
		
		//verifyResponsevalue(clientHelper);
		return clientHelper;
	}
	public ClientHelper patch(ClientHelper clientHelper) {
		clientHelper.getHeader();
		//log.info("PATCH Service Call for :: " + clientHelper.getServiceName());
		RestAssured.baseURI = clientHelper.getBaseUri();
		RestAssured.useRelaxedHTTPSValidation();
		Response actualResponse = RestAssured
				.given().headers(clientHelper.getHeader())
				.and().body(clientHelper.getRequestBody())
				//.and().log().all()
				.when().patch(clientHelper.getPath())
				.then().log().all()
				//.and().assertThat().statusCode(statusCode)
				.and().extract().response();
		clientHelper.setResponse(actualResponse);
	
		return clientHelper;
	}

}
