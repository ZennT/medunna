package stepdefinitions.dbsteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import pojos.RoomApiRequest;
import utilities.ConfigurationReader;
import utilities.DatabaseUtility;

import java.sql.SQLException;
import java.util.List;

import static Hooks.Hooks.spec;
import static utilities.ApiUtils.postRequestRoomApi;
import static utilities.Authentication.generateToken;

public class RoomDBSteps {
    RoomApiRequest roomApi = new RoomApiRequest();
    Response response;
    long roomID;

    @Given("create room by using post request")
    public void createRoomByUsingPostRequest() {
        spec.pathParams("first","api","second","rooms");

        roomApi.setDescription("this is a test room description");
        roomApi.setRoomType("TWIN");
        roomApi.setRoomNumber(30700);
        roomApi.setPrice(5000.50);
        roomApi.setStatus(true);

        response = postRequestRoomApi(generateToken(), ConfigurationReader.getProperty("room_endpoint"),roomApi);
        response.prettyPrint();

        response = response.then().extract().path("id");
    }

    @And("connect to database")
    public void connectToDatabase() {
        DatabaseUtility.createConnection();
    }

    @Then("validate that room is landed in db")
    public void validateThatRoomIsLandedInDb() throws SQLException {
        DatabaseUtility.executeQuery("Select id from room");
        List<Long> allRoomsFromDB = DatabaseUtility.getResult();
        System.out.println(allRoomsFromDB);
        Assert.assertTrue(allRoomsFromDB.contains(roomID));


    }
}
