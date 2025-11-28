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
        new SavoraBO().login(generatedUser.getEmail(), generatedUser.getPassword()).deletePost("9c312d7b-9847-4856-a7a1-36789d279e54");
    }
}
