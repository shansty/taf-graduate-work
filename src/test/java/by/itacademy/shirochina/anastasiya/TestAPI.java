package by.itacademy.shirochina.anastasiya;

import by.itacademy.shirochina.anastasiya.api.PostObject;
import by.itacademy.shirochina.anastasiya.utils.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

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
                post("https://markformelle.by/ajax/auth_ajax.php").then().extract().asString();
        Assertions.assertTrue(htmlResponse.contains("Вы успешно вошли на сайт!"));
    }

    @Test
    public void submitLoginFormWithIncorrectData() {
        String htmlResponse = given().formParams(postObject.getFormParamsWithIncorrectData()).when().
                post("https://markformelle.by/ajax/auth_ajax.php").then().extract().asString();
        Assertions.assertTrue(htmlResponse.contains("Неверный Email или пароль."));
    }

    @Test
    public void searchForValidData() {
        given().queryParams(postObject.getQueryParams("t--shirt")).when().
                get("https://markformelle.by/search").then().assertThat().statusCode(200);

    }
    @Test
    public void searchForInvalidData() {
        given().queryParams(postObject.getQueryParams("lnl/cN?LAScn/lihACb?LBJ")).when().
                get("https://markformelle.by/search").then().assertThat().statusCode(200);
    }
}
