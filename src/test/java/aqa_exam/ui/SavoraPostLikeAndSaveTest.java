package aqa_exam.ui;

import aqa_exam.listeners.CustomAllureListener;
import aqa_exam.listeners.CustomListener;
import aqa_exam.db.User;
import aqa_exam.db.UserProvider;
import aqa_exam.ui.bo.SavoraBO;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({CustomListener.class, CustomAllureListener.class})
public class SavoraPostLikeAndSaveTest {

    //test 2 - validate post liked and saved
    @Test
    public void savoraPostLikeAndSaveTest() {
        User generatedUser = UserProvider.generateUser();
        new SavoraBO()
//                .logout() // Uncomment for Allure Report
                .login(generatedUser.getEmail(), generatedUser.getPassword())
                .createPost("create post about milkshake")
                .likeAndSavePost();
    }
}
