package aqa_exam.api;

import aqa_exam.db.User;
import aqa_exam.db.UserProvider;
import aqa_exam.listeners.CustomAllureListener;
import aqa_exam.listeners.CustomListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({CustomListener.class, CustomAllureListener.class})
public class SavoraAPICreatePostTest {
    private SavoraAPIBO savoraAPIBO;
    private final User testUser = UserProvider.generateUser();

    @BeforeMethod
    public void setup() {
        savoraAPIBO = new SavoraAPIBO().login(testUser);
    }

    @Test
    public void validatePostCreatedTest() {
        //test 1 - validate post created
        String prompt = "create post about the best holiday destination: Maldives";
        String postId = savoraAPIBO.createPost(prompt);

        Assert.assertNotNull(postId, "Post ID must be present to confirm successful creation.");
    }
}
