package stepdefinitions.dbsteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DatabaseUtility;

import java.util.List;

import static utilities.ReadTxt.getDBTestItemNames;
import static utilities.ReadTxt.getTestItemNames;
import static utilities.WriteToTxt.saveDBTestItemsData;

public class US17_CreateUpdateDeleteTestItemDBStepDefs {

    List< Object> allTestItemNames;

    @Given("user creates the connection with DB using {string} and {string} , {string}")
    public void user_creates_the_connection_with_db_using_and(String url, String username, String password) {
        DatabaseUtility.createConnection(url, username,password);
    }
    @Given("user sends query to DB and gets the column data {string} and {string}")
    public void user_sends_query_to_db_and_gets_the_column_data_and(String query, String columnName) {
        allTestItemNames = DatabaseUtility.getColumnData(query, columnName);
        System.out.println(allTestItemNames);

    }
    @Given("user saves DB records to correspondent files")
    public void user_saves_db_records_to_correspondent_files() {
        saveDBTestItemsData(allTestItemNames);
    }
    @Then("user validates DB test item data")
    public void user_validates_db_test_item_data() {
        List<String> expectedTestItemNamesUI = getTestItemNames();

        List<String> actualDatabaseData = getDBTestItemNames();//All records fetched with SQL query
        Assert.assertTrue(actualDatabaseData.containsAll(expectedTestItemNamesUI));
    }

}
