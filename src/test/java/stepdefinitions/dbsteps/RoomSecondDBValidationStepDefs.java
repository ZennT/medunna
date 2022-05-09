package stepdefinitions.dbsteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DatabaseUtility;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static utilities.DatabaseUtility.*;



public class RoomSecondDBValidationStepDefs {

    List<Long> allRoomsFromDB;

    @Given("User connects to the database")
    public void userConnectsToTheDatabase() {
//      createConnection();
        createConnection("jdbc:postgresql://medunna.com:5432/medunna_db","medunnadb_user" , "Medunnadb_@129");
    }


    @And("user sends new room query to DB and gets the column data")
    public void userSendsNewRoomQueryToDBAndGetsTheColumnData() throws SQLException {
        executeQuery("Select id from room");
        System.out.println(allRoomsFromDB);
        allRoomsFromDB = DatabaseUtility.getRoomResult();

    }


    @And("User validates new room landed on db")
    public void userValidatesNewRoomLandedOnDb() throws SQLException {


//1.way
        Assert.assertTrue(allRoomsFromDB.contains(83893));
        System.out.println("assertTrue");

//        2.way
//        List<Long> myIds = new ArrayList<>();
//        myIds.add(96616l);
//        myIds.add(96613l);
//        Assert.assertTrue(allRoomsFromDB.containsAll(myIds));
//        System.out.println("asserted");

    }

    @Then("User sends query to delete from db")
    public void userSendsQueryToDeleteFromDb() {
    }




}
