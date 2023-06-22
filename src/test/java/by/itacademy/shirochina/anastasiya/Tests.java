package by.itacademy.shirochina.anastasiya;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Tests {
    ChromeDriver driver;
    WebDriverWait wait;
    HomePage homePage;
    HomeStep step;
    Util util;

    @BeforeEach
    public void warmUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        homePage = new HomePage(driver, wait);
        step = new HomeStep(driver, wait);
        util = new Util();
    }

    @Test
    public void fillFormWithIncorrectDataAndSubmit() {
        step.fillFormAndSubmit(util.generateEmail(), util.generatePassword());
        Assertions.assertEquals(homePage.expectedErrorMessage, homePage.getErrorMessage());
    }

    @Test
    public void fillFormWithEmailAndEmptyPassword() {
        step.fillFormAndSubmit(util.generateEmail(), "");
        Assertions.assertEquals(homePage.expectedErrorMessage, homePage.getErrorMessage());
    }

    @Test
    public void fillFormWithPasswordAndEmptyEmail() {
        step.fillFormAndSubmit("", util.generatePassword());
        Assertions.assertEquals(homePage.expectedErrorMessage, homePage.getErrorMessage());
    }

    @Test
    public void fillFormWithEmptyData() {
        step.fillFormAndSubmit("", "");
        Assertions.assertEquals(homePage.expectedErrorMessage, homePage.getErrorMessage());
    }

    @Test
    public void fillFormWithCorrectData() {
        step.fillFormAndSubmit(util.correctEmail(), util.correctPassword());
        // TO DO ASSERTION
        Assertions.assertEquals(homePage.expectedErrorMessage, homePage.getErrorMessage());
    }
    @AfterEach
    public void tearsDown() {
        driver.quit();
    }
}
