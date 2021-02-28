package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class TestGetAndPostExamples { 
  
  @Test
  public void testGet() { 

    baseURI="https://reqres.in/api/";

    given().
      get("/users?page=2").
    then().
      statusCode(200).
      body("data[1].first_name", equalTo("Lindsay")).
      body("data.first_name", hasItems("Lindsay", "Tobias"));
    


  }

  @Test
  public void testPost() {
    /*
    Map<String, Object> map = new HashMap<>();
    map.put("name", "Ewald");
    map.put("job", "Senior Architect"); 

    System.out.println(map);
    */
    JSONObject requset = new JSONObject(); 
    requset.put("name", "Ewald");
    requset.put("job", "Senior");

    System.out.println(requset.toJSONString());

    baseURI="https://reqres.in/api/";
    given().
      header("Content-Type", "application/json").
      contentType(ContentType.JSON).
      accept(ContentType.XML).
      body(requset.toJSONString()).
    when().
      post("/users"). 
    then().
      statusCode(201).log().all();
  }
}