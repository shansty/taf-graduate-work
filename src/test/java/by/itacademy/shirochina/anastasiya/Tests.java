package by.itacademy.shirochina.anastasiya;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Tests {
    ChromeDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    HomePage homePage = new HomePage(driver, wait);
    HomeStep step = new HomeStep(driver,wait);
    @Test
    public void test(){
        step.fillFormAndSubmit("efw", "qfad");
        Assertions.assertEquals(homePage.expectedErrorMessage, step.getErrorMessage());
        driver.quit();
    }

}
