package services;

import client.TrelloClient;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListApi extends TrelloClient {

    public String createAListApi(String idBoard, String name) {

        Response response = givenAuth()
                .queryParam("idBoard", idBoard)
                .queryParam("name", name)
                .post("/lists");
        assertEquals(200, response.statusCode(), "list creation failed");
        return response.jsonPath().getString("id");


    }
}
