package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestsExamples { 

  @Test
  public void test_1() { 
    Response response = get("https://reqres.in/api/users?page=2"); 

    System.out.println(response.getStatusCode());
    System.out.println(response.getTime());

    Assert.assertEquals(response.getStatusCode(), 200, "Response status code equls 200");
  }

  @Test
  public void test_2() { 
    baseURI="https://reqres.in/api";
    given().
      get("/users?page=2").
    then().
      statusCode(200).
      body("data[1].id", equalTo(8)).log().all();
  }
}