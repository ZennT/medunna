package stepdefinitions.apisteps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.CreateUpdateDeleteTestItem;
import utilities.ConfigurationReader;

import java.io.IOException;
import java.util.List;

import static Hooks.Hooks.spec;
import static junit.framework.TestCase.assertEquals;
import static utilities.ApiUtils.getRequest;
import static utilities.ApiUtils.postRequestTestItem;
import static utilities.Authentication.generateToken;
import static utilities.ReadTxt.getApiTestItemNames;
import static utilities.ReadTxt.getTestItemNames;
import static utilities.WriteToTxt.saveAllTestItems;
import static utilities.WriteToTxt.saveTestItemInfo;


public class US17_CreateUpdateDeleteTestItemApiStepDefs {


    CreateUpdateDeleteTestItem createUpdateDeleteTestItem= new CreateUpdateDeleteTestItem();
    Faker faker = new Faker();
    Response response;
    CreateUpdateDeleteTestItem [] createUpdateDeleteTestItems;


    //=================================Test Items Post Request=====================================

    @Given("user sets the path params to create test item")
    public void user_sets_the_path_params_to_create_test_item() {

        spec.pathParams("first","api","second","c-test-items");

    }

    @Given("user sets expected data")
    public void user_sets_expected_data() {

        createUpdateDeleteTestItem.setName(faker.name().firstName()+" test");
        createUpdateDeleteTestItem.setDescription("mg/mL");
        createUpdateDeleteTestItem.setPrice(faker.number().numberBetween(100,150)+"");
        createUpdateDeleteTestItem.setDefaultValMin("80");
        createUpdateDeleteTestItem.setDefaultValMax("130");

    }

    @Given("user send Post request for test item and gets response")
    public void user_send_post_request_for_test_item_and_gets_response() {

        response=postRequestTestItem(generateToken(), ConfigurationReader.getProperty("testItem_endpoint"),createUpdateDeleteTestItem);
        response.prettyPrint();

    }

    @Given("user saves the test item records")
    public void user_saves_the_test_item_records() {

        saveTestItemInfo(createUpdateDeleteTestItem);

    }

    @Then("user validates test item record with Api")
    public void user_validates_test_item_record_with_api() throws IOException {
        response.then().statusCode(201);

        ObjectMapper obj=new ObjectMapper();
        CreateUpdateDeleteTestItem actualCreateUpdateDeleteTestItem=obj.readValue(response.asString(),CreateUpdateDeleteTestItem.class);

        assertEquals(createUpdateDeleteTestItem.getName(),actualCreateUpdateDeleteTestItem.getName());
        assertEquals(createUpdateDeleteTestItem.getDescription(),actualCreateUpdateDeleteTestItem.getDescription());
        assertEquals(createUpdateDeleteTestItem.getPrice(),actualCreateUpdateDeleteTestItem.getPrice());
        assertEquals(createUpdateDeleteTestItem.getDefaultValMin(),actualCreateUpdateDeleteTestItem.getDefaultValMin());
        assertEquals(createUpdateDeleteTestItem.getDefaultValMax(),actualCreateUpdateDeleteTestItem.getDefaultValMax());
    }



    //=================================Test Items Get Request=============================================

    @Given("user sends the get request for test items data")
    public void user_sends_the_get_request_for_test_items_data() {

        response=getRequest(generateToken(),ConfigurationReader.getProperty("testItem_endpoint"));
        //response.prettyPrint();

    }

    @Given("user deserializes test items data to Java")
    public void user_deserializes_test_items_data_to_java() throws IOException {
        ObjectMapper obj = new ObjectMapper();
        createUpdateDeleteTestItems = obj.readValue(response.asString(),CreateUpdateDeleteTestItem[].class);

    }

    @Given("user saves the test items data to correspondent file")
    public void user_saves_the_test_items_data_to_correspondent_file() {
        saveAllTestItems(createUpdateDeleteTestItems);

    }

    @Then("user validates expected test item records with Api")
    public void user_validates_expected_test_item_records_with_api() {
        List<String> expectedData=getTestItemNames();
        //System.out.println("expected:"+ expectedData);
        List<String> actualTestItems=getApiTestItemNames();
        //System.out.println("actual: "+actualTestItems);
        Assert.assertTrue(actualTestItems.containsAll(expectedData));


    }

}