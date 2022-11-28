package com.APITest.Employee;

import java.io.File;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;


import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SendDataWithHelpOfPOJOCLASS {
	//serialisation
		@Test(enabled = false)
		public void postRequestEmployeeSerial() throws Exception {
			// Reading data
			POJOEmployeeClass objpojo = new POJOEmployeeClass();
			objpojo.setName("abc");
			objpojo.setEmail("Dr@gmail.com");
			objpojo.setSalary("12343535");
			objpojo.setMarried("true");
			//object Mapper
			ObjectMapper mapper = new ObjectMapper();
			String jsonBodyData= mapper.writeValueAsString(objpojo);

			RestAssured.baseURI = "http://localhost:3000";

			// NOte we can add .log().all() after given or we can add it after end then it
			// will log entire body here you can write also **body(hm)**
			RestAssured.given().log().all().headers("Content-Type", "application/json").body(jsonBodyData).when()
					.post("/Employee");

			Response reps2 = RestAssured.get("http://localhost:3000");
			System.out.println(reps2.asString());
			System.out.println(reps2.statusCode());
			System.out.println(reps2.statusLine());

			System.out.println("***********************************");
			Response resp = RestAssured.get("http://localhost:3000/Employee/");
			System.out.println("Response of get :" + resp.asPrettyString());

		}
		
		//deserialisation ==back to pojo object

		@Test(enabled = true)
		public void postRequestEmployee() throws Exception {
//			// Reading data
//			POJOEmployeeClass objpojo = new POJOEmployeeClass();
//			objpojo.setName("abc");
//			objpojo.setDesg("Dr");
//			
//			//object Mapper
//			ObjectMapper mapper = new ObjectMapper();
//			String jsonBodyData= mapper.writeValueAsString(objpojo);

			RestAssured.baseURI = "http://localhost:3000";

			// NOte we can add .log().all() after given or we can add it after end then it
			// will log entire body here you can write also **body(hm)**
//			RestAssured.given().log().all().headers("Content-Type", "application/json").body(jsonBodyData).when()
//					.post("/Employee");

			Response reps2 = RestAssured.get("http://localhost:3000");
			
			POJOEmployeeClass objpojo2= RestAssured.given().get("http://localhost:3000/Employee/7").as(POJOEmployeeClass.class);
			System.out.println("***********************************");
			POJOEmployeeClass.ToString(objpojo2);
			

			System.out.println("***********************************");
		

		}

}
