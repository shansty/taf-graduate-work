package by.itacademy.shirochina.anastasiya;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TestAPI {
    @Test
    public void submitLoginFormWithCorrectData() {
        HashMap<String, String> formParams = new HashMap<>();
        formParams.put("backurl", "/");
        formParams.put("AUTH_FORM", "Y");
        formParams.put("TYPE", "AUTH");
        formParams.put("USER_LOGIN", "shirochina16@gmail.com");
        formParams.put("USER_PASSWORD", "123456789");
        formParams.put("USER_REMEMBER", "Y");
        String htmlResponse = given().formParams(formParams).when().post("https://markformelle.by/ajax/auth_ajax.php").then().extract().asString();
        Assertions.assertTrue(htmlResponse.contains("Вы успешно вошли на сайт!"));
    }

    @Test
    public void submitLoginFormWithIncorrectData() {
        HashMap<String, String> formParams = new HashMap<>();
        formParams.put("backurl", "/");
        formParams.put("AUTH_FORM", "Y");
        formParams.put("TYPE", "AUTH");
        formParams.put("USER_LOGIN", "shirochina16@gmail.com");
        formParams.put("USER_PASSWORD", "123");
        formParams.put("USER_REMEMBER", "Y");
        String htmlResponse = given().formParams(formParams).when().post("https://markformelle.by/ajax/auth_ajax.php").then().extract().asString();
        Assertions.assertTrue(htmlResponse.contains("Неверный Email или пароль."));
    }

    @Test
    public void getMethodTest() {
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("q", "t-shirt");
        String htmlResponse = given().queryParams(queryParams).when().get("https://markformelle.by/search").then().extract().asString();
        Assertions.assertTrue(htmlResponse.contains("Поиск"));
    }
}
