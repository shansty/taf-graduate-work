package by.itacademy.shirochina.anastasiya.api;

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
        String actualMessage = postObject.getActualMessageFromTagName(htmlResponse, postObject.tagNameForCorrectMessage);
        Assertions.assertEquals(postObject.successMessage, actualMessage);
    }

    @Test
    public void testLoginFormWithIncorrectData() {
        String htmlResponse = given().formParams(postObject.getFormParamsWithIncorrectData()).when().
                post(postObject.endpoint).then().assertThat().statusCode(200).extract().asString();
        String actualMessage = postObject.getActualMessageFromTagName(htmlResponse, postObject.tagNameForIncorrectMessage);
        Assertions.assertEquals(postObject.errorMessage, actualMessage);
    }

    @Test
    public void testSearchForValidData() {
        String htmlResponse = given().queryParams(postObject.getQueryParams(postObject.validQueryParam)).when().
                get(postObject.searchEndpoint).then().assertThat().statusCode(200).extract().asString();
        String actualMessage = postObject.getActualMessageInAttribute(htmlResponse, postObject.cssQueryForCorrectSearch, postObject.attributeForCorrectSearch);
        Assertions.assertEquals(postObject.expectedMessageForValidSearch, actualMessage);
    }

    @Test
    public void testSearchForInvalidData() {
        String htmlResponse = given().queryParams(postObject.getQueryParams(postObject.invalidQueryParam)).when().
                get(postObject.searchEndpoint).then().assertThat().statusCode(200).extract().asString();
        String actualMessage = postObject.getActualMessageFromCssQuery(htmlResponse, postObject.cssQueryForIncorrectSearch);
        Assertions.assertEquals(postObject.expectedMessageForInvalidSearch, actualMessage);
    }
}
