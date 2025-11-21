package aqa_exam.ui;

import aqa_exam.db.User;
import aqa_exam.db.UserProvider;
import aqa_exam.ui.bo.SavoraBO;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SavoraCreatePostTest {

    @DataProvider
    public static Object[][] createPostDataProvider() {
        User generatedUser = UserProvider.generateUser();

        return new Object[][]{
//                { "john", "1111", "create post about coctail" },
//                { "bob", "2222", "create post about salad" },
                { generatedUser.getEmail(), generatedUser.getPassword(), "create post about salad" }
        };
    }

    //test 1 - validate post created
    @Test(dataProvider = "createPostDataProvider")
    public void savoraCreatePostTest(String login, String password, String postText) {

        new SavoraBO()
                .login(login, password)
                .verifyUserLogged()
                .createPost(postText);
    }
}
