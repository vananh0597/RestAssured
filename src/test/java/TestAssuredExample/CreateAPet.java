package TestAssuredExample;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;

public class CreateAPet {

    @Test
    void testPost() {
        Map<String, Object> map = new HashMap<>();

        map.put("name", "Meow");
        map.put("id", "3510");
        JSONObject request = new JSONObject(map);

        Response response = given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(request.toJSONString()).
                when() .
                        post("https://petstore.swagger.io/v2/pet");

        response.body().prettyPrint();
        Assert.assertEquals(response.body().jsonPath().get("name"), "Meow");
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);

    }
}

