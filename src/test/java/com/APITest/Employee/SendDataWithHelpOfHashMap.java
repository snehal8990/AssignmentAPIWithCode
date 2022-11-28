package com.APITest.Employee;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SendDataWithHelpOfHashMap {
	@Test(enabled = true)
	public void postRequestEmployee() {

		RestAssured.baseURI = "http://localhost:3000";

		// NOte we can add .log().all() after given or we can add it after end then it
		// will log entire body here you can write also **body(hm)**
		RestAssured.given().log().all().headers("Content-Type", "application/json").body(hashmapDetails()).when()
				.post("/Employee");

		Response reps2 = RestAssured.get("http://localhost:3000");
		System.out.println(reps2.asString());
		System.out.println(reps2.statusCode());
		System.out.println(reps2.statusLine());

		System.out.println("***********************************");
		Response resp = RestAssured.get("http://localhost:3000/Employee/");
		System.out.println("Response of get :" + resp.asPrettyString());

	}

	public static HashMap<String, String> hashmapDetails() {
		HashMap<String, String> hmEmployee = new HashMap<String, String>();
		// insert value in
		
		hmEmployee.put("name", "sdsd");
		hmEmployee.put("email", "Company_id_empli_demo@gmail.com");
		hmEmployee.put("salary", "198000");
		hmEmployee.put("married", "false");
		return hmEmployee;
	}
}
