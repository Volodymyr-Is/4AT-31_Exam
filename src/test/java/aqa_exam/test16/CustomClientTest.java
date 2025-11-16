package aqa_exam.test16;

import aqa_exam.task16.TrelloBo;
import aqa_exam.task16.TrelloCreateCheckListResModel;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.UUID;

public class CustomClientTest {
    @Test
    void trelloTest() throws IOException, InterruptedException {
        String listName1 = "List1_" + UUID.randomUUID().toString().substring(0, 10);
        TrelloBo trelloBo = new TrelloBo();
        TrelloCreateCheckListResModel actualResultList1 = trelloBo.createCheckList(listName1);

        TrelloCreateCheckListResModel expectedResultList1 = new TrelloCreateCheckListResModel();
        expectedResultList1.setName(listName1);

        trelloBo.validateRes(actualResultList1, expectedResultList1);

        String listId = actualResultList1.getId();
        String cardName = "Card_" + UUID.randomUUID().toString().substring(0, 10);
        trelloBo.addCard(listId, cardName);

        String listName2 = "List2_" + UUID.randomUUID().toString().substring(0, 10);
        TrelloCreateCheckListResModel actualResultList2 = trelloBo.createCheckList(listName2);

        TrelloCreateCheckListResModel expectedResultList2 = new TrelloCreateCheckListResModel();
        expectedResultList2.setName(listName2);

        trelloBo.validateRes(actualResultList2, expectedResultList2);

        trelloBo.moveCardsToList2(actualResultList1.getId(), actualResultList2.getId());
    }
}
