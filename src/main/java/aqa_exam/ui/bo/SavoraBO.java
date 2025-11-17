package aqa_exam.ui.bo;

import aqa_exam.ui.po.SavoraHomePage;

public class SavoraBO {
    SavoraHomePage savoraHomePage = new SavoraHomePage();

    public SavoraBO createPost() {
//        todo
        return this;
    }

    public SavoraBO login() {
        savoraHomePage.openPage();
        savoraHomePage.goToLoginPage();

        return this;
    }
}
