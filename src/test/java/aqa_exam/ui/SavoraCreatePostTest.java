package aqa_exam.ui;

import aqa_exam.CustomAllureListener;
import aqa_exam.CustomListener;
import aqa_exam.db.User;
import aqa_exam.db.UserProvider;
import aqa_exam.ui.bo.SavoraBO;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({CustomListener.class, CustomAllureListener.class})
public class SavoraCreatePostTest {

    @DataProvider
    public static Object[][] createPostDataProvider() {
        User generatedUser = UserProvider.generateUser();

        return new Object[][]{
//                { "john", "1111", "create post about coctail" },
//                { "bob", "2222", "create post about salad" },
                { generatedUser.getEmail(), generatedUser.getPassword(), "create post about caesar salad" }
        };
    }

    //test 1 - validate post created
    @Test(dataProvider = "createPostDataProvider")
    public void savoraCreatePostTest(String login, String password, String prompt) {

        new SavoraBO()
                .login(login, password)
//                .verifyUserLogged()
                .createPost(prompt);
    }
}
