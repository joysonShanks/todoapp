package com.joyson.todoapp;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TodoApiTest {

	@LocalServerPort
	int port;

	@Before
	public void setUp() {
		RestAssured.port = port;
		RestAssured.baseURI = "http://localhost";
	}

	@Test
	public void createTasks() {
		JSONObject taskObject = new JSONObject();
		try {
			taskObject.put("taskName", "Get new Phone !!");
			taskObject.put("priority", 3);
			taskObject.put("completed", false);
		} catch (JSONException jEx) {
			jEx.printStackTrace();
			
		}
		RestAssured.given().body(taskObject.toString()).contentType(ContentType.JSON).post("/todo-app/task").then()
				.assertThat().statusCode(201);
	}

	@Test
	public void getTodo() throws InterruptedException {
		RestAssured.given().get("/todo-app/todo").then().statusCode(200);
	}

}
