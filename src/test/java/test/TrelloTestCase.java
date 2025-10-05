package test;


import org.junit.jupiter.api.Test;
import services.BoardApi;
import services.CardApi;
import services.ListApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class TrelloTestCase {


    @Test
    public void trelloTestCase() {
        BoardApi boardApi = new BoardApi();

        String createBoardId = boardApi.createABoard("Trello Test Automation Case");
        boardApi.getABoard(createBoardId);

        ListApi listApi = new ListApi();
        String ListID = listApi.createAListApi(createBoardId, "Trello Test Automation List");

        CardApi cardApi = new CardApi();
        List<String> cardList = new ArrayList<>();
        cardList.add(cardApi.createACard(ListID, "test1"));
        cardList.add(cardApi.createACard(ListID, "test2"));

        Random random = new Random();
        cardApi.updateCard(cardList.get(random.nextInt(cardList.size())), "updated card");

        for (String cardId : cardList) {
            cardApi.deleteCard(cardId);
        }

        boardApi.deleteBoard(createBoardId);

    }
}
