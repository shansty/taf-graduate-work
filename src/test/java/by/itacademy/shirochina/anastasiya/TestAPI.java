package by.itacademy.shirochina.anastasiya;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

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
        formParams.put("USER_PASSWORD", "1234567");
        formParams.put("USER_REMEMBER", "Y");
        given().formParams(formParams).when().post("https://markformelle.by/ajax/auth_ajax.php").then().log().body().assertThat().statusCode(200);
    }

    @Test
   public void submitLoginFormWithIncorrectData() {
       WebDriver driver = new HtmlUnitDriver();

        //try {
            HashMap<String, String> formParams = new HashMap<>();
            formParams.put("backurl", "/");
            formParams.put("AUTH_FORM", "Y");
            formParams.put("TYPE", "AUTH");
            formParams.put("USER_LOGIN", "shirochina16@gmail.com");
            formParams.put("USER_PASSWORD", "123");
            formParams.put("USER_REMEMBER", "Y");
            String htmlResponse = given().formParams(formParams).when().post("https://markformelle.by/ajax/auth_ajax.php").then().extract().asString();
            System.out.println(htmlResponse);
//            driver.get("data:text/html;charset=UTF-8," + htmlResponse);
//            String xpathExpression = "//div/p/strong";
//            WebElement element = driver.findElement(By.xpath(xpathExpression));
//
//            // Manipulate the selected element
//            if (element != null) {
//                // Print the text content of the element
//                System.out.println("Text content: " + element.getText());
//
//                // Get the modified HTML code
//                String modifiedHtml = driver.getPageSource();
//                System.out.println("Modified HTML: " + modifiedHtml);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            // Quit the WebDriver instance
//            driver.quit();
 //       }
    }
    @Test
   public void getMethodTest() {
       HashMap<String, String> queryParams = new HashMap<>();
       queryParams.put("q", "t-shirt");
       given().queryParams(queryParams).when().get("https://markformelle.by/search").then().log().body();
    }
}
