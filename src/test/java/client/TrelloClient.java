package client;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.ConfigReader;

import static io.restassured.RestAssured.given;

public class TrelloClient {

    private final RequestSpecification spec;


    public TrelloClient() {
        this.spec = new RequestSpecBuilder()
                .setBaseUri(ConfigReader.get("baseurl"))
                .setContentType(ContentType.JSON)
                .addQueryParam("key", ConfigReader.get("key"))
                .addQueryParam("token", ConfigReader.get("token"))
                .build();
    }

    protected RequestSpecification givenAuth() {
        return given().spec(spec);
    }


}
