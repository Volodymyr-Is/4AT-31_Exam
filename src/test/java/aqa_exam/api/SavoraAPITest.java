package aqa_exam.api;

import aqa_exam.ConfigReader;
import aqa_exam.db.User;
import aqa_exam.db.UserProvider;
import aqa_exam.ui.bo.SavoraBO;
import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static aqa_exam.api.UuidExtractor.extractUuid;
import static io.restassured.RestAssured.given;

public class SavoraAPITest {

    //test 1 - validate post created
//    @Test
//    public void savoraCreatePostTest(){
////        new SavoraAPIBO().login().createPost();
//    }

    //test 2 - validate post liked and saved

    //test 3 - validate post deleted

    @BeforeTest
    public void setup(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void RestAssuredTest(){
        Response response = given()
                .header("Next-Action", "60eb25a4c1381ebe74de93f0d78205b2e78ee627f5")
                .header("Next-Router-State-Tree", "%5B%22%22%2C%7B%22children%22%3A%5B%22(landing)%22%2C%7B%22children%22%3A%5B%22login%22%2C%7B%22children%22%3A%5B%22__PAGE__%22%2C%7B%7D%2C%22%2Flogin%22%2C%22refresh%22%5D%7D%5D%7D%5D%7D%2Cnull%2Cnull%2Ctrue%5D")
                .body("[\"john.test1.mail@gmail.com\",\"1qaz!QAZ\"]")
                .when()
                .post("http://localhost:3000/login")
                .then()
                .extract().response();

        Cookies cookies = response.getDetailedCookies();

        Response createPost = given()
                .header("Next-Action", "40fdebdfdfaff65b33012a8802cce2e445e6ea9d07")
                .header("Next-Router-State-Tree", "%5B%22%22%2C%7B%22children%22%3A%5B%22dashboard%22%2C%7B%22children%22%3A%5B%22create-post%22%2C%7B%22children%22%3A%5B%22ai%22%2C%7B%22children%22%3A%5B%22__PAGE__%22%2C%7B%7D%2C%22%2Fdashboard%2Fcreate-post%2Fai%22%2C%22refresh%22%5D%7D%5D%7D%5D%7D%2Cnull%2Cnull%5D%7D%2Cnull%2Cnull%2Ctrue%5D")
                .cookies(cookies)
                .body("[\"create post about coctail\"]")
                .when()
                .post("http://localhost:3000/dashboard/create-post/ai")
                .then()
                .extract().response();

        String body = createPost.getBody().prettyPrint();

        String postId = extractUuid(body);

        if (!postId.isEmpty()) {
            Assert.assertNotNull(postId);
        } else {
            System.out.println("ID not found");
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Response deletePost = given()
                .header("Next-Action", "40bd3e770533d34356f50627ce104895cab5ba672f")
                .header("Next-Router-State-Tree", "%5B%22%22%2C%7B%22children%22%3A%5B%22dashboard%22%2C%7B%22children%22%3A%5B%22post%22%2C%7B%22children%22%3A%5B%5B%22id%22%2C%22162928c1-c536-479a-a791-e01bf8b08df4%22%2C%22d%22%5D%2C%7B%22children%22%3A%5B%22__PAGE__%22%2C%7B%7D%2C%22%2Fdashboard%2Fpost%2F162928c1-c536-479a-a791-e01bf8b08df4%22%2C%22refresh%22%5D%7D%5D%7D%5D%7D%5D%7D%2Cnull%2Cnull%2Ctrue%5D")
                .cookies(cookies)
                .body("[\"" + postId + "\"]")
                .when()
                .post("http://localhost:3000/dashboard/post/" + postId)
                .then()
                .extract().response();
    }
}
