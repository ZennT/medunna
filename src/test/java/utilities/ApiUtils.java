package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.CreateUpdateDeleteTestItem;
import pojos.RoomApiRequest;
import pojos.RoomApiResponse;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiUtils {


    public static Response getRequest(String token, String endpoint) {

        Response response = given().headers(
                "Authorization",
                "Bearer " + token,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).when().get(endpoint);


        return response;

    }

    public static Response postRequestTestItem(String token, String endpoint, CreateUpdateDeleteTestItem createUpdateDeleteTestItem) {

        Response response = given().headers(
                "Authorization",
                "Bearer " + token,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).contentType(ContentType.JSON).body(createUpdateDeleteTestItem).when().post(endpoint);

        response.prettyPrint();
        return response;
    }

    public static Response putRequest(String token, String endpoint, RoomApiResponse updatedRoom) {

        Response response = given().headers(
                "Authorization",
                "Bearer " + token,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).contentType(ContentType.JSON).body(updatedRoom).when().put(endpoint);

        response.prettyPrint();
        return response;
    }

    public static Response deleteRequest(String token, String endpoint) {

        Response response = given().headers(
                "Authorization",
                "Bearer " + token,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).when().delete(endpoint);

        response.prettyPrint();
        return response;
    }


    public static Response postRequestRoomApi(String token, String endpoint, RoomApiRequest roomApi) {
        Response response = given().headers(
                "Authorization",
                "Bearer " + token,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).contentType(ContentType.JSON).body(roomApi).when().post(endpoint);

        response.prettyPrint();
        return response;


    }

    public static Response postRequestRoomApiSecond(String token, String endpoint, Map<String,Object> createdRoomData) {
        Response response = given().headers(
                "Authorization",
                "Bearer " + token,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).contentType(ContentType.JSON).body(createdRoomData).when().post(endpoint);

        response.prettyPrint();
        return response;


    }

    public static Response putRequestRoomSecond(String token, String endpoint, Map<String,Object> actualRoomData) {

        Response response = given().headers(
                "Authorization",
                "Bearer " + token,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).contentType(ContentType.JSON).body(actualRoomData).when().put(endpoint);

        response.prettyPrint();
        return response;
    }
}