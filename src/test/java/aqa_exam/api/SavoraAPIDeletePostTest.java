package aqa_exam.api;

import aqa_exam.api.SavoraAPIBO;
import aqa_exam.db.User;
import aqa_exam.db.UserProvider;
import aqa_exam.listeners.CustomAllureListener;
import aqa_exam.listeners.CustomListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({CustomListener.class, CustomAllureListener.class})
public class SavoraAPIDeletePostTest {
    private SavoraAPIBO savoraAPIBO;
    private final User testUser = UserProvider.generateUser();

    @BeforeMethod
    public void setup() {
        savoraAPIBO = new SavoraAPIBO().login(testUser);
    }

    @Test
    public void validatePostDeletedTest() {
        //test 2 - validate post deleted

        String postIdToDelete = savoraAPIBO.createPost("create a post pasta");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        savoraAPIBO.deletePost(postIdToDelete);
    }
}
