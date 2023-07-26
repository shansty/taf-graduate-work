package by.itacademy.shirochina.anastasiya.api;

import by.itacademy.shirochina.anastasiya.utils.Util;
import io.restassured.response.ValidatableResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.sessionId;

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
                post(postObject.endpoint).then().assertThat().statusCode(200).extract().asString();
        Document document = Jsoup.parse(htmlResponse);
        String actual = document.getElementsByTag("span").text();
        Assertions.assertEquals(postObject.successMessage, actual);
    }

    @Test
    public void submitLoginFormWithIncorrectData() {
        String htmlResponse = given().formParams(postObject.getFormParamsWithIncorrectData()).when().
                post(postObject.endpoint).then().assertThat().statusCode(200).extract().asString();
        Document document = Jsoup.parse(htmlResponse);
        String actual = document.getElementsByTag("font").text();
        Assertions.assertEquals(postObject.errorMessage, actual);
    }

    @Test
    public void searchForValidData() {
        String htmlResponse = given().queryParams(postObject.getQueryParams("t-shirt")).when().
                get(postObject.searchEndpoint).then().assertThat().statusCode(200).extract().body().asString();
        Document document = Jsoup.parse(htmlResponse);
        String actual = document.select("li[data-product-id]").select("input[value]").get(2).attr("value").toString();
        Assertions.assertEquals("Бюстгальтер t-shirt без косточек белого цвета", actual);
    }

    @Test
    public void searchForInvalidData() {
        String htmlResponse = given().queryParams(postObject.getQueryParams("lnl/cN?LAScn/lihACb?LBJ")).when().
                get(postObject.searchEndpoint).then().assertThat().statusCode(200).extract().body().asString();
        ;
        Document document = Jsoup.parse(htmlResponse);
        String actual = document.select("div.text").text();
        Assertions.assertEquals("Сожалеем, но по вашему запросу ничего не найдено", actual);
    }
}
