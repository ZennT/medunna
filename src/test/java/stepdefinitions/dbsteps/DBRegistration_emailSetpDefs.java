package stepdefinitions.dbsteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static utilities.DBUtils.closeConnection;
import static utilities.DatabaseUtility.createConnection;
import static utilities.DatabaseUtility.getColumnData;

public class DBRegistration_emailSetpDefs {

        List<Object> allDBEmails;  // to see it all step we move it here in class level.
        List<Object> allDBSSns;
        List<Object> allDBusername;


        @Given("user creates a connection with DB")
        public void userCreatesAConnectionWithDB() {
            //=> connectuoni direk DataBaseutils ten hazir method ile de alabiliriz constroctor with and without patameter
        //    DataBaseUtils.createConnection();
            createConnection("jdbc:postgresql://medunna.com:5432/medunna_db","medunnadb_user" , "Medunnadb_@129");

        }

        @And("user selects all {string} column data from table")
        public void userSelectsAllColumnDataFromTable(String email) {
         //   executeQuery("Select * FROM jhi_user");
            allDBEmails=getColumnData("select * from jhi_user", email);
            System.out.println("All Email from DB : " + allDBEmails);
        }

        @Then("user validates registrant {string} with the database")
        public void userValidatesRegistrantWithTheDatabase(String email) {
            assertTrue(allDBEmails.contains(email));

        }
//========================================SSN=====================================================
        @And("user selects all ssn {string} column data")
        public void userSelectsAllSsnColumnData(String ssn) {
            allDBSSns=getColumnData("select * from jhi_user", ssn);
            System.out.println("All Ssn from DB : " +  allDBSSns);
        }

        @Then("user validates registrant {string} ids with the database")
        public void userValidatesRegistrantIdsWithTheDatabase(String ssn) {
            assertTrue(allDBSSns.toString().contains(ssn));

    //        List<String> expectedSSNIDs = new ArrayList<>();
    //        expectedSSNIDs.add("662-32-9756");
    //        expectedSSNIDs.add("369-93-5260");
    //        List<String> actualData = getSSNIDs();//All ssn records reading from readtxt
    //        Assert.assertTrue(actualData.containsAll(expectedSSNIDs));

        }
    //========================================Login=====================================================
        @And("user selects all username {string} column data")
        public void userSelectsAllUsernameColumnData(String login) {
           allDBusername=getColumnData("select * from jhi_user", login);
            System.out.println("All Username from DB : " +  allDBusername);
    }


        @Then("user validates registrant username {string} with the database")
        public void userValidatesRegistrantUsernameWithTheDatabase(String username) {
            assertTrue(allDBusername.contains(username));
        }

        @Then("close the database connection")
        public void close_the_database_connection() {
            closeConnection();
        }
}








