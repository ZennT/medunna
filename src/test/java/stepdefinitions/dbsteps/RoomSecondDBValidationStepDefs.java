package stepdefinitions.dbsteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DatabaseUtility;
import java.sql.SQLException;
import java.util.List;
import static utilities.DatabaseUtility.createConnection;


public class RoomSecondDBValidationStepDefs {
    List<Long> allRoomsFromDB;
    @Given("User connects to the database")
    public void userConnectsToTheDatabase() {
        createConnection("jdbc:postgresql://medunna.com:5432/medunna_db","medunnadb_user" , "Medunnadb_@129");
    }


    @And("user sends new room query to DB and gets the column data")
    public void userSendsNewRoomQueryToDBAndGetsTheColumnData() throws SQLException {
        DatabaseUtility.executeQuery("Select id from room");
        allRoomsFromDB= DatabaseUtility.getResult();
        System.out.println(allRoomsFromDB);

    }

    @And("User validates new room landed on db")
    public void userValidatesNewRoomLandedOnDb() {
        //1. Way
        Assert.assertTrue(allRoomsFromDB.contains(35703L));
        System.out.println("assertTrue");

        //2.Way

//        List<Object> myIds= new ArrayList<>();
//        myIds.add(83893L);
//        myIds.add(7651L);
    }

    @Then("User sends query to delete from  db")
    public void userSendsQueryToDeleteFromDb() {
    }


}
