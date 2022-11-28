package com.APITest.Employee;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SendDataWithHelpOfJSON {
	@Test(enabled = true)
	public void postRequestEmployee() {



		RestAssured.baseURI = "http://localhost:3000";

		// NOte we can add .log().all() after given or we can add it after end then it
		// will log entire body here you can write also **body(hm)**
		RestAssured.given().log().all().headers("Content-Type", "application/json").body(new File("./dataEmployee.json")).when()
				.post("/Employee");

		Response reps2 = RestAssured.get("http://localhost:3000");
		System.out.println(reps2.asString());
		System.out.println(reps2.statusCode());
		System.out.println(reps2.statusLine());

		System.out.println("***********************************");
		Response resp = RestAssured.get("http://localhost:3000/Employee/");
		System.out.println("Response of get :" + resp.asPrettyString());

	}

}
