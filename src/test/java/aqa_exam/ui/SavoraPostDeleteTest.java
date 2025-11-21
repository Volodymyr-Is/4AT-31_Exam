package aqa_exam.ui;

import aqa_exam.db.User;
import aqa_exam.db.UserProvider;
import aqa_exam.ui.bo.SavoraBO;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SavoraPostDeleteTest {
    //test 2 - validate post liked and saved
    @Test
    public void savoraPostDeleteTest() {

        new SavoraBO().login("", "").createPost("");
    }
}
