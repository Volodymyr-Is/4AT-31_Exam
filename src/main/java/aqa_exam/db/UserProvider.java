package aqa_exam.db;

import aqa_exam.ConfigReader;
import org.hibernate.Session;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class UserProvider {

//    private static final String SUPABASE_URL = ConfigReader.getSecretProp("supabase.url");
//    private static final String ANON_KEY = ConfigReader.getSecretProp("supabase.anon_key");
//
//    public static User generateUser() {
//        String uniqueId = UUID.randomUUID().toString();
//        String name = "test_" + uniqueId.substring(0, 8);
//        String email = name + "@testmail.com";
//        String password = "1qaz!QAZ";
//
//        String authUserId;
//
//        try {
//            String jsonBody = String.format(
//                    "{\"email\": \"%s\", \"password\": \"%s\"}", email, password
//            );
//
//            io.restassured.response.Response response = given()
//                    .baseUri(SUPABASE_URL)
//                    .basePath("/auth/v1/signup")
//                    .header("Content-Type", "application/json")
//                    .header("apikey", ANON_KEY) // Supabase API key
//                    .header("Authorization", "Bearer " + ANON_KEY)
//                    .body(jsonBody)
//                    .when()
//                    .post()
//                    .then()
//                    .statusCode(200)
//                    .extract().response();
//
//            // Отримання UUID, згенерованого Supabase
//            authUserId = response.jsonPath().getString("user.id");
//
//        } catch (Exception e) {
//            System.err.println("Помилка при створенні користувача через Auth API: " + e.getMessage());
//            throw new RuntimeException("Auth API failed", e);
//        }
//
//        User user = new User();
//        user.setId(UUID.fromString(authUserId));
//        user.setName(name);
//        user.setEmail(email);
//        user.setPassword(password);
//
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//
//        session.save(user);
//
//        session.getTransaction().commit();
//
//        return user;
//    }

    public static User generateUser() {
        User user = new User();
        user.setName("admin1");
        user.setEmail("john.test1.mail@gmail.com");
        user.setPassword("1qaz!QAZ");

        return user;
    }
}
