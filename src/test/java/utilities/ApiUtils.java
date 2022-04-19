package utilities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojos.*;

import javax.swing.text.AbstractDocument;
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


        return response;
    }

    public static Response putRequest(String token, String endpoint, RoomApiResponse updatedRoom){

        Response response = given().headers(
                "Authorization",
                "Bearer " + token,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).contentType(ContentType.JSON).body(updatedRoom).when().put(endpoint);

        response.prettyPrint();
        return  response;

    }

    public static Response deleteRequest(String token, String endpoint){

        Response response = given().headers(
                "Authorization",
                "Bearer " + token,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).contentType(ContentType.JSON).when().delete(endpoint);

        response.prettyPrint();
        return  response;

    }

    public static Response postRequestRoom(String token, String endpoint, RoomCreateUpdateDelete room) {

        Response response = given().headers(
                "Authorization",
                "Bearer " + token,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).contentType(ContentType.JSON).body(room).when().post(endpoint);


        return response;
    }

    public static Response postRequestAppointment(String token, String endpoint, AppointmentCase07 app) {

        Response response = given().headers(
                "Authorization",
                "Bearer " + token,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).contentType(ContentType.JSON).body(app).when().post(endpoint);


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
        // ilk content type.JSON --> bearer token ile ilgili
        // ikincisi  de response type


        return response;
    }

    public static Response postRequestRoomApi(String token, String endpoint, Map<String,String> requestBody) {

        Response response = RestAssured.given().headers(
                "Authorization",
                "Bearer " + token,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).body(requestBody).when().post(endpoint);
        // ilk content type.JSON --> bearer token ile ilgili
        // ikincisi  de response type


        return response;
    }
}

//     String  endpoint ="https://medunna.com/api/appointments/request";
//      response = given().headers(
//                "Authorization",
//                "Bearer " + generateToken(),
//                "Content-Type",
//                ContentType.JSON,
//                "Accept",
//                ContentType.JSON).contentType(ContentType.JSON).body(expectedAppointmentCreate).when().post(endpoint);