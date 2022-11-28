package com.APITest.Employee;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SendDataWithHelpOfExcel {

    //Insert user using excel
    @Test(enabled = true)
	public void postRequestEmployeeUSingExcel() throws Exception {
    	String name= ExcelFileRead.readExcel(1, 1);
    	String email = ExcelFileRead.readExcel(2, 1);
		RestAssured.baseURI = "http://localhost:3000/";
		String bodyVariable = "{\r\n"
				+ "        \"name\": \""+name+"\",\r\n"
				+ "        \"email\": \""+email+"\",\r\n"
				+ "        \"salary\": 23000,\r\n"
				+ "        \"married\": false\r\n"
				+ "       \r\n"
				+ "    }";
		RestAssured.given().headers("Content-Type","application/json").body(bodyVariable).when().post("/Employee").then().statusCode(201);
			
		Response resp1= RestAssured.get("http://localhost:3000/Employee/");
		System.out.println(resp1.asString());
	}
}
