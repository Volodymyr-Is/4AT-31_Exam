package aqa_exam.ui;

import aqa_exam.CustomAllureListener;
import aqa_exam.CustomListener;
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
        new SavoraBO().login(generatedUser.getEmail(), generatedUser.getPassword()).deletePost("551015eb-77bd-4540-a050-c8b0ad6a9021");
    }
}
