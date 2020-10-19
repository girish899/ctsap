package ctest01.ctest;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;


import java.util.Map;

public class ClientHelper {


	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getBaseUri() {
		return baseUri;
	}

	public void setBaseUri(String baseUri) {
		this.baseUri = baseUri;
	}

	public Headers getHeader() {
		return header;
	}

	public void setHeader(Headers header) {
		this.header = header;
	}

	public String getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSchemaPath() {
		return schemaPath;
	}

	public void setSchemaPath(String schemaPath) {
		this.schemaPath = schemaPath;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public int getExpStatusCode() {
		return expStatusCode;
	}

	public void setExpStatusCode(int expStatusCode) {
		this.expStatusCode = expStatusCode;
	}

	public int getBagId() {
		return bagId;
	}

	public void setBagId(int bagId) {
		this.bagId = bagId;
	}

	public Map<String, String> getQueryParams() {
		return queryParams;
	}

	public void setQueryParams(Map<String, String> queryParams) {
		this.queryParams = queryParams;
	}

	private String serviceName;
	private String baseUri;
	private Headers header;
	private String requestBody;
	private String path;
	private String schemaPath;
	private Response response;
	private int expStatusCode;
	private int bagId;
	private Map<String, String> queryParams;
	ClientHelper clientHelper=new ClientHelper();
	
	 public ClientHelper getServiceDetails(){

	        Header header = new Header("content-type","application/json; charset=utf-8");
	        Headers headers = new Headers(header);
	        
	    
			clientHelper.setHeader(headers);

	    
	        clientHelper.setBaseUri("http://localhost:8080");
	        return clientHelper;
	    }

	

}



