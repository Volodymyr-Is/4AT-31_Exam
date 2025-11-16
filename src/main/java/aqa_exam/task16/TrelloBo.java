package aqa_exam.task16;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TrelloBo {
    static String board_id = ConfigReader.getProp("board_id");
    public static String trello_key = ConfigReader.getProp("trello_key");
    public static String trello_token = ConfigReader.getProp("trello_token");

    public static TrelloCreateCheckListResModel createCheckList(String list_name) throws IOException, InterruptedException {
        HttpRequest createCheckListRequest = HttpRequest
                .newBuilder()
                .POST(HttpRequest.BodyPublishers.noBody())
                .uri(URI.create("https://api.trello.com/1/boards/" + board_id + "/lists?name=" + list_name + "&key=" + trello_key + "&token=" + trello_token))
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse createCheckListResponse = client.send(createCheckListRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println(createCheckListResponse);
        System.out.println(createCheckListResponse.body());

        TrelloCreateCheckListResModel trelloCreateCheckList = new ObjectMapper().readValue(createCheckListResponse.body().toString(), TrelloCreateCheckListResModel.class);
        System.out.println(trelloCreateCheckList);

        return trelloCreateCheckList;
    }


    public void validateRes(TrelloCreateCheckListResModel actualRes, TrelloCreateCheckListResModel expectedRes) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(actualRes.getId());
        softAssert.assertEquals(actualRes.getName(), expectedRes.getName());
        softAssert.assertNotNull(actualRes.getBoardId());

        softAssert.assertAll();
    }

    public void addCard(String checklistId, String cardName) throws IOException, InterruptedException {
        HttpRequest createCardRequest = HttpRequest
                .newBuilder()
                .POST(HttpRequest.BodyPublishers.noBody())
                .uri(URI.create("https://api.trello.com/1/cards?idList=" + checklistId + "&key=" + trello_key + "&token=" + trello_token + "&name=" + cardName))
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse createCardResponse = client.send(createCardRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println(createCardResponse);
        System.out.println(createCardResponse.body());

        TrelloCreateCardResModel trelloCreateCard = new ObjectMapper().readValue(createCardResponse.body().toString(), TrelloCreateCardResModel.class);
        System.out.println(trelloCreateCard);
    }

    public void moveCardsToList2(String list1Id, String list2Id) throws IOException, InterruptedException {
        HttpRequest createCardRequest = HttpRequest
                .newBuilder()
                .POST(HttpRequest.BodyPublishers.noBody())
                .uri(URI.create("https://api.trello.com/1/lists/" + list1Id + "/moveAllCards?idBoard=" + board_id + "&idList=" + list2Id + "&key=" + trello_key + "&token=" + trello_token))
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse createCardResponse = client.send(createCardRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println(createCardResponse);
        System.out.println(createCardResponse.body());
    }
}
