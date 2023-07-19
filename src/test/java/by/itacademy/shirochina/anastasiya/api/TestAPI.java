package by.itacademy.shirochina.anastasiya.api;

import by.itacademy.shirochina.anastasiya.utils.Util;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TestAPI {
    Util util;
    PostObject postObject;

    @BeforeEach
    public void warmUp() {
        util = new Util();
        postObject = new PostObject();
    }

    @Test
    public void submitLoginFormWithCorrectData() {
        String htmlResponse = given().formParams(postObject.getFormParamsWithCorrectData()).when().
                post(postObject.endpoint).then().extract().asString();
        Document document = Jsoup.parse(htmlResponse);
        String actual = document.getElementsByTag("span").text();
        Assertions.assertEquals(postObject.successMessage, actual);
    }

    @Test
    public void submitLoginFormWithIncorrectData() {
        String htmlResponse = given().formParams(postObject.getFormParamsWithIncorrectData()).when().
                post(postObject.endpoint).then().extract().asString();
        Document document = Jsoup.parse(htmlResponse);
        String actual = document.getElementsByTag("font").text();
        Assertions.assertEquals(postObject.errorMessage, actual);
    }

    @Test
    public void searchForValidData() {
        given().queryParams(postObject.getQueryParams("t-shirt")).when().
                get(postObject.searchEndpoint).then().log().all().assertThat().statusCode(200);
    }

    @Test
    public void searchForInvalidData() {
        given().queryParams(postObject.getQueryParams("lnl/cN?LAScn/lihACb?LBJ")).when().
                get(postObject.searchEndpoint).then().log().body().assertThat().statusCode(200);
    }
}
