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
        new SavoraBO().login(generatedUser.getEmail(), generatedUser.getPassword()).likeAndSavePost("c2ab8b9c-51d5-44a5-9269-561fb74a5037");
    }
}
