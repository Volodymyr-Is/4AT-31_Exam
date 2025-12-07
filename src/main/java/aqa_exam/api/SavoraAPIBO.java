package aqa_exam.api;

import aqa_exam.db.User;
import aqa_exam.utils.UuidExtractor;
import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class SavoraAPIBO {

    private static final Logger LOGGER = LogManager.getLogger(SavoraAPIBO.class);
    private Cookies authCookies;
    private final String API_BASE_URL = "http://localhost:3000";

    public SavoraAPIBO() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }


    public SavoraAPIBO login(User user) {
        LOGGER.info("Attempting login for user: john.test1.mail@gmail.com");

        Response response = given()
                .header("Next-Action", "60eb25a4c1381ebe74de93f0d78205b2e78ee627f5")
                .header("Next-Router-State-Tree", "%5B%22%22%2C%7B%22children%22%3A%5B%22(landing)%22%2C%7B%22children%22%3A%5B%22login%22%2C%7B%22children%22%3A%5B%22__PAGE__%22%2C%7B%7D%2C%22%2Flogin%22%2C%22refresh%22%5D%7D%5D%7D%5D%7D%2Cnull%2Cnull%2Ctrue%5D")
                .body("[\"" + user.getEmail() + "\",\"" + user.getPassword() + "\"]")
                .when()
                .post(API_BASE_URL + "/login")
                .then()
                .statusCode(200)
                .extract().response();

        authCookies = response.getDetailedCookies();
        LOGGER.info("Login successful. Cookies saved for subsequent requests.");
        return this;
    }

    public String createPost(String prompt) {
        LOGGER.info("Creating new post with prompt: " + prompt);

        Response createPostResponse = given()
                .header("Next-Action", "40fdebdfdfaff65b33012a8802cce2e445e6ea9d07")
                .header("Next-Router-State-Tree", "%5B%22%22%2C%7B%22children%22%3A%5B%22dashboard%22%2C%7B%22children%22%3A%5B%22create-post%22%2C%7B%22children%22%3A%5B%22ai%22%2C%7B%22children%22%3A%5B%22__PAGE__%22%2C%7B%7D%2C%22%2Fdashboard%2Fcreate-post%2Fai%22%2C%22refresh%22%5D%7D%5D%7D%5D%7D%2Cnull%2Cnull%5D%7D%2Cnull%2Cnull%2Ctrue%5D")
                .cookies(authCookies)
                .body("[\"" + prompt + "\"]")
                .when()
                .post(API_BASE_URL + "/dashboard/create-post/ai")
                .then()
                .statusCode(200)
                .extract().response();

        String postId = UuidExtractor.extractUuid(createPostResponse.getBody().asString());
        Assert.assertNotNull(postId, "Post ID should not be null after creation.");

        LOGGER.info("Post created successfully. PostId: " + postId);
        return postId;
    }

    public void deletePost(String postId) {
        LOGGER.info("Deleting post with ID: " + postId);

        Response deletePostResponse = given()
                .header("Next-Action", "40bd3e770533d34356f50627ce104895cab5ba672f")
                .header("Next-Router-State-Tree", "%5B%22%22%2C%7B%22children%22%3A%5B%22dashboard%22%2C%7B%22children%22%3A%5B%22post%22%2C%7B%22children%22%3A%5B%5B%22id%22%2C%22162928c1-c536-479a-a791-e01bf8b08df4%22%2C%22d%22%5D%2C%7B%22children%22%3A%5B%22__PAGE__%22%2C%7B%7D%2C%22%2Fdashboard%2Fpost%2F162928c1-c536-479a-a791-e01bf8b08df4%22%2C%22refresh%22%5D%7D%5D%7D%5D%7D%5D%7D%2Cnull%2Cnull%2Ctrue%5D")
                .cookies(authCookies)
                .body("[\"" + postId + "\"]")
                .when()
                .post(API_BASE_URL + "/dashboard/post/" + postId)
                .then()
                .statusCode(200)
                .extract().response();

        LOGGER.info("Post deletion request completed for ID: " + postId + ". Response status: " + deletePostResponse.getStatusCode());
    }

    public String updateBio(User user) {
        LOGGER.info("Updating user bio for user ID: " + user.getId());

        String bioUUID = UUID.randomUUID().toString();

        Response updateBioResponse = given()
                .header("Next-Action", "7c94b01874049d39ba4ee2f69352fdd3188dc4aa3e")
                .header("Next-Router-State-Tree", "%5B%22%22%2C%7B%22children%22%3A%5B%22dashboard%22%2C%7B%22children%22%3A%5B%22settings%22%2C%7B%22children%22%3A%5B%22__PAGE__%22%2C%7B%7D%2C%22%2Fdashboard%2Fsettings%22%2C%22refresh%22%5D%7D%5D%7D%2Cnull%2Cnull%5D%7D%2Cnull%2Cnull%2Ctrue%5D")
                .cookies(authCookies)
                .body("[\"" + user.getId() + "\",\"admin1\",\"Hello. I am test user! " + bioUUID + "\",null,\"Ukraine\"]")
                .when()
                .post(API_BASE_URL + "/dashboard/settings")
                .then()
                .statusCode(200)
                .extract().response();

        String bioBody = updateBioResponse.getBody().asString();
        String bioUUIDOutput = UuidExtractor.extractBioUUID(bioBody);

        Assert.assertEquals(bioUUIDOutput, bioUUID, "Extracted Bio UUID does not match expected UUID.");

        LOGGER.info("Bio updated successfully. Verified UUID: " + bioUUIDOutput);
        return bioUUIDOutput;
    }
}