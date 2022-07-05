package TestAssuredExample;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteAPet {

    @Test
    void testDelete_notFound_passed() {
        Response response =
                given().
                        delete(" https://petstore.swagger.io/v2/pet/1");
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_NOT_FOUND);
    }

    @Test
    void testDelete_AvailablePet_passed() {
        Response responseDelete = given().
                delete(" https://petstore.swagger.io/v2/pet/3014");
        Assert.assertEquals(responseDelete.statusCode(), 200);
        Response responseGet =
                given().
                        get(" https://petstore.swagger.io/v2/pet/3014");
        Assert.assertEquals(responseGet.statusCode(), HttpStatus.SC_NOT_FOUND);
    }
}
