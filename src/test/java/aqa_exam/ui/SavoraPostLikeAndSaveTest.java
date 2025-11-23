package aqa_exam.ui;

import aqa_exam.db.User;
import aqa_exam.db.UserProvider;
import aqa_exam.ui.bo.SavoraBO;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SavoraPostLikeAndSaveTest {

    //test 2 - validate post liked and saved
    @Test
    public void savoraPostLikeAndSaveTest() {
        User generatedUser = UserProvider.generateUser();
        new SavoraBO().login(generatedUser.getEmail(), generatedUser.getPassword()).likeAndSavePost("d7d514e3-e0da-4676-b342-99babbcaad81");
    }
}
