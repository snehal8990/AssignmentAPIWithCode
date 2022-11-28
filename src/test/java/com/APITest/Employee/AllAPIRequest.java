package com.APITest.Employee;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AllAPIRequest {

	// Get Request to API 
	@Test(enabled = false)
	public void getRequestEmployee() {
		Response resp = RestAssured.get("http://localhost:3000/Employee");
		System.out.println("Response of get :"+resp.asPrettyString());
	}
	
	// To Get particular employee 
	
	@Test(enabled = false)
	public void getRequestEmployeeParticular() {
		Response resp = RestAssured.get("http://localhost:3000/Employee/1");
		System.out.println("Response of get :"+resp.asPrettyString());
	}
	
	// insert particular employee
	@Test(enabled = false)
	public void postRequestEmployeeParticular() {
		RestAssured.baseURI = "http://localhost:3000/";
		String bodyVariable = "{\r\n"
				+ "        \"name\": \"Weeeto\",\r\n"
				+ "        \"email\": \"bob32@gmail.com\",\r\n"
				+ "        \"salary\": 23000,\r\n"
				+ "        \"married\": false\r\n"
				+ "       \r\n"
				+ "    }";
		RestAssured.given().headers("Content-Type","application/json").body(bodyVariable).when().post("/Employee").then().statusCode(201);
			
		Response resp1= RestAssured.get("http://localhost:3000/Employee/");
		System.out.println(resp1.asString());
	}
	
	// delete particular employee entry
	@Test(enabled = false)
	public void deleteRequestEmployeeParticular() {
        // First fetch the response in the response container
        Response resp = RestAssured.given().header("Content-Type", "application/json").when()
                .delete("http://localhost:3000/Employee/5");
                
        // Extract the response code and response message and print it    
        System.out.println(resp.statusCode());
        System.out.println(resp.statusLine());
     
	}
	
	//update particular employee details
	@Test(enabled=false)
	public void putRequestEmployeeParticular() {
		String updateValue="{\r\n"
				+ "        \"name\": \"Moanoo\",\r\n"
				+ "        \"email\": \"Ram123@gmail.com\",\r\n"
				+ "        \"salary\": 96000,\r\n"
				+ "        \"married\": true\r\n"
				+ "    }";
		//"Content-Type","application/json"
		Response resp = RestAssured.given().headers("Content-Type","application/json").body(updateValue).when().put("http://localhost:3000/Employee/3");
		System.out.println("Status Code :"+resp.statusCode());
		System.out.println("Status Line"+resp.statusLine());
		System.out.println("*********************************************************************************");
		Response resp1= RestAssured.get("http://localhost:3000/Employee/3");
		System.out.println(resp1.asString());
	}
	
	//update particular employee's salary and married status
	@Test(enabled = false)
	public void patchRequestEmployeeParticular() {
		String body =  "{\r\n"
				+ "        \"salary\": 198000,\r\n"
				+ "        \"married\": false\r\n"
				+ "}";
		Response resp = RestAssured.given().headers("Content-Type","application/json").body(body).when()
				.patch("http://localhost:3000/Employee/3");
	       // Extract the response code and response message and print it
        System.out.println("********************************************************************");
        System.out.println("The status Code is :"+resp.statusCode());
        System.out.println("The status response line s :"+resp.statusLine());
        System.out.println("********************************************************************");
        Response resp2 = RestAssured.get("http://localhost:3000/Employee/3");
        System.out.println(resp2.asString());
	}
	
	// USED Data Provider to update email id of employee
	
	@DataProvider(name= "testData")
	public Object[][] getData() {		
		return new Object[][] {{"1"},{"2"},{"3"},{"4"}};
	}
	
	@Test(enabled = false,dataProvider = "testData")
	public void patchWithDatProvider(String id) {
		String body= "{\r\n"
				+ "        \"email\": \"CompanyID_EMP_ID"+id+"@gmail.com\"\r\n"
				+ "}";
		Response resp= RestAssured.given().headers("Content-Type","application/json").body(body).when().patch("http://localhost:3000/Employee/"+id);
	    // Extract the response code and response message and print it
        System.out.println("********************************************************************");
        System.out.println("The status Code is :"+resp.statusCode());
        System.out.println("The status response line s :"+resp.statusLine());
        System.out.println("********************************************************************");
        Response resp2 = RestAssured.get("http://localhost:3000/Employee/"+id);
        System.out.println(resp2.asString());
		
	}
	
	//Assertion and Query Param together
	// Assertions 
    @Test(enabled = false)
    public void AssertionsPlusQueryParam() {
        Response resp = RestAssured.given()
                .queryParam("id", "3")
                .header("Content-Type", "application/json")
                .when()        
                .get("http://localhost:3000/Employee");
                
        // Extract the response code and response message and print it
        System.out.println("********************************************************************");
        System.out.println("The status Code is :"+resp.statusCode());
        System.out.println("The status response line s :"+resp.statusLine());
        int value = resp.statusCode();
		assertEquals(value, 200);
        assertNotNull(resp.statusCode());
        System.out.println("********************************************************************");
        Response resp2 = RestAssured.get("http://localhost:3000/Employee/3");
        System.out.println(resp2.asString());    
    }
    

	
	
}
