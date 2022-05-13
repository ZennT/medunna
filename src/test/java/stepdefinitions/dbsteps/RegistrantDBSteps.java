package stepdefinitions.dbsteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DatabaseUtility;

import java.util.ArrayList;
import java.util.List;

import static utilities.DatabaseUtility.createConnection;
import static utilities.ReadTxt.getSSNIDs;
import static utilities.WriteToTxt.saveRegistrantData;

public class RegistrantDBSteps {
    List< Object> allDBSSNs;

    @Given("user creates a connection with DB using {string} and {string} , {string}")
    public void user_creates_a_connection_with_db_using_and(String url, String username, String password) {
        DatabaseUtility.createConnection(url, username,password);
    }
    @Given("user sends the query to DB and gets the column data {string} and {string}")
    public void user_sends_the_query_to_db_and_gets_the_column_data_and(String query, String columnName) {
        allDBSSNs = DatabaseUtility.getColumnData(query, columnName);
        System.out.println(allDBSSNs);
   }

    @Given("user saves the DB records to correspondent files")
    public void user_saves_the_db_records_to_correspondent_files() {
        saveRegistrantData(allDBSSNs);
    }

    @Then("user validates DB Registrant data")
    public void user_validates_db_registrant_data() {
        List<String> expectedSSNIDs = new ArrayList<>();
        expectedSSNIDs.add("662-32-9756");
        expectedSSNIDs.add("369-93-5260");

        List<String> actualData = getSSNIDs();//All records

        Assert.assertTrue(actualData.containsAll(expectedSSNIDs));

    }

/**
 * post --> create --> post ile veri gonderdigimiz database'e ekliyor.
 * put --> update
 * oop concept in your framework --> static method class name/ object olusturma / parent-child ile classlar arasi siniflar arasi bag kuruyoruz.
 * selenium webdriver bir interface ve full abstract, driver utilde switch case kodlariy;a interfaceden subclasslara ulastik(firefox-chromedriver)
 * alt classlar selnium webdriver ozeligini aliyorlar cunku o parent, polymorphisim oluyor, hatta override da louyor, webdriver chrome = new Chromedriver
 * abstract - abstraction farkli
 * abstrack class da concrete ve abstract method kullanilir ama interface de metodlar sadece abstract olur.
 * bir sinifi iki classa extend edemiyoruz.
 *
 */

}