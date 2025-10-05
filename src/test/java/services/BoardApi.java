package services;

import client.TrelloClient;
import io.restassured.response.Response;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardApi extends TrelloClient {

    public String createABoard(String name){
        Response response = givenAuth()
                .queryParam("name",name)
                .post("/boards");
        assertEquals(200,response.statusCode(),"board creation failed");
        return response.jsonPath().getString("id");
    }

    public void getABoard(String id){
        Response response = givenAuth()
                .pathParam("id",id)
                .get("/boards/{id}");
        assertEquals(200,response.statusCode(),"the board could not be found");
    }

    public void deleteBoard(String boardId) {
        int code = givenAuth().delete("/boards/{id}", boardId).statusCode();
        assertEquals(200, code, "Delete board failed");
    }

}
