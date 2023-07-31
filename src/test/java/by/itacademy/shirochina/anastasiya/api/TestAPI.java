package by.itacademy.shirochina.anastasiya.api;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TestAPI {
    PostObject postObject;

    @BeforeEach
    public void warmUp() {
        postObject = new PostObject();
    }

    @Test
    public void testLoginFormWithCorrectData() {
        String htmlResponse = given().formParams(postObject.getFormParamsWithCorrectData()).when().
                post(postObject.endpoint).then().assertThat().statusCode(200).extract().asString();
        Document document = Jsoup.parse(htmlResponse);
        String actualMessage = document.getElementsByTag("span").text();
        Assertions.assertEquals(postObject.successMessage, actualMessage);
    }

    @Test
    public void testLoginFormWithIncorrectData() {
        String htmlResponse = given().formParams(postObject.getFormParamsWithIncorrectData()).when().
                post(postObject.endpoint).then().assertThat().statusCode(200).extract().asString();
        Document document = Jsoup.parse(htmlResponse);
        String actualMessage = document.getElementsByTag("font").text();
        Assertions.assertEquals(postObject.errorMessage, actualMessage);
    }

    @Test
    public void testSearchForValidData() {
        String htmlResponse = given().queryParams(postObject.getQueryParams(postObject.validQueryParam)).when().
                get(postObject.searchEndpoint).then().assertThat().statusCode(200).extract().body().asString();
        Document document = Jsoup.parse(htmlResponse);
        String actualMessage = document.select("li[data-product-id]").select("input[value]").get(2).attr("value").toString();
        Assertions.assertEquals(postObject.expectedMessageForValidSearch, actualMessage);
    }

    @Test
    public void testSearchForInvalidData() {
        String htmlResponse = given().queryParams(postObject.getQueryParams(postObject.invalidQueryParam)).when().
                get(postObject.searchEndpoint).then().assertThat().statusCode(200).extract().body().asString();
        ;
        Document document = Jsoup.parse(htmlResponse);
        String actualMessage = document.select("div.text").text();
        Assertions.assertEquals(postObject.expectedMessageForInvalidSearch, actualMessage);
    }
}
