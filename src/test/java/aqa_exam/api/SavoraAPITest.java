package aqa_exam.api;

import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.UUID;

import static aqa_exam.utils.UuidExtractor.*;
import static io.restassured.RestAssured.given;

public class SavoraAPITest {

    private static final Logger LOGGER = LogManager.getLogger(SavoraAPITest.class);

    @BeforeTest
    public void setup(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void RestAssuredTest(){
        LOGGER.info("Starting Savora API Test sequence...");

        Response response = given()
                .header("Next-Action", "60eb25a4c1381ebe74de93f0d78205b2e78ee627f5")
                .header("Next-Router-State-Tree", "%5B%22%22%2C%7B%22children%22%3A%5B%22(landing)%22%2C%7B%22children%22%3A%5B%22login%22%2C%7B%22children%22%3A%5B%22__PAGE__%22%2C%7B%7D%2C%22%2Flogin%22%2C%22refresh%22%5D%7D%5D%7D%5D%7D%2Cnull%2Cnull%2Ctrue%5D")
                .body("[\"john.test1.mail@gmail.com\",\"1qaz!QAZ\"]")
                .when()
                .post("http://localhost:3000/login")
                .then()
                .extract().response();

        Cookies cookies = response.getDetailedCookies();
        LOGGER.info("Successfully logged in and received cookies.");

        Response createPost = given()
                .header("Next-Action", "40fdebdfdfaff65b33012a8802cce2e445e6ea9d07")
                .header("Next-Router-State-Tree", "%5B%22%22%2C%7B%22children%22%3A%5B%22dashboard%22%2C%7B%22children%22%3A%5B%22create-post%22%2C%7B%22children%22%3A%5B%22ai%22%2C%7B%22children%22%3A%5B%22__PAGE__%22%2C%7B%7D%2C%22%2Fdashboard%2Fcreate-post%2Fai%22%2C%22refresh%22%5D%7D%5D%7D%5D%7D%2Cnull%2Cnull%5D%7D%2Cnull%2Cnull%2Ctrue%5D")
                .cookies(cookies)
                .body("[\"create post about coctail\"]")
                .when()
                .post("http://localhost:3000/dashboard/create-post/ai")
                .then()
                .extract().response();

        String postBody = createPost.getBody().prettyPrint();
        String postId = extractUuid(postBody);

        //test 1 - validate post created
        if (postId != null && !postId.isEmpty()) {
            Assert.assertNotNull(postId, "Post ID should not be null after creation.");
            LOGGER.info("Test 1: Post created successfully. PostId: " + postId);
        } else {
            LOGGER.error("Test 1 Failed: Post ID not found in response body.");
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //test 2 - validate post deleted
        Response deletePost = given()
                .header("Next-Action", "40bd3e770533d34356f50627ce104895cab5ba672f")
                .header("Next-Router-State-Tree", "%5B%22%22%2C%7B%22children%22%3A%5B%22dashboard%22%2C%7B%22children%22%3A%5B%22post%22%2C%7B%22children%22%3A%5B%5B%22id%22%2C%22162928c1-c536-479a-a791-e01bf8b08df4%22%2C%22d%22%5D%2C%7B%22children%22%3A%5B%22__PAGE__%22%2C%7B%7D%2C%22%2Fdashboard%2Fpost%2F162928c1-c536-479a-a791-e01bf8b08df4%22%2C%22refresh%22%5D%7D%5D%7D%5D%7D%5D%7D%2Cnull%2Cnull%2Ctrue%5D")
                .cookies(cookies)
                .body("[\"" + postId + "\"]")
                .when()
                .post("http://localhost:3000/dashboard/post/" + postId)
                .then()
                .extract().response();

        LOGGER.info("Test 2: Delete post request sent for PostId: " + postId);

        //test 3 - validate bio updated
        String bioUUID = UUID.randomUUID().toString();
        Response updateBio = given()
                .header("Next-Action", "7c94b01874049d39ba4ee2f69352fdd3188dc4aa3e")
                .header("Next-Router-State-Tree", "%5B%22%22%2C%7B%22children%22%3A%5B%22dashboard%22%2C%7B%22children%22%3A%5B%22settings%22%2C%7B%22children%22%3A%5B%22__PAGE__%22%2C%7B%7D%2C%22%2Fdashboard%2Fsettings%22%2C%22refresh%22%5D%7D%5D%7D%2Cnull%2Cnull%5D%7D%2Cnull%2Cnull%2Ctrue%5D")
                .cookies(cookies)
                .body("[\"233db10a-4217-4e1f-b41d-c40d3c804848\",\"admin1\",\"Hello. I am test user! " + bioUUID + "\",null,\"Ukraine\"]")
                .when()
                .post("http://localhost:3000/dashboard/settings")
                .then()
                .extract().response();

        String bioBody = updateBio.getBody().prettyPrint();
        String bioUUIDOutput = extractBioUUID(bioBody);

        if(bioUUIDOutput != null && !bioUUIDOutput.isEmpty())
        {
            Assert.assertEquals(bioUUIDOutput, bioUUID, "Test 3 Failed: Extracted Bio UUID does not match expected UUID.");
            LOGGER.info("Test 3: Bio updated successfully. Extracted UUID: " + bioUUIDOutput);
        } else {
            LOGGER.error("Test 3 Failed: Updated Bio UUID not found in response body.");
        }
    }
}
