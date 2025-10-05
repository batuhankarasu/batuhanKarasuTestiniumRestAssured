package services;

import client.TrelloClient;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardApi extends TrelloClient {

    public String createACard(String listId, String name) {
        Response response = givenAuth()
                .queryParam("idList", listId)
                .queryParam("name", name)
                .post("/cards");
        assertEquals(200, response.statusCode(), "card creation failed");
        return response.jsonPath().getString("id");
    }

    public void updateCard(String id, String name) {
        int code = givenAuth()
                .queryParam("name", name)
                .put("/cards/{id}", id)
                .statusCode();
        assertEquals(200, code, "card creation failed");
    }

    public void deleteCard(String id) {
        int code = givenAuth()
                .delete("/cards/{id}", id)
                .statusCode();
        assertEquals(200, code, "Delete card failed");
    }

    ;
}
