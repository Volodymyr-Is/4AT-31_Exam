package aqa_exam.ui;

import aqa_exam.db.User;
import aqa_exam.db.UserProvider;
import aqa_exam.ui.bo.SavoraBO;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SavoraPostLikeAndSaveTest {

    //test 3 - validate post deleted
    @Test
    public void savoraPostLikeAndSaveTest() {

        new SavoraBO().login("", "").createPost("");
    }
}
