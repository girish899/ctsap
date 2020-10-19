package ctest01.ctest;

import static org.testng.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertTrue;


public class Apitest extends basehelper {
	
	@Test
	public void VerifyCreateEmployee() throws URISyntaxException
	{
	ClientHelper client = null;
	basehelper bb=new basehelper();
	ClientHelper cc=new ClientHelper();
	client = bb.post(cc.getServiceDetails());
	Assert.assertEquals(client.getExpStatusCode(),200);
	
	}
	
	
	@Test
	public void GetEmployee() throws URISyntaxException
	{
	ClientHelper client = null;
	basehelper bb=new basehelper();
	ClientHelper cc=new ClientHelper();
	client = bb.get(cc.getServiceDetails());
	Assert.assertEquals(client.getExpStatusCode(),200);
	
	}
	
	
	@Test
	public void VerifyLogin() throws URISyntaxException
	{
	ClientHelper client = null;
	basehelper bb=new basehelper();
	ClientHelper cc=new ClientHelper();
	client = bb.get(cc.getServiceDetails());
	Assert.assertEquals(client.getExpStatusCode(),200);
	
	}

}
