package com.APITest.Employee;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonPathEmployee {
	@Test(enabled = true)
	public void postRequestEmployee() {
		RestAssured.baseURI = "http://localhost:3000";
		String bodyVariable = " {\r\n"
				+ "        \"name\": \"Preeto\",\r\n"
				+ "        \"email\": \"bob32@gmail.com\",\r\n"
				+ "        \"salary\": 57000,\r\n"
				+ "        \"married\": true\r\n"
				+ "     \r\n"
				+ "    }";
		//NOte we can add .log().all() after given or we can add it after end then it will log entire body
		Response resp= RestAssured.given().headers("Content-Type","application/json").body(bodyVariable).when().post("/Employee");
		JsonPath jsp= new JsonPath(resp.asString());
		String actualDataREsponse= jsp.getString("name");
		System.out.println("ACTUAL NAME :"+actualDataREsponse);
		assertEquals(actualDataREsponse, "Preeto");
		
		String actualDataREsponseEmail= jsp.getString("email");
		System.out.println("ACTUAL EMAIL :"+actualDataREsponseEmail);
		assertEquals(actualDataREsponse, "bob32@gmail.com");
		
		Response reps2 = RestAssured.get("http://localhost:3000/Employee");
		System.out.println(reps2.asString());
		System.out.println(reps2.statusCode());
		System.out.println(reps2.statusLine());
		
		System.out.println("**************RESP2*****************************");
        Response resp2 = RestAssured.get("http://localhost:3000/Employee");
        System.out.println(resp2.asString());
        
        System.out.println("*********************************************************");
        //Reading the expected data from entire response
        //Get the number of courses
        JsonPath jsp2 = new JsonPath(resp2.asString());
        System.out.println("The Employee Count is :"+jsp2.getInt("Employee.size()"));
        System.out.println("all Employee name :"+jsp2.getString("name"));
        System.out.println("particular Employee name :"+jsp2.getString("name[2]"));
	
	}
}
