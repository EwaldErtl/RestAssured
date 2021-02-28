package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestPutPatchAndDeleteExamples {

  @Test
  public void testPut() {
    JSONObject requset = new JSONObject();
    requset.put("name", "Ewald");
    requset.put("job", "Senior");

    baseURI = "https://reqres.in/api/";
    given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.XML)
        .body(requset.toJSONString()).when().put("/users/2").then().statusCode(200).log().all();
  }

  @Test
  public void testPatch() {
    JSONObject requset = new JSONObject();
    // requset.put("name", "Ewald");
    requset.put("job", "Senior arch");

    baseURI = "https://reqres.in/";
    given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.XML)
        .body(requset.toJSONString()).when().patch("/api/users/2").then().statusCode(200).log().all();
  }

  @Test
  public void testDelete() {

    baseURI = "https://reqres.in/";
    given().when().delete("/api/users/2").then().statusCode(204);

    // fake API doesn't really remove the item
    given().when().get("/api/users/2").then().statusCode(200).log().all();
  }
}
