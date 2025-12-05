package aqa_exam.api;

import aqa_exam.api.SavoraAPIBO;
import aqa_exam.db.User;
import aqa_exam.db.UserProvider;
import aqa_exam.listeners.CustomAllureListener;
import aqa_exam.listeners.CustomListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({CustomListener.class, CustomAllureListener.class})
public class SavoraAPIUpdateBioTest {
    private SavoraAPIBO savoraAPIBO;
    private final User testUser = UserProvider.generateUser();

    @BeforeMethod
    public void setup() {
        savoraAPIBO = new SavoraAPIBO().login(testUser);
    }

    @Test
    public void validateBioUpdateTest() {
        //test 3 - validate bio updated
        String newBioText = "Hello. I am test user! My new bio is verified with UUID:";
        String extractedUuid = savoraAPIBO.updateBio(testUser);

        Assert.assertNotNull(extractedUuid, "UUID must be returned to confirm the bio was successfully updated and verified.");
    }
}
