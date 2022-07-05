package TestAssuredExample;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FindAPetById {
    @Test
    void testGet_notFound() {
        Response res = RestAssured.
                given().
                get(" https://petstore.swagger.io/v2/pet/1");
        Assert.assertEquals(res.statusCode(), HttpStatus.SC_OK);
    }

    @Test
    void testGet_Found() {
        Response response = RestAssured.
                given().
                get(" https://petstore.swagger.io/v2/pet/3510");
        response.body().prettyPrint();
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);

    }
}
