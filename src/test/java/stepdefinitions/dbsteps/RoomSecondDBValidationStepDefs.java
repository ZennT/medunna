package stepdefinitions.dbsteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DatabaseUtility;
<<<<<<< HEAD
import utilities.Driver;

import java.sql.SQLException;
=======


import java.sql.SQLException;
import java.util.ArrayList;
>>>>>>> master
import java.util.List;

import static utilities.DatabaseUtility.*;


<<<<<<< HEAD
public class RoomSecondDBValidationStepDefs {
    List<Long> allRoomsFromDB;
    List<Long> allRoomsFromDB1;
    @Given("User connects to the database")
    public void userConnectsToTheDatabase() {
        createConnection("jdbc:postgresql://medunna.com:5432/medunna_db","medunnadb_user" , "Medunnadb_@129");
=======

public class RoomSecondDBValidationStepDefs {

    List<Long> allRoomsFromDB;

    @Given("User connects to the database")
    public void userConnectsToTheDatabase() {
      createConnection();
//        createConnection("jdbc:postgresql://medunna.com:5432/medunna_db","medunnadb_user" , "Medunnadb_@129");
>>>>>>> master
    }


    @And("user sends new room query to DB and gets the column data")
    public void userSendsNewRoomQueryToDBAndGetsTheColumnData() throws SQLException {
<<<<<<< HEAD
        DatabaseUtility.executeQuery("Select id from room");
        allRoomsFromDB= DatabaseUtility.getResult();
        //System.out.println(allRoomsFromDB);

    }

    @And("User validates new room landed on db")
    public void userValidatesNewRoomLandedOnDb() {
        //1. Way
        Assert.assertTrue(allRoomsFromDB.contains(96346L));
        //System.out.println("assertTrue");

        //2.Way

//        List<Object> myIds= new ArrayList<>();
//        myIds.add(83893L);
//        myIds.add(7651L);
    }

    @Then("User sends query to delete from  db")
    public void userSendsQueryToDeleteFromDb() throws SQLException {
//        DatabaseUtility.executeQuery("Select id from room where id 96625");
        //1.way
//       executeQuery("Delete from room where id=96624");
        //2.way
        //deleteQuery("Delete from room where id=96609");
        //3.way
        //DeleteRoomRow(96602L);
        //4.way
        //executeDelete("Delete from room where id=96349");
        //5.way
       // executeDelete2("Delete from room where id=96348");
        //6.way
        deleteRows("room",96346L);

        DatabaseUtility.executeQuery("Select id from room");
        allRoomsFromDB1= DatabaseUtility.getResult();
        System.out.println(allRoomsFromDB1);
        Assert.assertFalse(allRoomsFromDB1.contains(96346L));
        //Assert.assertNotEquals(allRoomsFromDB,allRoomsFromDB1);

    }
=======
        executeQuery("Select id from room");
        allRoomsFromDB = DatabaseUtility.getRoomResult();
        System.out.println(allRoomsFromDB);

    }


    @And("User validates new room landed on db")
    public void userValidatesNewRoomLandedOnDb() throws SQLException {


//1.way
        Assert.assertTrue(allRoomsFromDB.contains(83893L));
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




>>>>>>> master
}
