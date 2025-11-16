package aqa_exam.test16;

import aqa_exam.task16.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.UUID;

import static io.restassured.RestAssured.*;

public class Task16Test {

//    Make restAssured Test Cases using scenario from Task_15
//    The same using any another API client.
//    Add Request and Response clases for each unique endpoints.
//    Validate Response Object using your own class comparator.

    @BeforeTest
    public void setup(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void RestAssuredTest(){
//        Step 1
        String boardName = UUID.randomUUID().toString().substring(0, 10);
        Response response = given()
                .pathParam("trello_key", ConfigReader.getProp("trello_key"))
                .pathParam("trello_token", ConfigReader.getProp("trello_token"))
                .pathParam("board_name", boardName)
                .when()
                .post("https://api.trello.com/1/boards/?name={board_name}&key={trello_key}&token={trello_token}")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();

        Assert.assertEquals(response.path("name"), boardName, "Unexpected Board name");
        System.out.println("Board Name: " + boardName);
        String boardId = response.path("id");

//        Step 2
        String list1Name = "List1_" + UUID.randomUUID().toString().substring(0, 10);
        response = given()
                .pathParam("trello_key", ConfigReader.getProp("trello_key"))
                .pathParam("trello_token", ConfigReader.getProp("trello_token"))
                .pathParam("board_id", boardId)
                .pathParam("list_name", list1Name)
                .when()
                .post("https://api.trello.com/1/boards/{board_id}/lists?name={list_name}&key={trello_key}&token={trello_token}")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();

        Assert.assertEquals(response.path("name"), list1Name, "Unexpected List name");
        System.out.println("List Name: " + list1Name);
        String list1Id = response.path("id");

//        Step 3
        String cardName = UUID.randomUUID().toString().substring(0, 10);
        response = given()
                .pathParam("trello_key", ConfigReader.getProp("trello_key"))
                .pathParam("trello_token", ConfigReader.getProp("trello_token"))
                .pathParam("list_id", list1Id)
                .pathParam("card_name", cardName)
                .when()
                .post("https://api.trello.com/1/cards?idList={list_id}&key={trello_key}&token={trello_token}&name={card_name}")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();

        Assert.assertEquals(response.path("name"), cardName, "Unexpected Card name");
        System.out.println("Card Name: " + cardName);
        String cardId = response.path("id");

//        Step 4
        String list2Name = "List2_" + UUID.randomUUID().toString().substring(0, 10);
        response = given()
                .pathParam("trello_key", ConfigReader.getProp("trello_key"))
                .pathParam("trello_token", ConfigReader.getProp("trello_token"))
                .pathParam("board_id", boardId)
                .pathParam("list_name", list2Name)
                .when()
                .post("https://api.trello.com/1/boards/{board_id}/lists?name={list_name}&key={trello_key}&token={trello_token}")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();

        Assert.assertEquals(response.path("name"), list2Name, "Unexpected List name");
        System.out.println("List Name: " + list2Name);
        String list2Id = response.path("id");

        response = given()
                .pathParam("trello_key", ConfigReader.getProp("trello_key"))
                .pathParam("trello_token", ConfigReader.getProp("trello_token"))
                .pathParam("list1_id", list1Id)
                .pathParam("board_id", boardId)
                .pathParam("list2_id", list2Id)
                .when()
                .post("https://api.trello.com/1/lists/{list1_id}/moveAllCards?idBoard={board_id}&idList={list2_id}&key={trello_key}&token={trello_token}")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();
    }
}
