package aqa_exam.ui;

import aqa_exam.listeners.CustomAllureListener;
import aqa_exam.listeners.CustomListener;
import aqa_exam.db.User;
import aqa_exam.db.UserProvider;
import aqa_exam.ui.bo.SavoraBO;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({CustomListener.class, CustomAllureListener.class})
public class SavoraPostDeleteTest {

    //test 3 - validate post deleted
    @Test
    public void savoraPostDeleteTest() {
        User generatedUser = UserProvider.generateUser();

        new SavoraBO()
                .logout() // Uncomment for Allure Report
                .login(generatedUser.getEmail(), generatedUser.getPassword())
                .deletePost("0d9f0e7b-8b5e-43e2-bce5-7d1bfa5956f2");
    }
}
