package aqa_exam.ui;

import aqa_exam.db.User;
import aqa_exam.db.UserProvider;
import aqa_exam.ui.bo.SavoraBO;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SavoraPostDeleteTest {

    //test 3 - validate post deleted
    @Test
    public void savoraPostDeleteTest() {
        User generatedUser = UserProvider.generateUser();
        new SavoraBO().login(generatedUser.getEmail(), generatedUser.getPassword()).deletePost("d7d514e3-e0da-4676-b342-99babbcaad81");
    }
}
